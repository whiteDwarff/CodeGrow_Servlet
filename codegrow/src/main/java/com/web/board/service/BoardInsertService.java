package com.web.board.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.board.dao.BoardAuthDao;
import com.web.board.dto.AuthDto;
import com.web.service.Service;

public class BoardInsertService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("utf-8");
  
    HttpSession session = req.getSession();
    String title = req.getParameter("title");
    String content = req.getParameter("content");
    String param = req.getParameter("param");
    
    BoardAuthDao dao = BoardAuthDao.getInstance();
    AuthDto newBoard = new AuthDto(title, content, (int)session.getAttribute("id"));
    
    dao.insertBoard(param, newBoard);
    
    int result = dao.getId(param, title, content);
    req.setAttribute("boardId", result);
    req.setAttribute("pm", param);
    
  }

}
