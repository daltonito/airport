<%@page import="com.airports.portal.controller.support.Requests"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="navbar-collapse collapse">
	<ul class="nav navbar-nav pull-left" style="margin-left: 8em;">
		<li class="active"><a href="<c:url value='<%=Requests.ROOT%>' />">Home</a></li>
		<li><a href="<c:url value='<%=Requests.QUERY%>' />">Query</a></li>
		<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown">Reports<b class="caret"></b></a>
			<ul class="dropdown-menu">
				<li><a href="<c:url value='<%=Requests.REPORTS%>' />">Countries with highest/lowest number of airports</a></li>
				<li><a href="<c:url value='<%=Requests.REPORTS%>' />">Types of runways per country</a></li>
				<li><a href="<c:url value='<%=Requests.REPORTS%>' />">Most common runway identifications</a></li>
			</ul>
		</li>
	</ul>
</div>