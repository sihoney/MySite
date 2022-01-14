<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:out value="${param.id }"></c:out>

<c:choose>
	<c:when test="${param.view eq 'board' }">
		<div id="aside">
			<h2>게시판</h2>
			<ul>
				<li><a href="/MySite/board">일반게시판</a></li>
				<li><a href="/MySite/guest">댓글게시판</a></li>
			</ul>
		</div>	
	</c:when>
	<c:when test="${param.view eq 'guest' }">
			<div id="aside">
				<h2>방명록</h2>
				<ul>
					<li>일반방명록</li>
					<li>ajax방명록</li>
				</ul>
			</div>
	</c:when>
	<c:when test="${param.view eq 'user' }">
			<div id="aside">
				<h2>회원</h2>
				<ul>
					<li>회원정보</li>
					<li>로그인</li>
					<li>회원가입</li>
				</ul>
			</div>
	</c:when>
</c:choose>
