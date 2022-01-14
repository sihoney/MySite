<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page import="com.javaex.vo.UsersVo" %>

<%
	UsersVo authUser = (UsersVo) session.getAttribute("authUser");

	String result = request.getParameter("result");
	
%> --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/MySite/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/MySite/assets/css/user.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div id="wrap">

		<!-- header, nav -->
		<%-- <jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include> --%>
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		<div id="container" class="clearfix">
			<c:import url="/WEB-INF/views/include/aside.jsp">
				<c:param name="view" value="user"></c:param>
			</c:import>
			<!-- //aside -->

			<div id="content">
			
				<div id="content-head">
					<h3>로그인</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>회원</li>
							<li class="last">로그인</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				 <!-- //content-head -->
	
				<div id="user">
					<div id="loginForm">
						<form action="/MySite/user" method="get">
							<input type="hidden" name="action" value="login">
	
							<!-- 아이디 -->
							<div class="form-group">
								<label class="form-text" for="input-uid">아이디</label> 
								<input type="text" id="input-uid" name="id" value="" placeholder="아이디를 입력하세요">
							</div>
	
							<!-- 비밀번호 -->
							<div class="form-group">
								<label class="form-text" for="input-pass">비밀번호</label> 
								<input type="text" id="input-pass" name="password" value="" placeholder="비밀번호를 입력하세요"	>
							</div>
	
<%-- 							<%
							if("fail".equals(result)) {
							%>
							<p style="color:red">로그인에 실패했습니다. 다시 로그인해주세요</p>
							<%
							}
							%> --%>
							
							<c:choose>
								<c:when test="${'fail' eq param.result }">
									<p style="color:red">로그인에 실패했습니다. 다시 로그인해주세요</p>
								</c:when> 
							</c:choose>
							
							<!-- 버튼영역 -->
							<div class="button-area">
								<button type="submit" id="btn-submit">로그인</button>
							</div>
							
						</form>
					</div>
					<!-- //loginForm -->
				</div>
				<!-- //user -->
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