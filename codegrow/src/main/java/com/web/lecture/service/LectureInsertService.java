package com.web.lecture.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.service.Service;
import com.web.video.dao.LectureDao;
import com.web.video.dao.VideoDao;
import com.web.video.dto.VideoDto;

public class LectureInsertService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("utf-8");
    
    int group = Integer.parseInt(req.getParameter("url"));
    String title = req.getParameter("title");
    String description = req.getParameter("description");
    String url = req.getParameter("link");
    
    HttpSession session = req.getSession();
    int uploader_id = (int)session.getAttribute("id");
    
    LectureDao Lecturedao = LectureDao.getInstance();
    int id = Lecturedao.InsertVideo(title, description, url, group, uploader_id);
   
    req.setAttribute("id", id);
    req.setAttribute("group", group);
    req.setAttribute("msg", "게시물이 등록되었습니다");
    
    
    
    
  }

}
