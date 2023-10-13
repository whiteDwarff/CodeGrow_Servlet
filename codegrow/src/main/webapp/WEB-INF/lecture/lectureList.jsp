<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LECTURE || CodeGrow</title>
<script src="https://kit.fontawesome.com/08a7424104.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="./css/ohter/common.css">
<link rel="stylesheet" href="./css/ohter/header.css">
<link rel="stylesheet" href="./css/lecture/lectureList.css">
<script type="module">
import { failedLoginInfo } from "./script/member/index.js";
failedLoginInfo("${msg}");
</script>
</head>
<body>
	<%@include file="../common/header.jsp"%>
	<section id="board-section">
				<!-- 게시판 정렬 옵션 -->
		<article class="board-list">
			<form method="get" action="lecture" id="align-option">
				<select name="select" onchange="this.form.submit()">
					<option value="1" class="align-option">최신순</option>
					<option value="2" class="align-option">오래된순</option>
					<option value="3" class="align-option">조회수높은순</option>
					<option value="4" class="align-option">조회수낮은순</option>
				</select>
			</form>
			<!-- table header -->
			<table class="table table-hover">
				<tr class="video-item">
					<th class="video-number">번호</th>
					<th class="video-title">내용</th>
					<th class="video-date">등록일</th>
					<th class="video-hit">조회수</th>
					<th></th>
				</tr>
				
				<c:forEach var="video" items="${ videos }" >
				<tr>
					<td class="video-number">${video.id}</td>
					<td class="video-title">
						<a href="/education?id=${video.id}&group=${video.category_id}" class="flex align pointer video">
							<embed controls=0
								src="https://img.youtube.com/vi/${ video.url }/maxresdefault.jpg"
								allowfullscreen></embed>
							<div>
								<span class="block font video-title">${ video.title }</span>
								<span class="block video-description">${ video.description }</span>
							</div>
						</a>
					</td>
					<td class="video-date">${ video.uploaded_at }</td>
					<td class="video-hit">${ video.hit }</td>
					<td>
						<a href="/lectureInsert?id=${ video.id }" class="table-button pointer">수정</a>
						<a href="/lectureDelete?id=${ video.id }" class="table-button delete-button pointer">삭제</a>
				</tr>
				</c:forEach>
				</table>
			</article>
			
			<c:if test="${ empty videos }">
				<div id="data-none" class="text-align">
					<span>검색된 결과가 없습니다.</span>
				</div>
			</c:if>
	</section>
	<section id="ohter">
		<c:if test="${ not empty startNum && not empty numOfPages}">
			<!-- #### pageNation #### -->
			<div id="page-nation" class="flex center">
				<ul class="flex">
    			<a href="/lecture?p=${p - 1}" id="prev">
    				<i class="fa-solid fa-chevron-left"></i>
    			</a>
    			<c:forEach var="i" begin="${startNum}" end="${startNum + numOfPages - 1}" step="1">
        		<c:if test="${i <= lastNum}">
            	<a href="/lecture?select=${ option }&p=${i}" class="page-num">${i}</a>
        		</c:if>
    			</c:forEach>
    			<a href="/lecture?p=${p+1}" id="next">
    				<i class="fa-solid fa-chevron-right"></i>
    			</a>
				</ul>
			</div>
			<!-- ########## -->
		</c:if>
	
	
		<form method="post" action="/lecture" id="search-form" class="flex">
			<input type="text" name="content" id="form-value" placeholder="검색어를 입력하세요">
			<div id="button-wrap" class="text-align">
		 		<a href="/lectureInsert" id="qna-button" class="pointer">등록</a>
				<button id="search-button" class="none">검색</button>
			</div>
		</form>
	</section>
	
	<%@include file="../common/footer.jsp"%>
	
	<script src="./script/ohter/header.js"></script>
	<script type="module">
  import { 
		currentPaging,
		hiddenPrevButton,
		searchBoardList,
		hiddenNextButton,
		selectOptionHandelr,
} from "./script/board/boardList.js";	
import {
		deleteVideo,
} from "./script/lecture/lectureList.js";


		const pageValue = ${p};
		const lastValue = '${lastNum}';
		const option = '${option}';	
		if(lastValue) {
  		currentPaging(pageValue); 
			hiddenPrevButton(pageValue);
			searchBoardList();
			hiddenNextButton(pageValue, lastValue)
			selectOptionHandelr(option);
		}
deleteVideo();
</script>

</body>
</html>