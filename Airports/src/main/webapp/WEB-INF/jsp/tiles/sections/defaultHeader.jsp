<%@page import="com.airports.portal.controller.support.Requests"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- Fixed navbar -->
<div class="navbar navbar-inverse navbar-fixed-top headroom gradBackground" >
	<div class="container">
		<div class="navbar-header" style="width: 40%;">
			<!-- Button for smallest screens -->
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
			<span style="COLOR: white; FLOAT: left; font-size: 1.3em; padding-top: 0.7em; padding-left: 4em; font-weight: bold; font-family: 'Open sans', Helvetica, Arial;">INTERNATIONAL AIRPORTS PORTAL</span>
			<a class="navbar-brand" href="<c:url value='<%=Requests.ROOT%>' />" style="margin-left: -18em;"><img style="width: 24%; opacity: 0.86;" src="<c:url value="/img/logo.png" />" alt=""></a>
		</div>
		<tiles:insertDefinition name="menu" />
	</div>
</div> 
<!-- /.navbar -->

<header id="head" class="secondary"></header>