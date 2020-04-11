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
			<label>ID:</label> ${employee.idMatricola}<br>
			<label>Cognome:</label> ${employee.surname}<br>
			<label>Nome:</label> ${employee.name}<br>
		</div>
	</body>
</html>