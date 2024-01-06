package Main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PotionTest {
	static final String POTION_NAME ="Potion1";
	Potion potion;
	
	@Test
	void PotionCreation() {
		potion = new Potion(POTION_NAME);
		assertEquals(potion.getName(), POTION_NAME);
	}

}
