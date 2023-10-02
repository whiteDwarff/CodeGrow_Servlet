package com.web.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.board.dao.BoardAuthDao;
import com.web.service.Service;

public class BoardUpdateService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("utf-8");
    String title = req.getParameter("title");
    String contentValue = req.getParameter("content");
    String param = req.getParameter("param");
    
    int id = Integer.parseInt(req.getParameter("id"));
    
    BoardAuthDao dao = BoardAuthDao.getInstance();
    dao.updateBoard(param, title, contentValue, id);
    
    req.setAttribute("boardId", id);
    req.setAttribute("pm", param);
  }

}
