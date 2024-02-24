package company;

public class MiddleSizePackage extends Package{
	private int size;
	
	public MiddleSizePackage(int id, int size) {
		super(id);
		if(size<4) {
			this.size = 4;
		}else if(size>6) {
			this.size = 6;
		}else {
			this.size = size;
		}
	}
	
	@Override
	public double getDeliveryPrice() {
		return getSize()*4;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

}
