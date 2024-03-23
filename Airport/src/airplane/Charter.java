package airplane;

public class Charter extends Airplane{
	int numberOfSeats; 
	
	public Charter(String number, int size, String maker, String model, int x, int y, double availableFuel, int numberOfSeats) {
		super(number, size, maker, model, x, y, availableFuel);
		
		if(numberOfSeats>20) {
			throw new RuntimeException("Too many seats(Max 20)");
		}else if(size<1 || size>5) {
			throw new RuntimeException("Out of range for size(1-5)");
		}
		
		this.numberOfSeats = numberOfSeats;
	}
	
	public Charter(String number, int size, String maker, String model, Position position, double availableFuel, int numberOfSeats) {
		super(number, size, maker, model, position, availableFuel);
		
		if(numberOfSeats>20) {
			throw new RuntimeException("Too many seats(Max 20)");
		}else if(size<1 || size>5) {
			throw new RuntimeException("Out of range for size(1-5)");
		}
		
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public boolean canReachAirtport(Airport airport) {
		return distanceToAirport(airport) <= getAvailableFuel()/((double)this.numberOfSeats * size);
	}

}
