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
		<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css" />
		<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />" /> 
		<link rel="stylesheet" href="<c:url value='/css/font-awesome.min.css' />" />
	
		<!-- Custom styles for template -->
		<link rel="stylesheet" href="<c:url value='/css/bootstrap-theme.css' />" media="screen" />
		
	
	    <!--  Fonts and icons     -->
	    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet" />
	    
		<!-- <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script> -->
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" />
		<script async src="http://code.jquery.com/ui/1.10.1/jquery-ui.min.js"></script>
		<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js" ></script>
		<script src="<c:url value="/js/headroom.min.js" />" />
		<script src="<c:url value="/js/jQuery.headroom.min.js" />" />
		<script src="<c:url value="/js/template.js" />" />
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="<c:url value='/css/main.css' />" />
		
		
	</head>
	<body>
		<tiles:insertAttribute name="header" />
		<div class="container">
			<tiles:insertAttribute name="body" />
		</div>
		<div style="height: 12%;"></div>
		<footer id="footer" class="footer">
			<tiles:insertAttribute name="footer" />
		</footer>
	</body>
</html>