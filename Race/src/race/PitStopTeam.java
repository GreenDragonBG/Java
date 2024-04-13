package race;

import java.util.concurrent.ThreadLocalRandom;

public class PitStopTeam {
    private int id;
    private Team team;
    private PitLane pitLane;
    private int servicedCars = 0;
    private boolean open = true;
 
    public PitStopTeam(Team team, PitLane pitLane) {
    	this.id = Race.counter++;
		this.team = team;
		this.pitLane = pitLane;
	}
    
	public void service(Car car){
		this.open = false;
        this.servicedCars++;
        try{
            Thread.sleep(ThreadLocalRandom.current().nextInt(400,1000));
        }catch(InterruptedException e){
        }
        this.open = true;
        
        synchronized (pitLane) {
        	pitLane.notifyAll();
		}
        
    }
    public int getNumberOfServicedCars(){
        return this.servicedCars;
    }
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		  this.team = team;
	      this.team.addStop(this);
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getServicedCars() {
		return servicedCars;
	}

	public void setServicedCars(int servicedCars) {
		this.servicedCars = servicedCars;
	}
	
	
	
    
    
}
