/**
 * 
 */
package com.eatrest.office.inventory.management.service.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Anurag Jain
 *
 */
@Configuration
@ComponentScan(
	{"com.eatrest.user.management.service.services", 
	"com.eatrest.user.management.service.dao.repositories"}
)
public class ContextConfig {
	
	@LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
	
		
}
