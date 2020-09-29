package com.bookmyflight.flightsservice.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookmyflight.flightsservice.model.Flight;

@Repository
public interface FlightsRepository extends JpaRepository<Flight, Integer> {

	@Query("SELECT f FROM Flight f WHERE f.departureAirport = :source and f.arrivalAirport = :destination and f.departureTime >= :departureDate")
	List<Flight> findFlightsBySourceDestinationAndTravelDate(@Param("source") String source,
			@Param("destination") String destination, @Param("departureDate") Date departureDate);
}
