package gasStation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class GasStation {
	private Category Fuel;
	private Category Food;
	private Category Other;
	
	private List<Discount> discounts;
	
	private Map<Product, Integer> basket;
	
	public GasStation() {
		this.Fuel = new Category("fuel", 100);
		this.Food = new Category("food", 120);
		this.Other = new Category("other", 130);
		discounts = new ArrayList<Discount>() {};
		basket = new HashMap<Product , Integer>() {};
	}

	public void chekout() {
		for(Product p : basket.keySet()) {
			System.out.println("<"+ p.getCode() +">" + " / " 
		+ basket.get(p) + p.getUnit() + " / " + p.getPrice() 
		+ " / " + p.getPrice()*basket.get(p));
		}
		getDiscounts().stream()
		.filter(d -> d.getCondition()==true);
	}
	
	
	
	
	public Category getFuel() {
		return Fuel;
	}

	public void setFuel(Category fuel) {
		Fuel = fuel;
	}

	public Category getFood() {
		return Food;
	}

	public void setFood(Category food) {
		Food = food;
	}

	public Category getOther() {
		return Other;
	}

	public void setOther(Category other) {
		Other = other;
	}

	public List<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}
	
	
}
