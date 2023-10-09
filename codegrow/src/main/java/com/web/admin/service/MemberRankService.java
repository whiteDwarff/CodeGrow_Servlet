package com.web.admin.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.service.Service;
import com.web.user.dao.AdminDao;

public class MemberRankService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("utf-8");
    int id = Integer.parseInt(req.getParameter("id"));
    String rank = req.getParameter("rank");
    
    AdminDao dao = AdminDao.getInstance();
    dao.changeUserRank(id, rank);
  }

}
