package com.web.search;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.service.Service;

@WebServlet("/search")
public class SearchContoller extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Service service = new SearchService();
    service.execute(req, resp);
    req.getRequestDispatcher("/WEB-INF/search/search.jsp").forward(req, resp);
  }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Service service = new FormService();
    service.execute(req, resp);
    
    req.getRequestDispatcher("/WEB-INF/search/search.jsp").forward(req, resp);
  }

}
