package com.example.techieswalk.controller;

import java.net.URI;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class OrderController {
	
	@RequestMapping(value = "api/v1/ping", method = RequestMethod.GET)
	public String pingOrders() throws Exception {
		return "Orders service is up and running !!";
	}
	
	@CircuitBreaker(name = "example", fallbackMethod = "defaultPaymentGateway")
	@RequestMapping(value = "api/v1/order-product", method = RequestMethod.GET)
	public String orderProducts() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = URI.create("http://localhost:8081/api/v1/payments");
		String paymentMsg =  restTemplate.getForObject(uri, String.class);
		return "Orders returned successfully and payment service returned:: " + paymentMsg ;
	}
	
	public String payments() {
		RestTemplate restTemplate = new RestTemplate();
		URI uri = URI.create("http://localhost:8081/api/v1/payments");
		String paymentMsg =  restTemplate.getForObject(uri, String.class);
		return paymentMsg;
	}
	
	public String defaultPaymentGateway() {
	    return "default payment with upi is in progress and available";
	}
}



