<%@ include file="/WEB-INF/jsp/common/common.jsp" %>
<nav class="navbar navbar-dark bg-primary navbar-expand-lg">
	<a class="navbar-brand" href="${ctx}">AM-Web&trade;</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item ${(param.active ne 'activity')?'active':''}">
				<a class="nav-link" href="${ctx}activity"> Attivita <span class="sr-only">(current)</span> </a>
			</li>
			<li class="nav-item ${(param.active ne 'employee')?'active':''}">
				<a class="nav-link" href="${ctx}employee"> Dipendenti <span class="sr-only">(current)</span> </a>
			</li>
		</ul>
		<a href="${ctx}logout" class="btn btn-success btn-sm">Logout</a>
	</div>
</nav>