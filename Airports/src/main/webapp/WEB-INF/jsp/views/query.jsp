<%@page import="com.airports.portal.controller.support.Requests"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
					<form action="${form_action}" method="POST" autocomplete="false">
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
				<div class="table-responsive"> 
					<div class="col-md-12 col-sm-12">
						<table class="table table-striped">
							<thead>
								<tr class="caption">
									<th>Name</th>
									<th>Identifier</th>
									<th>Type</th>
									<th>Region</th>
									<th>Municipality</th>
									<th>Sched. Service</th>
									<th>GPS Code</th>
									<th>IATA Code</th>
									<th>Local Code</th>
									<th>Location</th>
									<th>Runways</th>
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
											<td id="grid_airport_type">
												<a  style="font-size: 1.4em;" data-toggle="modal" data-target="#geoLocationModal" 
												onclick="openGeoLocationModal('${airport.name}', ${airport.latitudeDegree}, ${airport.longitudeDegree});">
													<i class="fa fa-map-marker" aria-hidden="true"></i>
												</a>
											</td>
											<td id="grid_airport_type">
												<c:if test="${not empty airport.runways}">
													<i class="fa fa-info-circle" aria-hidden="true"></i>
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
				
				</c:if>
			</c:if>
	</article>
</div>
<script>

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