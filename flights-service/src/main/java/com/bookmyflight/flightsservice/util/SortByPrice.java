package com.bookmyflight.flightsservice.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.bookmyflight.flightsservice.api.ISortingStrategy;
import com.bookmyflight.flightsservice.model.Flight;

@Service
@Primary
public class SortByPrice implements ISortingStrategy {

	@Override
	public List<Flight> sortFlights(List<Flight> resultSet) {
		resultSet = resultSet.stream().sorted((f1, f2) -> Integer.compare(f1.getPrice(), f2.getPrice()))
				.collect(Collectors.toList());
		return resultSet;

	}

}
