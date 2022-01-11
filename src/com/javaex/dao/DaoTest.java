package com.javaex.dao;

import java.util.List;

import com.javaex.vo.GuestbookVo;

public class DaoTest {

	public static void main(String[] args) {
		
		GuestbookDao gDao = new GuestbookDao();
		List<GuestbookVo> list = gDao.getList();
		
		for(GuestbookVo gvo : list) {
			System.out.println(gvo.toString());
		}
		
//		UsersDao usersDao = new UsersDao();
//	
////		usersDao.addUser(new UsersVo("aaa", "1234", "heejin", "female"));
//		
//		UsersVo uvo = usersDao.getUser("hhe", "1234");
//		
//		if(uvo == null) {
//			System.out.println("일치하는 계정이 없습니다.");
//		} else {
//			System.out.println(uvo.toString());
//		}
	}

}
