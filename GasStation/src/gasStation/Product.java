package gasStation;

public class Product  extends Items{
	private double price;
	private String unit;
	private Category category;
	private double currentPrice;
	
	public Product(double price, int code, String unit, Category category) {
		super(code);
		this.price =price;
		this.unit =unit;
		this.category =category;
		this.currentPrice=price;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}
	
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
