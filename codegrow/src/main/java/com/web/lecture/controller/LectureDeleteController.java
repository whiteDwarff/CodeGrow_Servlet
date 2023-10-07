package com.web.lecture.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.lecture.service.LectureDeleteService;
import com.web.service.Service;

@WebServlet("/lectureDelete")
public class LectureDeleteController extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new LectureDeleteService();
    service.execute(req, resp);
    
    req.getRequestDispatcher("/lecture").forward(req, resp);
    
  }
}
