package com.rest.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.core.connector.rest.RestClientFactory;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.rest.consumer","com.core.connector","com.servicecore.cfg"})
public class Application  implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	 
	public static void main(String... args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	private RestClientFactory restClientFactory;
	
	public void run(String... args) throws Exception {
	        RestTemplate restTemplate = new RestTemplate();
	        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
	        log.info(quote.toString());
	        Quote quote1 = restClientFactory.getClient().getForObject("http://gturnquist-quoters.cfapps.io/api/random",
					Quote.class);
			System.out.println("quote1 " + quote1.toString());
	    }
}