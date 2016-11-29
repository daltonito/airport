package com.airports.portal.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.airports.portal.controller.core.BaseController;
import com.airports.portal.controller.support.Requests;
import com.airports.portal.model.support.AirportPaginationHelper;
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
    	model.addAttribute("search_action", true);
    	return Views.QUERY_VIEW.name();
    }
    
    @RequestMapping(value = Requests.QUERY, method = RequestMethod.POST, params = "query_submit")
    public String searchQueryRequest(@RequestParam("query_input") String queryInput, Model model) {
    	
    	if (queryInput != null && queryInput.trim().length() > 1) {
    		LOGGER.debug("Entered input is " + queryInput);
    		searchedQueryPage(queryInput, null, model);
    	} else {
        	LOGGER.debug("Invalid user input, returning action to the query search screen");
        	model.addAttribute("search_action", true);
        	model.addAttribute("error_action", true);
    	}

        return Views.QUERY_VIEW.name();
    }
    
    @RequestMapping(value = Requests.QUERY, method = RequestMethod.POST, params = "pageNumber")
    public String getSearchedQueryPage(@RequestParam("query_input") String queryInput, @RequestParam("pageNumber") Integer pageNumber, Model model) {
    	searchedQueryPage(queryInput, pageNumber, model);
        return Views.QUERY_VIEW.name();
    }
    
    private void searchedQueryPage(String queryInput, Integer pageNumber, Model model) {
    	
    	AirportPaginationHelper page = airportService.getAirportsAndRunwaysByCountry(queryInput, pageNumber == null ? 1 : pageNumber);
    	
    	if (page != null) {
	        setPaginationParameters(page.getAirportsPage(), model);
	        model.addAttribute("country", page.getCountry());
	    	model.addAttribute("result_action", true);
    	} else {
    		LOGGER.debug("Airports not found for country input " + queryInput);
        	model.addAttribute("search_action", true);
        	model.addAttribute("error_action", true);
    	}
    }
 
    @RequestMapping(value = Requests.REPORTS_NUMBER_OF_AIRPORTS, method = RequestMethod.GET)
    public String handleReportsNumberOfAirports(Model model) {
    	LOGGER.debug("Reports (Number of airports) is requested");
    	model.addAttribute("topCountries", airportService.getAirportsCountByCountry(10, true));
    	model.addAttribute("bottomCountries", airportService.getAirportsCountByCountry(10, false));
        return Views.REPORTS_NUMBER_OF_AIRPORTS_VIEW.name();
    }
    
    @RequestMapping(value = Requests.REPORTS_TYPES_OF_RUNWAYS, method = RequestMethod.GET)
    public String handleReportsTypesOfRunways(Model model) {
    	LOGGER.debug("Reports (Type of runways) is requested");
    	getRunwayTypesByCountry(null, model);
        return Views.REPORTS_TYPES_OF_RUNWAYS_VIEW.name();
    }
    
    @RequestMapping(value = Requests.REPORTS_TYPES_OF_RUNWAYS, method = RequestMethod.POST, params = "pageNumber")
    public String handleReportsTypesOfRunways(Model model, @RequestParam("pageNumber") Integer pageNumber) {
    	LOGGER.debug("Reports (Type of runways) is requested. Page number " + pageNumber);
    	getRunwayTypesByCountry(pageNumber, model);
        return Views.REPORTS_TYPES_OF_RUNWAYS_VIEW.name();
    }
    
    private void getRunwayTypesByCountry(Integer pageNumber, Model model) {
    	
    	RunwayTypesPaginationHelper page = airportService.getRunwayTypesByCountry(pageNumber == null ? 1 : pageNumber);
    	setPaginationParameters(page.getCountryPage(), model);
        model.addAttribute("countries", page.getCountryResults());
    }
    
    @RequestMapping(value = Requests.REPORTS_COMMON_RUNWAY_IDENTS, method = RequestMethod.GET)
    public String handleReportsHighestLowestCount(Model model) {
    	LOGGER.debug("Reports (Common runway identifications) is requested");
    	model.addAttribute("runwayIdents", airportService.getMostCommonRunwayIdents(10));
        return Views.REPORTS_COMMON_RUNWAY_IDENTS_VIEW.name();
    }
    
}
