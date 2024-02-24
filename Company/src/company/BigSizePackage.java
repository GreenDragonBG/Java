package company;

public class BigSizePackage extends Package{
	private int size;
	
	public BigSizePackage(int id, int size) {
		super(id);
		if(size<7) {
			this.size = 7;
		}else if(size>9) {
			this.size = 9;
		}else {
			this.size = size;
		}
	}
	
	@Override
	public double getDeliveryPrice() {
		return getSize()*5;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

}
