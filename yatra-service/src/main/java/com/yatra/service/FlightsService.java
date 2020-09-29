package com.yatra.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.yatra.model.Flight;


@Service
public class FlightsService {

	private static List<Flight> flights = new ArrayList<Flight>();

	static {
		flights.add(new Flight("101_AI", "Air India", "Bangalore", new Date(120, 8, 30), "Mumbai",
				new Date(120, 8, 30), 5300, 1, "Bangalore->Mumbai", 3));
		flights.add(new Flight("102_AI", "Air India", "Mumbai", new Date(120, 8, 30), "Bangalore",
				new Date(120, 8, 30), 5700, 1, "Mumbai->Bangalore", 3));
		flights.add(new Flight("103_AI", "Air India", "Bangalore", new Date(120, 8, 30), "Kolkata",
				new Date(120, 8, 30), 6000, 1, "Bangalore->Kolkata", 4));
		flights.add(new Flight("104_AI", "Air India", "Kolkata", new Date(120, 8, 30), "Bangalore",
				new Date(120, 8, 30), 6300, 1, "Kolkata->Bangalore", 5));
	}

	public List<Flight> searchFlights(MultiValueMap<String, String> searchRequest) {
		return flights;
	}

}
