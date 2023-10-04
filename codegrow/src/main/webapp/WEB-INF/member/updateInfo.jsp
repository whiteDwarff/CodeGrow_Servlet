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
<link rel="stylesheet" href="./css/border/updateInfo.css">
<script type="module">
import { failedLoginInfo } from "./script/member/index.js";
failedLoginInfo("${msg}");
</script>
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