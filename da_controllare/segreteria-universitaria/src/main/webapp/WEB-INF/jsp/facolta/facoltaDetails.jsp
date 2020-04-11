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
			<a href="${ctx}facolta">Indietro</a> <br>
			<label>ID</label> ${facolta.idFacolta}<br>
			<label>Nome Facolt&agrave;:</label> ${facolta.nomeFacolta}<br>
			<label>Numero iscritti: </label> ${facolta.numeroIscritti}<br>
		</div>
	</body>
</html>