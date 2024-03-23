package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import airplane.Airport;
import airplane.Passenger;

class AirplaneTest {
	Passenger passenger;
	Airport airport_sucsess;
	Airport airport_fail;
	Set<Airport> airporsts;
	
	@BeforeEach
	void setUp() {
		passenger = new Passenger("000001", 6,"Abbo", "K85", 5 , 5, 1200, 100);
		airport_sucsess = new Airport(10, 10, 7, 5);
		airport_fail = new Airport(10, 10, 7, 7);
		airporsts = new HashSet<Airport>();
	}
	
	@Test
	void landInNearestAirport_Sucsess() {
		airporsts.add(airport_sucsess);
		passenger.landInNearestAirport(airporsts);
		
		assertFalse(airport_sucsess.getLandedAirplanes().get(0) == null);
	}
	
	@Test
	void landInNearestAirport_Fail() {
		this.airporsts.add(airport_fail );
		
		assertThrows(RuntimeException.class,() -> this.passenger.landInNearestAirport(this.airporsts),"Can't reach an airport");
	}

}
