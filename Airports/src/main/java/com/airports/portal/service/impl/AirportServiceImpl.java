package com.airports.portal.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airports.portal.model.Airport;
import com.airports.portal.model.Country;
import com.airports.portal.model.Runway;
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
	
	@Override
	public Country getAirportsAndRunwaysByCountry(String countryInput) {
		
		Country country = null;
		
		if (countryInput.length() == 2) {
			country = countryRepository.findByCodeIgnoreCase(countryInput);
		} else if (countryInput.length() > 2) {
			country = countryRepository.findByNameLikeIgnoreCase(countryInput);
		}
		
		if (country == null)
			return null;
    	
		LOGGER.debug("Country found: " + country.getName());
    	List<Airport> airports = airportRepository.findByIsoCountry(country.getCode());
    	
    	for (Airport airport : airports) {
    		
    		LOGGER.debug("Airport found: " + airport.getName() + " - " + airport.getIdent());
    		List<Runway> airportRunways = runwayRepository.findByAirportIdent(airport.getIdent());
    		airport.setRunways(airportRunways);
    	}
    	
    	country.setAirports(airports);
    	
    	return country;
    }
	
	@Override
	public Map<String, Integer> getAirportsCountByCountry(Integer numberOfRecords, boolean descendingOrder) {
		return airportRepository.getAirportsCountByCountry(numberOfRecords, descendingOrder);
	}

	@Override
	public List<String> getRunwayTypesByCountry(String countryCode) {
		
		List<String> airportIdents = airportRepository.getAirportIdentsByCountry(countryCode);
		List<String> distinctSurfaces = runwayRepository.getDistinctRunwayTypes(airportIdents);
		return distinctSurfaces;
	}

	@Override
	public Map<String, Integer> getMostCommonRunwayIdents(Integer numberOfRecords) {
		return runwayRepository.getMostCommonRunwayIdents(numberOfRecords);
	}

}
