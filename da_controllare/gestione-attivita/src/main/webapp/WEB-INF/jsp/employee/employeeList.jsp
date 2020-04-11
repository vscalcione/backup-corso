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
			<div class="container" style="padding: 30px;">
											<a href="${ctx}employee/new" class="btn btn-primary">Crea nuovo dipendente</a><br>
				<table class="table table-hover table-sm" bo>
					<thead class="thead-dark">
						<tr>
							<th>Matricola</th>
							<th>Cognome</th>
							<th>Nome</th>
							<th>Azioni consentite</th>
						</tr>
					</thead>
					<c:forEach items="${employeeList}" var="employee">
					<tr>
						<td>
							<a href="${ctx}employee/${employee.idMatricola}" class="btn btn-primary">${employee.idMatricola}</a>
						</td>
						<td>${employee.surname}</td>
						<td>${employee.name}</td>
						<td>
							<a href="${ctx}employee/new" class="btn btn-primary">Crea nuovo dipendente</a>
							<a href="${ctx}employee/${employee.idMatricola}/edit" class="btn btn-warning" onclick="">Modifica</a>
							<a href="${ctx}employee/${employee.idMatricola}/delete" class="btn btn-danger" onclick="myAlertCancel();">Elimina</a> 
							<a href="${ctx}employee/${employee.idMatricola}/assignActivity" class="btn btn-success">Assegna attivit&agrave;</a>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>