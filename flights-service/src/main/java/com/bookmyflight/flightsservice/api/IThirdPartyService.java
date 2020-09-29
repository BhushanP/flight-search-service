package com.bookmyflight.flightsservice.api;

import java.util.List;

import org.springframework.util.MultiValueMap;

import com.bookmyflight.flightsservice.exception.ThirdPartyInvocationException;
import com.bookmyflight.flightsservice.model.Flight;

public interface IThirdPartyService {
	
	List<Flight> getFlights(final MultiValueMap<String, String> searchRequest) throws ThirdPartyInvocationException;

}
