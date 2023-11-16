package com.ensport.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ensport.admin.model.service.AdminService;
import com.ensport.admin.model.vo.MonthRevenue;
import com.google.gson.Gson;

/**
 * Servlet implementation class ChartMonthlyRevenue
 */
@WebServlet("/monthlyRevenue.ch")
public class ChartMonthlyRevenue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChartMonthlyRevenue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 1. DAO에서 월과 예약건수를 가져온다
		 * 2. 맞는 월이 없다면 0을 list2에 넣는다.
		 * 3. 맞는 월이 있다면 그 월에 예약건수*10000를 계산한 값을 그 월의 - 1 한 값을 인덱스로 넣어준다. 
		 * 4. ajax로 보내준다.
		 * 
		 * 
		 * */
		
		//db에서 월, 예약건수 가져오기 
		ArrayList<MonthRevenue> list = new AdminService().calculateMonthlyRevenue();
		
		//ajax success로 월매출 데이터 보내기
		ArrayList<Integer> list2 = new ArrayList<>();
		
		for(int i=0; i<12;i++) {
			list2.add(0);
		}
		
		//10월: 9인덱스 , 11월: 10인덱스, 12월 11인덱스
		for(int i=(list.get(0).getMonth())-1; i<12;i++) {
			
			for(int j=0;j<list.size();j++) { //list.size() : 2 (0,1 인덱스)
				
				if(i==(list.get(j).getMonth())-1) { //맞는 월이 있다면
					list2.set(i,((list.get(j).getMonthRevenue())*10000));
					System.out.println("확인 i:"+i);
				}
			}
		}
		for(int i=0;i<12;i++) {
			
			System.out.println("list2 확인"+list2.get(i));
		}
		
		response.setContentType("json/application; charset=UTF-8");
		new Gson().toJson(list2,response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
