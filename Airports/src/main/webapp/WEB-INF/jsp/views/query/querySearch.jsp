<%@page import="com.airports.portal.controller.support.Requests"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<ol class="breadcrumb">
	<li><a href="<c:url value='<%=Requests.ROOT%>' />">Home</a></li>
	<li class="active">Query</li>
</ol>

<div class="row">
	<article class="col-xs-12 maincontent">
		<header class="page-header">
			<h1 class="page-title">Query</h1>
		</header>
		<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-default">
				<div class="panel-body">
					<h3 class="thin text-center">Query airports</h3>
					<p class="text-center text-muted">Find information and details about airports and runways for specific country</p>
					<hr>
					<c:url value="<%=Requests.QUERY%>" var="form_action"></c:url>
					<form action="${form_action}" method="POST" autocomplete="off">
						<div class="row">
							<div class="col-lg-12">
								<label>Country name or code</label>
								<input type="text" class="form-control" name="query_input" id="query_input">
								<c:if test="${error_action eq true}">
										<p class="text-left text-muted" style="color: red;">The entered country name or code is not found.</p>						
								</c:if>								
							</div>
						</div>
						<div class="row">
							<div class="col-lg-8">
							</div>
							<div class="col-lg-4 text-right">
								<button class="btn btn-action top-margin" name="query_submit" id="query_submit" type="submit">Search</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</article>
</div>