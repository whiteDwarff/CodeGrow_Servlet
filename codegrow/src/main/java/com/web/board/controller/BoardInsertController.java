package com.web.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.service.Service;

@WebServlet("/boardInsert")
public class BoardInsertController extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new BoardInsertService();
    service.execute(req, resp);
    
    HttpSession session = req.getSession();
    int id = (int)session.getAttribute("boardId");
    req.setAttribute("msg", "게시글이 등록되었습니다.");
    resp.sendRedirect("/boardContent?id="+id);
  }
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new BoardContentService();
    service.execute(req, resp);
    req.getRequestDispatcher("/WEB-INF/board/insertBoard.jsp").forward(req, resp);
  }
}
