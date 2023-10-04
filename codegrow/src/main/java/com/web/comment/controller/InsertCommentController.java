package com.web.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.comment.service.CommentInsertService;
import com.web.service.Service;

@WebServlet("/insertComment")
public class InsertCommentController extends HttpServlet{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new CommentInsertService();
    service.execute(req, resp);
    
    Integer id = (Integer) req.getAttribute("boardId");
    resp.sendRedirect("/boardContent?param=board&id="+id);
  }
}
