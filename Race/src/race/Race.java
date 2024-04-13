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
        cars.add(new Car(team, driverName));
    }
    public void registerTeam(Team team){
        this.track.getPitLane().getPitStopTeams().add(new PitStopTeam(team));
    }
    
    public void start(){
    	Race race = this;
    	
    	for(Car car : cars) {
    		Thread thread = new Thread("Car: "+ car.getId()) {
    			@Override
    			public void run() {
    				int timeOnTrack =0;
    				while(timeOnTrack >= race.getTrack().getTimeToFinish()) {
    					int currentTime = car.getTimeForNextPitStop();
    					timeOnTrack+= currentTime;
    					try {
    						Thread.sleep(currentTime);
    					} catch (InterruptedException e) {}
        				car.enterPitLane();
    				}	
    			}
    		};
    		
    		thread.start();
    	}
    	
    	try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
