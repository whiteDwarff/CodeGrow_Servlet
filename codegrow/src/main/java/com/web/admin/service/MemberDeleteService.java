package com.web.admin.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.service.Service;
import com.web.user.dao.AdminDao;

public class MemberDeleteService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("utf-8");
    int id = Integer.parseInt(req.getParameter("id"));
    
    
    AdminDao dao = AdminDao.getInstance();
    
    String rank = dao.findUserRank(id);
    // 사용자의 등급이 Teacher인 경우 wish, video 모든 데이터 삭제
    if(rank.equals("T")) dao.deleteVideo(id);
    // 선택한 사용자의 모든 댓글 및 게시글, wish 삭제
    dao.deleteBoard(id);
    // member table에서 사용자의 데이터 삭제
    dao.deleteUser(id);
  }
}
