package com.web.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.admin.service.MemberDeleteService;
import com.web.admin.service.MemberRankService;
import com.web.service.Service;

@WebServlet("/changeUserInfo")
public class MemberRankController extends HttpServlet{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new MemberRankService();
    service.execute(req, resp);
    resp.sendRedirect("/memberList");
  }
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new MemberDeleteService();
    service.execute(req, resp);
    resp.sendRedirect("/memberList");
  }
}
