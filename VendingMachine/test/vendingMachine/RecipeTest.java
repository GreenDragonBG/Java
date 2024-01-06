package vendingMachine;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static vendingMachine.CoffeeVendingMachine.CAPACITY;

import org.junit.jupiter.api.Test;

class RecipeTest {
	private Recipe recipe;
	private static final int RECIPE_PRICE = 10;
	private static final String RECIPE_NAME = "cofee";
	private static final String INGERDIENT_NAME = "milk";
	private static final int INGERDIENT_AMOUNT = 250;
	
	@Test
	void CreatingRecipe_fail() {
		assertThrows(Exception.class, () -> {
			recipe = new Recipe(RECIPE_NAME, 0);
		});
	}
	
	@Test
	void CreatingRecipe_success() {
			try {
				recipe = new Recipe(RECIPE_NAME, RECIPE_PRICE);
			} catch (Exception e) {
				e.printStackTrace();
			}		
			assertEquals(recipe.getName(), RECIPE_NAME);
			assertEquals(recipe.getPrice(), RECIPE_PRICE);
	}
	
	@Test
	void addIngerdients_success() {
		
		try {
			recipe = new Recipe(RECIPE_NAME, RECIPE_PRICE);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		recipe.addIngerdients(INGERDIENT_NAME, INGERDIENT_AMOUNT);
		
		for(String ingr : recipe.getIngredients().keySet()) {
			assertEquals(ingr, INGERDIENT_NAME);
			assertEquals(recipe.getIngredients().get(ingr), INGERDIENT_AMOUNT);
		}
	}

}
