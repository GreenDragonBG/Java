package company;

import java.util.List;

public class Order {
	private final int id;
	private int addressId;
	private List<Package> packages;
	private Status status;
	
	public Order(int id, int addressId, Status status) {
		this.id = id;
		this.addressId = addressId;
		this.status = status;
	}
	
	public double getDeliveryPrice(){
		double total =0;
		for(Package p : getPackages()) {
			total += p.getDeliveryPrice();
		}
		return total;
	}

	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	
}
