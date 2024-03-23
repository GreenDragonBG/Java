package airplane;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Passenger p = new Passenger("000001", 6,"Abbo", "K85", 5 , 5, 1200, 100);
		Airport ap = new Airport(10, 10, 7, 7);
		Set<Airport> airporsts = new HashSet<Airport>();
		airporsts.add(ap);
		p.landInNearestAirport(airporsts);
		
		System.out.println(ap.getLandedAirplanes().get(0));
	}

}
