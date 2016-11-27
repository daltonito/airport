package com.airports.portal.model;

import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.airports.portal.model.core.BaseDocument;

@Document(collection = "runways")
public class Runway extends BaseDocument {

	private Long id;
	private String airportRef;
	@TextIndexed private String airportIdent;
	private String lengthFt;
	private String widthFt;
	private String surface;
	private String lighted;
	private String closed;
	private String leIdent;
	private String leLatitudeDeg;
	private String leLongitudeDeg;
	private String leElevationFt;
	private String leHeadingDegT;
	private String leDisplacedThresholdFt;
	private String heIdent;
	private String heLatitudeDeg;
	private String heLongitudeDeg;
	private String heElevationFt;
	private String heHeadingDegT;
	private String heDisplacedThresholdFt;
	
	@Field("id")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Field("airport_ref")
	public String getAirportRef() {
		return airportRef;
	}
	
	public void setAirportRef(String airportRef) {
		this.airportRef = airportRef;
	}
	
	@Field("airport_ident")
	public String getAirportIdent() {
		return airportIdent;
	}
	
	public void setAirportIdent(String airportIdent) {
		this.airportIdent = airportIdent;
	}
	
	@Field("length_ft")
	public String getLengthFt() {
		return lengthFt;
	}
	
	public void setLengthFt(String lengthFt) {
		this.lengthFt = lengthFt;
	}
	
	@Field("width_ft")
	public String getWidthFt() {
		return widthFt;
	}
	
	public void setWidthFt(String widthFt) {
		this.widthFt = widthFt;
	}
	
	@Field("surface")
	public String getSurface() {
		return surface;
	}
	
	public void setSurface(String surface) {
		this.surface = surface;
	}
	
	@Field("lighted")
	public String getLighted() {
		return lighted;
	}
	
	public void setLighted(String lighted) {
		this.lighted = lighted;
	}
	
	@Field("closed")
	public String getClosed() {
		return closed;
	}
	
	public void setClosed(String closed) {
		this.closed = closed;
	}
	
	@Field("le_ident")
	public String getLeIdent() {
		return leIdent;
	}
	
	public void setLeIdent(String leIdent) {
		this.leIdent = leIdent;
	}
	
	@Field("le_latitude_deg")
	public String getLeLatitudeDeg() {
		return leLatitudeDeg;
	}
	
	public void setLeLatitudeDeg(String leLatitudeDeg) {
		this.leLatitudeDeg = leLatitudeDeg;
	}
	
	@Field("le_longitude_deg")
	public String getLeLongitudeDeg() {
		return leLongitudeDeg;
	}
	
	public void setLeLongitudeDeg(String leLongitudeDeg) {
		this.leLongitudeDeg = leLongitudeDeg;
	}
	
	@Field("le_elevation_ft")
	public String getLeElevationFt() {
		return leElevationFt;
	}
	
	public void setLeElevationFt(String leElevationFt) {
		this.leElevationFt = leElevationFt;
	}
	
	@Field("le_heading_degT")
	public String getLeHeadingDegT() {
		return leHeadingDegT;
	}
	
	public void setLeHeadingDegT(String leHeadingDegT) {
		this.leHeadingDegT = leHeadingDegT;
	}
	
	@Field("le_displaced_threshold_ft")
	public String getLeDisplacedThresholdFt() {
		return leDisplacedThresholdFt;
	}
	
	public void setLeDisplacedThresholdFt(String leDisplacedThresholdFt) {
		this.leDisplacedThresholdFt = leDisplacedThresholdFt;
	}
	
	@Field("he_ident")
	public String getHeIdent() {
		return heIdent;
	}
	
	public void setHeIdent(String heIdent) {
		this.heIdent = heIdent;
	}
	
	@Field("he_latitude_deg")
	public String getHeLatitudeDeg() {
		return heLatitudeDeg;
	}
	
	public void setHeLatitudeDeg(String heLatitudeDeg) {
		this.heLatitudeDeg = heLatitudeDeg;
	}
	
	@Field("he_longitude_deg")
	public String getHeLongitudeDeg() {
		return heLongitudeDeg;
	}
	
	public void setHeLongitudeDeg(String heLongitudeDeg) {
		this.heLongitudeDeg = heLongitudeDeg;
	}
	
	@Field("he_elevation_ft")
	public String getHeElevationFt() {
		return heElevationFt;
	}
	
	public void setHeElevationFt(String heElevationFt) {
		this.heElevationFt = heElevationFt;
	}
	
	@Field("he_heading_degT")
	public String getHeHeadingDegT() {
		return heHeadingDegT;
	}
	
	public void setHeHeadingDegT(String heHeadingDegT) {
		this.heHeadingDegT = heHeadingDegT;
	}
	
	@Field("he_displaced_threshold_ft")
	public String getHeDisplacedThresholdFt() {
		return heDisplacedThresholdFt;
	}
	
	public void setHeDisplacedThresholdFt(String heDisplacedThresholdFt) {
		this.heDisplacedThresholdFt = heDisplacedThresholdFt;
	}
}
