<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/08a7424104.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="./css/ohter/common.css">
<link rel="stylesheet" href="./css/ohter/header.css">
<link rel="stylesheet" href="./css/education/index.css">
</head>
<body>
	<%@include file="../common/header.jsp"%>

	<section id="url-box">
		<div class="wrap">
			<div class="flex-box">
				<embed id="main-url"
					src="https://www.youtube.com/embed/<c:out value="${ video.url }" />?showinfo=0&modestbranding=1&rel=0"
					title="YouTube video player" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
					allowfullscreen />
					
				<div class="list-box">
					<div id="hit" class="flex between">
						<small>등록일 : ${ video.uploaded_at }</small>
						<small>조회수 : ${ video.hit }</small>
					</div>
					<h2 class="url-title">
						<c:out value="${ video.title }" />
					</h2>
					<h4 class="url-content">
						<c:out value="${ video.description }" />
					</h4>
					<!-- 관심목록 버튼 -->
						<c:if test="${ sessionScope.name eq null }">
						<button id="addToFavoritesBtn" disabled>
							로그인 후 이용할 수 있습니다.
						</button>
					</c:if>
					<c:if test="${ result == 0 }">
						<button id="addToFavoritesBtn">
							관심목록 추가 <i class="fa-solid fa-plus add"></i>
						</button>
					</c:if>
					<c:if test="${ result == 1 }">
						<button id="addToFavoritesBtn">
							관심목록 제거 <i class="fa-solid fa-minus add"></i>
						</button>
					</c:if>
					<!-- ##### sub menu 영역 ##### -->
					<ul class="list">
						<div class="scroll-box">
							<c:forEach var="list" items="${subMenu}">
								<li class="sub-list">
									<a href="/education?id=${ list.id }&group=${ list.category_id }">
										<embed controls=0 src="https://img.youtube.com/vi/${ list.url }/maxresdefault.jpg" allowfullscreen class="sub-url"></embed>
										<div>
											<span class="sub-url-title">${ list.title }</span>
											<span class="sub-url-content">${ list.description }</span>
										</div>
									</a>
								</li>
							</c:forEach>
						</div>
					</ul>

				</div>
			</div>
		</div>
	</section>
	
	<%@include file="../common/footer.jsp"%>

	<script src="./script/ohter/header.js"></script>
	<script type="module">
		import { currentVideo, addWishList } from "./script/education/education.js";
		currentVideo();
		addWishList(${param.id}, ${ result });
	</script>