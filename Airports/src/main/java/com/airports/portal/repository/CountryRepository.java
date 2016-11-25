package com.airports.portal.repository;

import com.airports.portal.model.Country;
import com.airports.portal.repository.core.BaseRepository;

public interface CountryRepository extends BaseRepository<Country, String> {

	Country findByCodeIgnoreCase(String countryCode);
	
	Country findByNameLikeIgnoreCase(String countryName);
}
