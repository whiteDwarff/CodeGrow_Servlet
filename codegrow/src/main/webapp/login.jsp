<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="login_submit.jsp" method="post">
		<div>
			<label for="email">EMAIL</label>
			<input id="email" type="text" name="email">
		</div>
			<div>
			<label for=password">PASSWORD</label>
			<input id="password" type="password" name="password">
		</div>
		<input type="submit" value="제출">
	</form>
</body>
</html>