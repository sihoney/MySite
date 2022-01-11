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
