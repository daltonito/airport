package com.airports.portal.repository.custom;

import java.util.List;
import java.util.Map;

public interface RunwayRepositoryCustom {

	public List<String> getDistinctRunwayTypes(List<String> airportIdents);
	
	Map<String, Integer> getMostCommonRunwayIdents(Integer numberOfRecords);
	
}
