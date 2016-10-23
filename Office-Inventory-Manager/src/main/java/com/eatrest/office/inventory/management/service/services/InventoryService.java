/**
 * 
 */
package com.eatrest.office.inventory.management.service.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eatrest.office.inventory.management.service.beans.ERSResponseBean;
import com.eatrest.office.inventory.management.service.beans.FullOfficeCreationInputBean;
import com.eatrest.office.inventory.management.service.dao.beans.FullOffice;
import com.eatrest.office.inventory.management.service.dao.repositories.FullOfficeRepository;
import com.mongodb.MongoException;

/**
 * @author Anurag Jain
 *
 */

@Service
public class InventoryService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FullOfficeRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public InventoryService() {
		super();
	}

	public ERSResponseBean authenticate(FullOfficeCreationInputBean user) {
		log.info("Authentication Service Called.");
		ERSResponseBean response = new ERSResponseBean();
		try {
			List<FullOffice> users = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
			log.info("Users authentication list size - " + users.size());
			if(users.size() > 0) {
				response.setStatus("200");
				response.setMessage("Success");
				response.setData("");
			} else {
				response.setStatus("204");
				response.setMessage("Authentication Failed.");
				response.setData("");
			}
		} catch (MongoException ex) {
			response.setStatus("503");
			response.setMessage("Database Service Not Available.");
			response.setData("");
			log.error("Failed authentication due to - " + ex.getMessage());
		} catch (NullPointerException ex) {
			response.setStatus("400");
			response.setMessage("Bad Request, fields can not be null.");
			response.setData("");
			log.error("Failed authentication due to - " + ex.getMessage());
		} catch (Exception ex) {
			response.setStatus("500");
			response.setMessage("Failed deleting Enterprise.");
			response.setData("");
			log.error("Failed authentication due to - " + ex.getMessage());
		}
		return response;
	}
}
