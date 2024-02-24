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
		double total =0;
		for(Product p : basket.keySet()) {
			System.out.println("<"+ p.getCode() +">" + " / " 
		+ basket.get(p) + p.getUnit() + " / " + p.getPrice() 
		+ " / " + p.getPrice()*basket.get(p) +"lv.");
		}
		//Discount
		for(Discount discount : getDiscounts().stream().filter(d -> !d.useDiscount(basket).isEmpty()).toList()) {
			System.out.print("-<"+ discount.getName() +"> / discount ("+ discount.getDiscount());
			if(discount.getPercetege()) {
				System.out.println("%)");
			}else {
				System.out.println("lv.)");
			}
			//Discount type
			if(discount.getTypes().isEmpty()) {
				System.out.print("--all / ");
			
			}else if(discount.getTypes().get(0) instanceof Category) {
				System.out.print("--");
				for(Object c : discount.getTypes()) {
					System.out.print(((Category) c).getName()+";");
				}
				System.out.print(" / ");
			
			}else if(discount.getTypes().get(0) instanceof Product) {
				System.out.print("--");
				for(Object c : discount.getTypes()) {
					System.out.print(((Product) c).getCode()+";");
				}
				System.out.print(" / ");
			}
			//Discount value
			for(Object p : discount.useDiscount(basket).keySet()) {
				System.out.println("<"+ ((Product) p).getCode() +"- "+ (double)discount.useDiscount(basket).get(p) +"lv.>");
			}
		}
		//Total Price
		System.out.println("-------------------------------------------------------");
		
		for(Discount discount : getDiscounts().stream().filter(d -> !d.useDiscount(basket).isEmpty()).toList()) {
			System.out.print("#<"+ discount.getName() +"> / discount ("+ discount.getDiscount());
			if(discount.getPercetege()) {
				System.out.println("%)");
			}else {
				System.out.println("lv.)");
			}
		}
		
		for(Product p : basket.keySet()) {
			total+=p.getCurrentPrice()*basket.get(p);
			p.setCurrentPrice(p.getPrice());
		}
		System.out.println("Total / <"+total+"lv.>");
		
	}
	
	
	
	
	public Map<Product, Integer> getBasket() {
		return basket;
	}

	public void setBasket(Map<Product, Integer> basket) {
		this.basket = basket;
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
