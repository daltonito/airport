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
			<h1 class="page-title">Countries with highest and lowest number of airports</h1>
		</header>
		<div class="col-md-6 col-sm-12">
			<h4 class="text-left text-muted">Top 10 countries with highest number of airports</h4>
			<hr>
			<table class="table table-striped">
				<thead style="background-color: #d0cdcd; opacity: 0.96;">
					<tr>
						<th> </th>
						<th>COUNTRY</th>
						<th>NUMBER OF AIRPORTS</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${topCountries}" var="entry" varStatus="loop">
						<c:set var="country" value="${entry.key}" />
						<tr>
							<td>${loop.index + 1}</td>
							<td><a href="${country.wikipediaLink}">${country.name} (${country.code})</a></td>
							<td>${entry.value}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-md-6 col-sm-12">
			<h4 class="text-left text-muted">Top 10 countries with lowest number of airports</h4>
			<hr>		
			<table class="table table-striped">
				<thead style="background-color: #d0cdcd; opacity: 0.96;">
					<tr>
						<th> </th>
						<th>COUNTRY</th>
						<th>NUMBER OF AIRPORTS</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bottomCountries}" var="entry" varStatus="loop">
						<c:set var="country" value="${entry.key}" />
						<tr>
							<td>${loop.index + 1}</td>
							<td><a href="${country.wikipediaLink}">${country.name} (${country.code})</a></td>
							<td>${entry.value}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>		
	</article>
</div>