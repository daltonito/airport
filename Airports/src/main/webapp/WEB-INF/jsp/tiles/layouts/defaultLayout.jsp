<?xml version="1.0" encoding="UTF-8" ?>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<meta charset="utf-8" />

		
		<title><tiles:getAsString name="title" /></title>
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		
		<link rel="shortcut icon" href="<c:url value='/img/gt_favicon.png' />" />
		<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700" />
		<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />" /> 
		<link rel="stylesheet" href="<c:url value='/css/font-awesome.min.css' />" />
	
		<!-- Custom styles for template -->
		<link rel="stylesheet" href="<c:url value='/css/bootstrap-theme.css' />" media="screen" />
		<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
	
	    <!--  Fonts and icons     -->
	    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet" />
	    
	    
<!-- 				<script src="https://maps.google.com/maps/api/js?libraries=geometry&key=AIzaSyDXdvm0FPWMumIBPVkeuIvHBpl5xSxntog">
		</script> -->
		<!-- <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script> -->
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" />
		<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js" />
		<script src="<c:url value="/js/headroom.min.js" />" />
		<script src="<c:url value="/js/jQuery.headroom.min.js" />" />
		<script src="<c:url value="/js/template.js" />" />
		<%-- <script src="<c:url value="/js/maplace.min.js" />" /> --%>
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		
	</head>
	<body>
		<tiles:insertAttribute name="header" />
		<div class="container">
			<tiles:insertAttribute name="body" />
		</div>
		<footer id="footer" class="footer">
			<tiles:insertAttribute name="footer" />
		</footer>
	</body>
</html>