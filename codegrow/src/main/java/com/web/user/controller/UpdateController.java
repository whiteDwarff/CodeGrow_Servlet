package com.web.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.category.dao.CategoryDao;
import com.web.category.dto.CategoryDto;
import com.web.service.Service;
import com.web.user.service.UserUpdateService;

@WebServlet("/updateInfo")
public class UpdateController extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    CategoryDao group = CategoryDao.getInstance();
    List<CategoryDto> menus = group.setHeader();
    req.setAttribute("menus", menus);
    req.getRequestDispatcher("/WEB-INF/member/updateInfo.jsp").forward(req, resp);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new UserUpdateService();
    service.execute(req, resp);
    req.getRequestDispatcher("/WEB-INF/member/updateInfo.jsp").forward(req, resp);
  }

}
