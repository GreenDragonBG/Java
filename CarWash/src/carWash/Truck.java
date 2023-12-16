package carWash;

public class Truck extends Automobile {

	public Truck(Manufacturers maker, String model) {
		super(maker, model);
		super.priceMultiplayer = 2;
	}

}
