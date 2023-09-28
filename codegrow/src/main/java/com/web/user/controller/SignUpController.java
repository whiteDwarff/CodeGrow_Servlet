package com.web.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.category.dao.CategoryDao;
import com.web.category.dto.CategoryDto;
import com.web.user.dao.Register;
import com.web.user.dao.UserDao;

@WebServlet("/join")
public class SignUpController extends HttpServlet{

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    resp.setContentType("text/html; charset=utf-8");
    String email = req.getParameter("email");
    String pwd = req.getParameter("pwd");
    String name = req.getParameter("name");
    String tel = req.getParameter("tel");
    
    Register user = new Register(name, email, pwd, tel);
    int result = UserDao.getInstance().singUp(user);
    
    if(result > 0) {
      req.setAttribute("msg", "회원가입이 완료되었습니다. 로그인 후 이용해주세요");
      CategoryDao group = CategoryDao.getInstance();
      List<CategoryDto> menus = group.setHeader();
      req.setAttribute("menus", menus);
      req.getRequestDispatcher("/WEB-INF/member/login.jsp").forward(req, resp);
    }
  
  }
}