<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<header id="header">
		<div class="header-wrap flex between">
			<nav class="flex align">
			<h1>
				<a href="/index">CodeGrow</a>
			</h1>
				<c:forEach var="menu" items="${ menus }">
				<a href="/search?group=${ menu.id }">${ menu.name }</a> 
				</c:forEach>
				<!-- 서블릿 필요 -->
				<a href="/board">Board</a>
				<a href="notice">Notice</a>
			</nav> <!-- nav -->
			<div class="sub-gnb">
				<i class="fa-solid fa-magnifying-glass header-image pointer"></i>
				<i class="fa-solid fa-user header-image pointer"></i>
			</div>
		</div>
		
		
		<div id="search-box">
			<div class="header-slide-wrap">
				<form action="search" method="post" id="header-search-form">
					<i class="fa-solid fa-magnifying-glass" id="header-input-image" class="inline" ></i>
					<input type="text"
						placeholder="codegrow.com 검색하기" name="title" id="header-search-input">
				</form>
			</div>
		</div>
		
		
		<div id="account-box">
			<div class="header-slide-wrap">
				<h4 class="font-max">Welcome CodeGrow !</h4>
				<c:choose>
					<c:when test="${ empty sessionScope.email }">
						<span id='login-span'>저장해둔 항목이 있는지 확인하려면 <a href='/login'>로그인</a>하세요</span>
					</c:when>
					<c:otherwise>
						<span id='login-span'>${ sessionScope.name }님 환영합니다.</span>
					</c:otherwise>
				</c:choose>
				<span id="profile">내프로필</span>
				<div class="label-box">
					<c:choose>
						<c:when test="${ empty sessionScope.email }">
							<div class="flex">
								<i class="fa-solid fa-bookmark inline"></i>
								<a href='/login'>관심 목록</a>
							</div>
							<div class="flex">
								<i class="fa-solid fa-user inline"></i>
								<a href='/login'>계정</a>
							</div>
							<div class="flex">
								<i class="fa-solid fa-right-to-bracket inline"></i>
								<a href='/login'>로그인</a>
							</div>
						</c:when>
						<c:otherwise>
							 <div class="flex">
									<i class="fa-solid fa-bookmark inline"></i>
									<a href='/wish'>관심 목록</a>
								</div>
								<div class="flex">
									<i class="fa-solid fa-user inline"></i>
									<a href='/updateInfo'>계정</a>
								</div>
								<div class="flex">
									<i class="fa-solid fa-right-to-bracket inline"></i>
									<a href='/logout'>로그인</a>
								</div>
						</c:otherwise>
          </c:choose>
					</div>
				</div>
			</div>
	</header>
</body>
</html>