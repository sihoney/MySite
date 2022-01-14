<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page import="com.javaex.vo.GuestbookVo" %>
<%@ page import="java.util.List" %>
<%@ page import="com.javaex.vo.UsersVo" %>

<%
	List<GuestbookVo> list = (List<GuestbookVo>) request.getAttribute("gList");
	UsersVo authUser = (UsersVo) session.getAttribute("authUser");
%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="/MySite/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">

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
				
				<div id="content-head" class="clearfix">
					<h3>일반방명록</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>방명록</li>
							<li class="last">일반방명록</li>
						</ul>
					</div>
				</div>
				<!-- //content-head -->

				<div id="guestbook">
					<form action="/MySite/guest" method="get">
						<input type="hidden" name="action" value="add">
						<table id="guestAdd">
							<colgroup>
								<col style="width: 70px;">
								<col>
								<col style="width: 70px;">
								<col>
							</colgroup>
							<tbody>
								<tr>
									<th><label class="form-text" for="input-uname">이름</label></td>
									<td><input id="input-uname" type="text" name="name" required></td>
									<th><label class="form-text" for="input-pass">패스워드</label></td>
									<td><input id="input-pass"type="password" name="pass" required></td>
								</tr>
								<tr>
									<td colspan="4"><textarea name="content" cols="72" rows="5" required></textarea></td>
								</tr>
								<tr class="button-area">
									<td colspan="4" class="text-center"><button type="submit">등록</button></td>
								</tr>
							</tbody>
							
						</table>
						<!-- //guestWrite -->
						<input type="hidden" name="action" value="add">
						
					</form>	
					
<%-- 					<%
					for(int i = 0; i < list.size(); i++) {
						int no = list.get(i).getNo();
					%>
						<table class="guestRead">
							<colgroup>
								<col style="width: 10%;">
								<col style="width: 40%;">
								<col style="width: 40%;">
								<col style="width: 10%;">
							</colgroup>
							<tr>
								<td><%= no %></td>
								<td><%= list.get(i).getName() %></td>
								<td><%=  list.get(i).getRegDate()%></td>
								<td><a href="/MySite/guest?action=deleteForm&no=<%= no%>">[삭제]</a></td>
							</tr>
							<tr>
								<td colspan=4 class="text-left"><%= list.get(i).getContent() %></td>
							</tr>
						</table>
						<!-- //guestRead -->
					<%
					}
					%>  --%>
					
					<c:forEach items="${requestScope.gList }" var="userVo" varStatus="status">
						<table class="guestRead">
							<colgroup>
								<col style="width: 10%;">
								<col style="width: 40%;">
								<col style="width: 40%;">
								<col style="width: 10%;">
							</colgroup>
							<tr>
								<td>${userVo.no }</td>
								<td>${userVo.name }</td>
								<td>${userVo.regDate }</td>
								<td><a href="/MySite/guest?action=deleteForm&no=${userVo.no }">[삭제]</a></td>
							</tr>
							<tr>
								<td colspan=4 class="text-left">${userVo.content }</td>
							</tr>
						</table>						
					</c:forEach>
					
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