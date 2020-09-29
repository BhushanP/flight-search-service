package com.bookmyflight.flightsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyflight.flightsservice.service.FlightsService;

@RestController
@RequestMapping("/bookmyflight")
public class FlightsController {

	@Autowired
	FlightsService flightsService;

	@GetMapping(value = "/search/flights")
	public @ResponseBody ResponseEntity<?> searchFlights(@RequestParam MultiValueMap<String, String> searchRequest) {
		return flightsService.searchFlights(searchRequest);
	}
}