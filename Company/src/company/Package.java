package company;

public abstract class Package {
	private final int id;
	
	public Package(int id) {
		this.id = id;
	}
	
	public abstract double getDeliveryPrice();
}
