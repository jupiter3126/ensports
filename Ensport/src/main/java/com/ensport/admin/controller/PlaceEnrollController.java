package com.ensport.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.ensport.admin.model.service.AdminService;
import com.ensport.admin.model.vo.Attachment;
import com.ensport.admin.model.vo.Place;
import com.ensport.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class placeEnrollController
 */
@WebServlet("/placeEnroll.pl")
public class PlaceEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceEnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("views/admin/placeManageView/placeEnrollView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
		
			int maxSize = 20 * 1024 * 1024;
			
			String savePath = request.getSession().getServletContext().getRealPath("/resources/uploadFiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8", new MyFileRenamePolicy());
			
			
			String placeName = multiRequest.getParameter("placeName");
			String localName = multiRequest.getParameter("localName");
			String categoryNo = multiRequest.getParameter("categoryNo");
			int max_capacity = Integer.parseInt(multiRequest.getParameter("max_capacity"));
			String place_size = multiRequest.getParameter("place_size");
			String parking_yn = multiRequest.getParameter("parking_yn");
			String place_sub_info = multiRequest.getParameter("place_sub_info");
			
			
			
			Place p = new Place(placeName,place_sub_info,place_size,parking_yn,max_capacity,categoryNo,localName);
			
			
			ArrayList<Attachment> list = new ArrayList<>();
			
			for(int i=1; i<=3; i++) {
				
				String key = "image"+i;
				
				if(multiRequest.getOriginalFileName(key)!=null) {
					
					Attachment at = new Attachment();
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));
					at.setFilePath("/resources/uploadFiles/");
					at.setFileType(2);
					
					if(i==1) {//대표이미지 fileLevel ==1 
						at.setFileLevel(1);
					}else { //상세이미지 fileLevel == 2
						at.setFileLevel(2);
					}
					
					list.add(at);
				}
			}
			
			int result = new AdminService().placeEnroll(p,list);
			HttpSession session = request.getSession();
			
			if(result>0) {
				
				session.setAttribute("alertMsg", "신규 경기장 개설 성공");
				
				response.sendRedirect(request.getContextPath()+"/placeList.pl");
			}else {
				for(Attachment at : list) { //등록 실패했을때
					if(at!=null){
						new File(savePath+at.getChangeName()).delete();
					}
				}
				session.setAttribute("alertMsg","신규 경기장 개설 실패");
				
				response.sendRedirect(request.getContextPath()+"/placeList.pl");
			}
			
		
		}
	}

}
