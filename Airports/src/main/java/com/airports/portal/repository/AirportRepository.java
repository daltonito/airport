package com.airports.portal.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.airports.portal.model.Airport;
import com.airports.portal.repository.core.BaseRepository;
import com.airports.portal.repository.custom.AirportRepositoryCustom;

/**
 * Used for database operations on the Airports collection.
 * Derives all functionalities and features from the BaseRepository
 * and implements custom query methods from the AirportRepositoryCustom interface.
 */
public interface AirportRepository extends BaseRepository<Airport, String>, AirportRepositoryCustom {

	/**
	 * Retrieves all airports for a given country code value.
	 * 
	 * @param countryName the input value for the country code
	 * @return all matching Airport documents
	 */
	List<Airport> findByIsoCountry(String countryName);
	
	/**
	 * Returns the total number of airports for a given country code value.
	 * 
	 * @param countryName the input value for the country code
	 * @return the number of airports that match the criteria
	 */
	Integer countByIsoCountry(String countryName);
	
	/**
	 * Retrieves all airports for a given country code value.
	 * 
	 * @param countryName the input value for the country code
	 * 
	 * @param pageable 
	 * 		an object that implements the Pageable interface, 
	 * 		contains the actual data required for pagination
	 * 
	 * @return Page object with the pagination and the document data
	 */		
	Page<Airport> findByIsoCountry(String countryName, Pageable pageable);
}
