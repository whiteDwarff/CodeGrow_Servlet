package com.web.admin.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.service.Service;
import com.web.user.dao.AdminDao;
import com.web.user.dto.UserDto;

public class MemberListService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("utf-8");
    String select = req.getParameter("select");
    
    if(select == null) {
      select = "DESC";
    }
    AdminDao dao = AdminDao.getInstance();
    // ------------------------------------------------
    // 페이지네이션 처리
    int count = dao.recordCount(); // 전체 레코드의 개수
    int numOfRecords = 10; // 한번에 가져올 레코드의 개수 
    int numOfPages = 5;    // 한 화면에 표시될 페이지의 개수
    
    String page = req.getParameter("p");
    int p = 1;
    if(page != null && !page.equals("")) p = Integer.parseInt(page);
    int startNum = p - ((p-1) % numOfPages);
    int lastNum = (int)Math.ceil((float)count / (float)numOfRecords);
    
    List<UserDto> users = dao.fetchedMemberList(p, numOfRecords, select);
    req.setAttribute("startNum", startNum);
    req.setAttribute("lastNum", lastNum);
    req.setAttribute("numOfPages", numOfPages);
    req.setAttribute("p", p);
    // ------------------------------------------------
    req.setAttribute("users", users);
    req.setAttribute("option", select);

  }

}
