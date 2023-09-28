package com.web.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.web.connection.ConnectionProvider;
import com.web.user.dto.LoginDto;
import com.web.user.dto.UserDto;

public class UserDao {
	// 다른 파일에서 new 키워드로 객체를 생성하지 않아도 됨 
	// 객체 생성과 관리가 효율적임
	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
	public UserDto loginDao(LoginDto dto) {
		
		UserDto user = new UserDto();
		
		String sql = "SELECT email, password, name, phone_number, created_at FROM member" +
					 " WHERE email = ? AND password = ?";
		// finally를 통해 con, pstmt를 닫아줄 필요 없음
		try(
			Connection con = ConnectionProvider.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
		) {
			// pstmt 객체에 값을 mapping
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPwd());
			
			// ResultSet 객체의 close() 필요x
			try (ResultSet rs = pstmt.executeQuery();) {
				if(rs.next()) {
					// query를 통해 반환된 값을 user 객체에 저장
					// login dto 객체의 값을 email에 셋팅
					user.setEmail(dto.getEmail());
					user.setName(rs.getString("name"));
					user.setTel(rs.getString("phone_number"));
					user.setRegDate(rs.getDate("created_at"));
					user.setNumber(1);
				} else user.setNumber(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	return user;
	}
	// 회원가입 
	public int singUp(Register user) {
	  int result = 0;
	  String sql = "INSERT INTO member (name, email, password, phone_number) VALUES(?,?,?,?)";
	  
	  try(
	      Connection con = ConnectionProvider.getConnection();
	      PreparedStatement pstmt = con.prepareStatement(sql);
	  ) {
	    pstmt.setString(1, user.getName());
	    pstmt.setString(2, user.getEmail());
	    pstmt.setString(3, user.getPwd());
	    pstmt.setString(4, user.getTel());
	    
	    result = pstmt.executeUpdate();
	    
	    System.out.println(user.getName());
	    System.out.println(user.getEmail());
	    System.out.println(user.getPwd());
	    System.out.println(user.getTel());
	    
	  } catch (Exception e) {
	    e.printStackTrace();
	  } 
	  return result;
	}
}
