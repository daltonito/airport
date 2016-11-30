package com.airports.portal.service;

import java.util.List;
import java.util.Map;

import com.airports.portal.model.Country;
import com.airports.portal.model.support.AirportPaginationHelper;
import com.airports.portal.model.support.CountrySuggestion;
import com.airports.portal.model.support.RunwayTypesPaginationHelper;

/**
 * Main interface used for all operations on Airports, Runways and Countries documents. 
 * Hides the repositories and provides accessible services and features for the controller, 
 * acting as a middle layer between the database and controller.
 */
public interface AirportService {
	
	/**
	 * Retrieves complete Airport and Runway documents for a given country value.
	 * The country value could be country code or (partial/fuzzy)country name.
	 * 
	 * @param countryInput input value for country
	 * @param pageNumber the number of the returned page (used for pagination)
	 * @return AirportPaginationHelper object containing the pagination values 
	 * 		   and the actual result data
	 */
	AirportPaginationHelper getAirportsAndRunwaysByCountry(String countryInput, Integer pageNumber);
	
	/**
	 * Retrieves a result map with Country documents (keys) 
	 * and the corresponding number of airports (values).
	 * 
	 * @param numberOfRecords the number of returned results
	 * @param descendingOrder true for descending, false for ascending order
	 * @return map with Country entity/number of airports entries
	 */
	Map<Country, Integer> getAirportsCountByCountry(Integer numberOfRecords, boolean descendingOrder);
	
	/**
	 * Retrieves all Country entities along with their corresponding distinct types of runways.
	 * 
	 * @param pageNumber the number of the returned page (used for pagination)
	 * @return RunwayTypesPaginationHelper object containing the pagination values 
	 * 		   and the actual result data
	 */
	RunwayTypesPaginationHelper getRunwayTypesByCountry(Integer pageNumber);

	/**
	 * Retrieves all distinct types of runways for a given country.
	 * 
	 * @param countryCode the country code
	 * @return list of distinct types of runways
	 */
	List<String> getRunwayTypesByCountry(String countryCode);
	
	/**
	 * Retrieves a result map with runway identifiers (keys) 
	 * and the corresponding number of occurrences (values).
	 * 
	 * @param numberOfRecords the number of returned results
	 * @return map with runway identifier/number of occurrences entries
	 */
	Map<String, Integer> getMostCommonRunwayIdents(Integer numberOfRecords);
	
	/**
	 * Retrieves a list of country suggestions depending on the country text input.
	 * 
	 * @param countryInput the country text input
	 * @return list of country suggestions that match the criteria
	 */
	List<CountrySuggestion> getCountrySuggestions(String countryInput);
	
}
