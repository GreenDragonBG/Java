package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import airplane.Airport;
import airplane.Passenger;

class AirportTest {
	Passenger passenger;
	Airport airport;
	Set<Airport> airporsts;
	
	@BeforeEach
	void setUp() {
		passenger = new Passenger("000001", 6,"Abbo", "K85", 5 , 5, 1200, 100);
		airport = new Airport(10, 10, 7, 5);
		airporsts = new HashSet<Airport>();
	}
	
	@Test
	void getLandedAirplanes() {
		airporsts.add(airport);
		passenger.landInNearestAirport(airporsts);
		
		assertEquals(passenger.toString() , airport.getLandedAirplanes().get(0).toString());
	}

}
