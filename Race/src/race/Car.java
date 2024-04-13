package race;

import java.util.concurrent.ThreadLocalRandom;

public class Car extends Thread {
	private int id;
	private Team team;
	private String driverName;
	private Race race;

	public Car(Team team, String driverName, Race race) {
		this.id = Race.counter++;
		this.team = team;
		this.driverName = driverName;
		this.race = race;
	}

	public int getTimeForNextPitStop() {
		return ThreadLocalRandom.current().nextInt(4000, 8000);
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
		this.team.addCar(this);
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(getTimeForNextPitStop());
			} catch (InterruptedException e) {
			}
			race.getTrack().getPitLane().enterPitLane(this);
		}
	}

}
