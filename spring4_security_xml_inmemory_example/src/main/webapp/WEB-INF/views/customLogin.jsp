<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Spring 4 Security Example</h3>
	<font color="red"> ${SPRING_SECURITY_LAST_EXCEPTION.message} </font>
	<h3>customLogin inside views</h3>
	<form action="<%=request.getContextPath()%>/appLogin" method="POST">
		Enter UserName: <input type="text" name="app_username" /><br />
		<br /> Enter Password: <input type="password" name="app_password" /> <br />
		<br /> <input type="submit" value="Login" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>