package com.bookmyflight.flightsservice.util;

import java.util.List;
import java.util.stream.Collectors;

import com.bookmyflight.flightsservice.api.ISortingStrategy;
import com.bookmyflight.flightsservice.model.Flight;

public class SortByAirline implements ISortingStrategy {

	@Override
	public List<Flight> sortFlights(List<Flight> resultSet) {
		 resultSet = resultSet.stream().sorted((f1, f2) -> f1.getAirline().compareTo(f2.getAirline()))
				.collect(Collectors.toList());
		 return resultSet;
	}

}
