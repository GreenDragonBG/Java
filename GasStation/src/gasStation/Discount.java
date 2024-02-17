package gasStation;

import java.util.ArrayList;
import java.util.List;

public class Discount {
	private String name;
	private int code;
	private double discount;
	private boolean isPercetege;
	private boolean condition;
	
	public Discount(String name, int code, double discount,boolean isPercentege, boolean condition) {
		this.name = name;
		this.code = code;
		this.discount = discount;
		this.isPercetege = isPercentege;
		this.condition = condition;
	}
	
	
	public void useDiscount(List<Product> useOn) throws Exception {
		if(condition) {
			
			if(isPercetege) {
				 price -= price*discount/100;
			}else {
				 price -= discount;
			}
		
		}else {
			 price;
		}
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
