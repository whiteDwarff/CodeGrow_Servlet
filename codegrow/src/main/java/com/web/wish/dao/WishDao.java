package com.web.wish.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.web.connection.ConnectionProvider;
import com.web.video.dto.VideoDto;

public class WishDao {
  private static WishDao instance = new WishDao();
  
  public static WishDao getInstance() {
    return instance;
  }
  // 
  public int checkWishList(int video_id, int member_id) {
    int result = 0;
    String sql = "SELECT COUNT(video_id) FROM wish WHERE video_id=? AND member_id=?";
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setInt(1, video_id);
      pstmt.setInt(2, member_id);
      try(ResultSet rs = pstmt.executeQuery();) {
        while(rs.next()) result = rs.getInt(1);
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
    return result;
  }
  // ajax의 요청에 따라 관심목록에 데이터 추가
  public void addWishVideo(int video_id, int member_id) {
    int result = this.checkWishList(video_id, member_id);
    String sql = "";
    if(result <= 0) {
      sql = "INSERT INTO wish (video_id, member_id) VALUES(?,?)";
    } else {
      sql = "DELETE FROM wish WHERE video_id=? AND member_id=?";
    }
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setInt(1, video_id);
      pstmt.setInt(2, member_id);
      pstmt.executeUpdate();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  public List<VideoDto> fetchedWishList(int member_id) {
    List<VideoDto> videos = new ArrayList<VideoDto>();
    String sql = "SELECT id, title, description, url, category_id FROM video "+
        "WHERE id IN (SELECT video_id FROM wish WHERE member_id=?)";
    
    try(
        Connection con = ConnectionProvider.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql);
        ) {
      pstmt.setInt(1, member_id);
      try(ResultSet rs = pstmt.executeQuery();) {
        while(rs.next()) {
          VideoDto video = new VideoDto();
          video.setId(rs.getInt("id"));
          video.setTitle(rs.getString("title"));
          video.setDescription(rs.getString("description"));
          video.setUrl(rs.getString("url"));
          video.setCategory_id(rs.getInt("category_id"));
          videos.add(video);
        }
      }
    } catch(Exception e) {
       e.printStackTrace();
    }
    return videos;
  }
}
