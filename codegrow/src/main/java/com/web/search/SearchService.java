package com.web.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.category.dao.CategoryDao;
import com.web.category.dto.CategoryDto;
import com.web.service.Service;
import com.web.video.dao.VideoDao;
import com.web.video.dto.VideoDto;
import com.web.wish.dao.WishDao;

public class SearchService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=UTF-8");
    
    String id = req.getParameter("group");
    
    if(id == null) {
      
      WishDao dao = WishDao.getInstance();
      HttpSession session = req.getSession();
      List<VideoDto> videos = dao.fetchedWishList((int)session.getAttribute("id"));
      req.setAttribute("videos", videos);
    } else {
      int groupId = Integer.parseInt(id);
      VideoDao dao = VideoDao.getInstance();
      List<VideoDto> videos = dao.fetchedVideoGroup(groupId);
      req.setAttribute("videos", videos);
      
    }
  }

}
