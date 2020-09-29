package com.bookmyflight.flightsservice.model;

import java.util.List;

public class FlightsList {

	private List<Flight> flights;

	private int noOfFlights;

	public List<Flight> getFlights() {
		return flights;
	}

	public int getNoOfFlights() {
		return noOfFlights;
	}

	public FlightsList() {
	}

	public FlightsList(List<Flight> flights, int noOfFlights) {
		super();
		this.flights = flights;
		this.noOfFlights = noOfFlights;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flights == null) ? 0 : flights.hashCode());
		result = prime * result + noOfFlights;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightsList other = (FlightsList) obj;
		if (flights == null) {
			if (other.flights != null)
				return false;
		} else if (!flights.equals(other.flights))
			return false;
		if (noOfFlights != other.noOfFlights)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FlightsList [flights=" + flights + ", noOfFlights=" + noOfFlights + "]";
	}

}
