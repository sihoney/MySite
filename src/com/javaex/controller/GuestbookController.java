package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.GuestbookDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.GuestbookVo;


@WebServlet("/guest")
public class GuestbookController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/guest");
		
		String action = request.getParameter("action");
		
		if("deleteForm".equals(action)) {
			
			WebUtil.forward(request, response, "/WEB-INF/views/guestbook/deleteForm.jsp");
			
		} 
		else if("delete".equals(action)) {
			String pass = request.getParameter("pass");
			int no = Integer.parseInt(request.getParameter("no"));
			
			GuestbookDao gDao = new GuestbookDao();
			GuestbookVo gvo = gDao.getGuest(no);
			
			if( pass.equals(gvo.getPassword()) ) {
				System.out.println("비밀번호가 일치합니다.");
				gDao.deleteGuest(no);
			} 
			else {
				System.out.println("비밀번호가 다릅니다.");
			}
			
			response.sendRedirect("/MySite/guest");
		}
		else if("add".equals(action)) {
			
			String name = request.getParameter("name");
			String password = request.getParameter("pass");
			String content = request.getParameter("content");
			
			GuestbookDao guestbookDao = new GuestbookDao();
			GuestbookVo gvo = new GuestbookVo(name, password, content);
			guestbookDao.addGuest(gvo);
			
			// redirect
			WebUtil.redirect(request, response, "/MySite/guest");
		}
		else {
			GuestbookDao gDao = new GuestbookDao();
			List<GuestbookVo> list = gDao.getList();
			
			request.setAttribute("gList", list);
			
			WebUtil.forward(request, response, "/WEB-INF/views/guestbook/addList.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
