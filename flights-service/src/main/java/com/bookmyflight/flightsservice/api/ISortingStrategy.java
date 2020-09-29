package com.bookmyflight.flightsservice.api;

import java.util.List;

import com.bookmyflight.flightsservice.model.Flight;

public interface ISortingStrategy {
	public List<Flight> sortFlights(List<Flight> result);
}
