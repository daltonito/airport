<%@page import="com.airports.portal.controller.support.Requests"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="navbar-collapse collapse">
	<ul class="nav navbar-nav pull-right" style="margin-right: 3em;">
		<li class="active"><a href="<c:url value='<%=Requests.ROOT%>' />" style="color: #d1dee5; font-weight: bold;">HOME</a></li>
		<li><a href="<c:url value='<%=Requests.QUERY%>' />" style="color: #d1dee5; font-weight: bold;">QUERY</a></li>
		<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: #d1dee5; font-weight: bold;">REPORTS<b class="caret"></b></a>
			<ul class="dropdown-menu">
				<li><a href="<c:url value='<%=Requests.REPORTS_NUMBER_OF_AIRPORTS%>' />">Number of airports</a></li>
				<li><a href="<c:url value='<%=Requests.REPORTS_TYPES_OF_RUNWAYS%>' />">Types of runways per country</a></li>
				<li><a href="<c:url value='<%=Requests.REPORTS_COMMON_RUNWAY_IDENTS%>' />">Common runway identifications</a></li>
			</ul>
		</li>
	</ul>
</div>