package com.airports.portal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airports.portal.model.Airport;
import com.airports.portal.repository.custom.AirportRepositoryCustom;

public interface AirportRepository extends MongoRepository<Airport, String>, AirportRepositoryCustom {

	List<Airport> findByIsoCountry(String countryName);
}
