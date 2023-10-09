package com.web.admin.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.service.Service;
import com.web.user.dao.AdminDao;
import com.web.user.dto.UserDto;

public class MemberSearchService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("utf-8");
    String name = req.getParameter("name");
    
    AdminDao dao = AdminDao.getInstance();
    List<UserDto> users = dao.fetchedSerchList(name);
    
    req.setAttribute("users", users);
    
  }

}
