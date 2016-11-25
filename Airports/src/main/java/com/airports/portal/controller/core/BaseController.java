package com.airports.portal.controller.core;

import org.apache.log4j.Logger;

public abstract class BaseController {
	
	private static final Logger LOGGER = Logger.getLogger(BaseController.class);

	protected String redirect(String request) {
		LOGGER.debug("Redirection to " + request);
		return "redirect:" + (request.startsWith("/") ? "" : "/") + request;
	}
	
	protected String forward(String request) {
		LOGGER.debug("Forwarding to " + request);
		return "forward:" + (request.startsWith("/") ? "" : "/") + request;
	}
}
