package com.makemytrip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.makemytrip.model.Flight;
import com.makemytrip.service.FlightsService;

@RestController
public class FlightsController {
	@Autowired
	FlightsService flightsService;

	@GetMapping(value = "/makemytrip/search/flights")
	public List<Flight> searchFlights(@RequestParam MultiValueMap<String, String> searchRequest) {
		return flightsService.searchFlights(searchRequest);
	}
}