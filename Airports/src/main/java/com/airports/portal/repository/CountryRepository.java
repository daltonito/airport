package com.airports.portal.repository;

import com.airports.portal.model.Country;
import com.airports.portal.repository.core.BaseRepository;

/**
 * Used for database operations on the Country collection.
 * Derives all functionalities and features from the BaseRepository.
 */
public interface CountryRepository extends BaseRepository<Country, String> {

	/**
	 * Retrieves all countries for a given country code. 
	 * Ignores the case of the letters from the input.
	 * 
	 * @param countryCode the input value for the country code
	 * @return all matching Country documents
	 */
	Country findByCodeIgnoreCase(String countryCode);
	
	/**
	 * Retrieves all countries for a given country name, 
	 * by ignoring the case of the letters from the input. 
	 * 
	 * @param countryName the input value for the country code
	 * @return all matching Country documents
	 */
	Country findByNameIgnoreCase(String countryName);
	
	/**
	 * Retrieves all countries for a given country name, 
	 * by making a -starts with- operation and ignoring
	 * the case of the letters from the input. 
	 * 
	 * @param countryName the input value for the country code
	 * @return all matching Country documents
	 */
	Country findByNameStartsWithIgnoreCase(String countryName);
	
	/**
	 * Retrieves all countries for a given country name, 
	 * by making a LIKE operation and ignoring
	 * the case of the letters from the input. 
	 * 
	 * @param countryName the input value for the country code
	 * @return all matching Country documents
	 */
	Country findByNameLikeIgnoreCase(String countryName);
}
