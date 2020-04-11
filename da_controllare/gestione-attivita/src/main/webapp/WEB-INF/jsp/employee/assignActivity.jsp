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
			<a href="${ctx}employee">Indietro</a> <br>
			<table class="table">
				<tr>
					<th></th>
					<th>Attivit&agrave;</th>
					<th>Data inizio</th>
					<th>Data fine</th>
					<th></th>
				</tr>
				<c:forEach items="${employeeActivityList}" var="activity">
					<tr>
						<td></td>
						<td>${activity.activityName}</td>
						<td><fmt:formatDate value="${activity.startDate}" pattern="dd/MM/yyyy"/></td>
						<td><fmt:formatDate value="${activity.endDate}" pattern="dd/MM/yyyy"/></td>
						<td>
							<a href="${ctx}employee/${employee.idMatricola}/removeActivity?idActivity=${activity.idActivity}">Rimuovi attivita</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<form action="${ctx}employee/${employee.idMatricola}/assignActivity" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<select name="idActivity">
					<option>---</option>
					<c:forEach items="${activityList}" var="activity">
						<option value="${activity.idActivity}">${activity.activityName}</option>
					</c:forEach>
				</select>
				<input type="submit" value="Assegna">
			</form>
		</div>
	</body>
</html>