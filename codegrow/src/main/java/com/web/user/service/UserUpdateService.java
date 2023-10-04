package com.web.user.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.category.dao.CategoryDao;
import com.web.category.dto.CategoryDto;
import com.web.service.Service;
import com.web.user.dao.UserDao;

public class UserUpdateService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    String pwd = req.getParameter("pwd");
    String tel = req.getParameter("tel");
    
    HttpSession session = req.getSession();
    int id = (int)session.getAttribute("id");
    
    UserDao dao = UserDao.getInstance();
    dao.updateInfo(pwd, tel, id);
    
    
    session.setAttribute("tel", tel);
    req.setAttribute("msg", "회원정보가 변경되었습니다");
  }

}
