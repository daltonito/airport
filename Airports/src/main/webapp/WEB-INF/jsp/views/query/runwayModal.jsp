<%@page import="com.airports.portal.controller.support.Requests"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>

<tilesx:useAttribute id="airport" name="airport" />

<!-- Modal -->
<div class="modal fade" id="runwaysModal_${airport.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document" style="width: 60%;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">${airport.name} Runways</h4>
			</div>
			<div class="modal-body">
				<div class="table-responsive"> 
					<table class="table table-bordered">
						<thead style="background-color: #d0cdcd; opacity: 0.96;">
							<tr>
								<th>IDENTIFIER</th>
								<th>LENGTH (FT)</th>
								<th>WIDTH (FT)</th>
								<th>SURFACE</th>
								<th>LIGHTED</th>
								<th>CLOSED</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${airport.runways}" var="runway">
								<tr>
									<td style="font-weight: bold;">${runway.leIdent}</td>
									<td>${runway.lengthFt}</td>
									<td>${runway.widthFt}</td>
									<td>${runway.surface}</td>
									<td>
										<c:if test="${not empty runway.lighted}">
											<c:if test="${runway.lighted eq 1}">
												yes
											</c:if>
											<c:if test="${runway.lighted eq 0}">
												no
											</c:if>
										</c:if>																				
									</td>
									<td>
										<c:if test="${not empty runway.closed}">
											<c:if test="${runway.closed eq 1}">
												yes
											</c:if>
											<c:if test="${runway.closed eq 0}">
												no
											</c:if>
										</c:if>																					
									</td>																					
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>																	
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>	