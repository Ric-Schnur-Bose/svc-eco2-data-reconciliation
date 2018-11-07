package com.bose.reconcile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HealthCheckController {

	@RequestMapping(value="health_check", method=RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public void checkHealth(HttpServletRequest request, HttpServletResponse response) {
		
	}	
}
