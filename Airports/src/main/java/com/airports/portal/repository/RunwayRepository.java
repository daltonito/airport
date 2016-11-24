package com.airports.portal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airports.portal.model.Runway;
import com.airports.portal.repository.custom.RunwayRepositoryCustom;

public interface RunwayRepository extends MongoRepository<Runway, String>, RunwayRepositoryCustom {
	
	List<Runway> findByAirportIdent(String airportRef);
	
}
