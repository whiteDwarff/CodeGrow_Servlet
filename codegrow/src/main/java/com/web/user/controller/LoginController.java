package com.web.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.category.dao.CategoryDao;
import com.web.category.dto.CategoryDto;
import com.web.user.dao.UserDao;
import com.web.user.dto.LoginDto;
import com.web.user.dto.UserDto;


@WebServlet("/login")
public class LoginController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		// input의 입력값 받아오기 
		String id = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		
		LoginDto login = new LoginDto(id, pwd);
		UserDto user = UserDao.getInstance().loginDao(login);
  CategoryDao group = CategoryDao.getInstance();
  List<CategoryDto> menus = group.setHeader();
		int result = user.getNumber();
		// login success
		if(result == 1) {
			// login 정보를 저장할 session 객체 생성
			HttpSession session = req.getSession();
   session.setAttribute("id", user.getId());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("name", user.getName());
			session.setAttribute("tel", user.getTel());
			session.setAttribute("regDate", user.getRegDate());
			session.setAttribute("rank", user.getRank());
	  req.setAttribute("menus", menus);
			resp.sendRedirect("/index");
		// password mismatch
		} else if(result == 0) {
			req.setAttribute("msg", "회원정보가 일치하지 않습니다.");
			doGet(req, resp);
		}

	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 실패 시 로그인 화면으로 돌아가기 위함 
	 CategoryDao group = CategoryDao.getInstance();
	 List<CategoryDto> menus = group.setHeader();
	 req.setAttribute("menus", menus);
		req.getRequestDispatcher("/WEB-INF/member/login.jsp").forward(req, resp);
	}
}
