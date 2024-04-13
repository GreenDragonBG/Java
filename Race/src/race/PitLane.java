package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PitLane {
    int maxNumberOfTeams;
    List<PitStopTeam> pitStopTeams;
    List<Car> cars;
 
    public PitLane(int maxNumberOfTeams) {
    	this.maxNumberOfTeams = maxNumberOfTeams;
    	this.pitStopTeams = new ArrayList<PitStopTeam>();
    	this.cars = new ArrayList<Car>();
    }
    
    public void addPitStopTeams(PitStopTeam pitStopTeam) throws Exception{
        if(maxNumberOfTeams == pitStopTeams.size()){
            throw new Exception("Pit lane is full of teams");
        }
        this.pitStopTeams.add(pitStopTeam);
    }
    public void addCar(Car car){
        this.cars.add(car);
    }
 
    public Optional<Car> getNextCar(PitStopTeam team) throws Exception{
       try{
           return cars.stream().filter(c -> c.getTeam().equals(team)).findFirst();
       }catch(Exception e){
           throw new Exception("No cars at the pit lane");
       }
    }
	public List<PitStopTeam> getPitStopTeams() {
		return pitStopTeams;
	}
	public void setPitStopTeams(List<PitStopTeam> pitStopTeams) {
		this.pitStopTeams = pitStopTeams;
	}
	
    
}
