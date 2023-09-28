package com.web.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.board.dao.BoardAuthDao;
import com.web.board.dto.AuthDto;
import com.web.category.dao.CategoryDao;
import com.web.category.dto.CategoryDto;
import com.web.service.Service;

public class BoardContentService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("utf-8");
    int id = Integer.parseInt(req.getParameter("id"));
    
    BoardAuthDao dao = BoardAuthDao.getInstance();
    CategoryDao group = CategoryDao.getInstance();
    
    dao.updateHit(id);
    AuthDto content = dao.fetchedBoardId(id);
    List<CategoryDto> menus = group.setHeader();
    
    req.setAttribute("content", content);
    req.setAttribute("menus", menus);

  }

}
