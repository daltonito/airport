package com.airports.portal.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airports.portal.model.Country;

public interface CountryRepository extends MongoRepository<Country, String> {

}
