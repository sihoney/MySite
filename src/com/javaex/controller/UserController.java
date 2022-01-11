package com.javaex.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaex.dao.UsersDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.UsersVo;

@WebServlet("/user")
public class UserController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/user");
		
		String action = request.getParameter("action");
		
		if("joinForm".equals(action)) {
			
			WebUtil.forward(request, response, "/WEB-INF/views/user/joinForm.jsp");
		}
		
		else if("join".equals(action)) {
			System.out.println(action);
			
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			
			UsersDao usersDao = new UsersDao();
			UsersVo uvo = new UsersVo(id, password, name, gender);
			int count = usersDao.addUser(uvo);
			System.out.println(count + "건이 저장되었습니다.");
			
			WebUtil.forward(request, response, "/WEB-INF/views/user/joinOk.jsp");
			
		} 
		
		else if("loginForm".equals(action)) {
			System.out.println(action);
			
			WebUtil.forward(request, response, "/WEB-INF/views/user/loginForm.jsp");
		}
		
		else if("login".equals(action)) {
			System.out.println(action);
			
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			UsersDao usersDao = new UsersDao();
			UsersVo uvo = usersDao.getUser(id, password);
			
			if(uvo != null) { // 성공
				HttpSession session = request.getSession(); 
				// default는 true
				// 인자는 boolean으로, 서버에 생성된 세션이 없을 경우 새로운 세션을 생성할지 말지 결정
				session.setAttribute("user", uvo); 
				
				System.out.println("로그인 성공");
				WebUtil.redirect(request, response, "/MySite/main");
			} else { // 실패
				System.out.println("로그인 실패");
				WebUtil.redirect(request, response, "/MySite/user?action=loginForm&result=fail");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
