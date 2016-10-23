/**
 * 
 */
package com.eatrest.user.management.service.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eatrest.user.management.service.beans.ERSResponseBean;
import com.eatrest.user.management.service.beans.UserLoginInputBean;
import com.eatrest.user.management.service.dao.beans.User;
import com.eatrest.user.management.service.dao.repositories.UserRepository;
import com.mongodb.MongoException;

/**
 * @author Anurag Jain
 *
 */

@Service
public class UserService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public UserService() {
		super();
	}

	public ERSResponseBean authenticate(UserLoginInputBean user) {
		log.info("Authentication Service Called.");
		ERSResponseBean response = new ERSResponseBean();
		try {
			List<User> users = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
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
