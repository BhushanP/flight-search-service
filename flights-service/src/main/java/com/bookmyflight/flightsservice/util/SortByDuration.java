package com.bookmyflight.flightsservice.util;

import java.util.List;
import java.util.stream.Collectors;

import com.bookmyflight.flightsservice.api.ISortingStrategy;
import com.bookmyflight.flightsservice.model.Flight;

public class SortByDuration implements ISortingStrategy {

	@Override
	public List<Flight> sortFlights(List<Flight> resultSet) {
		resultSet = resultSet.stream().sorted((f1, f2) -> Integer.compare(f1.getDuration(), f2.getDuration()))
				.collect(Collectors.toList());
		return resultSet;
	}

}
