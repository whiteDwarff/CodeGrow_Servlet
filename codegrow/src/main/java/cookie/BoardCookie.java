package cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.web.board.dao.BoardAuthDao;

public class BoardCookie{
  
  private static BoardCookie instance = new BoardCookie();
  
  public static BoardCookie getInstance() {
    return instance;
  }

  public void boardCookie(HttpServletRequest req, HttpServletResponse resp, String param, String id) {
    
    Cookie[] cookies = req.getCookies();
    
    // 쿠키가 있을 경우
    if (cookies != null) {
      // forEach를 중단시킬 상태변수
      boolean cookieExists = false;
      for (Cookie c : cookies) 
        if (c.getName().equals(param + id)) {
          cookieExists = true;
          break;
      }
        // 해당 게시글의 쿠키가 없거나 쿠키가 아예 없는 경우 새로운 쿠키 생성
       if (!cookieExists || cookies == null) addCookie(req, resp, param, id);
    }
  }
  public void addCookie(HttpServletRequest req, HttpServletResponse resp, String param, String id) {
    BoardAuthDao dao = BoardAuthDao.getInstance();
    dao.updateHit(param, Integer.parseInt(id));
    
    Cookie cookie = new Cookie(param + id, id);
    cookie.setMaxAge(24 * 60 * 60);
    resp.addCookie(cookie);
  }
}
