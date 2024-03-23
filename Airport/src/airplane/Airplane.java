package airplane;

import java.util.Set;

public abstract class Airplane {
	String number;
	int size;
	String maker;
	String model;
	Position position;
	double availableFuel;
	
	public Airplane(String number, int size, String maker,String model,int x,int y,double availableFuel) {
		if(number.toCharArray().length!=6) {
			throw new RuntimeException("Airplane number has to have 6 symbols");
		}
		this.number = number;
		this.size = size;
		this.maker = maker;
		this.model = model;
		this.position = new Position(x, y);
		this.availableFuel = availableFuel;
	}
	
	public Airplane(String number, int size, String maker,String model,Position position,double availableFuel) {
		if(number.toCharArray().length!=6) {
			throw new RuntimeException("Airplane number has to have 6 symbols");
		}
		this.number = number;
		this.size = size;
		this.maker = maker;
		this.model = model;
		this.position = new Position(0,0);
		this.position = position;
		this.availableFuel = availableFuel;
	}
	
	
	public double distanceToAirport(Airport airport) {
		// d=√((x_2-x_1)²+(y_2-y_1)²)
		return Math.sqrt((getPosition().getX()-airport.getPosition().getX())*(getPosition().getX()-airport.getPosition().getX())+(getPosition().getY()-airport.getPosition().getY()) * (getPosition().getY()-airport.getPosition().getY()));
	}
	
	public abstract boolean canReachAirtport(Airport airport);
	
	public void landInNearestAirport(Set<Airport> airports) {
		
		Airport current = new Airport(size, size, position);
		for (Airport airport : airports) {
			double minDistance = Double.MAX_VALUE;
			if(minDistance > distanceToAirport(airport)) {
				
				minDistance =distanceToAirport(airport);
				current = airport;
			}
		}
		
		final Airport closest = current;
		
		if(canReachAirtport(closest)) {
			airports.stream().filter(a -> a.equals(closest)).forEach(a->a.landAirplane(this));
			return;
		}
		
		throw new RuntimeException("Can't reach an airport");
		
	}
	
	
	
	

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public double getAvailableFuel() {
		return availableFuel;
	}

	public void setAvailableFuel(double availableFuel) {
		this.availableFuel = availableFuel;
	}
	
	
	
}
