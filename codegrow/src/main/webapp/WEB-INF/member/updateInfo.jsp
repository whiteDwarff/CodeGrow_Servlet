<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/08a7424104.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="./css/ohter/common.css">
<link rel="stylesheet" href="./css/ohter/header.css">
<style>

* {
	margin: 0;
	padding: 0;
	list-style: none;
	text-decoration: none;
}
body {
	font-size: 10px;
}
label {
	display: inline-block;
	width: 20%;
}
.title {
	font-size: 0.8rem;
	margin-bottom: 2rem;
	font-weight: bold;
}
.border-box {
	border-bottom: 1px solid #000;
	padding: 1rem 0;
}
.input {
	width: 80%;
	background-color: #fff;
	border: none;
}
input:focus {
	outline: none;
}
#join-submit {
	width: unset;
	margin: 4rem 0 4rem auto;
}
#join-submit:hover { color: #73d09a; }
</style>


</head>
<body>
	<%@include file="../common/header.jsp"%>
	<section>
		<div class="wrap">
		<%@include file="./account.jsp"%>
		</div> 
	</section>
	
	
	<script src="./script/ohter/header.js"></script>
	<script type="module">
		import { submitAccountInfo } from "./script/member/index.js";
		submitAccountInfo();
	</script>
</body>
</html>