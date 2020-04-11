<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User list</title>
</head>
<body>

<table>
	<tr>
		<th>User id</th> <th>Username</th> <th>password</th> <th>Enabled</th>
	</tr>

	<c:forEach items="${userList}" var="user">
		<tr>
			<td>${user.userId }</td>
			<td>${user.userName }</td>
			<td>${user.password }</td>
			<td>${user.enabled }</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>