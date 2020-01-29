<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
</head>
<body>
	<%
		String path = request.getContextPath();
	%>
	
	<%=path %>
	<!-- member가 null이면 이 페이지를 보여준다.  -->
	<c:if test = "${member == null}">
	<form role = "form" method="post"autocomplete="off" action="<%=path %>/member/login">
		<p>
			<label for ="userId">ID</label>
			<input type = "text" id="userId" name ="id" />
		</p>
		<p>
			<label for ="userPw">PW</label>
			<input type= "password" id = "userPw" name ="pw" />
		</p>
		<p><button type = "submit">LOGIN</button></p>
	</form>
	</c:if>
	<!-- F5하게 되면 사라짐. 일회성이라는 이야기 Controller에서 rttr.addFlashAttribute("msg",false); 이 여기서 실행됨. -->
	<c:if test = "${msg == false}">
		<p style ="color:#f00;">fail to login. please check your ID, PW</p>
	</c:if>
	
	<!-- login success -->
	<c:if test = "${member != null}">
		<p>Welcome! ${member.username}.</p>
		
		<a href ="<%=path%>/list">Board List</a> <br/>
		
		<a href ="<%=path%>/member/logout">LOGOUT</a>
	</c:if>
</body>
</html>