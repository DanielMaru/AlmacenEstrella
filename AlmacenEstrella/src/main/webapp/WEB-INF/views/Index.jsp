<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Bree+Serif" rel="stylesheet">
    </head>
    <body>
	      <nav class="navbar navbar-inverse">
			  <div class="container-fluid">
			    <div class="navbar-header">
			      <a class="navbar-brand" href="#"><img alt="logo" src="<c:url value="/resources/imagenes/fondo.png" />"></a>
			    </div>
			    <ul class="nav navbar-nav">
			      <li class="active"><a href="#">Inicio</a></li>
			      <li><a href="#">Productos</a></li>
			      <li><a href="#">Ventas</a></li>
			      <li><a href="#">Reportes</a></li>
			    </ul>
			  </div>
			</nav>

    </body>
</html>
