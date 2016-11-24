package com.airports.portal.repository.custom;

import java.util.List;
import java.util.Map;

public interface AirportRepositoryCustom {

	Map<Integer, String> getAirportsCountByCountry(Integer numberOfRecords, boolean descendingOrder);
	
	List<String> getAirportIdentsByCountry(String countryCode);
}
