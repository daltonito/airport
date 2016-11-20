<%@page import="com.airports.portal.controller.support.Requests"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="logo">
	<a href="<c:url value='<%=Requests.ROOT%>' />" class="simple-text"> International Airports </a>
</div>
<ul class="nav">
	<li class="active"><a href="<c:url value='<%=Requests.ROOT%>' />"> <i class="ti-panel"></i>
			<p>Home</p>
	</a></li>
	<li><a href="<c:url value='<%=Requests.QUERY%>' />"> <i class="ti-user"></i>
			<p>Query</p>
	</a></li>
	<li><a href="<c:url value='<%=Requests.REPORTS%>' />"> <i class="ti-view-list-alt"></i>
			<p>Reports</p>
	</a></li>
</ul>