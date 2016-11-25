package com.airports.portal.repository;

import java.util.List;

import com.airports.portal.model.Country;
import com.airports.portal.model.Runway;
import com.airports.portal.repository.core.BaseRepository;
import com.airports.portal.repository.custom.RunwayRepositoryCustom;

public interface RunwayRepository extends BaseRepository<Runway, String>, RunwayRepositoryCustom {
	
	List<Runway> findByAirportIdent(String airportRef);
	
}
