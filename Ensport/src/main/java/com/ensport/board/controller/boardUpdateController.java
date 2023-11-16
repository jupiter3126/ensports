package com.ensport.board.controller;

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

import com.ensport.board.model.service.BoardService;
import com.ensport.board.model.vo.Attachment;
import com.ensport.board.model.vo.Board;
import com.ensport.common.model.vo.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class boardUpdateController
 */
@WebServlet("/boardUpdate.bo")
public class boardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bno = Integer.parseInt(request.getParameter("bno")); //request요청값은 String타입으로 꺼내지므로 형변환
		
		
		BoardService bs = new BoardService();
		//수정페이지에 띄워줄 데이터 조회해오기
		Board b = bs.selectBoard(bno); 
		//첨부파일 정보
		Attachment at = bs.selectAttachment(bno);
		
		ArrayList<Attachment> list = bs.selectAttachmentList(bno);
		
//		System.out.println(at.getOriginName());
		
		request.setAttribute("b", b);
		request.setAttribute("a", at);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("views/board/boardUpdateForm.jsp").forward(request, response);;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			//전송 파일 용량 제한
			int maxSize = 10 * 1024 * 1024;
			
			//업로드된 파일 저장 위치 (물리적 경로 찾기)
			String savePath = request.getSession().getServletContext().getRealPath("/resources/uploadFiles/");
			
			//MultipartRequest객체 만들기 (객체가 생성되며 넘어온 파일이 있다면 서버에 파일 업로드가 된다)
			MultipartRequest multiRequest
					= new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			//변환된 multiRequest객체로 데이터 추출하기
			int boardNo = Integer.parseInt(multiRequest.getParameter("boardNo"));
		
			String title = multiRequest.getParameter("title");
			String content = multiRequest.getParameter("content");
			
			Board b = new Board();
			b.setBoardNo(boardNo);
			b.setBoardContent(content);
			b.setBoardTitle(title);
			
			//만약 새로운 첨부파일이 전달되었다면
			Attachment at = null;
			
			//기존첨부파일이 있을때 새로운 첨부파일이 들어온 경우 (기존 첨부파일 삭제해주기)
			boolean flag = false;
			
			//새로 전달된 파일명이 있을때
			if(multiRequest.getOriginalFileName("reUploadFile") != null) {
				at = new Attachment(); //객체 생성
				//전달된 파일명
				at.setOriginName(multiRequest.getOriginalFileName("reUploadFile"));
				//서버에 업로드된 파일명
				at.setChangeName(multiRequest.getFilesystemName("reUploadFile"));
				//저장 경로 넣기
				at.setFilePath("/resources/uploadFiles/");
				
				//만약 기존에도 파일이 있었다면 파일번호와 파일명을 전달받기
				if(multiRequest.getParameter("originAtNo") != null) {
					//새로 첨부된 파일이 있고 기존 파일도 있다면
					//파일정보가 등록된 데이터에서 변경작업을 한다 update
					//파일번호(식별자)를 이용하여 기존데이터에서 변경하기. (덮어쓰기)
					at.setAtNo(Integer.parseInt(multiRequest.getParameter("originAtNo")));
					
					//기존 첨부파일 삭제 플래그
					flag = true;
					
				}else {//새로 전달된 파일은 있지만 기존에는 파일이 없었을때
					//데이터베이스에 Attachment정보를 추가해야한다.
					//참조 게시글 번호를 세팅
					at.setBoardNo(boardNo);
				}
				
			}
			
			ArrayList<Attachment> list = new ArrayList<>();
			
			boolean flag1 = false;
			
			
			for(int i=1; i<3; i++) {
				
				if(multiRequest.getParameter("reUploadFile"+i) != null) {
					
					list.get(i).setOriginName(multiRequest.getOriginalFileName("reUploadFile"+i));
					
					list.get(i).setChangeName(multiRequest.getFilesystemName("reUploadFile"+i));
					
					list.get(i).setFilePath("/resources/uploadFiles/");
					
					list.get(i).setFileLevel(1);
					
					
				}
				
			}
			
			
			
			//서비스로 요청보내기
			//b,at : 
			//새로운 첨부파일이 없는경우 b,at(null)
			//새로운 첨부파일이 있고 기존에 첨부파일도 있는경우 b,at(fileNo) -at: update
			//새로운 첨부파일이 있고 기존에 첨부파일이 없는경우 b,at(refBno) -at: insert
			
			int result = new BoardService().updateBoard(b,at);
			HttpSession session = request.getSession();
			//성공시에 상세페이지로 성공메세지와 함께 
			//실패시에 상세페이지로 실패메세지와 함께
			if(result>0) {
				
				//기존에 있었던 파일이 지워져야한다면
				if(flag) {
					//기존 파일 삭제 해주기 (저장경로 + 원본파일명) -원본파일명은 view에서 넘겨줌
					new File(savePath+multiRequest.getParameter("originFileName")).delete();
				}
				
				request.setAttribute("a", at);
				session.setAttribute("alertMsg", "게시글 수정 성공");
				response.sendRedirect(request.getContextPath()+"/boardDetail.bo?bno="+boardNo);
			}else {
				session.setAttribute("alertMsg", "게시글 수정 실패");
				response.sendRedirect(request.getContextPath()+"/boardDetail.bo?bno="+boardNo);
			}
		}
	}

}
