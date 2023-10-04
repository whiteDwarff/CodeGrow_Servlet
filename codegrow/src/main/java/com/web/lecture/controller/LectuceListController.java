package com.web.lecture.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.lecture.service.LectuceListService;
import com.web.lecture.service.LectureSearchService;
import com.web.service.Service;

@WebServlet("/lecture")
public class LectuceListController extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new LectuceListService();
    service.execute(req, resp);
    req.getRequestDispatcher("/WEB-INF/lecture/lectureList.jsp").forward(req, resp);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Service service = new LectureSearchService();
    service.execute(req, resp);
    req.getRequestDispatcher("/WEB-INF/lecture/lectureList.jsp").forward(req, resp);
  }

}
