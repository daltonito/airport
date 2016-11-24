package com.airports.portal.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.airports.portal.model.core.BaseDocument;

@Document(collection = "countries")
public class Country extends BaseDocument {
	
	private String id;
	private String code;
	private String name;
	private String continent;
	private String wikipediaLink;
	private String keywords;
	
	@Field("id")
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Field("code")
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	@Field("name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Field("continent")
	public String getContinent() {
		return continent;
	}
	
	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	@Field("wikipedia_link")
	public String getWikipediaLink() {
		return wikipediaLink;
	}
	
	public void setWikipediaLink(String wikipediaLink) {
		this.wikipediaLink = wikipediaLink;
	}
	
	@Field("keywords")
	public String getKeywords() {
		return keywords;
	}
	
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
}
