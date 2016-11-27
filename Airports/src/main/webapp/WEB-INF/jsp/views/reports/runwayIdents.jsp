<%@page import="com.airports.portal.controller.support.Requests"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<ol class="breadcrumb">
	<li><a href="<c:url value='<%=Requests.ROOT%>' />">Home</a></li>
	<li class="active">Reports</li>
</ol>

<div class="row">
	<article class="col-xs-12 maincontent">
		<header class="page-header">
			<h1 class="page-title">Common runway identifications</h1>
		</header>
		<div class="col-md-6 col-md-offset-3 col-sm-12">
			<h4 class="text-left text-muted">Top 10 most common runway identifications</h4>
			<hr>
			<table class="table table-striped">
				<thead style="background-color: #d0cdcd; opacity: 0.96;">
					<tr>
						<th>RANKING</th>
						<th>RUNWAY IDENTIFIER</th>
						<th>NUMBER OF OCCURENCES</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${runwayIdents}" var="ident" varStatus="loop">
						<tr>
							<td>${loop.index + 1}</td>
							<td style="font-weight: bold;">${ident.key}</td>
							<td>${ident.value}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>		
	</article>
</div>