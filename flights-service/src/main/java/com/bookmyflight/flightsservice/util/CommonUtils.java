package com.bookmyflight.flightsservice.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.util.MultiValueMap;

import com.bookmyflight.flightsservice.exception.InvalidRequestException;

public final class CommonUtils {

	public static Date getDepartureDate(final MultiValueMap<String, String> searchRequest) throws InvalidRequestException {
		String dDate=searchRequest.get("departureDate").get(0);
        String currentFormat = "yyyy-MM-dd'T'hh:mm:ss.SSS'Z'";
        String timezone = "CDT";
        DateFormat srcDf = new SimpleDateFormat(currentFormat);
        srcDf.setTimeZone(TimeZone.getTimeZone(timezone));
		Date cDate=null;
		try {
			cDate = srcDf.parse(dDate);
		} catch (ParseException e) {
			throw new InvalidRequestException("Date format incorrect");
		}
		return cDate;
	}

}
