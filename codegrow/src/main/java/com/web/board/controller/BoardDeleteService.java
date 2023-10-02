package com.web.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.board.dao.BoardAuthDao;
import com.web.board.dao.BoardCommentDao;
import com.web.service.Service;

public class BoardDeleteService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    int id = Integer.parseInt(req.getParameter("id"));
    String param = req.getParameter("param");
    BoardAuthDao board = BoardAuthDao.getInstance();
    BoardCommentDao comment = BoardCommentDao.getInstance();
    // 게시글의 댓글 삭제 
    comment.deleteBoardCommenct(id);
    // 게시글 삭제
    board.deleteBoard(param, id);
    
    req.setAttribute("msg", "게시글이 삭제되었습니다.");

  }

}
