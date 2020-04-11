<%@ include file="/WEB-INF/content/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>


<script type="text/javascript" src="js/ControlloSestine.js"></script>
<script type="text/javascript" src="js/controlloJquery.js"></script>
<%@ include file="/WEB-INF/content/jsp/common/head.jsp"%>
<%@ include file="/WEB-INF/content/jsp/lottoAjax.jsp"%>

</head>
<body>
	<div>
		<hr>

		<h1>Sestina del lotto </h1>
		<s:form>
			<table>
				<tr id="ciclo">
					<s:iterator value="sestina" var="num">
						<td><input type="text" name="sestina" placeholder="${num}"
							value="${num}" maxlength="2" size="2"></td>
					</s:iterator>
				</tr>
			</table>
			<input type="button" id="genera" value="Genera Sestina Random">
			<input type="button" id="ricerca" value="cerca">
		</s:form>
		<hr>

	</div>
	<div id="result">
		
	</div>
</body>
</html>