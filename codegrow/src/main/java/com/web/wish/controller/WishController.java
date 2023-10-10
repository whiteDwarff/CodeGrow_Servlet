package com.web.wish.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.service.Service;
import com.web.wish.service.WishAddService;

@WebServlet("/wish")
public class WishController extends HttpServlet{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    Service service = new WishAddService();
    service.execute(req, resp);
  }
}
