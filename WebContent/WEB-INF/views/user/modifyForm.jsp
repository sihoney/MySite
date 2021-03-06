<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page import="com.javaex.vo.UsersVo" %>

<%
	UsersVo authUser = (UsersVo) session.getAttribute("authUser");	// 헤더 이름

	UsersVo uvo = (UsersVo) request.getAttribute("authUser"); // 폼 정보
	
	System.out.println("female".equals(uvo.getGender()));
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
					<h3>회원정보</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>회원</li>
							<li class="last">회원정보</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				 <!-- //content-head -->
	
				<div id="user">
					<div id="modifyForm">
						<form action="/MySite/user" method="get">
							<input type="hidden" name="action" value="modify">	
							<input type="hidden" name="id" value="${requestScope.authUser.id}">
								
							<!-- 아이디 -->
							<div class="form-group">
								<label class="form-text" for="input-uid">아이디</label> 
								<span class="text-large bold">${requestScope.authUser.id }</span>
							</div>
	
							<!-- 비밀번호 -->
							<div class="form-group">
								<label class="form-text" for="input-pass">패스워드</label> 
								<input type="text" id="input-pass" name="password" value="${requestScope.authUser.password }" placeholder="비밀번호를 입력하세요"	>
							</div>
	
							<!-- 이메일 -->
							<div class="form-group">
								<label class="form-text" for="input-name">이름</label> 
								<input type="text" id="input-name" name="name" value="${requestScope.authUser.name }" placeholder="이름을 입력하세요">
							</div>
	
							<!-- //나이 -->
							<div class="form-group">
								<span class="form-text">성별</span> 
								
<%-- 								<%
								if("female".equals(uvo.getGender())) {
								%>
								<label for="rdo-male">남</label> 
								<input type="radio" id="rdo-male" name="gender" value="male"> 
								
								<label for="rdo-female">여</label> 
								<input type="radio" id="rdo-female" name="gender" value="female" checked> 
								<%
								} else {
								%>
								<label for="rdo-male">남</label> 
								<input type="radio" id="rdo-male" name="gender" value="male" checked> 
								
								<label for="rdo-female">여</label> 
								<input type="radio" id="rdo-female" name="gender" value="female">
								<%
								}
								%> --%>
								
								<c:choose>
									<c:when test="${'female' eq requestScope.authUser.gender}">
										<label for="rdo-male">남</label> 
										<input type="radio" id="rdo-male" name="gender" value="male"> 
										
										<label for="rdo-female">여</label> 
										<input type="radio" id="rdo-female" name="gender" value="female" checked> 									
									</c:when>
									<c:otherwise>
										<label for="rdo-male">남</label> 
										<input type="radio" id="rdo-male" name="gender" value="male" checked> 
										
										<label for="rdo-female">여</label> 
										<input type="radio" id="rdo-female" name="gender" value="female">										
									</c:otherwise>
								</c:choose>
							</div>
	
							<!-- 버튼영역 -->
							<div class="button-area">
								<button type="submit" id="btn-submit">회원정보수정</button>
							</div>
							
						</form>
					
					
					</div>
					<!-- //modifyForm -->
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