package race;

import java.util.concurrent.ThreadLocalRandom;

public class Car {
	 private int id;
	    private Team team;
	    private String driverName;
	 
	    public Car(Team team, String driverName) {
	    	this.id = Race.counter++;
			this.team = team;
			this.driverName = driverName;
		}
	    
		public int getTimeForNextPitStop(){
	        return ThreadLocalRandom.current().nextInt(4000,8000);
	    }
	    public Team getTeam(){
	        return this.team;
	    }
	 
	     public void setTeam(Team team){
	         this.team = team;
	         this.team.addCar(this);
	     }
	     
	     public void enterPitLane() {
	    	 this.team.getStops().stream().filter(s -> s.isOpen()).findFirst().get().service(this);;
	     }
	     
	     public int getId() {
			return id;
		}
	     
}
