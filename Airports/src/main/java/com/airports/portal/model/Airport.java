package com.airports.portal.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.airports.portal.model.core.BaseDocument;

@Document(collection = "airports")
public class Airport extends BaseDocument {
	
	private String id;
	private String ident;
	private String type;
	private String name;
	private Double latitudeDegree;
	private Double longitudeDegree;
	private Integer elevationFt;
	private String continent;
	private String isoCountry;
	private String isoRegion;
	private String municipality;
	private String scheduledService;
	private String gpsCode;
	private String iataCode;
	private String localCode;
	private String homeLink;
	private String wikipediaLink;
	private String keywords;
	
	@Field("id")
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Field("ident")
	public String getIdent() {
		return ident;
	}
	
	public void setIdent(String ident) {
		this.ident = ident;
	}
	
	@Field("type")
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	@Field("name")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Field("latitude_deg")
	public Double getLatitudeDegree() {
		return latitudeDegree;
	}
	
	public void setLatitudeDegree(Double latitudeDegree) {
		this.latitudeDegree = latitudeDegree;
	}
	
	@Field("longitude_deg")
	public Double getLongitudeDegree() {
		return longitudeDegree;
	}
	
	public void setLongitudeDegree(Double longitudeDegree) {
		this.longitudeDegree = longitudeDegree;
	}
	
	@Field("elevation_ft")
	public Integer getElevationFt() {
		return elevationFt;
	}
	
	public void setElevationFt(Integer elevationFt) {
		this.elevationFt = elevationFt;
	}
	
	@Field("continent")
	public String getContinent() {
		return continent;
	}
	
	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	@Field("iso_country")
	public String getIsoCountry() {
		return isoCountry;
	}
	
	public void setIsoCountry(String isoCountry) {
		this.isoCountry = isoCountry;
	}
	
	@Field("iso_region")
	public String getIsoRegion() {
		return isoRegion;
	}
	
	public void setIsoRegion(String isoRegion) {
		this.isoRegion = isoRegion;
	}
	
	@Field("municipality")
	public String getMunicipality() {
		return municipality;
	}
	
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	
	@Field("scheduled_service")
	public String getScheduledService() {
		return scheduledService;
	}
	
	public void setScheduledService(String scheduledService) {
		this.scheduledService = scheduledService;
	}
	
	@Field("gps_code")
	public String getGpsCode() {
		return gpsCode;
	}
	
	public void setGpsCode(String gpsCode) {
		this.gpsCode = gpsCode;
	}
	
	@Field("iata_code")
	public String getIataCode() {
		return iataCode;
	}
	
	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}
	
	@Field("local_code")
	public String getLocalCode() {
		return localCode;
	}
	
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	
	@Field("home_link")
	public String getHomeLink() {
		return homeLink;
	}
	
	public void setHomeLink(String homeLink) {
		this.homeLink = homeLink;
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
