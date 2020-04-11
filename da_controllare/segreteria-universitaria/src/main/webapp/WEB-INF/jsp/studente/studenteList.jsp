<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="/WEB-INF/jsp/common/head.jsp" %>
	</head>
	<body>
		<jsp:include page="/WEB-INF/jsp/common/navbar.jsp">
			<jsp:param name="active" value="studente" />
		</jsp:include>
		<div class="container">
			<div class="container" style="padding: 30px;">
				<a href="${ctx}studente/new" class="btn btn-primary">Crea un nuovo studente</a><br>
				<table class="table table-hover table-sm" bo>
					<thead class="thead-dark">
						<tr>
							<th>Matricola</th>
							<th>Nome</th>
							<th>Cognome</th>
							<th>Email</th>
							<th>Azioni consentite</th>
						</tr>
					</thead>
					<c:forEach items="${studenteList}" var="employee">
					<tr>
						<td>
							<a href="${ctx}studente/${studente.matricola}" class="btn btn-primary">${studente.matricola}</a>
						</td>
						<td>${studente.nome}</td>
						<td>${studente.cognome}</td>
						<td>
							<a href="${ctx}studente/new" class="btn btn-primary">Crea nuovo dipendente</a>
							<a href="${ctx}studente/${studente.matricola}/edit" class="btn btn-warning" onclick="">Modifica</a>
							<a href="${ctx}studente/${studente.matricola}/delete" class="btn btn-danger" onclick="myAlertCancel();">Elimina</a> 
							<a href="${ctx}studente/${studente.matricola}/assignFacolta" class="btn btn-success">Assegna attivit&agrave;</a>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>