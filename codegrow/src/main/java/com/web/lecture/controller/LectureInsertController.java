package com.web.lecture.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.lecture.service.LectureDetailService;
import com.web.lecture.service.LectureInsertService;
import com.web.service.Service;
import com.web.video.dao.LectureDao;
import com.web.video.dto.VideoDto;

@WebServlet("/lectureInsert")
public class LectureInsertController extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    String id = req.getParameter("id");
    if(id != null && !id.isEmpty()) {
      Service service = new LectureDetailService();
      service.execute(req, resp);
    }
    req.getRequestDispatcher("/WEB-INF/lecture/VideoInsert.jsp").forward(req, resp);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new LectureInsertService();
    service.execute(req, resp);
    
    int id = (int)req.getAttribute("id");
    int group = (int)req.getAttribute("group");
    resp.sendRedirect("/education?id="+id+"&group="+group);
  }
}
