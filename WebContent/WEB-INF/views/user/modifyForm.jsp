<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javaex.vo.UsersVo" %>
<%
	UsersVo authUser = (UsersVo) session.getAttribute("authUser");	// 헤더	

	UsersVo uvo = (UsersVo) request.getAttribute("authUser"); // 폼
	
	System.out.println("female".equals(uvo.getGender()));
%>
    
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

		<div id="header" class="clearfix">
			<h1>
				<a href="">MySite</a>
			</h1>

			<%
			if(authUser != null){ // 성공
			%>
			<ul>
				<li><%= authUser.getName() %> 님 안녕하세요^^</li>
				<li><a href="/MySite/user?action=logout" class="btn_s">로그아웃</a></li>
				<li><a href="/MySite/user?action=modifyForm" class="btn_s">회원정보수정</a></li>
			</ul>	
			<%
			} else { // 실패
			%>
			<ul>
				<li><a href="/MySite/user?action=loginForm" class="btn_s">로그인</a></li>
				<li><a href="/MySite/user?action=joinForm" class="btn_s">회원가입</a></li>
			</ul>
			<%
			}
			%>
			
		</div>
		<!-- //header -->

		<div id="nav">
			<ul class="clearfix">
				<li><a href="">입사지원서</a></li>
				<li><a href="">게시판</a></li>
				<li><a href="">갤러리</a></li>
				<li><a href="">방명록</a></li>
			</ul>
		</div>
		<!-- //nav -->

		<div id="container" class="clearfix">
			<div id="aside">
				<h2>회원</h2>
				<ul>
					<li>회원정보</li>
					<li>로그인</li>
					<li>회원가입</li>
				</ul>
			</div>
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
							<input type="hidden" name="id" value="<%= uvo.getId()%>">
								
							<!-- 아이디 -->
							<div class="form-group">
								<label class="form-text" for="input-uid">아이디</label> 
								<span class="text-large bold"><%= uvo.getId() %></span>
							</div>
	
							<!-- 비밀번호 -->
							<div class="form-group">
								<label class="form-text" for="input-pass">패스워드</label> 
								<input type="text" id="input-pass" name="password" value="<%= uvo.getPassword() %>" placeholder="비밀번호를 입력하세요"	>
							</div>
	
							<!-- 이메일 -->
							<div class="form-group">
								<label class="form-text" for="input-name">이름</label> 
								<input type="text" id="input-name" name="name" value="<%= uvo.getName() %>" placeholder="이름을 입력하세요">
							</div>
	
							<!-- //나이 -->
							<div class="form-group">
								<span class="form-text">성별</span> 
								
								<%
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
								%>
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

		<div id="footer">
			Copyright ⓒ 2020 황일영. All right reserved
		</div>
		<!-- //footer -->
		
	</div>
	<!-- //wrap -->

</body>

</html>