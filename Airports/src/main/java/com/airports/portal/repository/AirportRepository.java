package com.airports.portal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airports.portal.model.Airport;

public interface AirportRepository extends MongoRepository<Airport, String> {

}
