package com.web.lecture.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.service.Service;
import com.web.video.dao.LectureDao;
import com.web.video.dto.VideoDto;

public class LectureSearchService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("utf-8");
    HttpSession session = req.getSession();
    
    String content = req.getParameter("content");
    int id = (int) session.getAttribute("id");
    
    LectureDao dao = LectureDao.getInstance();
    List<VideoDto> videos = dao.fetchedVideoTitle(content, id);
    
    req.setAttribute("videos", videos);

  }

}
