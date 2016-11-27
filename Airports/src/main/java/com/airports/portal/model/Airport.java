package com.airports.portal.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.airports.portal.model.core.BaseDocument;

@CompoundIndex(name = "iso_country_ident_idx", def = "{'isoCountry' : 1, 'ident' : 1}" )
@Document(collection = "airports")
public class Airport extends BaseDocument {
	
	private Long id;
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
	
	private List<Runway> runways = new ArrayList<>();
	
	
	@Field("id")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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
		return airportType.valueOf(type).getValue();
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

	@Transient
	public List<Runway> getRunways() {
		return runways;
	}

	public void setRunways(List<Runway> runways) {
		this.runways = runways;
	}
	
	private enum airportType {
		
		small_airport("Small airport"),
		medium_airport("Medium airport"),
		large_airport("Large airport"),
		seaplane_base("Seaplane base"),
		balloonport("Balloonport"),
		heliport("Heliport"),
		closed("Closed");
		
		private String value;
		
		public String getValue() {
			return value;
		}
		
		private airportType(String value) {
			this.value = value;
		}
		
	}
}
