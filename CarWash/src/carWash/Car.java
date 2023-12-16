package carWash;

public class Car extends Automobile {

	public Car(Manufacturers maker, String model) {
		super(maker, model);
		super.priceMultiplayer = 1;
	}

}
