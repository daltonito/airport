package com.airports.portal.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airports.portal.controller.core.BaseController;
import com.airports.portal.controller.support.Requests;
import com.airports.portal.model.support.AirportPaginationHelper;
import com.airports.portal.model.support.CountrySuggestion;
import com.airports.portal.model.support.RunwayTypesPaginationHelper;
import com.airports.portal.service.AirportService;
import com.airports.portal.view.Views;

@Controller
public class AirportsController extends BaseController {
	
	private static final Logger LOGGER = Logger.getLogger(AirportsController.class);
	
	@Autowired
	AirportService airportService;
	
	@RequestMapping(Requests.ROOT)
	public String welcomeRequest() {
		LOGGER.debug("Welcome view requested");
		return Views.WELCOME_VIEW.name();
	}
 
    @RequestMapping(value = Requests.QUERY, method = RequestMethod.GET)
    public String handleQueryRequest(Model model) {
    	LOGGER.debug("Query search view requested");
    	return Views.QUERY_SEARCH_VIEW.name();
    }
    
    @RequestMapping(value = Requests.QUERY_AUTOCOMPLETE, method = RequestMethod.POST)
	public @ResponseBody List<CountrySuggestion> getCountrySuggestions(@RequestParam("term") String queryInput) {
    	
    	if (queryInput != null && queryInput.trim().length() > 1) {
    		return airportService.getCountrySuggestions(queryInput);
    	}
    	
    	return null;
	}
    
    @RequestMapping(value = Requests.QUERY, method = RequestMethod.POST, params = "query_submit")
    public String submitQueryRequest(@RequestParam("query_input") String queryInput, Model model) {
    	
    	if (queryInput != null && queryInput.trim().length() > 1) {
    		LOGGER.debug("Entered input is " + queryInput);
    		return populateQueryPage(queryInput, null, model);
    		
    	} else {
        	LOGGER.debug("Invalid user input, returning action to the query search screen");
        	model.addAttribute("error_action", true);
        	return Views.QUERY_SEARCH_VIEW.name();
    	}
    }
    
    @RequestMapping(value = Requests.QUERY, method = RequestMethod.POST, params = "pageNumber")
    public String displayQueryPage(@RequestParam("query_input") String queryInput, @RequestParam("pageNumber") Integer pageNumber, Model model) {
    	return populateQueryPage(queryInput, pageNumber, model);
    }
    
    private String populateQueryPage(String queryInput, Integer pageNumber, Model model) {
    	
    	AirportPaginationHelper page = airportService.getAirportsAndRunwaysByCountry(queryInput, pageNumber == null ? 1 : pageNumber);
    	
    	if (page != null) {
	        setPaginationParameters(page.getAirportsPage(), model);
	        model.addAttribute("totalAirports", page.getTotalAirports());
	        model.addAttribute("country", page.getCountry());
	    	return Views.QUERY_RESULTS_VIEW.name();
	    	
    	} else {
    		LOGGER.debug("Airports not found for country input " + queryInput);
        	model.addAttribute("error_action", true);
        	return Views.QUERY_SEARCH_VIEW.name();
    	}
    }
 
    @RequestMapping(value = Requests.REPORTS_NUMBER_OF_AIRPORTS, method = RequestMethod.GET)
    public String displayReportsNumberOfAirports(Model model) {
    	LOGGER.debug("Reports (Number of airports) is requested");
    	model.addAttribute("topCountries", airportService.getAirportsCountByCountry(10, true));
    	model.addAttribute("bottomCountries", airportService.getAirportsCountByCountry(10, false));
        return Views.REPORTS_NUMBER_OF_AIRPORTS_VIEW.name();
    }
    
    @RequestMapping(value = Requests.REPORTS_TYPES_OF_RUNWAYS, method = RequestMethod.GET)
    public String displayReportsTypesOfRunways(Model model) {
    	LOGGER.debug("Reports (Type of runways) is requested");
    	populateRunwayTypesByCountry(null, model);
        return Views.REPORTS_TYPES_OF_RUNWAYS_VIEW.name();
    }
    
    @RequestMapping(value = Requests.REPORTS_TYPES_OF_RUNWAYS, method = RequestMethod.POST, params = "pageNumber")
    public String displayReportsTypesOfRunways(Model model, @RequestParam("pageNumber") Integer pageNumber) {
    	LOGGER.debug("Reports (Type of runways) is requested. Page number " + pageNumber);
    	populateRunwayTypesByCountry(pageNumber, model);
        return Views.REPORTS_TYPES_OF_RUNWAYS_VIEW.name();
    }
    
    private void populateRunwayTypesByCountry(Integer pageNumber, Model model) {
    	
    	RunwayTypesPaginationHelper page = airportService.getRunwayTypesByCountry(pageNumber == null ? 1 : pageNumber);
    	setPaginationParameters(page.getCountryPage(), model);
        model.addAttribute("countries", page.getCountryResults());
    }
    
    @RequestMapping(value = Requests.REPORTS_COMMON_RUNWAY_IDENTS, method = RequestMethod.GET)
    public String displayReportsHighestLowestCount(Model model) {
    	LOGGER.debug("Reports (Common runway identifications) is requested");
    	model.addAttribute("runwayIdents", airportService.getMostCommonRunwayIdents(10));
        return Views.REPORTS_COMMON_RUNWAY_IDENTS_VIEW.name();
    }
    
}
