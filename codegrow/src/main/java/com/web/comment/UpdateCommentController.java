package com.web.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.service.Service;

@WebServlet("/updateComment")
public class UpdateCommentController extends HttpServlet{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new UpdateCommentService();
    service.execute(req, resp);
    
    HttpSession session = req.getSession();
    int id = (int)session.getAttribute("board_id");
    resp.sendRedirect("boardContent?id="+id);
  }
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new DeleteCommentService();
    service.execute(req, resp);
    
    HttpSession session = req.getSession();
    int id = (int)session.getAttribute("board_id");
    req.setAttribute("msg", "댓글이 삭제되었습니다.");
    req.getRequestDispatcher("/boardContent?id="+id).forward(req, resp);
  }

}
