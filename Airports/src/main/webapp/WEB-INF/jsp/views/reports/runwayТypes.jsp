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
				<!-- PAGINATION -->
				
				<div class="pagination">
				    <ul class="pagination">
				        <c:choose>
				            <c:when test="${currentIndex == 1}">
				                <li class="disabled"><a href="#">&lt;&lt;</a></li>
				                <li class="disabled"><a href="#">&lt;</a></li>
				            </c:when>
				            <c:otherwise>
				                <li><a onclick="getPage(1);">&lt;&lt;</a></li>
				                <li><a onclick="getPage(${currentIndex - 1});">&lt;</a></li>
				            </c:otherwise>
				        </c:choose>
				        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
				            <c:url var="pageUrl" value="/pages/${i}" />
				            <c:choose>
				                <c:when test="${i == currentIndex}">
				                    <li class="active"><a onclick="getPage(${i});"><c:out value="${i}" /></a></li>
				                </c:when>
				                <c:otherwise>
				                    <li><a onclick="getPage(${i});"><c:out value="${i}" /></a></li>
				                </c:otherwise>
				            </c:choose>
				        </c:forEach>
				        <c:choose>
				            <c:when test="${currentIndex == totalPages}">
				                <li class="disabled"><a href="#">&gt;</a></li>
				                <li class="disabled"><a href="#">&gt;&gt;</a></li>
				            </c:when>
				            <c:otherwise>
				                <li><a onclick="getPage(${currentIndex + 1});">&gt;</a></li>
				                <li><a onclick="getPage(${totalPages});">&gt;&gt;</a></li>
				            </c:otherwise>
				        </c:choose>
				    </ul>
				</div>
				<!-- PAGINATION -->						
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