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
												<tiles:insertDefinition name="runwayModal">
													<tiles:putAttribute name="airport" value="${airport}" />
												</tiles:insertDefinition>																									
											</c:if>
										</td>
									</tr>
								</c:forEach>
								<c:if test="${empty country.airports}">
									<td colspan="11" style="text-align: center;">Airports not found for this country.</td>
								</c:if>								
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
										<h4 class="modal-title" style="text-align: center;"><span id="geoLocationModalTitle"></span></h4>
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