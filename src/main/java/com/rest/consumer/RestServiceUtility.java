package com.rest.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.core.connector.rest.RestClientFactory;

@RestController
public class RestServiceUtility {
	//@Resource(name = "factory.restClient")
	@Autowired
	//@Qualifier("restClientFactory")
	private RestClientFactory restClientFactory;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getData() {
		Quote quote1 = restClientFactory.getClient().getForObject("http://gturnquist-quoters.cfapps.io/api/random",
				Quote.class);
		System.out.println("quote1 " + quote1.toString());
		return quote1.toString();
		//return "Data";
	}
}
