<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="/WEB-INF/jsp/common/head.jsp" %>
	</head>
	<body>
		<jsp:include page="/WEB-INF/jsp/common/navbar.jsp">
			<jsp:param name="active" value="activity" />
		</jsp:include>
		<div class="container">
			<a href="${ctx}activity">Indietro</a> <br>
			<table class="table">
				<tr>
					<th>Matricola</th>
					<th>Cognome</th>
					<th>Nome</th>
					<th></th>
				</tr>
				<c:forEach items="${employeeList}" var="employee">
					<tr>
						<td>
							<a href="${ctx}employee/${employee.idMatricola}"> ${employee.idMatricola}</a>
						</td>
						<td>${employee.surname}</td>
						<td>${employee.name}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>