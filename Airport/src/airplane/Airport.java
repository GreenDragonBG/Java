package airplane;

import java.util.Arrays;
import java.util.List;

public class Airport {
	int capacity;
	int maxSize;
	Position position;
	Airplane[] airplanes;
	
	public Airport(int capacity,int maxSize,int x, int y) {
		this.capacity = capacity;
		this.maxSize = maxSize;
		this.position = new Position(x, y);
		
		airplanes = new Airplane[capacity];
	}
	
	public Airport(int capacity,int maxSize,Position position) {
		this.capacity = capacity;
		this.maxSize = maxSize;
		this.position = new Position(0, 0);
		this.position = position;
		
		airplanes = new Airplane[capacity];
	}
	
	public boolean canFitPlane(Airplane airplane) {
		return Arrays.asList(airplanes).stream().anyMatch(a -> a == null) && airplane.getSize()<=getMaxSize();
	}
	
	public void landAirplane(Airplane airplane) {
		if(canFitPlane(airplane)) {
			for (int i= 0; i< airplanes.length;i++ ) {
				if( airplanes[i]== null) {
					airplanes[i] = airplane;
					return;
				}
			}
		}
		throw new RuntimeException("Airport is either full or the airplane can't fit"); 
	}
	
	public void flyAirplane(String number) {
		for (int i= 0; i< airplanes.length;i++ ) {
			if( airplanes[i].getNumber().equals(number)) {
				airplanes[i] = null;
				return;
				
			}else if(i== airplanes.length-1) {
				throw new RuntimeException("No such plane in  this airport");
			}
		}
	}
	
	public List<Airplane> getLandedAirplanes() {
		return Arrays.asList(airplanes).stream().filter(a -> a!= null).sorted((a1,a2) -> Integer.compare(a1.getSize(), a2.getSize())).toList();
	}
	
	 
	
	
	
	
	

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	
	
	
}
