package com.web.search;

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

public class FormService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("utf-8");
    resp.setContentType("text/html; charset=UTF-8");
    
    String title = req.getParameter("title");
    VideoDao dao = VideoDao.getInstance();
    CategoryDao group = CategoryDao.getInstance();
    
    
    List<VideoDto> videos = dao.fetchedVideoTitle(title);
    List<CategoryDto> menus = group.setHeader();
    
    req.setAttribute("videos", videos);
    req.setAttribute("menus", menus);
  }

}
