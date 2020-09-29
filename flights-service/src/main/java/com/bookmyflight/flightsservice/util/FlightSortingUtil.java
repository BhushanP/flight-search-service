package com.bookmyflight.flightsservice.util;

import java.util.List;

import com.bookmyflight.flightsservice.api.ISortingStrategy;

public class FlightSortingUtil {

	public static ISortingStrategy setSortingStrategy(List<String> sortingField, ISortingStrategy sortingStrategy) {
		if (sortingField == null || sortingField.isEmpty() || sortingField.get(0) == null
				|| sortingField.get(0).equalsIgnoreCase("price"))
			return sortingStrategy;
		String sortBy = sortingField.get(0);

		if (sortBy.equalsIgnoreCase("airline"))
			sortingStrategy = new SortByAirline();
		
		if (sortBy.equalsIgnoreCase("priceDesc"))
			sortingStrategy = new SortByPriceDesc();
		
		if (sortBy.equalsIgnoreCase("duration"))
			sortingStrategy = new SortByDuration();
		
		if (sortBy.equalsIgnoreCase("departureTime"))
			sortingStrategy = new SortByDepartureTime();

		return sortingStrategy;

	}
}
