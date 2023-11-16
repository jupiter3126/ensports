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
import com.ensport.common.model.vo.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class PlaceUpdateController
 */
@WebServlet("/placeUpdate.pl")
public class PlaceUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//multipart/form-data로 전송되었는지 확인
		//multipart/form-data 로 전달되었다면
		//기존 request객체에서 값을 추출할 수 없기때문에
		//MultipartRequest 객체로 변환 후 값을 추출해야한다.
		//이때 MultipartRequest 객체를 생성하는 구문이 업로드 처리를 하는 구문이기때문에
		//해당 파일에 대한 설정을 해줘야함
		if(ServletFileUpload.isMultipartContent(request)) {
			//전송 파일 용량 제한
			int maxSize = 50 * 1024 * 1024;
			
			//업로드된 파일 저장 위치 (물리적 경로 찾기)
			String savePath = request.getSession().getServletContext().getRealPath("/resources/uploadFiles/");
			
			//MultipartRequest 객체 만들기 (객체가 생성되며 넘오온 파일이 있다면 서버에 파일 업로드가 된다)
			MultipartRequest multiRequest = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
			
			//변환된 multiRequest객체로 데이터 추출하기
			int placeNo = Integer.parseInt(multiRequest.getParameter("placeNo"));
			String placeName = multiRequest.getParameter("placeName");
			String localName = multiRequest.getParameter("localName");
			String categoryNo = multiRequest.getParameter("categoryNo");
			int max_capacity = Integer.parseInt(multiRequest.getParameter("max_capacity"));
			String place_size = multiRequest.getParameter("place_size");
			String parking_yn = multiRequest.getParameter("parking_yn");
			String place_sub_info = multiRequest.getParameter("place_sub_info");
			
			Place p = new Place(placeNo,placeName,place_sub_info,place_size,parking_yn,max_capacity,categoryNo,localName);
			
			
			//만약 새로운 첨부파일이 전달되었다면
			ArrayList<Attachment> list = new ArrayList<>();
			
			//기존첨부파일이 있을때 새로운 첨부파일이 들어온 경우(기본 첨부파일 삭제해주기)
			boolean flag1 = false;
			boolean flag2 = false;
			boolean flag3 = false;
			
			
			for(int i = 1; i<=3; i++) {
				
				String key = multiRequest.getParameter("originFileNo"+i);
				if(key.equals("0")) {
					key = null;
				}
				//새로 전달된 파일명이 있을때
				if(multiRequest.getOriginalFileName("reloadFile"+i) != null) {
					
					Attachment at = new Attachment();
					//전달된 파일명
					at.setOriginName(multiRequest.getOriginalFileName("reloadFile"+i));
					//서버에 업로드된 파일명
					at.setChangeName(multiRequest.getOriginalFileName("reloadFile"+i));
					//저장 경로 넣기
					at.setFilePath("/resources/uploadFiles/");
					at.setFileType(2);
					
					if(i==1) {//대표이미지 fileLevel ==1 
						at.setFileLevel(1);
					}else { //상세이미지 fileLevel == 2
						at.setFileLevel(2);
					}
					
					
					
					if(key != null) {
						//새로 첨부된 파일이 있고 기존 파일도 있다면 
						//파일정보가 등록된 데이터에서 변경작업을 한다. update
						//파일번호(식별자)를 이용하여 기존데이터에서 변경하기. (덮어쓰기)
						at.setAtNo(Integer.parseInt(key));
						
						//기존 첨부파일 삭제 플래그
						if(i==1) {
							
							flag1 = true;
						}else if(i==2) {
							flag2 = true;
						}else {
							flag3 = true;
						}
						
					}else { //새로 전달된 파일은 있지만 기존에는 파일이 없었을때
						//데이터베이스에 Attachment정보를 추가해야한다.
						//참조 게시글 번호를 세팅
						at.setRefBno(placeNo);
						
					}
					list.add(at);
				}else {//새로 전달된 파일명이 없을때
					if(key!=null) {
						
						int originFileNo = Integer.parseInt(key); 
						new AdminService().deleteUnselectedFile(originFileNo);
					}
				}
			}
				//서비스로 요청 보내기
				//b,at : 
				//새로운 첨부파일이 없는 경우 b,at(null) -b : update
				//새로운 첨부파이이 있고 기존에 첨부파일이 있는경우 b,at(filaNo) -at: update
				//새로운 첨부파일이 있고 기존에 첨부파일이 없는 경우 b, at(refBno) -at: insert
				
				int result = new AdminService().updatePlace(p,list);
				HttpSession session = request.getSession();
				//성공시에 상세페이지로 성공메세지와 함께
				if(result>0) {
					
					
						//기존에 있었던 파일이 지워져야한다면
						if(flag1) {
								//기존 파일 삭제 해주기 (저장경로 + 원본파일명 ) - 원본파일명은 view에서 넘겨줌
								new File(savePath+multiRequest.getParameter("originFilename"+1)).delete();
						}
						if(flag2) {
							//기존 파일 삭제 해주기 (저장경로 + 원본파일명 ) - 원본파일명은 view에서 넘겨줌
							new File(savePath+multiRequest.getParameter("originFilename"+2)).delete();
						}
						if(flag3) {
							//기존 파일 삭제 해주기 (저장경로 + 원본파일명 ) - 원본파일명은 view에서 넘겨줌
							new File(savePath+multiRequest.getParameter("originFilename"+3)).delete();
					}
					
					
					session.setAttribute("alertMsg", "경기장 수정 성공");
					response.sendRedirect(request.getContextPath()+"/placeDetail.pl?pno="+placeNo);
				}else {
					session.setAttribute("alertMsg", "경기장 수정 실패");
					response.sendRedirect(request.getContextPath()+"/placeDetail.pl?pno="+placeNo);
				}
				//실패시에 상세페이지로 실패메세지와 함께
				
			}
				
		}

	}

