package airplane;

public class Cargo extends Airplane{
	int load;
	
	public Cargo(String number, int size, String maker, String model, int x, int y, double availableFuel, int load) {
		super(number, size, maker, model, x, y, availableFuel);
		
		if(load>1000 || load<0) {
			throw new RuntimeException("Load out of bounds(0-1000)");
		}
		
		this.load = load;
	}
	
	public Cargo(String number, int size, String maker, String model, Position position, double availableFuel, int load) {
		super(number, size, maker, model, position, availableFuel);
		
		if(load>1000 || load<0) {
			throw new RuntimeException("Load out of bounds(0-1000)");
		}
		
		this.load = load;
	}

	@Override
	public boolean canReachAirtport(Airport airport) {
		return distanceToAirport(airport) <= getAvailableFuel()/((double)this.load * size);
	}
}
