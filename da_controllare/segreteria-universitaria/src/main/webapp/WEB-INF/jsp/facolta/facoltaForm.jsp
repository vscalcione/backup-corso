<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="/WEB-INF/jsp/common/head.jsp" %>
	</head>
	<body>
		<jsp:include page="/WEB-INF/jsp/common/navbar.jsp">
			<jsp:param name="active" value="facolta" />
		</jsp:include>
		<div class="container">		
			<a href="${ctx}facolta" class="btn btn-primary"> Indietro</a> <br>
			<hr>
			<c:choose>
				<c:when test="${not empty facolta.idFacolta}">
					<c:url value="/facolta/${facolta.idFacolta}/edit" var="saveUrl" />
				</c:when>
				<c:otherwise>
					<c:url value="/facolta/new" var="saveUrl" />
				</c:otherwise>
			</c:choose>
			<form action="${saveUrl}" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<c:if test="${not empty facolta.idFacolta}">
					<label>ID</label> ${facolta.idFacolta}
					<input type="hidden" name="idFacolta" value="${facolta.idFacolta}">
					<br>
				</c:if>
				<label>Attivit&agrave;:</label>
				<input type="text" name="activityName" value="${activity.activityName}"> <br>
				<label>Data inizio:</label>
				<fmt:formatDate value="${activity.startDate}" pattern="yyyy-MM-dd" var="startDateF"/>
				<input type="date" name="startDate" value="${startDateF}"> <br>
				<label>Data fine:</label>
				<fmt:formatDate value="${activity.endDate}" pattern="yyyy-MM-dd" var="endDateF"/>
				<input type="date" name="endDate" value="${endDateF}"> <br>
				<input type="reset" value="Cancella" class="btn btn-danger rounded"> <input type="submit" value="Salva" class="btn btn-success rounded">
			</form>
		</div>
	</body>
</html>