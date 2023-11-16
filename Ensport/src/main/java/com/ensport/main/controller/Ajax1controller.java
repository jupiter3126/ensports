package com.ensport.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensport.matching.model.service.SoccerMatchingService;
import com.ensport.matching.model.vo.SoccerMatching;
import com.google.gson.Gson;



/**
 * Servlet implementation class Ajax1controller
 */
@WebServlet("/ajax1.do")
public class Ajax1controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajax1controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<SoccerMatching> list = new  SoccerMatchingService().selectMostSoccerMatchingList();
		
//		for(SoccerMatching sm : list) {
//			System.out.println(sm);
//		}
		
		request.setAttribute("mlist", list);
		
		
		
        Gson gson = new Gson();
        String json = gson.toJson(list);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}





