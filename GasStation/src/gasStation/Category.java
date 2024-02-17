package gasStation;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private String name;
	private int code;
	private List<Product> products;
	
	public Category(String name, int code) {
		this.name =name;
		this.code =code;
		this.products = new ArrayList<Product>() {};
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
