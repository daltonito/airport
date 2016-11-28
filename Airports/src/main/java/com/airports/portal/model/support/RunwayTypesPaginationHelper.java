package com.airports.portal.model.support;

import java.util.Map;

import org.springframework.data.domain.Page;

import com.airports.portal.model.Country;

/**
 * Simple helper class used for transferring the actual data and pagination 
 * from the service layer to the controller. 
 */
public class RunwayTypesPaginationHelper {

	Map<Country, String> countryResults;
	Page<Country> countryPage;
	
	public RunwayTypesPaginationHelper(Map<Country, String> countryResults, Page<Country> countryPage) {
		this.countryResults = countryResults;
		this.countryPage = countryPage;
	}
	
	public Map<Country, String> getCountryResults() {
		return countryResults;
	}
	
	public void setCountryResults(Map<Country, String> countryResults) {
		this.countryResults = countryResults;
	}
	
	public Page<Country> getCountryPage() {
		return countryPage;
	}
	
	public void setCountryPage(Page<Country> countryPage) {
		this.countryPage = countryPage;
	}
}
