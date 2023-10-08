package com.web.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
  // 이름을 검색해서 회원 조회 
  public UserDto fetchedSerchList(String value) {
    String sql = "SELECT id, name, email, phone_number, created_at, rank FROM member ORDER BY created_at WHERE name LIKE ?";
    UserDto user = new UserDto();
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        ) {
      pstmt.setString(1, "%"+value+"%");
      while(rs.next()) {
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setTel(rs.getString("phone_number"));
        user.setRegDate(rs.getDate("created_at"));
        user.setRank(rs.getString("rank"));
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
    return user;
  }
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
