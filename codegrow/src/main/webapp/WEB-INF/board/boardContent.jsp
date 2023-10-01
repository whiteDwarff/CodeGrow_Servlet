<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CodeGrow || Q&A</title>
<script src="https://kit.fontawesome.com/08a7424104.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="./css/ohter/common.css">
<link rel="stylesheet" href="./css/ohter/header.css">
<link rel="stylesheet" href="./css/border/boardContent.css">
<script type="module">
import { failedLoginInfo } from "./script/member/index.js";
failedLoginInfo("${msg}");
</script>
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<!-- 게시글 상세 내용 -->
	<section id="main-content">
		<div class="main-wrap">
			<div id="title-wrap" class="flex between align">
				<h3>❗ ${ content.title }</h3>
				<c:if test="${ sessionScope.name == content.name }">
					<div>
						<a href="/boardInsert?id=${ content.id }"><i
							class="fa-solid fa-pen pointer"></i></a> <a
							href="/boardDelete?id=${ content.id }"><i
							class="fa-solid fa-trash pointer"></i></a>
					</div>
				</c:if>
			</div>
			<div class="qna-wrap flex">
				<span class="label grey"><i class="fa-solid fa-user grey"></i>
					작성자</span> <span class="grey"> ${ content.name }</span>
			</div>
			<div class="qna-wrap flex">
				<span class="label grey"><i
					class="fa-solid fa-calendar-days grey"></i> 작성일</span> <span class="grey">${ content.created_at }</span>
			</div>
			<div class="qna-wrap flex">
				<span class="label grey"><i class="fa-solid fa-play grey"></i>
					조회수</span> <span class="grey">${content.hit }</span>
			</div>
			<div id="last-wrap" class="qna-wrap flex">
				<span class="label grey"><i class="fa-solid fa-check grey"></i>
					댓글수</span> <span class="grey">${ count }</span>
			</div>
			<div id="content">
				<p class="content">
					<span id="note">🗒</span> ${ content.content }
				</p>
			</div>
		</div>
		<!-- qna-wrap -->
	</section>

	<!--  댓글 작성 -->
	<section id="add-content">
		<form class="flex align-top" method="post" action="/insertComment">
			<label class="label grey">COMMENT</label>
			<c:if test="${ empty sessionScope.name }">
				<textarea disabled class="grey bold">로그인 후 댓글을 작성할 수 있습니다.</textarea>
			</c:if>
			<c:if test="${ not empty sessionScope.name }">
				<textarea name="comment"></textarea>
			</c:if>
			<input value="${ content.id }" name="post_id" class="none" />
			<button id="submit-button" class="pointer block bold">SUBMIT</button>
		</form>
	</section>

	<c:if test="${ not empty comment }">
		<section id="comment-content">
			<!-- #### 댓글 #### -->
			<c:forEach var="list" items="${ comment }">
				<div class="comment-card author-box">
					<c:if test="${ sessionScope.name == list.name}">
						<div class="comment-button-wrap">
							<!-- 댓글 수정 버튼 -->
							<i class="fa-solid fa-pen pointer update-button"></i>
							<!-- 댓글 삭제 버튼 -->
							<a
								href="/updateComment?comment_id=${list.id }&board_id=${ content.id  }">
								<i class="fa-solid fa-trash pointer"></i>
							</a>
						</div>
					<div class="flex align">
						<span class="comment-author">${ list.name }</span>
						<div>
							<small class="comment-date">${ list.created_at }</small>
							<p class="comment-content author-content">${ list.content }</p>
							<form method="post" action="/updateComment" class="update-form none">
								<textarea name="comment">${ list.content }</textarea>
								<input value="${ list.id }" name="comment_id" /> <input
									value="${ content.id }" name="board_id" />
								<button>UPDATE</button>
							</form>
						</div>
					</div>
					</c:if>
					<c:if test="${ sessionScope.name != list.name }">
						<div class="flex align">
						<span class="comment-author">${ list.name }</span>
						<div>
							<small class="comment-date">${ list.created_at }</small>
							<p class="comment-content">${ list.content }</p>
						</div>
					</div>
					</c:if>
				</div>
			</c:forEach>
		</section>
	</c:if>

<script src="./script/ohter/header.js"></script>
<script type="module">
import { updateComment } from "./script/board/boardContent.js"
updateComment();

</script>
</body>
</html>