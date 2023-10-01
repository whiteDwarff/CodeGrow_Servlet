package com.web.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.board.dao.BoardCommentDao;
import com.web.service.Service;

public class InsertCommentService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("utf-8");
    HttpSession session = req.getSession();
    
    String comment = req.getParameter("comment");
    int post_id = Integer.parseInt(req.getParameter("post_id")); // 게시글의 ID
    int author_id = (int)session.getAttribute("id");   // 작성자의 ID
    
    BoardCommentDao dao = BoardCommentDao.getInstance();
    dao.insertComment(comment, post_id, author_id);
    session.setAttribute("board_id", post_id);

  }

}
