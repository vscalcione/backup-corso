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
			<a href="${ctx}studente">Indietro</a> <br>
			<hr>
			<c:choose>
				<c:when test="${not empty studente.matricola}">
					<c:url value="/studente/${studente.matricola}}/edit" var="saveUrl" />
				</c:when>
				<c:otherwise>
					<c:url value="/studente/new" var="saveUrl" />
				</c:otherwise>
			</c:choose>			
			<form action="${saveUrl}" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<c:if test="${not empty studente.matricola}">
					<label>Matricola:</label> ${studente.matricola}
					<input type="hidden" name="matricola" value="${studente.matricola}">
					<br>
				</c:if>
				<label>Cognome:</label>
				<input type="text" name="cognome" value="${studente.cognome}"> <br>
				<label>Nome:</label>
				<input type="text" name="nome" value="${studente.nome}"> <br>
				<input type="reset" value="Cancella"> <input type="submit" value="Salva">
			</form>
		</div>
	</body>
</html>