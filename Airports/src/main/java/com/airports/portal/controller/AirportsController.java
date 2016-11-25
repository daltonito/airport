package com.airports.portal.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airports.portal.controller.core.BaseController;
import com.airports.portal.controller.support.Requests;
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
    	
    	airportService.getAirportsAndRunwaysByCountry("US");
    	
//    	Map<String, Integer> descMapa = airportService.getAirportsCountByCountry(10, true);
    	
//    	Map<Integer, String> ascMapa = airportService.getAirportsCountByCountry(10, false);

//    	List<String> runwayTypes = airportService.getRunwayTypesByCountry("US");
    	
//
    	
        return Views.QUERY_VIEW.name();
    }
 
    @RequestMapping(value = Requests.REPORTS, method = RequestMethod.GET)
    public String handleReportsRequest(Model model) {
        return Views.REPORTS_VIEW.name();
    }
    
}
