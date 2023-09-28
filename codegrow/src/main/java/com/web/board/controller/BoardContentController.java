package com.web.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.service.Service;

@WebServlet("/boardContent")
public class BoardContentController extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Service service = new BoardContentService();
    service.execute(req, resp);
    req.getRequestDispatcher("/WEB-INF/board/boardContent.jsp").forward(req, resp);
  }
}
