package gasStation;

import java.util.ArrayList;
import java.util.List;

public class Category extends Items{
	private String name;
	private List<Product> products;
	
	public Category(String name, int code) {
		super(code);
		this.name =name;
		this.products = new ArrayList<Product>() {};
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
