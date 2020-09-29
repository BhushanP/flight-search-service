package com.makemytrip.model;

import java.util.Date;

public class Flight {

	private String number;

	private String airline;

	private String arrivalAirport;

	private Date arrivalTime;

	private String departureAirport;

	private Date departureTime;

	private int price;

	private int noOfStops;

	private String route;
	
	private int duration;

	public Flight() {

	}

	public Flight(String number, String airline, String arrivalAirport, Date arrivalTime, String departureAirport,
			Date departureTime, int price, int noOfStops, String route, int duration) {
		super();
		this.number = number;
		this.airline = airline;
		this.arrivalAirport = arrivalAirport;
		this.arrivalTime = arrivalTime;
		this.departureAirport = departureAirport;
		this.departureTime = departureTime;
		this.price = price;
		this.noOfStops = noOfStops;
		this.route = route;
		this.duration = duration;
	}

	public String getNumber() {
		return number;
	}

	public String getAirline() {
		return airline;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public int getPrice() {
		return price;
	}

	public int getNoOfStops() {
		return noOfStops;
	}

	public String getRoute() {
		return route;
	}

	public int getDuration() {
		return duration;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airline == null) ? 0 : airline.hashCode());
		result = prime * result + ((arrivalAirport == null) ? 0 : arrivalAirport.hashCode());
		result = prime * result + ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime * result + ((departureAirport == null) ? 0 : departureAirport.hashCode());
		result = prime * result + ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime * result + duration;
		result = prime * result + noOfStops;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + price;
		result = prime * result + ((route == null) ? 0 : route.hashCode());
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
		Flight other = (Flight) obj;
		if (airline == null) {
			if (other.airline != null)
				return false;
		} else if (!airline.equals(other.airline))
			return false;
		if (arrivalAirport == null) {
			if (other.arrivalAirport != null)
				return false;
		} else if (!arrivalAirport.equals(other.arrivalAirport))
			return false;
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
			return false;
		if (departureAirport == null) {
			if (other.departureAirport != null)
				return false;
		} else if (!departureAirport.equals(other.departureAirport))
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (duration != other.duration)
			return false;
		if (noOfStops != other.noOfStops)
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (price != other.price)
			return false;
		if (route == null) {
			if (other.route != null)
				return false;
		} else if (!route.equals(other.route))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Flight [number=" + number + ", airline=" + airline + ", arrivalAirport=" + arrivalAirport
				+ ", arrivalTime=" + arrivalTime + ", departureAirport=" + departureAirport + ", departureTime="
				+ departureTime + ", price=" + price + ", noOfStops=" + noOfStops + ", route=" + route + ", duration="
				+ duration + "]";
	}

}