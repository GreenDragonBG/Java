package race;

public class Track{
    String name;
    int timeToFinish;
    PitLane pitLane;
    
    public Track( String name, int timeToFinish, PitLane pitLane) {
    	this.name = name;
    	this.timeToFinish = timeToFinish;
    	this.pitLane = pitLane;
    }
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTimeToFinish() {
		return timeToFinish;
	}
	public void setTimeToFinish(int timeToFinish) {
		this.timeToFinish = timeToFinish;
	}
	public PitLane getPitLane() {
		return pitLane;
	}
	public void setPitLane(PitLane pitLane) {
		this.pitLane = pitLane;
	}
	
    
}
