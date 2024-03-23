package airplane;

public class Passenger extends Airplane{
	int numberOfSeats;
	
	public Passenger(String number, int size, String maker, String model, int x, int y, double availableFuel, int numberOfSeats) {
		super(number, size, maker, model, x, y, availableFuel);
		
		if(numberOfSeats>500 || numberOfSeats<100) {
			throw new RuntimeException("Seats out of bounds (100-500)");
		}else if(size<5 || size>10) {
			throw new RuntimeException("Out of range for size(5-10)");
		}
		
		this.numberOfSeats = numberOfSeats;
	}
	
	public Passenger(String number, int size, String maker, String model, Position position, double availableFuel, int numberOfSeats) {
		super(number, size, maker, model, position, availableFuel);
		
		if(numberOfSeats>500 || numberOfSeats<100) {
			throw new RuntimeException("Seats out of bounds (100-500)");
		}else if(size<5 || size>10) {
			throw new RuntimeException("Out of range for size(5-10)");
		}
		
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public boolean canReachAirtport(Airport airport) {
		return distanceToAirport(airport) <= getAvailableFuel()/((double)this.numberOfSeats * size);
	}
	
}
