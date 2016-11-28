package com.airports.portal.repository.custom;

import java.util.List;
import java.util.Map;

/**
 * Used for defining custom methods and queries on the Runways documents 
 * that are not supported by the PagingAndSortingRepository interface.
 */
public interface RunwayRepositoryCustom {

	/**
	 * Retrieves all distinct types of runways, 
	 * where the airport identification is contained in the given identifications collection.
	 * 
	 * @param airportIdents a collection with airport identifiers
	 * @return list of distinct types of runways
	 */
	public List<String> getDistinctRunwayTypes(List<String> airportIdents);
	
	/**
	 * Retrieves a result map with runway identifiers (keys) 
	 * and the corresponding number of occurrences (values).
	 * 
	 * @param numberOfRecords the number of returned results
	 * @return map with runway identifier/number of occurrences entries
	 */
	Map<String, Integer> getMostCommonRunwayIdents(Integer numberOfRecords);
	
}
