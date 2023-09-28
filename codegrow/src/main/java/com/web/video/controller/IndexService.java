package com.web.video.controller;

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

public class IndexService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=UTF-8");
    
    VideoDao video = VideoDao.getInstance();
    CategoryDao group = CategoryDao.getInstance();
    
    List<VideoDto> videos = video.fetchedVideoList();
    List<CategoryDto> category = group.fetchedGroupTitle();
    List<CategoryDto> menus = group.setHeader();
    
    req.setAttribute("videos", videos);
    req.setAttribute("category", category);
    req.setAttribute("menus", menus);
  }

}
