package com.bookmyflight.flightsservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.bookmyflight.flightsservice.api.IThirdPartyService;
import com.bookmyflight.flightsservice.exception.ThirdPartyInvocationException;
import com.bookmyflight.flightsservice.model.Flight;



@Service
@Qualifier("makemytrip")
public class MakeMyTripServiceImpl implements IThirdPartyService{

	private static final String MAKEMYTRIP_URL = "http://makemytrip-service/makemytrip/search/flights";
	@Autowired 
	RestTemplate restTemplate;
	
	@Override
	public List<Flight> getFlights(MultiValueMap<String, String> searchRequest) throws ThirdPartyInvocationException {
		try{
		Flight[] flights = restTemplate.getForObject(MAKEMYTRIP_URL, Flight[].class);
		List<Flight> flightList= new ArrayList<>(Arrays.asList(flights));
		return flightList;
		}catch (Exception e) {
			throw new ThirdPartyInvocationException("Error while calling goibibo api");
		}
	}
}
