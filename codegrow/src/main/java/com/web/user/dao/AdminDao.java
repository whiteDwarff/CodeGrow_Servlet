package com.web.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mariadb.jdbc.export.Prepare;

import com.web.connection.ConnectionProvider;
import com.web.user.dto.UserDto;

public class AdminDao {
  private static AdminDao instance = new AdminDao();
  
  public static AdminDao getInstance() {
    return instance;
  }
  // 회원목록 조회
  public List<UserDto> fetchedMemberList(int p, int numOfRecords, String select) {
    String sql = "SELECT id, name, email, phone_number, created_at, rank FROM member ORDER BY created_at " + select + " LIMIT ?, ?"; 
    List<UserDto> users = new ArrayList<UserDto>();
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setInt(1,  (p-1) * numOfRecords);
      pstmt.setInt(2, numOfRecords);
      try(ResultSet rs = pstmt.executeQuery();) {
       while(rs.next()) {
         int id = rs.getInt("id");
         String name = rs.getString("name");
         String email = rs.getString("email");
         String phone_number = rs.getString("phone_number");
         Date date = rs.getDate("created_at");
         String rank = rs.getString("rank");
         UserDto user = new UserDto(id, email, name, phone_number, date, rank);
         users.add(user);
       }
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
    return users;
  }
  // -----------------------------------------------------------
  // 이름을 검색해서 회원 조회 
  public List<UserDto> fetchedSerchList(String name) {
    String sql = "SELECT id, name, email, phone_number, created_at, rank FROM member WHERE name LIKE ? ORDER BY created_at";
    List<UserDto> users = new ArrayList<UserDto>();
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setString(1, "%"+name+"%");
      try(ResultSet rs = pstmt.executeQuery();) {
       while(rs.next()) {
         UserDto user = new UserDto();
         
         user.setId(rs.getInt("id"));
         user.setName(rs.getString("name"));
         user.setEmail(rs.getString("email"));
         user.setTel(rs.getString("phone_number"));
         user.setRegDate(rs.getDate("created_at"));
         user.setRank(rs.getString("rank"));
         users.add(user);
       }
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
    return users;
  }
  // -----------------------------------------------------------
  // 사용자의 등급을 변경
  public void changeUserRank(int id, String rank) {
    String sql = "UPDATE member SET rank = ? WHERE id = ?";
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setString(1, rank);
      pstmt.setInt(2, id);
      pstmt.executeUpdate();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  // -----------------------------------------------------------
  // 회원 탈퇴 기능
  // 게시글 및 댓글, 관심목록 삭제
  public void deleteBoard(int id) {
    // 댓글삭제
    String comment = "DELETE FROM comment WHERE author_id = ?";
    // 사용자가 작성한 게시글의 댓글 삭제
    String boardComment = "DELETE FROM comment WHERE post_id in (SELECT id FROM board WHERE author_id = ?)";
    // 사용자가 작성한 게시글 삭제
    String board = "DELETE FROM board WHERE author_id = ?";
    // 사용자의 관심목록 삭제
    String wish = "DELETE FROM wish WHERE member_id = ?";
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement commentPstmt = con.prepareStatement(comment);
        PreparedStatement boardcommentPstmt = con.prepareStatement(boardComment);
        PreparedStatement boardPstmt = con.prepareStatement(board);
        PreparedStatement wishPstmt = con.prepareStatement(wish);
        ){
      commentPstmt.setInt(1, id);
      commentPstmt.executeUpdate();
      boardcommentPstmt.setInt(1, id);
      boardcommentPstmt.executeUpdate();
      boardPstmt.setInt(1, id);
      boardPstmt.executeUpdate();
      wishPstmt.setInt(1, id);
      wishPstmt.executeUpdate();
      
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  // 사용자의 등급이 Teacher인 경우 video 삭제
  public void deleteVideo(int id) {
    // 등록한 강의를 관심목록으로 추가한 사용자들의 관심목록 삭제 
    String wish = "DELETE FROM wish WHERE video_id IN (SELECT id FROM video WHERE uploader_id = ?)";
    // 등록한 강의 삭제
    String video = "DELETE FROM video WHERE uploader_id = ?";
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement wishPstmt = con.prepareStatement(wish);
        PreparedStatement videoPstmt = con.prepareStatement(video);
        ) {
      wishPstmt.setInt(1, id);
      wishPstmt.executeUpdate();
      videoPstmt.setInt(1, id);
      videoPstmt.executeUpdate();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  // 사용자의 등급을 반환
  public String findUserRank(int id) {
    String sql = "SELECT rank FROM member WHERE id = ?";
    String rank = "";
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setInt(1, id);
      try(ResultSet rs = pstmt.executeQuery();) {
        while(rs.next()) {
          rank = rs.getString("rank");
        }
      }
      pstmt.setInt(1, id);
    } catch(Exception e) {
      e.printStackTrace();
    }
    return rank;
  }
  // 사용자 회원탈퇴
  public void deleteUser(int id) {
    String sql = "DELETE FROM member WHERE id = ?";
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
 // -----------------------------------------------------------
  public int recordCount() {
    String sql = "SELECT COUNT(id) FROM MEMBER";
    int count = 0;
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
}
