package com.web.comment.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.board.dao.BoardCommentDao;
import com.web.service.Service;

public class CommentUpdateService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("utf-8");
    String comment = req.getParameter("comment");
    int comment_id = Integer.parseInt(req.getParameter("comment_id"));
    int board_id = Integer.parseInt(req.getParameter("board_id"));
    
    
    BoardCommentDao dao = BoardCommentDao.getInstance();
    dao.updateComment(comment, comment_id);
    
    req.setAttribute("boardId", board_id);
  }

}
