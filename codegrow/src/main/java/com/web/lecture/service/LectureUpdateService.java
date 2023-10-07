package com.web.lecture.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.service.Service;
import com.web.video.dao.LectureDao;

public class LectureUpdateService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("utf-8");
    String title = req.getParameter("title");
    String description = req.getParameter("description");
    String url = req.getParameter("url");
    int category_id = Integer.parseInt(req.getParameter("category"));
    int id = Integer.parseInt(req.getParameter("id"));
    
    LectureDao dao = LectureDao.getInstance();
    dao.updateVideo(title, description, url, category_id, id);
    
    req.setAttribute("id", id);
    req.setAttribute("group", category_id);

  }

}
