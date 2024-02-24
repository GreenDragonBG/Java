package company;

public class SmallSizePackage extends Package {
	private int size;
	
	public SmallSizePackage(int id, int size) {
		super(id);
		if(size<1) {
			this.size = 1;
		}else if(size>3) {
			this.size = 3;
		}else {
			this.size = size;
		}
	}
	
	@Override
	public double getDeliveryPrice() {
		return getSize()*3;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

}
