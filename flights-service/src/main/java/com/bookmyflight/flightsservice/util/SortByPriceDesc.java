package com.bookmyflight.flightsservice.util;

import java.util.List;
import java.util.stream.Collectors;

import com.bookmyflight.flightsservice.api.ISortingStrategy;
import com.bookmyflight.flightsservice.model.Flight;

public class SortByPriceDesc implements ISortingStrategy {

	@Override
	public List<Flight> sortFlights(List<Flight> resultSet) {
		resultSet = resultSet.stream().sorted((f2, f1) -> Integer.compare(f2.getPrice(), f1.getPrice()))
				.collect(Collectors.toList());
		return resultSet;

	}

}
