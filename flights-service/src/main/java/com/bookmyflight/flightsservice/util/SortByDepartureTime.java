package com.bookmyflight.flightsservice.util;

import java.util.List;
import java.util.stream.Collectors;

import com.bookmyflight.flightsservice.api.ISortingStrategy;
import com.bookmyflight.flightsservice.model.Flight;

public class SortByDepartureTime implements ISortingStrategy {

	@Override
	public List<Flight> sortFlights(List<Flight> resultSet) {
		resultSet = resultSet.stream().sorted((f1, f2) -> f1.getDepartureTime().compareTo(f2.getDepartureTime()))
				.collect(Collectors.toList());
		return resultSet;
	}

}
