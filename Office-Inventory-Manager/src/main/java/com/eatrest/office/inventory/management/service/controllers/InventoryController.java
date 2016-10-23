/**
 * 
 */
package com.eatrest.office.inventory.management.service.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eatrest.office.inventory.management.service.beans.ERSResponseBean;
import com.eatrest.office.inventory.management.service.beans.FullOfficeCreationInputBean;
import com.eatrest.office.inventory.management.service.services.InventoryService;

/**
 * @author Anurag Jain
 */

@CrossOrigin
@RefreshScope
@RestController
@RequestMapping("/EatRest")
public class InventoryController {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	InventoryService userService;
	
	@RequestMapping(value="/User/authenticate", method=RequestMethod.POST)
	public ERSResponseBean authenticate(@RequestBody FullOfficeCreationInputBean user) {
		ERSResponseBean response = new ERSResponseBean();
		log.info("Controller: Authenticate User: " + user.toString());
		try {
			response = userService.authenticate(user);
		} catch(Exception ex) {
			ex.printStackTrace();
			log.info("Authentication Service - " + ex.getMessage());
			response.setMessage(ex.getMessage());
			response.setStatus("500");
			response.setData("");
		}		
		return response;
	}	
}
