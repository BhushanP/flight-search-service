package com.bookmyflight.flightsservice.util;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.MultiValueMap;

import com.bookmyflight.flightsservice.model.Flight;

public class FlightFilterUtil {

	public static List<Flight> filter(List<Flight> result, MultiValueMap<String, String> searchRequest, Date departureDate) {
		return result.stream().distinct().filter(f -> bySource(f, searchRequest.get("source").get(0)))
				.filter(f -> byDestination(f, searchRequest.get("destination").get(0)))
				.filter(f -> byDepartureDate(f,departureDate))
				.filter(f -> byAirline(f, searchRequest.get("airline")))
				.collect(Collectors.toList());

	}

	private static boolean byAirline(Flight f, List<String> airline) {
		if(airline==null||airline.isEmpty()|| airline.get(0)==null)
			return true;
		return airline.get(0).equalsIgnoreCase(f.getAirline());
	}

	private static boolean byDepartureDate(Flight f, Date departureDate) {
		return departureDate.before(f.getDepartureTime());
	}

	private static boolean byDestination(Flight f, String destination) {
		return destination.equalsIgnoreCase(f.getArrivalAirport());
	}

	private static boolean bySource(Flight f, String source) {
		return source.equalsIgnoreCase(f.getDepartureAirport());
	}

}
