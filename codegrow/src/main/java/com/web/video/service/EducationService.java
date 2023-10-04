package com.web.video.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.category.dao.CategoryDao;
import com.web.category.dto.CategoryDto;
import com.web.service.Service;
import com.web.video.dao.VideoDao;
import com.web.video.dto.VideoDto;

public class EducationService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=UTF-8");
    
    int id = Integer.parseInt(req.getParameter("id"));
    int groupId = Integer.parseInt(req.getParameter("group"));
    
    VideoDao dao = VideoDao.getInstance();
    
    dao.updateHit(id);
    VideoDto video = dao.fetchedVideoId(id);
    List<VideoDto> subMenu = dao.fetchedVideoGroup(groupId);
    
    req.setAttribute("subMenu", subMenu);
    req.setAttribute("video", video);
  }

}
