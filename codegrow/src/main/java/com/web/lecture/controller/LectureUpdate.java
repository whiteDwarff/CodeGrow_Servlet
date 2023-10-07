package com.web.lecture.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.lecture.service.LectureUpdateService;
import com.web.service.Service;

@WebServlet("/lectureUpdate")
public class LectureUpdate extends HttpServlet{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new LectureUpdateService();
    service.execute(req, resp);
    int id = (int)req.getAttribute("id");
    int group = (int)req.getAttribute("group");
    resp.sendRedirect("/education?id="+id+"&group="+group);
  }

}
