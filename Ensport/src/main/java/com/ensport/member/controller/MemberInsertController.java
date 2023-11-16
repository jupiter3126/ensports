package com.ensport.member.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.valves.StuckThreadDetectionValve;

import com.ensport.member.model.service.MemberService;
import com.ensport.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertController
 */
@WebServlet("/memberInsert.do")
public class MemberInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("views/member/memberInsertForm.jsp").forward(request, response);

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String userNickname = request.getParameter("userNickname");
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("addressDetail");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String[] prefers = request.getParameterValues("prefer");
		
		String prefer = "";

		// null값을 java에서 미리 처리하고 나면 프론트에서 null값을 따로 처리할 필요가 없다.
		if (prefers != null) {
			prefer = String.join(",", prefers);
		}
		
		
		//별명 랜덤 생성
		if(userNickname == null || userNickname == "") {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			userNickname = "PLAYER" + sdf.format(new Date()) + (int)(Math.random()*100000); 
		}
		
		
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPassword(userPassword);
		m.setUserNickname(userNickname);
		m.setUserName(userName);
		m.setPhone(phone);
		m.setAddress(address);
		m.setAddressDetail(addressDetail);
		m.setEmail(email);
		m.setGender(gender);
		m.setPrefer(prefer);

		int result = new MemberService().insertMember(m);
		
		
		// 처리된 행 수를 토대로 사용자에게 보여줄 응답화면 지정하기

		// 회원가입 성공 시에 session에 회원가입 성공 메시지 담고 index 페이지로 재요청
		// 회원가입 실패시 request에 에러 메시지 담고 errorPage로 포워딩 해보기
		if(result > 0) {	//성공
			
			HttpSession session = request.getSession();
			//menubar에 작성되어 있는 알림 활용하기
			
			session.setAttribute("alertMsg", "회원가입에 성공하였습니다.");
			response.sendRedirect(request.getContextPath() + "/login.do");
			
		}else {		//실패(실패시 화면)
			
			//뢰원가입 실패시 request에 에러 메시지 담고 errorPage로 포워딩해보기
			request.setAttribute("alertMsg", "회원가입에 실패하였습니다.");

			//request.getRequestDispatcher 객체에 보여줄 뷰 페이지 정보(경로) 설정한 뒤 위임하기(forward)하기
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);	//한줄처리로 슝~
		}
	}

}
