package vendingMachine;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static vendingMachine.CoffeeVendingMachine.CAPACITY;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeVendingMachineTest {

	private static final int COFEE_AMOUNT = 50;
	private static final int RECIPE_PRICE = 10;
	private static final String COFEE_INGREDIENT = "cofee";
	private CoffeeVendingMachine machine;

	@BeforeEach
	void setUp() {
		machine = new CoffeeVendingMachine(Set.of(COFEE_INGREDIENT));
	}

	@Test
	void resupplyContainer_existingContainer_containerResuplied() {
		// Set up for the test
		machine.containers.put(COFEE_INGREDIENT, 200);

		// execution
		machine.resupplyContainer(COFEE_INGREDIENT);

		// validation
		int result = machine.getIngerdientSupply(COFEE_INGREDIENT);
		assertEquals(CAPACITY, result);
	}

	@Test
	void resupplyContainer_notExistingContainer_containerResuplied() {
		assertThrows(RuntimeException.class, () -> {
			machine.resupplyContainer("milk");
		});
	}

	@Test
	void brewRecipe_validRecipe_recipeBrewed() throws Exception {
		Recipe recipe = new Recipe("espresso", RECIPE_PRICE);
		recipe.addIngerdients(COFEE_INGREDIENT, COFEE_AMOUNT);

		machine.brewRecipe(recipe);

		assertEquals(CAPACITY - COFEE_AMOUNT, machine.getIngerdientSupply(COFEE_INGREDIENT));
		assertEquals(RECIPE_PRICE, machine.getTurnover());

	}

	@Test
	void brewRecipe_notExistingIngerdient_exception() throws Exception {
		Recipe recipe = new Recipe("espresso", RECIPE_PRICE);
		recipe.addIngerdients("milk", ThreadLocalRandom.current().nextInt());

		RuntimeException thrownException = assertThrows(RuntimeException.class, () -> {
			machine.brewRecipe(recipe);
		});

		assertEquals(RuntimeException.class, thrownException.getClass());
		assertEquals("There is no container with this ingredient", thrownException.getMessage());
	}

	@Test
	void brewRecipe_notEnoughIngerdient_exception() throws Exception {
		Recipe recipe = new Recipe("espresso", RECIPE_PRICE);
		recipe.addIngerdients(COFEE_INGREDIENT, COFEE_AMOUNT);
		machine.containers.put(COFEE_INGREDIENT, COFEE_AMOUNT - 15);

		assertThrows(RuntimeException.class, () -> {
			machine.brewRecipe(recipe);
		});
	}

	@Test
	void getIngerdientSupply_notExistingIngredient_exception() {
		assertThrows(RuntimeException.class, () -> {
			machine.getIngerdientSupply("milk");
		});

	}

	@Test
	void resupply_allContainerAreFull() {
		machine.containers.put("milk", 20);

		machine.resupply();

		assertEquals(CAPACITY, machine.getIngerdientSupply(COFEE_INGREDIENT));
		assertEquals(CAPACITY, machine.getIngerdientSupply("milk"));
	}

	@AfterEach
	void tearDown() {

	}

}
