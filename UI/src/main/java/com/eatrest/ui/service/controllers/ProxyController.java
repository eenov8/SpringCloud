/**
 * 
 */
package com.eatrest.ui.service.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eatrest.ui.service.beans.GatewayInputDTO;
import com.eatrest.ui.service.beans.IOTMCResponseInfo;
import com.eatrest.ui.service.services.ProxyService;

/**
 * @author Harman
 *
 */
@RefreshScope
@RestController
@RequestMapping("/Gateway")
public class ProxyController {
	
	@Autowired
	private ProxyService gatewayService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@RequestMapping(value="/route", method=RequestMethod.POST)
	public IOTMCResponseInfo route(@RequestBody GatewayInputDTO input) {
		return gatewayService.forwardRequest(input);
	}
}