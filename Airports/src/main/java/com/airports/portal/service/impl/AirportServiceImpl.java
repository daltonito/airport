package com.airports.portal.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
			country = countryRepository.findByCodeIgnoreCase(countryInput);
		} else if (countryInput.length() > 2) {
			country = countryRepository.findByNameLikeIgnoreCase(countryInput);
		}
		
		if (country == null)
			return null;
		
		LOGGER.debug("Country found: " + country.getName());

		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.ASC, "name");
		Page<Airport> airportsPage = airportRepository.findByIsoCountry(country.getCode(), request);
    	
    	for (Airport airport : airportsPage) {
    		
    		LOGGER.debug("Airport found: " + airport.getName() + " - " + airport.getIdent());
    		List<Runway> airportRunways = runwayRepository.findByAirportIdent(airport.getIdent());
    		airport.setRunways(airportRunways);
    	}
    	
    	return new AirportPaginationHelper(country, airportsPage);
    }
	
	/* (non-Javadoc)
	 * @see com.airports.portal.service.AirportService#getAirportsCountByCountry(java.lang.Integer, boolean)
	 */
	@Override
	public Map<Country, Integer> getAirportsCountByCountry(Integer numberOfRecords, boolean descendingOrder) {
		
		Map<Country, Integer> results = new LinkedHashMap<Country, Integer>();
		Map<String, Integer> queryResults = airportRepository.getAirportsCountByCountry(numberOfRecords, descendingOrder);
		
		for (String countryCode : queryResults.keySet()) {
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
			results.put(country, StringUtils.join(getRunwayTypesByCountry(country.getCode()), ", "));
		}
		
		return new RunwayTypesPaginationHelper(results, countryPage);
	}

	/* (non-Javadoc)
	 * @see com.airports.portal.service.AirportService#getRunwayTypesByCountry(java.lang.String)
	 */
	@Override
	public List<String> getRunwayTypesByCountry(String countryCode) {
		
		List<String> airportIdents = airportRepository.getAirportIdentsByCountry(countryCode);
		List<String> distinctSurfaces = runwayRepository.getDistinctRunwayTypes(airportIdents);
		return distinctSurfaces;
	}

	/* (non-Javadoc)
	 * @see com.airports.portal.service.AirportService#getMostCommonRunwayIdents(java.lang.Integer)
	 */
	@Override
	public Map<String, Integer> getMostCommonRunwayIdents(Integer numberOfRecords) {
		return runwayRepository.getMostCommonRunwayIdents(numberOfRecords);
	}

}
