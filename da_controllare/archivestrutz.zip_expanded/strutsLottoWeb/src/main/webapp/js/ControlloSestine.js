function validate() {
	var sestina = document.getElementsByName("sestina");

	for (var i = 0; i < sestina.length; i++) {	

		if (validator(sestina[i].value)) {

			alert("Sestina non valida");
			sestina[i].style.backgroundColor = "red";
			var res = document.getElementById("result");
			res.parentNode.removeChild(res);
			return false;
		}
	}
	
	//controllo doppi
	for (var i = 0; i < sestina.length - 1; i++) {

		for (var j = i + 1; j < sestina.length; j++) {
			
			if (sestina[i].value == sestina[j].value) {

				sestina[i].style.backgroundColor = "red";
				sestina[j].style.backgroundColor = "red";
				alert("Sestina non valida");
				var res = document.getElementById("result");
				res.parentNode.removeChild(res);
				return false;
			}
		}
	}
}


function validator(element) 
{
	return (isNaN(element) || isLess(element) || isMore(element));	
}

function isLess(element)
{
	return element < 1 ? true : false;
}

function isMore(element)
{
	return element > 90 ? true : false;
}