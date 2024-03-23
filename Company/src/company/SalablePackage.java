package company;

public class SalablePackage extends Package{
	private int size;
	private double price;
	
	public SalablePackage(int id, int size, double price) {
		super(id);
		
		if(size<1) {
			this.size = 1;
		}else if(size>9) {
			this.size = 9;
		}else {
			this.size = size;
		}
		
		this.price = price;
	}
	
	@Override
	public double getDeliveryPrice() {
		if(getSize()<=3) {
			return size*3+price*0.1;
		}else if(getSize()>3 && getSize()<7) {
			return size*4+price*0.1;
		}else if(getSize()<=9) {
			return size*5+price*0.1;
		}
		return (Double) null;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

}
