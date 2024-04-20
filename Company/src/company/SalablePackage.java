package company;

public class SalablePackage extends Package{
	private double price;
	private Package pack;
	
	public SalablePackage(int id, Package pack, double price) {
		super(id);
		this.price = price;
		this.pack = pack;
	}
	
	@Override
	public double getDeliveryPrice() {
		return pack.getDeliveryPrice()+ price*0.1;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Package getPack() {
		return pack;
	}

	public void setPack(Package pack) {
		this.pack = pack;
	}
	
	

}
