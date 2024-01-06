package Main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WeaponTest {
	static final String WEAPON_NAME ="Weapon1";
	static final int WEAPON_DAMAGE =10;
	Weapon weapon;
	@Test
	void WeaponCreation() {
		weapon = new Weapon(WEAPON_NAME, WEAPON_DAMAGE);
		assertEquals(weapon.getName(),WEAPON_NAME);
		assertEquals(weapon.getDamage(),WEAPON_DAMAGE);
	}

}
