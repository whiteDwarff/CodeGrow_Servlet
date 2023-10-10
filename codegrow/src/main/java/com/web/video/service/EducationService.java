package com.web.video.service;

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

import cookie.VideoCookie;

public class EducationService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=UTF-8");
    
    int id = Integer.parseInt(req.getParameter("id"));
    int groupId = Integer.parseInt(req.getParameter("group"));
    
    // ------------------------------------------------------
    // cookie 존재 여부에 따라 조회수 업로드
    VideoCookie cookie = VideoCookie.getInstance();
    cookie.videoCookie(req, resp, Integer.toString(id));
    // ------------------------------------------------------
    // main video와 subMenu 저장
    VideoDao dao = VideoDao.getInstance();
    VideoDto video = dao.fetchedVideoId(id);
    List<VideoDto> subMenu = dao.fetchedVideoGroup(groupId);
    // ------------------------------------------------------
    // 관심목록에 해당 비디오가 있는지 확인
    WishDao wishDao = WishDao.getInstance();
    HttpSession session = req.getSession(false);
    if(session != null && (Integer)session.getAttribute("id") != null) {
      // result가 1을 반환하면 관심목록에 추가된 video
      int result = wishDao.checkWishList(id, (int)session.getAttribute("id"));
      req.setAttribute("result", result);
    }
    
    req.setAttribute("video", video);
    req.setAttribute("subMenu", subMenu);
  }

}
