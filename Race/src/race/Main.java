package race;

import java.time.LocalDate;
import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Race r = new Race( new Date(), new Track("Track101", 30000, new PitLane(5)));
		Team cherven = new Team("Cherveni");
		Team sin = new Team("Sini");
		r.registerCar(cherven, "Driver 01");
		r.registerCar(cherven, "Driver 03");
		r.registerCar(cherven, "Driver 07");
		
		r.registerCar(sin, "Driver 02");
		r.registerCar(sin, "Driver 03");
		r.registerCar(sin, "Driver 11");
		
		r.registerTeam(sin);
		r.registerTeam(cherven);
		r.registerTeam(sin);
		r.registerTeam(cherven);
		
		r.getCars().stream().filter(c-> c.getTeam().equals(sin)).forEach(c-> sin.addCar(c));
		r.getCars().stream().filter(c-> c.getTeam().equals(cherven)).forEach(c-> cherven.addCar(c));
		r.getTrack().getPitLane().getPitStopTeams().stream().filter(t-> t.getTeam().equals(sin)).forEach(t-> sin.addStop(t));
		r.getTrack().getPitLane().getPitStopTeams().stream().filter(t-> t.getTeam().equals(cherven)).forEach(t-> cherven.addStop(t));
		
		
		r.start();
	}
}	
