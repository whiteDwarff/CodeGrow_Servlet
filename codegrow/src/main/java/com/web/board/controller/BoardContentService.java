package com.web.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.board.dao.BoardAuthDao;
import com.web.board.dao.BoardCommentDao;
import com.web.board.dto.AuthDto;
import com.web.board.dto.ContentDto;
import com.web.category.dao.CategoryDao;
import com.web.category.dto.CategoryDto;
import com.web.service.Service;

public class BoardContentService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("utf-8");
    
      String id = req.getParameter("id");
      
      BoardAuthDao dao = BoardAuthDao.getInstance();
      BoardCommentDao contentDao = BoardCommentDao.getInstance();
      CategoryDao group = CategoryDao.getInstance();
      List<CategoryDto> menus = group.setHeader();
    
    // insertBoard를 분기처리 하기 위해 id가 있는 경우 req 객체에 저장하여 포워딩 하기 위함
    if(id != null && !id.isEmpty()) {
      int finalId = Integer.parseInt(id);
      
      dao.updateHit(finalId);
      int count = contentDao.getCount(finalId);
      AuthDto content = dao.fetchedBoardId(finalId);
      List<ContentDto> comment = contentDao.fetchedCommentById(finalId);
      
      req.setAttribute("content", content);
      req.setAttribute("count", count);
      req.setAttribute("comment", comment);
    }
    
    
    req.setAttribute("menus", menus);
  }

}
