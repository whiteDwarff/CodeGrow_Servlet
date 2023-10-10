package com.web.wish.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.web.service.Service;
import com.web.wish.dao.WishDao;

public class WishAddService implements Service {

  @Override
  public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Auto-generated method stub
    req.setCharacterEncoding("utf-8");
    HttpSession session = req.getSession();

    int member_id = (int) session.getAttribute("id");
    try {
      // JSON 데이터를 파싱하기 위해 사용할 객체, JSON 객체를 JAVA 객체로 변환해 줌
      JSONParser parser = new JSONParser();
      // HTTP 요청의 본문(JSON 데이터)를 파싱하고 결과룰 JSON Object로 변환
      JSONObject jsonBody = (JSONObject) parser.parse(req.getReader());
      // 파싱된 JSON Object 객체에서 요청한 값을 반환
      String video_id = (String) jsonBody.get("id");
      
      WishDao dao = WishDao.getInstance();
      int wish = dao.checkWishList(Integer.parseInt(video_id), member_id);
      dao.addWishVideo(Integer.parseInt(video_id), member_id);

    } catch (ParseException e) {
      e.printStackTrace();
    }
  }

}
