package com.bookmyflight.flightsservice.util;

import org.springframework.util.MultiValueMap;

import com.bookmyflight.flightsservice.exception.InvalidRequestException;

public class RequestValidator {

	public static void validateRequest(MultiValueMap<String, String> searchRequest) throws InvalidRequestException {		

		if (searchRequest == null || searchRequest.isEmpty()){
			throw new InvalidRequestException("Invalid request : Source, destination and departure date are mandatory");
		}

		if (searchRequest.get("source")==null || searchRequest.get("source").isEmpty()){
			throw new InvalidRequestException("Invalid request : Source is mandatory");
		}

		if (searchRequest.get("destination")==null || searchRequest.get("destination").isEmpty()){
			throw new InvalidRequestException("Invalid request : Destination is mandatory");
		}
		
		if (searchRequest.get("departureDate")==null || searchRequest.get("departureDate").isEmpty()){
			throw new InvalidRequestException("Invalid request : departureDate is mandatory");
		}
	}

}
