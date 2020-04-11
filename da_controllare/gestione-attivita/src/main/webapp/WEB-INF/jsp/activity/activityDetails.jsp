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
			<label>ID:</label> ${activity.idActivity}<br>
			<label>Attivit&agrave;:</label> ${activity.activityName}<br>
			<label>Data inizio:</label> <fmt:formatDate value="${activity.startDate}" pattern="dd/MM/yyyy"/><br>
			<label>Data fine:</label> <fmt:formatDate value="${activity.endDate}" pattern="dd/MM/yyyy"/><br>
		</div>
	</body>
</html>