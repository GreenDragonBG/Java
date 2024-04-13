package race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Race{
    Date date;
    Track track;
    List<Car> cars;
    public static int counter = 0;
 
    public Race( Date date,Track track) {
    	this.date = date;
    	this.track = track;
    	this.cars = new ArrayList<Car>() {};
    }
    
    public void registerCar(Team team, String driverName){
        cars.add(new Car(team, driverName, this));
    }
    public void registerTeam(Team team){
        this.track.getPitLane().getPitStopTeams().add(new PitStopTeam(team,this.track.getPitLane()));
    }
    
    public void start(){
    	for(Car car : cars) {
    		car.start();
    	}
    	
    	try {
			Thread.sleep(getTrack().getTimeToFinish());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	for(Car car : cars) {
    		car.interrupt();
    	}
    	printRace();
    }
    
    
    public void printRace() {
    	System.out.println(getDate() +" - " + getTrack().getName());
    	System.out.println("Number of participants: " + getCars().size());
    	System.out.println("Pit stop teams: ");
    	int count =1;
    	List<PitStopTeam> list= getTrack().getPitLane().getPitStopTeams().stream().sorted((o1, o2)->o1.getNumberOfServicedCars()-o2.getNumberOfServicedCars()).toList();
    	for(PitStopTeam p : list ) {
    		 System.out.println(count + " - " + p.getId() + " - " + p.getTeam().getName() + " : " + p.getNumberOfServicedCars());
    		 count++;
    	}
    }

    
    
    
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
    
    
    
}
