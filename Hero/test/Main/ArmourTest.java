package Main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArmourTest {
	Armour armour;
	static final String ARMOUR_NAME = "Armour1";
	static final int  ARMOUR_DEFENCE = 5;
	@Test
	void ArmourCreation() {
		armour = new Armour(ARMOUR_NAME, ARMOUR_DEFENCE);
		assertEquals(armour.getName(), ARMOUR_NAME);
		assertEquals(armour.getDefence(), ARMOUR_DEFENCE);
	}

}
