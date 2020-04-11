<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="ctx" />
<!DOCTYPE html>
<html>
<head>
	<title>${ctx}</title>

	<meta charset="UTF-8">
	<link rel="stylesheet" href="${ctx}webjars/bootstrap/4.2.1/css/bootstrap.min.css" >

	<script type="text/javascript" src="${ctx}webjars/jquery/3.3.1-1/jquery.js" ></script>
	<script type="text/javascript" src="${ctx}webjars/popper.js/1.14.3/popper.js" ></script>
	<script type="text/javascript" src="${ctx}webjars/bootstrap/4.2.1/js/bootstrap.js" ></script>
</head>
<body>
	<h1>Hello ${userName}</h1>
</body>
</html>