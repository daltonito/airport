package com.airports.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.airports.portal.controller.support.Requests;
import com.airports.portal.view.Views;

@Controller
public class AirportsController {
 
    @RequestMapping(Requests.ROOT)
    public String welcomeRequest() {
        return Views.WELCOME_VIEW.name();
    }
 
    @RequestMapping(value = Requests.QUERY, method = RequestMethod.GET)
    public String handleQueryRequest(Model model) {
        return Views.QUERY_VIEW.name();
    }
 
    @RequestMapping(value = Requests.REPORTS, method = RequestMethod.GET)
    public String handleReportsRequest(Model model) {
        return Views.REPORTS_VIEW.name();
    }
}