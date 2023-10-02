package com.web.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.board.controller.BoardListService;
import com.web.service.Service;

@WebServlet("/notice")
public class NoticeController extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new BoardListService();
    service.execute(req, resp);
    req.getRequestDispatcher("/WEB-INF/board/BoardList.jsp").forward(req, resp);
  }
}
