package com.airports.portal.service;

import java.util.List;
import java.util.Map;

import com.airports.portal.model.support.AirportPaginationHelper;

public interface AirportService {
	
	AirportPaginationHelper getAirportsAndRunwaysByCountry(String countryInput, Integer pageNumber);
	
	Map<String, Integer> getAirportsCountByCountry(Integer numberOfRecords, boolean descendingOrder);

	List<String> getRunwayTypesByCountry(String countryCode);
	
	Map<String, Integer> getMostCommonRunwayIdents(Integer numberOfRecords);
	
}
