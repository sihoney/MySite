<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page import="com.javaex.vo.UsersVo" %>
    
<%
	int no = Integer.parseInt(request.getParameter("no"));

	UsersVo authUser = (UsersVo) session.getAttribute("authUser");	
%> --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/MySite/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/MySite/assets/css/guestbook.css" rel="stylesheet" type="text/css">

</head>

<body>
	<div id="wrap">

		<!-- header, nav -->
		<%-- <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include> --%>
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		<div id="container" class="clearfix">
			<c:import url="/WEB-INF/views/include/aside.jsp">
				<c:param name="view" value="guest"></c:param>
			</c:import>
			<!-- //aside -->

			<div id="content">
			
				<div id="content-head">
					<h3>일반방명록</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>방명록</li>
							<li class="last">일반방명록</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->
	
				<div id="guestbook">
					<form action="/MySite/guest" method="get">
						<input type="hidden" name="action" value="delete">
						<input type="hidden" name="no" value="${param.no }">
						
						<table id="guestDelete">
							<colgroup>
								<col style="width: 10%;">
								<col style="width: 40%;">
								<col style="width: 25%;">
								<col style="width: 25%;">
							</colgroup>
							<tr>
								<td>비밀번호</td>
								<td><input type="password" name="pass" required></td>
								<td class="text-left"><button type="submit">삭제</button></td>
								<td><a href="/guestbook2/gbc">[메인으로 돌아가기]</a></td>
							</tr>
						</table>
						<input type='hidden' name="" value="">
						<input type='hidden' name="" value="">
					</form>
					
				</div>
				<!-- //guestbook -->
			</div>
			<!-- //content  -->

		</div>
		<!-- //container  -->
		
	 	<%-- <jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include> --%>
	 	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->

	</div>
	<!-- //wrap -->

</body>

</html>
