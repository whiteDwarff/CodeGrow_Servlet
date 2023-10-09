package com.web.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.admin.service.MemberListService;
import com.web.admin.service.MemberSearchService;
import com.web.service.Service;

@WebServlet("/memberList")
public class MemberListController extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new MemberListService();
    service.execute(req, resp);
    req.getRequestDispatcher("/WEB-INF/admin/memberList.jsp").forward(req, resp);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Service service = new MemberSearchService();
    service.execute(req, resp);
    req.getRequestDispatcher("/WEB-INF/admin/memberList.jsp").forward(req, resp);
  }
}
