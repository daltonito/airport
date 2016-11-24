package com.airports.portal.repository.custom;

import java.util.List;

public interface RunwayRepositoryCustom {

	public List<String> getDistinctRunwayTypes(List<String> airportIdents);
	
	public List<String> getMostCommonRunwayIdents(Integer numberOfRecords);
	
}
