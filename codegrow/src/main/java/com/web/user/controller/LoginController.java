package com.web.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.user.dao.UserDao;
import com.web.user.dto.LoginDto;
import com.web.user.dto.UserDto;


@WebServlet("/user/login")
public class LoginController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// incoding setting
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		// input의 입력값 받아오기 
		String id = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		
		LoginDto login = new LoginDto(id, pwd);
		UserDto user = UserDao.getInstance().loginDao(login);
		int result = user.getNumber();
		
		// login success
		if(result == 1) {
			// login 정보를 저장할 session 객체 생성
			HttpSession session = req.getSession();
			session.setAttribute("email", user.getEmail());
			session.setAttribute("name", user.getName());
			session.setAttribute("tel", user.getTel());
			session.setAttribute("regDate", user.getRegDate());
	  req.setAttribute("name", "name님 하이");
			resp.sendRedirect("/main");
		// password mismatch
		} else if(result == 0) {
			req.setAttribute("loginGuide", "비밀번호가 일치하지 않습니다.");
			doGet(req, resp);
		// email mismatch
		} 
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 실패 시 로그인 화면으로 돌아가기 위함 
		req.getRequestDispatcher("/WEB-INF/member/login.jsp").forward(req, resp);
	}
}
