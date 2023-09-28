package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
  private Connection getConnection() throws Exception {
    InitialContext init = new InitialContext();
    DataSource ds = (DataSource) init.lookup("java:comp//env/jdbc/codegrow");
    Connection con = ds.getConnection();
    
    return con;
   }
   public MemberDto loginDao(String emeil, String passwrod) {
    String sql = "select * from member where email = ? and password = ?";
    MemberDto dto = new MemberDto();
    
    try(Connection con = getConnection(); 
     PreparedStatement pstmt = con.prepareStatement(sql);) {
     
     pstmt.setString(1, emeil);
     pstmt.setString(2, passwrod);
     
     try(ResultSet rs = pstmt.executeQuery();) {
       if(rs.next()) {
         dto.setName(rs.getString("name"));
         dto.setEmail(rs.getString("email"));
         dto.setPassword(rs.getString("password"));
         dto.setPhone(rs.getString("phone_number"));
       } 
     }
    } catch(Exception e) {
     e.printStackTrace();
    }
    return dto;
   }
}
