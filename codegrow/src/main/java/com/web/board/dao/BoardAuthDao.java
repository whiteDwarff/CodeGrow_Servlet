package com.web.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.web.board.dto.AuthDto;
import com.web.connection.ConnectionProvider;

public class BoardAuthDao {
  private static BoardAuthDao instance = new BoardAuthDao();
  
  public static BoardAuthDao getInstance() {
    return instance;
  }

  // 게시판의 모든 데이터 조회
  public List<AuthDto> fetchedBoardList(int p, int numOfRecords, String select) {
    String sql = "";
    System.out.println(select);
    
    if(select == null || select.equals("1")) {
       sql = "SELECT b.id, b.title, b.content, b.author_id, b.created_at, "+
       "b.hit, m.name FROM board b JOIN member m on b.author_id = m.id ORDER BY b.id DESC LIMIT ?, ?";
    } else if(select.equals("2")) {
      sql = "SELECT b.id, b.title, b.content, b.author_id, b.created_at, "+
          "b.hit, m.name FROM board b JOIN member m on b.author_id = m.id LIMIT ?, ?";
    } else if(select.equals("3")) {
      sql = "SELECT b.id, b.title, b.content, b.author_id, b.created_at, "+
          "b.hit, m.name FROM board b JOIN member m on b.author_id = m.id ORDER BY b.hit DESC LIMIT ?, ?";
    } else {
      sql = "SELECT b.id, b.title, b.content, b.author_id, b.created_at, "+
          "b.hit, m.name FROM board b JOIN member m on b.author_id = m.id ORDER BY b.hit LIMIT ?, ?";
    }
  
    List<AuthDto> contents = new ArrayList<AuthDto>();
    
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ){
      
      pstmt.setInt(1,  (p-1) * numOfRecords);
      pstmt.setInt(2, numOfRecords);
      
        try( ResultSet rs = pstmt.executeQuery();) {
          
          while(rs.next()) {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String content = rs.getString("content");
            int authorId = rs.getInt("author_id");
            Date createdAt = rs.getDate("created_at");
            int hit = rs.getInt("hit");
            String name = rs.getString("name");
            
            AuthDto auth = new AuthDto(id,title, content, authorId, createdAt, hit, name);
            contents.add(auth);
          }
        }
      
    } catch(Exception e) {
      e.printStackTrace();
    }
    return contents;
  }
  // 하나의 게시글 조회
  public AuthDto fetchedBoardId(int id) {
    String sql =  "SELECT b.id, b.title, b.content, b.author_id, b.created_at, "+
        "b.hit, m.name FROM board b JOIN member m on b.author_id = m.id WHERE b.id = ?";
    AuthDto board = new AuthDto();
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setInt(1, id);
      try(ResultSet rs = pstmt.executeQuery();) {
        while(rs.next()) {
          int board_id = rs.getInt("id");
          String title = rs.getString("title");
          String content = rs.getString("content");
          int authorId = rs.getInt("author_id");
          Date createdAt = rs.getDate("created_at");
          int hit = rs.getInt("hit");
          String name = rs.getString("name");
          
          board = new AuthDto(board_id, title, content, authorId, createdAt, hit, name);
        }
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
    return board;
  }
  // 게시판 검색기능
  public List<AuthDto> fechedSearchList(String param, String keyword) {
    List<AuthDto> contents = new ArrayList<AuthDto>();
    String sql ="";
    if(param.equals("title")) {
     sql = "SELECT b.id, b.title, b.content, b.author_id, b.created_at, b.hit, m.name "
         + "FROM board b "
         + "JOIN member m ON b.author_id = m.id "
         + "WHERE b.title LIKE ? "
         + "ORDER BY b.id DESC";
    } else if(param.equals("name")) {
       sql = " SELECT b.id, b.title, b.content, b.author_id, b.created_at, b.hit, m.name "
           + "FROM board b "
           + "JOIN member m ON b.author_id = m.id "
           + "WHERE m.name LIKE ?"
           + "ORDER BY b.id DESC";
    }
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      
      pstmt.setString(1, "%"+keyword+"%");
      
      try(ResultSet rs = pstmt.executeQuery();) {
        while(rs.next()) {
          int id = rs.getInt("id");
          String title = rs.getString("title");
          String content = rs.getString("content");
          int authorId = rs.getInt("author_id");
          Date createdAt = rs.getDate("created_at");
          int hit = rs.getInt("hit");
          String name = rs.getString("name");
          
          AuthDto auth = new AuthDto(id,title, content, authorId, createdAt, hit, name);
          contents.add(auth);
        }
      }
      
    } catch(Exception e) {
      e.printStackTrace();
    }
    return contents;
  }
  // 게시판의 모든 게시글의 개수 조회 
  public int recordCount() {
    int count = 0;
    String sql = "SELECT count(id) FROM BOARD";
    
    try(
        Connection con = ConnectionProvider.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ) {
      if(rs.next()) count = rs.getInt(1);
      
    } catch(Exception e) {
      e.printStackTrace();
    }
    return count;
  }
  // 조회수 업로드
  public void updateHit(int id) {
    String sql = "UPDATE board SET HIT = HIT + 1 WHERE id = ?";
    
    try(Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setInt(1, id);
      pstmt.executeUpdate();
    }  catch(Exception e) {
      e.printStackTrace();
    }
  }
  // 게시글 작성
  public void insertBoard(AuthDto dto) {
    String sql = "INSERT INTO board (title, content, author_id) VALUES (?, ?, ?)";
    
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setString(1, dto.getTitle());
      pstmt.setString(2, dto.getContent());
      pstmt.setInt(3, dto.getAuthor_id());
      int i = pstmt.executeUpdate();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  public void updateBoard(String title, String content, int id) {
    String sql = "UPDATE BOARD SET title=?, content=? where id=?";
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setString(1, title);
      pstmt.setString(2, content);
      pstmt.setInt(3, id);
      int i = pstmt.executeUpdate();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  public void deleteBoard(int id) {
    String sql = "DELETE FROM board WHERE id = ?";
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ){
      pstmt.setInt(1, id);
      int i = pstmt.executeUpdate();
      
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  public int getId(String title, String content) {
    String sql = "SELECT id FROM BOARD WHERE title = ? and content = ?";
    int count = 0;
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
        pstmt.setString(1, title);
        pstmt.setString(2, content);
        try(ResultSet rs = pstmt.executeQuery();) {
      
        if(rs.next()) count = rs.getInt(1);
        }
      
    } catch(Exception e) {
      e.printStackTrace();
    }
    return count;
  }
}
