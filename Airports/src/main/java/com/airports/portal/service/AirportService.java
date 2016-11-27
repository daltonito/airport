package com.airports.portal.service;

import java.util.List;
import java.util.Map;

import com.airports.portal.model.Country;
import com.airports.portal.model.support.AirportPaginationHelper;
import com.airports.portal.model.support.RunwayTypesPaginationHelper;

public interface AirportService {
	
	AirportPaginationHelper getAirportsAndRunwaysByCountry(String countryInput, Integer pageNumber);
	
	Map<Country, Integer> getAirportsCountByCountry(Integer numberOfRecords, boolean descendingOrder);
	
	RunwayTypesPaginationHelper getRunwayTypesByCountry(Integer pageNumber);

	List<String> getRunwayTypesByCountry(String countryCode);
	
	Map<String, Integer> getMostCommonRunwayIdents(Integer numberOfRecords);
	
}
