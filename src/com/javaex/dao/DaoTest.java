package com.javaex.dao;

import com.javaex.vo.UsersVo;

public class DaoTest {

	public static void main(String[] args) {
		
		UsersDao uDao = new UsersDao();
		
		uDao.updateUser(new UsersVo("1", "1234", "sihoney", "male"));
		
		
		
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
