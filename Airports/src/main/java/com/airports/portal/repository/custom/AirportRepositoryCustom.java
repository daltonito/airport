package com.airports.portal.repository.custom;

import java.util.List;
import java.util.Map;

public interface AirportRepositoryCustom {

	Map<String, Integer> getAirportsCountByCountry(Integer numberOfRecords, boolean descendingOrder);
	
	List<String> getAirportIdentsByCountry(String countryCode);
}
