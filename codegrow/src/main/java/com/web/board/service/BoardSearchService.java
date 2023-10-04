package com.web.board.service;

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

public class BoardSearchService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("utf-8");
    String param = req.getParameter("param");
    String option = req.getParameter("option");
    String content = req.getParameter("content");
    
    BoardAuthDao boardDao = BoardAuthDao.getInstance();
    
    List<AuthDto> lists = boardDao.fechedSearchList(param, option, content);
    
    req.setAttribute("lists", lists);
    req.setAttribute("pm", param);
    }
}
