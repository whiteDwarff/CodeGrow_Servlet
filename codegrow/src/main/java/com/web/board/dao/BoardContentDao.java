package com.web.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.web.board.dto.ContentDto;
import com.web.connection.ConnectionProvider;

public class BoardContentDao {
  private static BoardContentDao instance = new BoardContentDao();

  public static BoardContentDao getInstance() {
    return instance;
  }
  
  // 게시글의 id에 맞는 댓글 조회
  public List<ContentDto> fetchedCommentById(int id) {
    String sql = "SELECT c.id, c.content, c.created_at, m.name "
        + "FROM comment c "
        + "JOIN member m ON c.author_id = m.id "
        + "WHERE post_id = ?";
    
    List<ContentDto> lists = new ArrayList<ContentDto>();
    
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setInt(1, id);
      try(ResultSet rs = pstmt.executeQuery();) {
        while(rs.next()) {
          
          int comment_id = rs.getInt("id");
          String content = rs.getString("content");
          Date created_at = rs.getDate("created_at");
          String name = rs.getString("name");
          
          ContentDto list = new ContentDto(comment_id, content, created_at, name);
          lists.add(list);
        }
      }
      
    } catch(Exception e) {
      e.printStackTrace();
    }
    return lists;
  }
  public int getCount(int id) {
    int count = 0;
    String sql = "SELECT COUNT(id) FROM comment WHERE post_id = ?";
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setInt(1, id);
      try(ResultSet rs = pstmt.executeQuery();) {
        if(rs.next()) count = rs.getInt(1);
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
    return count;
  }
}
