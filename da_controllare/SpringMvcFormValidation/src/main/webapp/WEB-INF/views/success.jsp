<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Benvenuto</title>
		<meta name="author" content="Scalcione Vincenzo">
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">	    
	</head>
	<body>
		<div class="container">
	    	<h2 align="center" class="text-primary">Esempio di Validazione Form con Spring MVC</h2>
	    	<hr />
	    	<div>&nbsp;</div>
	        <h4 align="center">Benvenuto <span class="text-success">${userform.email}</span>! Hai appena eseguito con successo
	        il tuo primo Login!!!! </h4>
	    </div>
	</body>
</html>