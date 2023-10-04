package com.web.video.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.web.connection.ConnectionProvider;
import com.web.video.dto.VideoDto;

public class LectureDao {
  private static LectureDao instance = new LectureDao();
  
  public static LectureDao getInstance() {
    return instance;
  }
  
  public List<VideoDto> fetchedVideoList(int uploader_id, int p, int numOfRecords, String select){
    String sql="";
    if(select == null || select.equals("1")) 
      sql = "SELECT * FROM video where uploader_id = ? ORDER BY uploaded_at DESC, category_id DESC LIMIT ?, ?";
    else if(select.equals("2")) 
      sql = "SELECT * FROM video where uploader_id = ? ORDER BY uploaded_at ASC, category_id ASC LIMIT ?, ?";
    else if(select.equals("3")) 
      sql = "SELECT * FROM video where uploader_id = ? ORDER BY hit DESC, category_id DESC LIMIT ?, ?";
    else
      sql = "SELECT * FROM video where uploader_id = ? ORDER BY hit ASC, category_id ASC LIMIT ?, ?";
    List<VideoDto> videos = new ArrayList<VideoDto>();
    
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
       ) {
      pstmt.setInt(1, uploader_id);
      pstmt.setInt(2,  (p-1) * numOfRecords);
      pstmt.setInt(3, numOfRecords);
      
      try(ResultSet rs = pstmt.executeQuery();) {
       while(rs.next()) {
         int id = rs.getInt("id");
         String title = rs.getString("title");
         String description = rs.getString("description");
         String url = rs.getString("url");
         Date uploaded_at = rs.getDate("uploaded_at");
         int hit = rs.getInt("hit");
         int category_id = rs.getInt("category_id");
         
         
         VideoDto video = new VideoDto(id, title, description, url, uploaded_at, category_id, hit);
         videos.add(video);
       }
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
    return videos;
  }
  public List<VideoDto> fetchedVideoTitle(String value, int uploaded_id) {
    String sql = "SELECT * from VIDEO WHERE uploader_id = ? and TITLE LIKE ?";
    List<VideoDto> videos = new ArrayList<VideoDto>();
    
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setInt(1, uploaded_id);
      pstmt.setString(2, "%"+value+"%");
   
      try(ResultSet rs = pstmt.executeQuery();) {
        while(rs.next()) {
          int id = rs.getInt("id");
          String title = rs.getString("title");
          String description = rs.getString("description");
          String url = rs.getString("url");
          Date uploaded_at = rs.getDate("uploaded_at");
          int hit = rs.getInt("hit");
          int category_id = rs.getInt("category_id");
          
          VideoDto video = new VideoDto(id, title, description, url, uploaded_at, category_id, hit);
          videos.add(video);
        }
      }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return videos;
  }
  public int recordCount(int id) {
    int count = 0;
    String sql = "SELECT COUNT(id) FROM video WHERE uploader_id = ?";
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setInt(1, id);
      ResultSet rs = pstmt.executeQuery();
      if(rs.next()) count = rs.getInt(1);
      
    } catch(Exception e) {
      e.printStackTrace();
    }
    return count;
  }
  
} 

