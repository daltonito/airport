<?xml version="1.0" encoding="UTF-8" ?>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		
		<title><tiles:getAsString name="title" /></title>
		
		<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    	<meta name="viewport" content="width=device-width" />
    	
		<link href="<c:url value='/css/bootstrap.min.css' />" rel="stylesheet" />
		<link href="<c:url value='/css/animate.min.css' />" rel="stylesheet" />
		<link href="<c:url value='/css/paper-dashboard.css' />" rel="stylesheet" />
		<link href="<c:url value='/css/themify-icons.css' />" rel="stylesheet" />
	
	    <!--  Fonts and icons     -->
	    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet" />
	    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css' />
	
		<script src="<c:url value="/js/paper-dashboard.js" />"></script>
		<script src="<c:url value="/js/bootstrap-checkbox-radio.js" />"></script>
		<script src="<c:url value="/js/jquery-1.10.2.js" />"></script>
		<script src="<c:url value="/js/bootstrap.min.js" />"></script>
	</head>
	<body>
		<div class="wrapper">
			<div class="sidebar" data-background-color="white" data-active-color="danger">
				<div class="sidebar-wrapper">
					<tiles:insertAttribute name="menu" />
				</div>
			</div>
			<div class="main-panel">
				<nav class="navbar navbar-default">
					<tiles:insertAttribute name="header" />
				</nav>
				<div class="content">
					<tiles:insertAttribute name="body" />
				</div>
			</div>
			<footer class="footer">
				<tiles:insertAttribute name="footer" />
			</footer>
		</div>
	</body>
</html>