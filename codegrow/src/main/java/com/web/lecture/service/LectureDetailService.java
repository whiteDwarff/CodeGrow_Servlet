package com.web.lecture.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.service.Service;
import com.web.video.dao.LectureDao;
import com.web.video.dto.VideoDto;

public class LectureDetailService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    String id = req.getParameter("id");
    LectureDao Lecturedao = LectureDao.getInstance();
    int finalId = Integer.parseInt(id);
    VideoDto video = Lecturedao.fetchedVideoById(finalId);
    req.setAttribute("video", video);

  }

}
