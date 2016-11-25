package com.airports.portal.service;

import java.util.List;
import java.util.Map;

public interface AirportService {
	
	void getAirportsAndRunwaysByCountry(String countryInput);
	
	Map<String, Integer> getAirportsCountByCountry(Integer numberOfRecords, boolean descendingOrder);

	List<String> getRunwayTypesByCountry(String countryCode);
	
	Map<String, Integer> getMostCommonRunwayIdents(Integer numberOfRecords);
	
}
