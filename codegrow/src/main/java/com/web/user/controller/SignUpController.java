package com.web.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.user.dao.Register;
import com.web.user.dao.UserDao;

@WebServlet("/member/signUp")
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
      System.out.println("성공");
      req.setAttribute("createAccount", "회원가입이 완료되었습니다. 로그인 후 이용해주세요");
      resp.sendRedirect("/user/login");
//      doGet(req, resp);
    }
//    else {
//      System.out.println("실패");
//      req.setAttribute("createAccount", "회원가입이 실패");
//      doGet(req, resp);
//    }
  }
  
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("/WEB-INF/member/login.jsp").forward(req, resp);
  }
}
