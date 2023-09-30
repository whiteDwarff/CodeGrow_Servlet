package com.web.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.board.dao.BoardAuthDao;
import com.web.board.dto.AuthDto;
import com.web.category.dao.CategoryDao;
import com.web.category.dto.CategoryDto;
import com.web.service.Service;

public class BoardSearchService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("utf-8");
    BoardAuthDao boardDao = BoardAuthDao.getInstance();
    CategoryDao group = CategoryDao.getInstance();
    
    int count = boardDao.recordCount(); // 전체 레코드의 개수
    int numOfRecords = 10; // 한번에 가져올 레코드의 개수 
    int numOfPages = 5;    // 한 화면에 표시될 페이지의 개수
    
    String page = req.getParameter("p");
    int p = 1;
    
    if(page != null && !page.equals("")) p = Integer.parseInt(page);
    
    int startNum = p - ((p-1) % numOfPages);
    int lastNum = (int)Math.ceil((float)count / (float)numOfRecords);
    
    String option = req.getParameter("option");
    String content = req.getParameter("content");
    
    List<AuthDto> lists = boardDao.fechedSearchList(option, content);
    List<CategoryDto> menus = group.setHeader();
    
    req.setAttribute("lists", lists);
    req.setAttribute("menus", menus);
    req.setAttribute("startNum", startNum);
    req.setAttribute("lastNum", lastNum);
    req.setAttribute("numOfPages", numOfPages);
    req.setAttribute("p", p);
    }
  

}