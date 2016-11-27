<%@page import="com.airports.portal.controller.support.Requests"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<ol class="breadcrumb">
	<li><a href="<c:url value='<%=Requests.ROOT%>' />">Home</a></li>
	<li class="active">Query</li>
</ol>

<div class="row">
	<article class="col-xs-12 maincontent">
		<header class="page-header">
			<h1 class="page-title">Query</h1>
		</header>
		<c:if test="${search_action eq true}">
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
		</c:if>
		<c:if test="${result_action eq true}">
			<c:if test="${empty country}">
					<h3 class="thin text-center">Country not found</h3>
					<p class="text-center text-muted">The entered country name or code is not found. <a href="<c:url value='<%=Requests.QUERY%>' />">Search again ?</a></p>						
			</c:if>
			<c:if test="${not empty country}">
				<div class="row">
					<div class="col-md-3 col-sm-3">
						<h3 class="thin text-center"><a class="pull-left" style="padding-bottom: 1em;" href="${country.wikipediaLink}">${country.name} (${country.code})</a></h3>
					</div>
				</div>
				<div class="row">
					<div class="table-responsive"> 
						<div class="col-md-12 col-sm-12">
							<table class="table table-striped">
								<thead style="background-color: #d0cdcd; opacity: 0.96;">
									<tr>
										<th>NAME</th>
										<th>IDENTIFIER</th>
										<th>TYPE</th>
										<th>REGION</th>
										<th>MUNICIPALITY</th>
										<th>SCHED. SERVICE</th>
										<th>GPS CODE</th>
										<th>IATA CODE</th>
										<th>LOCAL CODE</th>
										<th>LOCATION</th>
										<th>RUNWAYS</th>
									</tr>
								</thead>
									<tbody>
										<c:forEach items="${country.airports}" var="airport">
											<tr id="grid_airport_id_${airport.id}">
												<td id="grid_airport_name">
													<c:if test="${not empty airport.wikipediaLink}">
														<a href="${airport.wikipediaLink}">${airport.name}</a>
													</c:if>
													<c:if test="${empty airport.wikipediaLink}">
														${airport.name}
													</c:if>										
												</td>
												<td id="grid_airport_ident">${airport.ident}</td>
												<td id="grid_airport_type">${airport.type}</td>
												<td id="grid_airport_region">${airport.isoRegion}</td>
												<td id="grid_airport_municipality">${airport.municipality}</td>
												<td id="grid_airport_sched_service">${airport.scheduledService}</td>
												<td id="grid_airport_gps_code">${airport.gpsCode}</td>
												<td id="grid_airport_iata_code">${airport.iataCode}</td>
												<td id="grid_airport_local_code">${airport.localCode}</td>
												<td id="grid_airport_location" style="text-align: center;">
													<a  style="font-size: 1.4em;" data-toggle="modal" data-target="#geoLocationModal" 
													onclick="openGeoLocationModal('${airport.name}', ${airport.latitudeDegree}, ${airport.longitudeDegree});">
														<i class="fa fa-map-marker" aria-hidden="true"></i>
													</a>
												</td>
												<td id="grid_airport_runways" style="text-align: center;">
													<c:if test="${fn:length(airport.runways) > 0}">
														<a  style="font-size: 1.4em;" data-toggle="modal" data-target="#runwaysModal_${airport.id}">
															<i class="fa fa-info-circle" aria-hidden="true"></i>
														</a>												
														
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
																						<td>${runway.leIdent}</td>
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
																	<div class="modal-footer">
																		<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
																	</div>
																</div>
															</div>
														</div>														
													</c:if>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<!-- Modal -->
								<div class="modal fade" id="geoLocationModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal" aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title"><span id="geoLocationModalTitle"></span></h4>
											</div>
											<div class="modal-body">
												<div id="map" style="width:100%;height:50%;overflow:visible;"></div>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
											</div>
										</div>
									</div>
								</div>	
							</div>
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
				</c:if>
			</c:if>
	</article>
</div>
<script>
	function getPage(pageNumber) {
	    var form = document.createElement("form");
	    var element1 = document.createElement("input"); 
	    var element2 = document.createElement("input");  
	
	    form.method = "POST";
	    form.action = '<c:url value='<%=Requests.QUERY%>' />';   
	
	    element1.value=pageNumber;
	    element1.name="pageNumber";
	    element1.type="hidden";
	    form.appendChild(element1);  
	
	    element2.value='${country.code}';
	    element2.name="query_input";
	    element2.type="hidden";
	    form.appendChild(element2);
	
	    document.body.appendChild(form);
	
	    form.submit();
	}


	function openGeoLocationModal(title, latDeg, lngDeg) {
		
		$("#geoLocationModalTitle").text(title);
		/* $('#geoLocationModal').modal('show'); */
		
        var uluru = {lat: latDeg, lng: lngDeg};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 8,
          center: uluru
        });
        
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
        
    	$('#geoLocationModal').on('shown.bs.modal', function () {
    	    google.maps.event.trigger(map, "resize");
    	    map.setCenter(new google.maps.LatLng(latDeg, lngDeg));
    	});
	}
</script>
    <script>
      function initMap() {
        var uluru = {lat: -25.363, lng: 131.044};
        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 8,
          center: uluru
        });
        var marker = new google.maps.Marker({
          position: uluru,
          map: map
        });
      }
    </script>
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDXdvm0FPWMumIBPVkeuIvHBpl5xSxntog&callback=initMap">
  </script>