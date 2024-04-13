package race;

import java.util.ArrayList;
import java.util.List;	

public class Team {
    private String name;
    private List<Car> cars;
    private List<PitStopTeam> stops;

    public Team(String name) {
    	this.name = name;
    	this.cars = new ArrayList<Car>();
    	this.stops = new ArrayList<PitStopTeam>();
    }
    
    public void addCar(Car car){
        if(!car.getTeam().equals(this)){
            car.setTeam(this);
        }else {
        	this.cars.add(car);        	
        }
    }
    
    public void addStop(PitStopTeam stop){
        if(!stop.getTeam().equals(this)){
            stop.setTeam(this);
        }else {
        	this.stops.add(stop);        	
        }
    }
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public List<PitStopTeam> getStops() {
		return stops;
	}

	public void setStops(List<PitStopTeam> stops) {
		this.stops = stops;
	}
    
    
}
