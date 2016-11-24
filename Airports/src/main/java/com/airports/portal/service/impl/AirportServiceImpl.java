package com.airports.portal.service.impl;

import java.util.List;
import java.util.Map;

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
	
	@Autowired
	AirportRepository airportRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	RunwayRepository runwayRepository;
	
	@Override
	public void getAirportsAndRunwaysByCountry(String countryInput) {
    	
    	Country country = countryRepository.findByCodeOrNameLikeAllIgnoreCase(countryInput, countryInput);
    	System.out.println("Entered country name: " + country.getName());
    	
    	List<Airport> airports = airportRepository.findByIsoCountry(country.getCode());
    	
    	for (Airport airport : airports) {
    		System.out.println("Airport: " + airport.getName() + " - " + airport.getIdent());
    		
    		List<Runway> airportRunways = runwayRepository.findByAirportIdent(airport.getIdent());
    		
    		for (Runway runway : airportRunways) {
    			System.out.println("Runway: " + runway.getAirportIdent() + " - " + runway.getSurface());
    		}
    	}
    }
	
	@Override
	public Map<Integer, String> getAirportsCountByCountry(Integer numberOfRecords, boolean descendingOrder) {
		return airportRepository.getAirportsCountByCountry(numberOfRecords, descendingOrder);
	}

	@Override
	public List<String> getRunwayTypesByCountry(String countryCode) {
		
		List<String> airportIdents = airportRepository.getAirportIdentsByCountry(countryCode);
		List<String> distinctSurfaces = runwayRepository.getDistinctRunwayTypes(airportIdents);
		return distinctSurfaces;
	}

	@Override
	public List<String> getMostCommonRunwayIdents(Integer numberOfRecords) {
		return runwayRepository.getMostCommonRunwayIdents(numberOfRecords);
	}

}
