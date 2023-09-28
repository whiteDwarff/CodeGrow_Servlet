<%@page import="member.MemberDto"%>
<%@page import="member.MemberDao"%>
<%@page import="com.web.user.dto.UserDto"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.web.connection.ConnectionProvider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("utf-8");
String email = request.getParameter("email");
String pwd = request.getParameter("password");

MemberDao dao = new MemberDao();
MemberDto dto = dao.loginDao(email, pwd);

if(email.equals(dto.getEmail()) && pwd.equals(dto.getPassword())) {
	session.setAttribute("email", dto.getEmail());
	session.setAttribute("password", dto.getPassword());
	session.setAttribute("name", dto.getName());
	session.setAttribute("phone", dto.getPhone());
	response.sendRedirect("main.jsp");
} else { %>

<script>
	  if(confirm("아이디 / 비밀번호가 일치하지 않습니다.")) location.href="login.jsp";
	  else history.back();
 </script>
<% } %>
%>
