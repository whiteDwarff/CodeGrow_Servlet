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

public class LectuceListService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("utf-8");
    
    HttpSession session = req.getSession();
    LectureDao dao = LectureDao.getInstance();
    int id = (int) session.getAttribute("id");
    
    String select = req.getParameter("select");
    if(select == null) select = "1";
    
    int count = dao.recordCount(id); // 전체 레코드의 개수
    int numOfRecords = 7; // 한번에 가져올 레코드의 개수 
    int numOfPages = 5;    // 한 화면에 표시될 페이지의 개수
    
    String page = req.getParameter("p");
    int p = 1;
    
    if(page != null && !page.equals("")) p = Integer.parseInt(page);
    
    int startNum = p - ((p-1) % numOfPages);
    int lastNum = (int)Math.ceil((float)count / (float)numOfRecords);
    
    
    List<VideoDto> videos = dao.fetchedVideoList(id, p, numOfRecords, select);
    
    req.setAttribute("videos", videos);
    req.setAttribute("startNum", startNum);
    req.setAttribute("lastNum", lastNum);
    req.setAttribute("numOfPages", numOfPages);
    req.setAttribute("option", select);
    req.setAttribute("p", p);
  }

}
