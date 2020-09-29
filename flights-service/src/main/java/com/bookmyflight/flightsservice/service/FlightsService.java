package com.bookmyflight.flightsservice.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.bookmyflight.flightsservice.api.ISortingStrategy;
import com.bookmyflight.flightsservice.api.IThirdPartyService;
import com.bookmyflight.flightsservice.exception.InvalidRequestException;
import com.bookmyflight.flightsservice.exception.ThirdPartyInvocationException;
import com.bookmyflight.flightsservice.model.Flight;
import com.bookmyflight.flightsservice.model.FlightsList;
import com.bookmyflight.flightsservice.repo.FlightsRepository;
import com.bookmyflight.flightsservice.util.CommonUtils;
import com.bookmyflight.flightsservice.util.FlightFilterUtil;
import com.bookmyflight.flightsservice.util.FlightSortingUtil;
import com.bookmyflight.flightsservice.util.RequestValidator;

@Service
public class FlightsService {

	private static final String NO_FLIGHTS_FOUND = "No flights available. Try changing your search criteria.";

	@Autowired
	FlightsRepository flightsRepository;

	@Autowired
	@Qualifier("goibibo")
	IThirdPartyService goibiboService;

	@Autowired
	@Qualifier("makemytrip")
	IThirdPartyService makeMyTripService;

	@Autowired
	@Qualifier("yatra")
	IThirdPartyService yatraService;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ISortingStrategy sortingStrategy;

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightsService.class);

	public ResponseEntity<?> searchFlights(final MultiValueMap<String, String> searchRequest) {
		FlightsList flightsList;
		Date departureDate;
		try {
			RequestValidator.validateRequest(searchRequest);
			departureDate = CommonUtils.getDepartureDate(searchRequest);
		} catch (InvalidRequestException e) {
			LOGGER.error(e.getLocalizedMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

		
		List<Flight> result = flightsRepository.findFlightsBySourceDestinationAndTravelDate(searchRequest.get("source").get(0),
				searchRequest.get("destination").get(0), departureDate);

		if (result == null || result.isEmpty()) {
			getFlightsFromThirdParty(searchRequest, result);
		}

		result = FlightFilterUtil.filter(result, searchRequest,departureDate);

		FlightSortingUtil.setSortingStrategy(searchRequest.get("sort"), sortingStrategy);

		result = sortingStrategy.sortFlights(result);

		flightsRepository.saveAll(result);

		flightsList = new FlightsList(result, result.size());

		if (flightsList.getNoOfFlights() <= 0) {
			LOGGER.error(NO_FLIGHTS_FOUND);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(NO_FLIGHTS_FOUND);
		}
		return ResponseEntity.accepted().body(flightsList);
	}


	private void getFlightsFromThirdParty(final MultiValueMap<String, String> searchRequest, List<Flight> result) {
		try {
			result.addAll(goibiboService.getFlights(searchRequest));
		} catch (ThirdPartyInvocationException e) {
			LOGGER.error(e.getLocalizedMessage());

		}
		try {
			result.addAll(makeMyTripService.getFlights(searchRequest));
		} catch (ThirdPartyInvocationException e) {
			LOGGER.error(e.getLocalizedMessage());
		}
		try {
			result.addAll(yatraService.getFlights(searchRequest));
		} catch (ThirdPartyInvocationException e) {
			LOGGER.error(e.getLocalizedMessage());
		}
	}

}
