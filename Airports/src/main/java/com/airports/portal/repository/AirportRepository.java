package com.airports.portal.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.airports.portal.model.Airport;
import com.airports.portal.repository.core.BaseRepository;
import com.airports.portal.repository.custom.AirportRepositoryCustom;

public interface AirportRepository extends BaseRepository<Airport, String>, AirportRepositoryCustom {

	List<Airport> findByIsoCountry(String countryName);
	
	Page<Airport> findByIsoCountry(String countryName, Pageable pageable);
}
