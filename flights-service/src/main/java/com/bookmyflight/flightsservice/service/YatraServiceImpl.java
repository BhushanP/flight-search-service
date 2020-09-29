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
@Qualifier("yatra")
public class YatraServiceImpl implements IThirdPartyService{

	private static final String YATRA_URL = "http://yatra-service/yatra/search/flights";
	@Autowired 
	RestTemplate restTemplate;
	
	@Override
	public List<Flight> getFlights(MultiValueMap<String, String> searchRequest) throws ThirdPartyInvocationException {
		try{
		Flight[] flights = restTemplate.getForObject(YATRA_URL, Flight[].class);
		List<Flight> flightList= new ArrayList<>(Arrays.asList(flights));
		return flightList;
		}catch (Exception e) {
			throw new ThirdPartyInvocationException("Error while calling goibibo api");
		}
	}
}
