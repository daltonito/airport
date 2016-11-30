package com.airports.portal.model.support;

import org.springframework.data.domain.Page;

import com.airports.portal.model.Airport;
import com.airports.portal.model.Country;


/**
 * Simple helper class used for transferring the actual data and pagination 
 * from the service layer to the controller. 
 */
public class AirportPaginationHelper {
	
	private Country country;
	private Integer totalAirports;
	private Page<Airport> airportsPage;
	
	public AirportPaginationHelper(Country country, Integer totalAirports, Page<Airport> airportsPage) {
		this.country = country;
		this.totalAirports = totalAirports;
		this.airportsPage = airportsPage;
		country.setAirports(airportsPage.getContent());
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Integer getTotalAirports() {
		return totalAirports;
	}

	public void setTotalAirports(Integer totalAirports) {
		this.totalAirports = totalAirports;
	}

	public Page<Airport> getAirportsPage() {
		return airportsPage;
	}
	
	public void setAirportsPage(Page<Airport> airportsPage) {
		this.airportsPage = airportsPage;
	}

}
