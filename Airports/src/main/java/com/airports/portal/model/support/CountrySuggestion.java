package com.airports.portal.model.support;

import com.airports.portal.model.Country;

public class CountrySuggestion {
	
	private String code;
	private String name;
	
	public CountrySuggestion(Country country) {
		this.code = country.getCode();
		this.name = country.getName();
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
