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

public class VideoDao {
  // new Instance 
  private static VideoDao instance = new VideoDao();

  public static VideoDao getInstance() {
   return instance;
  }
  // 모든 비디오 데이터 조회 
  public List<VideoDto> fetchedVideoList(){
    String sql = "SELECT * FROM video ORDER BY category_id ASC";
    
    List<VideoDto> lists = new ArrayList<VideoDto>();
    
    try(
        Connection con = ConnectionProvider.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
       ) {
      while(rs.next()) {
        int id = rs.getInt("id");
        String title = rs.getString("title");
        String description = rs.getString("description");
        String url = rs.getString("url");
        Date uploaded_at = rs.getTimestamp("uploaded_at");
        int category_id = rs.getInt("category_id");
        
        VideoDto list = new VideoDto(id, title, description, url, uploaded_at, category_id);
        lists.add(list);
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
    return lists;
  }
  // 조회수 업로드
  public void updateHit(int id) {
    String sql = "UPDATE VIDEO SET HIT = HIT + 1 WHERE id = ?";
    
    try(Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setInt(1, id);
      pstmt.executeUpdate();
    }  catch(Exception e) {
      e.printStackTrace();
    }
  }
  // URL로 넘겨진 id를 통해 하나의 비디오 조회
  public VideoDto fetchedVideoId(int id) {
    String sql = "SELECT title, description, url, uploaded_at, hit FROM VIDEO WHERE ID = ?";
    VideoDto video = new VideoDto();
    
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setInt(1, id);
      
      try(ResultSet rs = pstmt.executeQuery();) {
        while(rs.next()) {
          video.setTitle(rs.getString("title"));
          video.setDescription(rs.getString("description"));
          video.setUrl(rs.getString("url"));
          video.setUploaded_at(rs.getDate("uploaded_at"));
          video.setHit(rs.getInt("hit"));
        }
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
    return video;
  }
  // education에서 사용할 sub menu
  public List<VideoDto> fetchedVideoGroup(int groupId) {
    String sql = "SELECT id, title, description, url, category_id from VIDEO WHERE category_id = ?";
    List<VideoDto> videos = new ArrayList<VideoDto>();
    
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setInt(1, groupId);
   
      try(ResultSet rs = pstmt.executeQuery();) {
        while(rs.next()) {
          int id = rs.getInt("id");
          String title = rs.getString("title");
          String description = rs.getString("description");
          String url = rs.getString("url");
          int category_id = rs.getInt("category_id");
          
          VideoDto video = new VideoDto(id, title, description, url, category_id);
          videos.add(video);
        }
        
      }
    } catch (Exception e) {
          e.printStackTrace();
    }
    return videos;
  }
  // 검색내용에 해당하는 video 가져오기 
  public List<VideoDto> fetchedVideoTitle(String value) {
    String sql = "SELECT id, title, description, url, category_id from VIDEO WHERE TITLE LIKE ?";
    List<VideoDto> videos = new ArrayList<VideoDto>();
    
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setString(1, "%"+value+"%");
   
      try(ResultSet rs = pstmt.executeQuery();) {
        while(rs.next()) {
          int id = rs.getInt("id");
          String title = rs.getString("title");
          String description = rs.getString("description");
          String url = rs.getString("url");
          int category_id = rs.getInt("category_id");
          
          VideoDto video = new VideoDto(id, title, description, url, category_id);
          videos.add(video);
        }
      }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return videos;
  }
  
  
}
