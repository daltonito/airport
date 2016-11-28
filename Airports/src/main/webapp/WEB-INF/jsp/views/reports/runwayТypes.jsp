<%@page import="com.airports.portal.controller.support.Requests"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<ol class="breadcrumb">
	<li><a href="<c:url value='<%=Requests.ROOT%>' />">Home</a></li>
	<li class="active">Reports</li>
</ol>

<div class="row">
	<article class="col-xs-12 maincontent">
		<header class="page-header">
			<h1 class="page-title">Types of runways per country</h1>
		</header>
		<div class="col-md-12 col-sm-12">
			<div class="table-responsive"> 
				<table class="table table-striped">
					<thead style="background-color: #d0cdcd; opacity: 0.96;">
						<tr>
							<th style="width: 20%;">COUNTRY</th>
							<th>TYPES OF RUNWAYS</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${countries}" var="entry" varStatus="loop">
							<c:set var="country" value="${entry.key}" />
							<tr>
								<td><a href="${country.wikipediaLink}">${country.name} (${country.code})</a></td>
								<td>${entry.value}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 col-sm-12" style="text-align: center;">
				<tiles:insertDefinition name="pagination">
					<tiles:putAttribute name="currentIndex" value="${currentIndex}" />
					<tiles:putAttribute name="beginIndex" value="${beginIndex}" />
					<tiles:putAttribute name="endIndex" value="${endIndex}" />
					<tiles:putAttribute name="totalPages" value="${totalPages}" />
				</tiles:insertDefinition>									
			</div>
		</div>			
	</article>
</div>
<script>
	function getPage(pageNumber) {
	    var form = document.createElement("form");
	    var element1 = document.createElement("input"); 
	
	    form.method = "POST";
	    form.action = '<c:url value='<%=Requests.REPORTS_TYPES_OF_RUNWAYS%>' />';   
	
	    element1.value=pageNumber;
	    element1.name="pageNumber";
	    element1.type="hidden";
	    form.appendChild(element1);  
	
	    document.body.appendChild(form);
	
	    form.submit();
	}
</script>