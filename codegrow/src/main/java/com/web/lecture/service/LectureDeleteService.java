package com.web.lecture.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.service.Service;
import com.web.video.dao.LectureDao;

public class LectureDeleteService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    int id = Integer.parseInt(req.getParameter("id"));
    
    LectureDao dao = LectureDao.getInstance();
    dao.deleteVideo(id);
    
    req.setAttribute("msg", "동영상이 삭제되었습니다.");

  }

}
