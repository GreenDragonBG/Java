package vendingMachine;

import java.util.Collection;
import java.util.HashMap;

/*
 * Steps to create test:
 * 1. Create new source folder at src level with name test
 * 2. Magic combination Ctrl + 1
 * 3. Create new JUnit test case
 * 4. Select JUnit Jupiter at top (this is tha latest version of the library)
 * 5. Make sure to select the new source folder and package at the top
 * 6. Click Finish 
 */

public class CoffeeVendingMachine {
	protected static final int CAPACITY = 5000;
	private double turnover;
	protected HashMap<String, Integer> containers;

	public CoffeeVendingMachine(Collection<String> ingredients) {
		turnover = 0;
		containers = new HashMap<String, Integer>();
		for (String ingedient : ingredients) {
			containers.put(ingedient, CAPACITY);
		}
	}

	public void resupplyContainer(String ingredient) {
		if (containers.containsKey(ingredient)) {
			containers.put(ingredient, CAPACITY);
		} else {
			throw new RuntimeException("There is no container with this ingredient");
		}
	}

	public void resupply() {
		for (String key : containers.keySet()) {
			resupplyContainer(key);
		}
	}

	public int getIngerdientSupply(String ingredient) {
		if (!containers.containsKey(ingredient)) {
			throw new RuntimeException("There is no container with this ingredient");
		}
		return containers.get(ingredient);
	}

	private void useIngredient(String ingredient, int amount) {
		if (!containers.containsKey(ingredient)) {
//			double b = 10 / 0;
			throw new RuntimeException("There is no container with this ingredient");
		}
		if (containers.get(ingredient) < amount) {
			throw new RuntimeException("Not enough ingredinet to get that amount");
		}
		containers.put(ingredient, containers.get(ingredient) - amount);
	}

	public void brewRecipe(Recipe recipe) {
		for (String ingredient : recipe.getIngredients().keySet()) {
			useIngredient(ingredient, recipe.getIngredients().get(ingredient));
		}
		this.turnover += recipe.getPrice();
	}

	public double getTurnover() {
		return turnover;
	}

}
