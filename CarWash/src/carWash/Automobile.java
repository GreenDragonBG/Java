package carWash;

public abstract class Automobile {
	private Manufacturers maker;
	private String model;
	protected double priceMultiplayer;
	
	public Automobile(Manufacturers maker,String model) {
		this.maker = maker;
		this.model = model;
	}
	
	public double getPriceMultiplayer() {
		return priceMultiplayer;
	}
}
