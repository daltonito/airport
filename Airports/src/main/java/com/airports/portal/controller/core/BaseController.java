package com.airports.portal.controller.core;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

import com.airports.portal.model.core.BaseDocument;

/**
 * Controller class that should be extended by all controllers.<br/>
 * Provides additional features like redirect/forward requests,  
 * calculates pagination indexes etc.
 */
public abstract class BaseController {
	
	private static final Logger LOGGER = Logger.getLogger(BaseController.class);

	/**
	 * Used for controller redirect request. 
	 * Redirect request returns the control on the client, 
	 * then immediately initiates a new request to the server.
	 * This action will remove all parameters from the initial request.
	 * 
	 * @param request
	 * 		the controller to which the request should be redirected
	 * @return redirect request string
	 */
	protected String redirect(String request) {
		LOGGER.debug("Redirection to " + request);
		return "redirect:" + (request.startsWith("/") ? "" : "/") + request;
	}
	
	/**
	 * Used for controller forward request. 
	 * Forward request does not return the control to the client, 
	 * it processes the request internally on the server.
	 * This action will keep all parameters from the initial request.
	 * 
	 * @param request
	 * 		the controller to which the request should be forwarded
	 * @return forward request string
	 */
	protected String forward(String request) {
		LOGGER.debug("Forwarding to " + request);
		return "forward:" + (request.startsWith("/") ? "" : "/") + request;
	}
	
	/**
	 * Method used for calculating the required indexes 
	 * and total pages used by the pagination bar.
	 * All required pagination parameters will be added to the model
	 * 
	 * @param page a Page entity that contains the paginating data
	 * @param model used for adding the calculated values to the model
	 */
	protected <T extends BaseDocument> void setPaginationParameters(Page<T> page, Model model) {
    	int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());
        
        LOGGER.debug("Setting pagination parameters (begin, current, end) indexes:" + begin + ", " + current + ", ");
        LOGGER.debug("Setting pagination parameters (total pages):" + page.getTotalPages());
        
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPages", page.getTotalPages());
	}
}
