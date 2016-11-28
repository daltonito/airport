package com.airports.portal.model.support;

import org.springframework.data.domain.Page;

import com.airports.portal.model.Airport;
import com.airports.portal.model.Country;


/**
 * Simple helper class used for transferring the actual data and pagination 
 * from the service layer to the controller. 
 */
public class AirportPaginationHelper {
	
	Country country;
	Page<Airport> airportsPage;
	
	public AirportPaginationHelper(Country country, Page<Airport> airportsPage) {
		this.country = country;
		this.airportsPage = airportsPage;
		country.setAirports(airportsPage.getContent());
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Page<Airport> getAirportsPage() {
		return airportsPage;
	}
	
	public void setAirportsPage(Page<Airport> airportsPage) {
		this.airportsPage = airportsPage;
	}

}
