<%@page import="com.airports.portal.controller.support.Requests"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="container-fluid">
	<div class="navbar-header">
		<a href="<c:url value='<%=Requests.ROOT%>' />" class="navbar-brand"><c:out value="${title}"/></a>
	</div>
	<div class="collapse navbar-collapse">
	</div>
</div>