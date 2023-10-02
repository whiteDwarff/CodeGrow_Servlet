package com.web.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.service.Service;

@WebServlet("/boardUpdate")
public class BoardUpdateController extends HttpServlet{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new BoardUpdateService();
    service.execute(req, resp);
    
    String param = (String) req.getAttribute("pm");
    Integer id = (Integer) req.getAttribute("boardId");
    
    resp.sendRedirect("/boardContent?param="+param+"&id="+id);
  }

}
