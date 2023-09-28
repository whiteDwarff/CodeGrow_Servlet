package com.web.category.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.web.category.dto.CategoryDto;
import com.web.connection.ConnectionProvider;

public class CategoryDao {
  private static CategoryDao instance = new CategoryDao();
  
  public static CategoryDao getInstance() {
    return instance;
  }

  
  public List<CategoryDto> setHeader() {
    String sql = "SELECT id, name FROM CATEGORY";
    
    List<CategoryDto> menus = new ArrayList<CategoryDto>();
    
    try(
        Connection con = ConnectionProvider.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ) {
        while(rs.next()) {
          int id = rs.getInt("id");
          String name = rs.getString("name");
          
          CategoryDto menu = new CategoryDto(id, name);
          menus.add(menu);
          
        }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return menus;
  }
  // index의 slide 가이드
  public List<CategoryDto> fetchedGroupTitle() {
    String sql = "SELECT id, name, discription FROM CATEGORY";
    
    // array 객체 생성 
    List<CategoryDto> lists = new ArrayList<CategoryDto>();
    
    try(
        Connection con = ConnectionProvider.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ) {
      while(rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String discrioption = rs.getString("discription");
        
        // 하나의 카테고리 목록을 담은 객체 생성
        CategoryDto list = new CategoryDto(id, name, discrioption);
        // array에 담기
        lists.add(list);
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    return lists;
  }
}
