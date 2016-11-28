package com.airports.portal.repository.custom;

import java.util.List;
import java.util.Map;

/**
 * Used for defining custom methods and queries on the Airports documents 
 * that are not supported by the PagingAndSortingRepository interface.
 */
public interface AirportRepositoryCustom {

	/**
	 * Retrieves a result map with country codes (keys) 
	 * and the corresponding number of airports (values).
	 * 
	 * @param numberOfRecords the number of returned results
	 * @param descendingOrder true for descending, false for ascending order
	 * @return map with country code/number of airports entries
	 */
	Map<String, Integer> getAirportsCountByCountry(Integer numberOfRecords, boolean descendingOrder);
	
	/**
	 * Retrieves all airport identifications for a given country code.
	 * 
	 * @param countryCode the country code value
	 * @return a list of all airport identifications that match the criteria
	 */
	List<String> getAirportIdentsByCountry(String countryCode);
}
