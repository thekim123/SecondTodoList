<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/auth/join" method="post">
	<input type="text" name="username" placeholder="Username"/> <br/>
	<input type="password" name="password" placeholder="Password"/> <br/>
	<input type="text" name="name" placeholder="name"/> <br/>
	<input type="email" name="email" placeholder="Email"/> <br/>
	<button>회원가입</button>
</form>
</body>
</html>