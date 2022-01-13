<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javaex.vo.UsersVo" %>

<%
	UsersVo authUser = (UsersVo) session.getAttribute("authUser");
%>

<%
if(authUser != null) {
%>
	<div id="footer">
		Copyright ⓒ 2020 <%= authUser.getName() %>. All right reserved
	</div>
<%
} else {
%>
	<div id="footer">
		Copyright ⓒ 2020 황일영. All right reserved
	</div>
<%
}
%>