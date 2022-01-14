package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaex.dao.BoardDao;
import com.javaex.dao.UsersDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.BoardVo;
import com.javaex.vo.UsersVo;

@WebServlet("/board")
public class BoardController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/board");
		
		String action = request.getParameter("action");
		
		if("writeForm".equals(action)) {
			System.out.println(action);
			
			WebUtil.forward(request, response, "/WEB-INF/views/board/writeForm.jsp");
		} 
		else if("write".equals(action)) {
			System.out.println(action);
			
			// 사용자가 폼에서 작성한 정보
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			// authUser 정보를 세션에서 꺼낸 뒤, user no를 board 테이블에 저장
			HttpSession session = request.getSession();
			UsersVo authUser = (UsersVo) session.getAttribute("authUser");
			
//			UsersDao uDao = new UsersDao();
//			UsersVo uvo = uDao.getUser(authUser.getId(), authUser.getPassword());
			
			BoardDao bDao = new BoardDao();
			BoardVo bvo = new BoardVo(title, content, authUser.getNo());
			bDao.addBoard(bvo);
			
			WebUtil.redirect(request, response, "/MySite/board");
			
		}
		else if("read".equals(action)) {
			System.out.println(action);
			
			// db에서 게시글 정보 가져오기
			int no = Integer.parseInt(request.getParameter("no"));
			BoardDao bDao = new BoardDao();
			BoardVo bvo = bDao.getInfo(no);
			
			// hit 숫자 업데이트 하기
			bDao.updateViews(no);
			
			// request에 담아 보내기
			request.setAttribute("bvo", bvo);
			WebUtil.forward(request, response, "/WEB-INF/views/board/read.jsp");
		}
		else if("delete".equals(action)) {
			System.out.println(action);
			
			 int no = Integer.parseInt(request.getParameter("no"));
			
			BoardDao bDao = new BoardDao();
			bDao.deleteBoard(no);
			
			WebUtil.redirect(request, response, "/MySite/board");
		}
		else if("modifyForm".equals(action)) {
			System.out.println(action);
			
			int no = Integer.parseInt(request.getParameter("no"));
			BoardDao bDao = new BoardDao();
			BoardVo bvo = bDao.getInfo(no);
			
			request.setAttribute("bvo", bvo);
			WebUtil.forward(request, response, "/WEB-INF/views/board/modifyForm.jsp");
		}
		else if("update".equals(action)) {
			System.out.println(action);
			
			int no = Integer.parseInt(request.getParameter("no"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			BoardVo bvo = new BoardVo(no, title, content, 0, "", 0, "");
			BoardDao bDao = new BoardDao();
			bDao.updateBoard(bvo);
			
			WebUtil.redirect(request, response, "/MySite/board");
			
		}
		else {
			BoardDao bDao = new BoardDao();
			List<BoardVo> bList = bDao.getList();
			
			request.setAttribute("bList", bList);
			WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");	
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
