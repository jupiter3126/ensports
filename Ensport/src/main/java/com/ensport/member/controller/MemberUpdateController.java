package com.ensport.member.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ensport.member.model.service.MemberService;
import com.ensport.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/memberUpdate.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberUpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("addressDetail");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String userNickname = request.getParameter("userNickname");
		String[] prefers = request.getParameterValues("prefer");

		String prefer = "";
		
		if (prefers != null) {
			prefer = String.join(",", prefers);
		}
		
		//별명이 없을시 랜덤 생성
		if(userNickname == null || userNickname == "") {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
			userNickname = "PLAYER" + sdf.format(new Date()) + (int)(Math.random()*100000); 
		}

		// 객체에 담아주기
		Member m = new Member();
		
		m.setUserNo(userNo);
		m.setUserId(userId);
		m.setUserName(userName);
		m.setPhone(phone);
		m.setAddress(address);
		m.setAddressDetail(addressDetail);
		m.setEmail(email);
		m.setGender(gender);
		m.setUserNickname(userNickname);
		m.setPrefer(prefer);
		
		// 서비스에 요청보내기(갱신된 회원정보를 반환)
		Member updateMember = new MemberService().updateMember(m);
		
		// 응답화면 설정하기
		if (updateMember == null) { // 실패~
			
			request.setAttribute("errorMsg", "회원정보 수정에 실패하였습니다.");
			request.getRequestDispatcher("views/member/myPage.jsp").forward(request, response);
			
		} else { // 성공

			HttpSession session = request.getSession();

			session.setAttribute("loginUser", updateMember);
			session.setAttribute("alertMsg", "정보 수정이 완료되었습니다.");

			response.sendRedirect(request.getContextPath() + "/myPage.me");

		}
	}
}
