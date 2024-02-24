package gasStation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Discount<T extends Items> {
	private String name;
	private int code;
	private double discount;
	private boolean isPercetege;
	private boolean condition;
	private List<T> types;
	
	public Discount(String name, int code, double discount,boolean isPercentege, boolean condition) {
		this.name = name;
		this.code = code;
		this.discount = discount;
		this.isPercetege = isPercentege;
		this.condition = condition;
		this.types= new ArrayList<T>();
	}
	
	public Map<Product, Double> useDiscount( Map<Product, Integer> basket){
		
		Map<Product, Double> output = new HashMap<Product, Double>();
		if(condition) {
		//All Items
		if(types.isEmpty()) {
			if(isPercetege) {
				
				for(Product p : basket.keySet()) {
					output.put(p, (p.getPrice()-p.getPrice()*discount/100) * basket.get(p) );
					p.setCurrentPrice(p.getPrice()-p.getPrice()*discount/100);
				}
			}else {
				
				for(Product p : basket.keySet()) {
					output.put(p, (p.getPrice()-discount) * basket.get(p) );
					p.setCurrentPrice(p.getPrice()-discount);
				}
			}
			
		}
		//Items based on Category
		else if(types.get(0)instanceof Category && basket.keySet().stream().map(k -> k.getCategory()).toList().containsAll(types)) {
			if(isPercetege) {
				
				for(Product p : basket.keySet()) {
					output.put(p, (p.getPrice()-p.getPrice()*discount/100) * basket.get(p) );
					p.setCurrentPrice(p.getPrice()-p.getPrice()*discount/100);
				}
			}else {
				
				for(Product p : basket.keySet()) {
					output.put(p, (p.getPrice()-discount) * basket.get(p) );
					p.setCurrentPrice(p.getPrice()-discount);
				}
			}
		}
		//Specific Products
		else if(types.get(0) instanceof Product && basket.keySet().contains(types)) {
			if(isPercetege) {
				
				for(Product p : basket.keySet()) {
					output.put(p, (p.getPrice()-p.getPrice()*discount/100) * basket.get(p) );
					p.setCurrentPrice(p.getPrice()-p.getPrice()*discount/100);
				}
			}else {
				
				for(Product p : basket.keySet()) {
					output.put(p, (p.getPrice()-discount) * basket.get(p) );
					p.setCurrentPrice(p.getPrice()-discount);
				}
			}
		}
		}
		return output;
		
	}
	
	
	
	public void addType(T item) {
		types.add(item);
	}
	
	public void removeType(int code) {
		
		for(int i =0; i< types.size(); i++) {
			
			if(types.get(i).getCode() == code) {
				types.remove(i);
			}
		}
	}
	
	
	public List<T> getTypes() {
		return types;
	}

	public void setTypes(List<T> types) {
		this.types = types;
	}

	public boolean isPercetege() {
		return isPercetege;
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public boolean getPercetege() {
		return isPercetege;
	}


	public void setPercetege(boolean isPercetege) {
		this.isPercetege = isPercetege;
	}


	public boolean getCondition() {
		return condition;
	}


	public void setCondition(boolean condition) {
		this.condition = condition;
	}
	
	
	
	
	
	
}
