package com.web.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.board.service.BoardListService;
import com.web.board.service.BoardSearchService;
import com.web.service.Service;

@WebServlet("/board")
public class BoardController extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new BoardListService();
    service.execute(req, resp);
    req.getRequestDispatcher("/WEB-INF/board/BoardList.jsp").forward(req, resp);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new BoardSearchService();
    service.execute(req, resp);
    String param = (String) req.getAttribute("pm");
    req.getRequestDispatcher("/WEB-INF/board/BoardList.jsp?param="+param).forward(req, resp);
  }

}
