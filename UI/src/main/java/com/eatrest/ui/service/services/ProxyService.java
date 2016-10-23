/**
 * 
 */
package com.eatrest.ui.service.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eatrest.ui.service.beans.GatewayInputDTO;
import com.eatrest.ui.service.beans.IOTMCResponseInfo;
import com.eatrest.ui.service.beans.LoginInputDTO;
import com.eatrest.ui.service.enums.GatewayRoutesEnum;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Harman
 *
 */

@Service
public class ProxyService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate restTemplate;
	
	Gson gson;
	
	/**
	 * 
	 */
	public ProxyService() {
		super();
		// TODO Auto-generated constructor stub
		gson = new GsonBuilder().create();
	}



	public IOTMCResponseInfo forwardRequest(GatewayInputDTO input) {
		log.info("Create EASM user thread initiated");
		String url = null;
		
		if(input.getUrl().equals("LOGIN_URL"))
			url = GatewayRoutesEnum.LOGIN_URL.getValue();
		
		if(input.getReqType().equals("POST")) {
			LoginInputDTO loginDto = gson.fromJson(input.getData(),LoginInputDTO.class);
			IOTMCResponseInfo response = restTemplate.postForObject(
					"http://" + url, 
					loginDto,
					IOTMCResponseInfo.class);
			return response;
		} else if(input.getReqType().equals("GET")) {
			IOTMCResponseInfo response = restTemplate.getForObject(
					"http://" + url, 
					IOTMCResponseInfo.class);
			return response;
		} else {
			IOTMCResponseInfo response = new IOTMCResponseInfo();
			response.setStatus("403");
			response.setMessage("Redirect URL missing");
			response.setData("");
			return response;
		}
	}
}
