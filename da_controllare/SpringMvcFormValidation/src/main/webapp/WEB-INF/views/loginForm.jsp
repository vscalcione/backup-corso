<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Login Form</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <meta name="author" content="Scalcione Vincenzo">
	    <meta name="description" content="qualcosa">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	    <style type="text/css">
	        .errormsg { color: red; }
	    </style>
	</head>
	<body>
		<div class="container">
		    <h2 align="center" class="text-primary">Validazione Form con Spring MVC</h2>
		    <hr>
		    <div>&nbsp;</div>
	    	<form:form action="/SpringMvcFormValidation/login" method="POST" modelAttribute="userform">
	    		 <div class="form-group">
	    		 	<div class="input-group mb-2">
	    		 		<div class="input-group-text">@ Email</div>
	    		 		<form:input path="email" size="30" cssClass="form-control" placeholder="Inserisci la tua E-Mail" />
	    		 	</div>			   
				    <small><form:errors path="email" cssClass="errormsg" /></small>
				 </div>
				 <div class="form-group">
				 	<div class="input-group mb-2">
				 		<div class="input-group-text"> *** Password</div>
				 		<form:password path="password" size="30" cssClass="form-control" placeholder="Inserisci la tua password" />
				 	</div>
				    <small><form:errors path="password" cssClass="errormsg" /></small>
				 </div>
				 <div class="form-group">
				    <button type="submit" class="btn btn-primary">Invio Dati</button>
				 </div>
	    	</form:form>
	    </div>
	</body>
</html>