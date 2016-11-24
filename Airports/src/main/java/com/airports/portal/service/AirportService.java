package com.airports.portal.service;

import java.util.List;
import java.util.Map;

public interface AirportService {
	
	void getAirportsAndRunwaysByCountry(String countryInput);
	
	Map<Integer, String> getAirportsCountByCountry(Integer numberOfRecords, boolean descendingOrder);

	List<String> getRunwayTypesByCountry(String countryCode);
	
	List<String> getMostCommonRunwayIdents(Integer numberOfRecords);
	
}
