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
		<div style="padding: 10px;">
		<a href="${ctx}activity/new" class="btn btn-primary">Crea nuova attivita</a>
		<table class="table table-hover table-sm">
			<thead class="thead-dark">
				<tr>
					<th>ID</th>
					<th>Attivit&agrave;</th>
					<th>Data inizio</th>
					<th>Data fine</th>
					<th>Azioni consentite </th>
				</tr>
				<c:forEach items="${activityList}" var="activity">
					<tr>
						<td>
							<a href="${ctx}activity/${activity.idActivity}" class="btn btn-primary"> ${activity.idActivity}
							</a>
						</td>
						<td>${activity.activityName}</td>
						<td>
							<fmt:formatDate value="${activity.startDate}" pattern="dd/MM/yyyy"/>
						</td>
						<td>
							<fmt:formatDate value="${activity.endDate}" pattern="dd/MM/yyyy"/>
						</td>
						<td>
							<a href="${ctx}activity/${activity.idActivity}/edit" class="btn btn-warning">Modifica</a>
							<a href="${ctx}activity/${activity.idActivity}/delete" class="btn btn-danger" onclick="return confirm('Vuoi eliminare?');">Elimina</a>
							<a href="${ctx}activity/${activity.idActivity}/employeeActivityList" class="btn btn-success">Visualizza Dipendenti</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>