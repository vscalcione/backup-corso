<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
$(document).ready(function() {
	
	//genera valori random
	$("#genera").click(function() {
		$.ajax({
			url : "${ctx}random.action",
			success : function(json) {
				var mapped = json.sestina;
				$("#result").empty();
				$("#result").append("<h1>Sestina generata</h1>");
				$("input[name='sestina']").each(function(i) {
					$(this).attr('value',mapped[i]);
					$(this).attr('placeholder',mapped[i]);
				})
			}
		})
	});// end genera
	
	//ricerca nel DB
	$("#ricerca").click(function() {
		var values = $("input[name='sestina']").map(function() {
			return $(this).val();}).get();
		if (!(controllo(values) && doppi(values))) {
			alert("sestina non valida");
			event.preventDefault();
			return;
		}
		$.ajax({
			type : "POST",
			dataType : 'json',
			data : {"sestina" : "[" + values + "]"},
			url : "${ctx}cerca.action",
			success : function(json) {
				$("#result").empty();
				if(json.sestina[0] == 1){
					$("#result").append("<h1>Sestina trovata</h1>");
				}
				else if(json.sestina[0] < 0){
					$("#result").append("<h1>Sestina non valida</h1>");
				} 
				else{
					$("#result").append("<h1>Sestina non trovata</h1>");
				}
			}
		})
	});// end ricerca

})// end ready
</script>