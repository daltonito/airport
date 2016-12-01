package com.airports.portal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.airports.portal.model.Airport;
import com.airports.portal.model.Country;
import com.airports.portal.model.Runway;
import com.airports.portal.model.support.AirportPaginationHelper;
import com.airports.portal.model.support.CountrySuggestion;
import com.airports.portal.model.support.RunwayTypesPaginationHelper;
import com.airports.portal.repository.AirportRepository;
import com.airports.portal.repository.CountryRepository;
import com.airports.portal.repository.RunwayRepository;
import com.airports.portal.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService {
	
	private static final Logger LOGGER = Logger.getLogger(AirportServiceImpl.class);
	
	@Autowired
	AirportRepository airportRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	RunwayRepository runwayRepository;
	
	/**
	 * Defines the number of records shown per page
	 */
	private static Integer PAGE_SIZE;
	
	@Value("${pagination.page.size:30}")
	public void setPageSize(Integer pageSize) {
		PAGE_SIZE = pageSize;
	} 
	
	/* (non-Javadoc)
	 * @see com.airports.portal.service.AirportService#getAirportsAndRunwaysByCountry(java.lang.String, java.lang.Integer)
	 */
	@Override
	public AirportPaginationHelper getAirportsAndRunwaysByCountry(String countryInput, Integer pageNumber) {
		
		Country country = null;
		
		if (countryInput.length() == 2) {
			// search by country code
			country = countryRepository.findByCodeIgnoreCase(countryInput);
		}
		
		if (countryInput.length() >= 2) {
			
			// country value selected via auto complete, extract the country code
			Matcher m = Pattern.compile("\\((.*?)\\)").matcher(countryInput);
			
			while(m.find()) {
				if (m.group(1).length() == 2) {
					country = countryRepository.findByCodeIgnoreCase(m.group(1));
				}
			}
			
			// search for the exact country name
			if (country == null) {
				country = countryRepository.findByNameIgnoreCase(countryInput);
			}
			
			// search for the country name that begins with the input string
			if (country == null) {
				List<Country> countryResults = countryRepository.findByNameStartsWithIgnoreCase(countryInput);
				country = countryResults != null && !countryResults.isEmpty() ? countryResults.get(0) : null;
			}
			
			// search for the country name that contains the input string
			if (country == null) {
				country = countryRepository.findByNameLikeIgnoreCase(countryInput);
			}
		}
		
		if (country == null)
			return null;
		
		LOGGER.debug("Country found: " + country.getName());

		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "name");
		Page<Airport> airportsPage = airportRepository.findByIsoCountry(country.getCode(), request);
		
		Integer totalAirports = airportRepository.countByIsoCountry(country.getCode());
    	
    	for (Airport airport : airportsPage) {
    		
    		LOGGER.debug("Airport found: " + airport.getName() + " - " + airport.getIdent());
    		List<Runway> airportRunways = runwayRepository.findByAirportIdent(airport.getIdent());
    		airport.setRunways(airportRunways);
    	}
    	
    	return new AirportPaginationHelper(country, totalAirports, airportsPage);
    }
	
	/* (non-Javadoc)
	 * @see com.airports.portal.service.AirportService#getAirportsCountByCountry(java.lang.Integer, boolean)
	 */
	@Override
	public Map<Country, Integer> getAirportsCountByCountry(Integer numberOfRecords, boolean descendingOrder) {
		
		Map<Country, Integer> results = new LinkedHashMap<Country, Integer>();
		Map<String, Integer> queryResults = airportRepository.getAirportsCountByCountry(numberOfRecords, descendingOrder);
		
		for (String countryCode : queryResults.keySet()) {
			LOGGER.debug("Country code: " + countryCode + " / " + queryResults.get(countryCode));
			results.put(countryRepository.findByCodeIgnoreCase(countryCode), queryResults.get(countryCode));
		}
		
		return results;
	}
	
	/* (non-Javadoc)
	 * @see com.airports.portal.service.AirportService#getRunwayTypesByCountry(java.lang.Integer)
	 */
	@Override
	public RunwayTypesPaginationHelper getRunwayTypesByCountry(Integer pageNumber) {
		
		Map<Country, String> results = new LinkedHashMap<Country, String>();
		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "name");
		Page<Country> countryPage = countryRepository.findAll(request);
		
		for (Country country : countryPage.getContent()) {
			
			List<String> runwayTypes = getRunwayTypesByCountry(country.getCode());
			results.put(country, StringUtils.join(runwayTypes, ", "));
			
			LOGGER.debug("Country code: " + country.getCode() + " / " + runwayTypes.toString());
		}
		
		return new RunwayTypesPaginationHelper(results, countryPage);
	}

	/* (non-Javadoc)
	 * @see com.airports.portal.service.AirportService#getRunwayTypesByCountry(java.lang.String)
	 */
	@Override
	public List<String> getRunwayTypesByCountry(String countryCode) {
		
		List<String> airportIdents = airportRepository.getAirportIdentsByCountry(countryCode);
		LOGGER.debug("Returned airport identifications: " + airportIdents.toString());
		
		List<String> distinctSurfaces = runwayRepository.getDistinctRunwayTypes(airportIdents);
		LOGGER.debug("Returned distinct surfaces: " + distinctSurfaces.toString());
		
		return distinctSurfaces;
	}

	/* (non-Javadoc)
	 * @see com.airports.portal.service.AirportService#getMostCommonRunwayIdents(java.lang.Integer)
	 */
	@Override
	public Map<String, Integer> getMostCommonRunwayIdents(Integer numberOfRecords) {
		return runwayRepository.getMostCommonRunwayIdents(numberOfRecords);
	}

	/* (non-Javadoc)
	 * @see com.airports.portal.service.AirportService#getCountrySuggestions(java.lang.String)
	 */
	@Override
	public List<CountrySuggestion> getCountrySuggestions(String countryInput) {
		
		Map<String, CountrySuggestion> filterMap = new HashMap<String, CountrySuggestion>();
    	List<CountrySuggestion> list = new ArrayList<CountrySuggestion>();

    	if (countryInput != null && countryInput.trim().length() >= 2) {
    		
    		if (countryInput.length() == 2) {
    			
    			Country country = countryRepository.findByCodeIgnoreCase(countryInput);
    			
    			if (country != null) {
		    		CountrySuggestion countrySuggestion = new CountrySuggestion(country);
		    		filterMap.put(countrySuggestion.getCode(), countrySuggestion);
		    		list.add(countrySuggestion);
    			}
    		}
    		
			List<Country> countries = countryRepository.findByNameStartsWithIgnoreCase(countryInput);
			
			if (countries != null && !countries.isEmpty()) {
				
				for (Country country : countries) {
					
					if (filterMap.get(country.getCode()) == null) {
						list.add(new CountrySuggestion(country));
					}
				}
			}
    	}
    	
		return list;
	}

}
