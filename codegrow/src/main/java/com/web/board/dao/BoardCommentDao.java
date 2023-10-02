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

public class BoardCommentDao {
  private static BoardCommentDao instance = new BoardCommentDao();

  public static BoardCommentDao getInstance() {
    return instance;
  }
  
  // 게시글의 id에 맞는 댓글 조회
  public List<ContentDto> fetchedCommentById(int id) {
    String sql = "SELECT c.id, c.content, c.created_at, m.name "
        + "FROM comment c "
        + "JOIN member m ON c.author_id = m.id "
        + "WHERE post_id = ? ORDER BY c.id DESC";
    
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
  // 댓글 등록 
  public void insertComment(String comment, int post_id, int author_id) {
    String sql = "INSERT INTO comment (content, post_id, author_id) VALUES (?, ?, ?)";
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ){
      pstmt.setString(1, comment);
      pstmt.setInt(2, post_id);
      pstmt.setInt(3, author_id);
      
      pstmt.executeUpdate();
      
      
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  // 댓글 수정
  public void updateComment(String comment, int id) {
    String sql = "UPDATE comment SET content = ? where id = ?";
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setString(1, comment);
      pstmt.setInt(2, id);
      pstmt.executeUpdate();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  // 댓글 삭제
  public void deleteComment(int id) {
    String sql = "DELETE FROM comment WHERE id = ?";
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ){
      pstmt.setInt(1, id);
      pstmt.executeUpdate();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  // 게시글 삭제 시 댓글까지 삭제 
  public void deleteBoardCommenct(int id) {
    String sql = "DELETE FROM comment WHERE post_id = ?";
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setInt(1, id);
      pstmt.executeUpdate();
      
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  // 댓글 수 조회
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
