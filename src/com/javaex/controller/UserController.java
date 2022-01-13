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
			UsersVo authUser = usersDao.getUser(id, password);
			
			if(authUser != null) { // 성공
				/*
				 * request.getSession()
				 * - default는 true
				 * - 인자는 boolean으로, 서버에 생성된 세션이 없을 경우 새로운 세션을 생성할지 말지 결정
				 * - 현재 세션이 존재하면 기존 세션 리턴
				 * 
				 * - 세션은 최소한의 데이터만 저장한다!
				 */
				HttpSession session = request.getSession(); 
				session.setAttribute("authUser", authUser); 
				
				System.out.println("로그인 성공");
				WebUtil.redirect(request, response, "/MySite/main");
			} else { // 실패
				System.out.println("로그인 실패");
				WebUtil.redirect(request, response, "/MySite/user?action=loginForm&result=fail");
			}
		}
		
		else if("logout".equals(action)) {
			System.out.println(action);
			
			HttpSession session = request.getSession();
			session.removeAttribute("authUser"); // 지정된 이름에 해당하는 객체를 세션에서 제거한다.
			session.invalidate(); // 해당 세션을 없애고 세션에 속해 있는 값들을 없앤다.
			
			WebUtil.redirect(request, response, "/MySite/main");
		}
		
		else if("modifyForm".equals(action)) {
			System.out.println(action);
			
			// 세션에 저장되어 있는 정보
			HttpSession session = request.getSession();
			UsersVo authUser = (UsersVo) session.getAttribute("authUser");
			
			// 세션에 있는 정보로 회원 데이터(db) 가져오기
			UsersDao uDao = new UsersDao();
			UsersVo uvo = uDao.getUser(authUser.getId(), authUser.getPassword());
			
			// modifyForm에 정보 넘겨주기
			request.setAttribute("authUser", uvo);
			WebUtil.forward(request, response, "/WEB-INF/views/user/modifyForm.jsp");
		}
		
		else if("modify".equals(action)) {
			System.out.println(action);
			
			String id = request.getParameter("id");
			String password = request.getParameter("passowrd");
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			
			// db 업데이트
			UsersVo uvo = new UsersVo(id, password, name, gender);
			UsersDao uDao = new UsersDao();
			uDao.updateUser(uvo);
			
			// 세션 업데이트
			HttpSession session = request.getSession();
			session.removeAttribute("authUser");
			session.setAttribute("authUser", uvo);
			
			WebUtil.redirect(request, response, "/MySite/main");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
