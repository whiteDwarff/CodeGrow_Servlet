<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A || CodeGrow</title>
<script src="https://kit.fontawesome.com/08a7424104.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="./css/ohter/common.css">
<link rel="stylesheet" href="./css/ohter/header.css">
<link rel="stylesheet" href="./css/border/board.css">
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
			<form method="get" action="/board" id="align-option">
				<select name="select" onchange="this.form.submit()">
					<option value="1" class="align-option">최신순</option>
					<option value="2" class="align-option">오래된순</option>
					<option value="3" class="align-option">조회수높은순</option>
					<option value="4" class="align-option">조회수낮은순</option>
				</select>
				<input value="${ pm }" name="param" class="none">
			</form>
			<!-- table header -->
			<table class="table table-hover">
				<tr class="post-item">
					<th class="post-number">번호</th>
					<th class="post-title">제목</th>
					<th class="post-author">작성자</th>
					<th class="post-date">작성일</th>
					<th class="post-hit">조회수</th>
				</tr>
				
				<c:forEach var="list" items="${ lists }" >
				<tr>
					<td class="number">${list.id}</td>
					<td class="post-title"><a href="/boardContent?param=${ pm }&id=${ list.id }">${ list.title }</a></td>
					<td class="post-author">${ list.name }</td>
					<td class="post-date">${ list.created_at }</td>
					<td>${list.hit }</td>
				</tr>
				</c:forEach>
				</table>
			</article>
			
			<c:if test="${ empty lists }">
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
    			<a href="/board?p=${p - 1}" id="prev">
    				<i class="fa-solid fa-chevron-left"></i>
    			</a>
    			<c:forEach var="i" begin="${startNum}" end="${startNum + numOfPages - 1}" step="1">
        		<c:if test="${i <= lastNum}">
            	<a href="/board?param=${ pm }&p=${i}&select=${option}" class="page-num">${i}</a>
        		</c:if>
    			</c:forEach>
    			<a href="/board?p=${p+1}" id="next">
    				<i class="fa-solid fa-chevron-right"></i>
    			</a>
				</ul>
			</div>
			<!-- ########## -->
		</c:if>
			
			<form method="post" action="/${ pm }" id="search-form" class="flex">
				<select name="option">
					<option value="title">제목</option>
					<option value="name">작성자</option>
				</select>
				<input type="text" name="content" id="form-value" placeholder="검색어를 입력하세요.">
				<input type="text" name="param" value="${ pm }" class="none">
				<div id="button-wrap">
		 			<c:if test="${ not empty sessionScope.name && sessionScope.name eq '관리자' && pm eq 'notice'}">
		 				<a href="/boardInsert?param=${ pm }" id="qna-button" class="pointer hover">작성하기</a>
		 			</c:if>
					<c:if test="${ not empty sessionScope.name && pm eq 'board'}">
		 				<a href="/boardInsert?param=${ pm }" id="qna-button" class="pointer">문의하기</a>
		 			</c:if>
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
</script>

</body>
</html>