package net.ajax.db;

import net.member.db.MemberDTO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AjaxDAO {
  
  DataSource ds;
  Connection con;
  PreparedStatement pstmt;
  ResultSet rs;
  
  public AjaxDAO() {
    
    try {
      Context init = new InitialContext();
      ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
      
    } catch (NamingException e) {
      System.out.println("DB 연결 실패");
      e.printStackTrace();
    }
    
  }
  
  /* AJAX start */
  
  public int IdChk(String email) {
    String sql = "SELECT * FROM MEMBER WHERE EMAIL=?";
    
    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement(sql);
      
      pstmt.setString(1, email);
      rs = pstmt.executeQuery();
      
      if (rs.next()) {
        return 1;
      }
      
    } catch (Exception e) {
    } finally {
      if (rs != null) try {
        rs.close();
      } catch (SQLException e) {
      }
      if (pstmt != null) try {
        pstmt.close();
      } catch (SQLException e) {
      }
      if (con != null) try {
        con.close();
      } catch (SQLException e) {
      }
    }
    
    return 0;
    
  }
  
  public boolean modifyPW_chk(String email, String old_pw) {
    String sql = "SELECT PASSWORD FROM MEMBER WHERE EMAIL =? ";
    
    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, email);
      rs = pstmt.executeQuery();
      
      while (rs.next()) {
        MemberDTO dto = new MemberDTO();
        dto.setPASSWORD(rs.getString("PASSWORD"));
        
        System.out.println(dto.getPASSWORD());
        
        if ((dto.getPASSWORD().equals(old_pw))) {
          return true;
        }
        
      }
      
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (rs != null) try {
        rs.close();
      } catch (SQLException e) { /*e.printStackTrace();*/ }
      if (pstmt != null) try {
        pstmt.close();
      } catch (SQLException e) { /*e.printStackTrace();*/ }
      if (con != null) try {
        con.close();
      } catch (SQLException e) { /*e.printStackTrace();*/ }
    }
    
    return false;
    
  }
  
  public boolean modifyPW(String email, String new_pw) {
    String sql = "UPDATE MEMBER SET PASSWORD = ? WHERE EMAIL = ?";
    
    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement(sql);
      
      System.out.println(email);
      System.out.println(new_pw);
      
      pstmt.setString(1, new_pw);
      pstmt.setString(2, email);
      
      pstmt.executeUpdate();
      
      return true;
      
    } catch (Exception e) {
    } finally {
      if (rs != null) try {
        rs.close();
      } catch (SQLException e) {
      }
      if (pstmt != null) try {
        pstmt.close();
      } catch (SQLException e) {
      }
      if (con != null) try {
        con.close();
      } catch (SQLException e) {
      }
    }
    
    return false;
    
  }
  
  /* delete Account */
  
  public boolean deleteAcc(String email) {
    String sql = "DELETE FROM MEMBER WHERE EMAIL = ? ";
    int result = 0;
    
    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, email);
      result = pstmt.executeUpdate();
      
      return true;
      
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (pstmt != null) try {
        pstmt.close();
      } catch (SQLException e) {
      }
      if (con != null) try {
        con.close();
      } catch (SQLException e) {}
    }
    
    return false;
  }
  
  /* AJAX end */
}




