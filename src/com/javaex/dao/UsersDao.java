package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.javaex.vo.UsersVo;

public class UsersDao {

	/////////////////////
	// field
	/////////////////////
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/////////////////////
	// constructor
	/////////////////////
	public UsersDao() {
	}
	
	/////////////////////
	// method
	/////////////////////
	public void getConnection() {
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void close() {
		try {

			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}
	
	public int addUser(UsersVo uvo) {
		
		int count = -1;
		this.getConnection();
		
		try {
			
			String query = "";
			query += " insert into users (no, id, password, name, gender) ";
			query += " values (seq_users_id.nextval, ?, ?, ?, ?) ";
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, uvo.getId());
			pstmt.setString(2, uvo.getPassword());
			pstmt.setString(3, uvo.getName());
			pstmt.setString(4, uvo.getGender());
			
			count = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.close();
		
		return count;
	}
	
	public UsersVo getUser(String id, String password) {
		
		UsersVo uvo = null;
		this.getConnection();
		
		try {

			String query = "";
			query += " select id, password, name, gender ";
			query += " from users ";
			query += " where id = ? ";
			query += " and password = ? ";
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				String ID = rs.getString("id");
				String PASSWORD = rs.getString("password");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				
				uvo = new UsersVo(ID, PASSWORD, name, gender);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		this.close();
		return uvo;
	}
}
