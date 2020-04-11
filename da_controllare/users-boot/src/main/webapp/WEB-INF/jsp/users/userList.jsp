<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="/WEB-INF/jsp/common/head.jsp" %>
		<link rel="icon" href="/favicon.ico" />
	</head>
	<body>
		<jsp:include page="/WEB-INF/jsp/common/navbar.jsp">
			<jsp:param name="active" value="users" />
		</jsp:include>
		<div class="container">
			<script type="text/javascript">
				function loadUsers() {
					$.get('/users-web/api/users', function(result) {
						var message = '';
						result.forEach(function(dto) { message += dto.userId+' '+dto.userName + '<br>'; });
						$('#risultato').html(message);
					});
				}
				function checkCount() {
					$.get('/users-web/api/users/count', function(result) {
						$('#count').text(result);
						//setTimeout(checkCount, 1000);
					});
				}
				$(function() {
					loadUsers();
					checkCount();
				});
			</script>
			<c:url value="/users/new" var="newUserUrl" />
			<div class="container" style="padding: 20px;">
			<table class="table table-hover table-sm">
			<thead class="thead-light">
				<tr>
					<th>User_ID</th> <th>Username</th> <th>Password</th> <th>Enabled</th>
					<th><a href="${newUserUrl}" class="btn btn-success btn-sm">Crea nuovo utente</a></th>
				</tr>
			</thead>
				<c:forEach items="${userList}" var="user">
					<c:url value="/users/${user.userId}" var="userDetailUrl" />
					<c:url value="/users/${user.userId}/edit" var="userEditUrl" />
					<c:url value="/users/${user.userId}/delete" var="userDeleteUrl" />
					<tr>
						<td> <a href="${userDetailUrl}" class="btn btn-primary btn-sm"> ${user.userId} </a> </td>
						<td>${user.userName }</td>
						<td>${user.password }</td>
						<td>${user.enabled }</td>
						<td>
							<a href="${userEditUrl}" class="btn btn-warning btn-sm">Modifica</a>
							<a href="${userDeleteUrl}" class="btn btn-danger btn-sm"onclick="return confirm('Vuoi eliminare?');">Elimina</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			</div>
			<div id="risultato"></div>
			<div id="count"></div>
		</div>
	</body>
</html>