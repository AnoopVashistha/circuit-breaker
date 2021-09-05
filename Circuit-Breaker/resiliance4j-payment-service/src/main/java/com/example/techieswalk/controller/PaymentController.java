package com.example.techieswalk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

	@RequestMapping(value = "api/v1/ping", method = RequestMethod.GET)
	public String pingOrders() throws Exception {
		return "Payment service is up and running !!";
	}

	@RequestMapping(value = "api/v1/payments", method = RequestMethod.GET)
	public String payment() throws Exception {
		return "Payment is done successfully!!";
	}
}
