package com.airports.portal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airports.portal.model.Runway;

public interface RunwayRepository extends MongoRepository<Runway, String> {
	
}
