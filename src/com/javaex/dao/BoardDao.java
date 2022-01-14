package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.vo.BoardVo;

public class BoardDao {
	
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
	public BoardDao() {
		
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
	
	public List<BoardVo> getList(){
		
		this.getConnection();
		List<BoardVo> list = new ArrayList<>();
		
		try {
	         /*****************************
	          3. SQL문 준비 / 바인딩 / 실행
	         ******************************/
			String query = "";
			query += " select board.no, ";
			query += "         title, ";
			query += "         name, ";
			query += "         hit, ";
			query += "         to_char(reg_date, 'YY-MM-DD HH:MI') reg_date ";
			query += " from board, users ";
			query += " where board.user_no = users.no ";
			query += " order by reg_date desc ";
			
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
	         /******************
	         4.결과처리
	         *******************/
			while(rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String name = rs.getString("name");
				int hit = rs.getInt("hit");
				String date = rs.getString("reg_date");
				
				BoardVo bvo = new BoardVo(no, title, name, hit, date);
				list.add(bvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.close();
		return list;
	}
	
	public void addBoard(BoardVo bvo) {
		
		this.getConnection();
		
		try {
			/*********************************
			 3. SQL문 준비 / 바인딩 / 실행
			**********************************/
			String query = "";
			query += " insert into board ";
			query += " values(seq_board_no.nextval, ?, ?, 0, sysdate, ?) ";
		
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, bvo.getTitle());
			pstmt.setString(2, bvo.getContent());
			pstmt.setInt(3, bvo.getUserNo());
			
			int count = pstmt.executeUpdate();
			
	        /*****************
			 4.결과처리
			******************/
			System.out.println(count + "건이 저장되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.close();
	}
	
	public int deleteBoard(int no) {
		
		int count = 0;
		this.getConnection();
		
		try {
			
			String query = "";
			query += " delete from board ";
			query += " where no = ? ";
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, no);
			
			count = pstmt.executeUpdate();
			
			System.out.println(count + "건이 삭제되었습니다.");
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		}
		
		this.close();
		
		return count;
	}
	
	public BoardVo getInfo(int no) {
		
		BoardVo bvo = null;
		this.getConnection();
		
		try {
	         /*****************************
	          3. SQL문 준비 / 바인딩 / 실행
	         ******************************/
			String query = "";
			query += " select board.no, ";
			query += "         title, ";
			query += "         name, ";
			query += "         hit, ";
			query += "         to_char(reg_date, 'YY-MM-DD HH:MI') ";
			query += "         , content ";
			query += " from board, users ";
			query += " where board.user_no = users.no ";
			query += " and board.no = ? ";
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
	         /******************
	         4.결과처리
	         *******************/
			while(rs.next()) {
				int boardNo = rs.getInt(1);
				String title = rs.getString(2);
				String name = rs.getString(3);
				int hit = rs.getInt(4);
				String regDate = rs.getString(5);
				String content = rs.getString(6);
				
				bvo = new BoardVo(boardNo, title, content, hit, regDate, 0, name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.close();
		
		return bvo;
	}
	
	public void updateViews(int no) {
		
		this.getConnection();
		
		try {
			/*********************************
			 3. SQL문 준비 / 바인딩 / 실행
			**********************************/
			String query = "";
			query += " update board ";
			query += " set hit = hit + 1 ";
			query += " where no = ? ";
		
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, no);
			
			int count = pstmt.executeUpdate();
			
	        /*****************
			 4.결과처리
			******************/
			System.out.println(count + "회 조회수가 증가했습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.close();
	}
	
	public void updateBoard(BoardVo bvo) {
		
		this.getConnection();
		
		try {
			/*********************************
			 3. SQL문 준비 / 바인딩 / 실행
			**********************************/
			String query = "";
			query += " update board ";
			query += " set title = ?, content = ? ";
			query += " where no = ?";
		
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, bvo.getTitle());
			pstmt.setString(2, bvo.getContent());
			pstmt.setInt(3, bvo.getNo());
			
			int count = pstmt.executeUpdate();
			
	        /*****************
			 4.결과처리
			******************/
			System.out.println(count + "건이 수정되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.close();
	}
}
