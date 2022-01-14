<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/MySite/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="/MySite/assets/css/board.css" rel="stylesheet" type="text/css">

</head>


<body>
	<div id="wrap">

		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->
		<!-- //nav -->

		<div id="container" class="clearfix">
			<c:import url="/WEB-INF/views/include/aside.jsp"></c:import>
			<!-- //aside -->

			<div id="content">

				<div id="content-head">
					<h3>게시판</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>게시판</li>
							<li class="last">일반게시판</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->
				<c:choose>
					<c:when test="${empty sessionScope.authUser}">
						<h3>login 해주고 작성해주세요.</h3>
					</c:when>
					<c:otherwise>
						<div id="board">
							<div id="writeForm">
								<form action="/MySite/board" method="get">
									<input type="hidden" name="action" value="write">
									<!-- 제목 -->
									<div class="form-group">
										<label class="form-text" for="txt-title">제목</label>
										<input type="text" id="txt-title" name="title" value="" placeholder="제목을 입력해 주세요">
									</div>
								
									<!-- 내용 -->
									<div class="form-group">
										<textarea id="txt-content" name="content"></textarea>
									</div>
									
									<a id="btn_cancel" href="/MySite/board">취소</a>
									<button id="btn_add" type="submit" >등록</button>
									
								</form>
								<!-- //form -->
							</div>
							<!-- //writeForm -->
						</div>
					</c:otherwise>
				</c:choose>
				
				<!-- //board -->
			</div>
			<!-- //content  -->
		</div>
		<!-- //container  -->


		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

</html>
