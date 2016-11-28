package com.airports.portal.repository;

import java.util.List;

import com.airports.portal.model.Runway;
import com.airports.portal.repository.core.BaseRepository;
import com.airports.portal.repository.custom.RunwayRepositoryCustom;

/**
 * Used for database operations on the Runway collection.
 * Derives all functionalities and features from the BaseRepository 
 * and implements custom query methods from the AirportRepositoryCustom interface.
 */
public interface RunwayRepository extends BaseRepository<Runway, String>, RunwayRepositoryCustom {
	
	/**
	 * Retrieves all runways for a given airport identification code. 
	 * 
	 * @param airportIdent airport identification value
	 * @return all matching Runway documents
	 */
	List<Runway> findByAirportIdent(String airportIdent);
	
}
