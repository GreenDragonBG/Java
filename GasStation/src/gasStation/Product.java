package gasStation;

public class Product {
	private double price;
	private int code;
	private String unit;
	private Category category;
	
	public Product(double price, int code, String unit, Category category) {
		this.price =price;
		this.code = code;
		this.unit =unit;
		this.category =category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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
