<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="/WEB-INF/jsp/common/head.jsp" %>
	</head>	
	<body>
		<jsp:include page="/WEB-INF/jsp/common/navbar.jsp">
			<jsp:param name="active" value="employee" />
		</jsp:include>
		<div class="container">
			<a href="${ctx}employee">Indietro</a> <br>
			<hr>
			<c:choose>
				<c:when test="${not empty employee.idMatricola}">
					<c:url value="/employee/${employee.idMatricola}/edit" var="saveUrl" />
				</c:when>
				<c:otherwise>
					<c:url value="/employee/new" var="saveUrl" />
				</c:otherwise>
			</c:choose>			
			<form action="${saveUrl}" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<c:if test="${not empty employee.idMatricola}">
					<label>Matricola:</label> ${employee.idMatricola}
					<input type="hidden" name="idMatricola" value="${employee.idMatricola}">
					<br>
				</c:if>
				<label>Cognome:</label>
				<input type="text" name="surname" value="${employee.surname}"> <br>
				<label>Nome:</label>
				<input type="text" name="name" value="${employee.name}"> <br>
				<input type="reset" value="Cancella"> <input type="submit" value="Salva">
			</form>
		</div>
	</body>
</html>