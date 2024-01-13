package Main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HeroTest {
	// String name, Classes type
	static final String HERO_NAME = "HERO1";
	static final Classes HERO_TYPE = Classes.ROGUE;
	Hero hero;

	@BeforeEach
	void startUp() {
		hero = new Hero(HERO_NAME, HERO_TYPE);
	}

	@Test
	void equipItem_Weapon_enoughSpace() throws Exception {
		Weapon weapon = new Weapon("Weapon1", 15);
			hero.equipItem(weapon);
			assertEquals(hero.getWeapons()[0],weapon);
	}

	@Test
	void equipItem_Weapon_notEnoughSpace() {
		Weapon weapon = new Weapon("Weapon1", 15);
		try {
			for(int i =0;i<hero.WeponSlots;i++) {
				hero.equipItem(weapon);
			}

			hero.equipItem(weapon);
			assertTrue(false);

		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	void equipItem_Armour_enoughSpace() throws Exception {
		Armour armour = new Armour("Armour1", 10);
			hero.equipItem(armour);
			assertEquals(hero.getArmour()[0], armour);
	}
	
	@Test
	void equipItem_Armour_notEnoughSpace() {
		Armour armour = new Armour("Armour1", 10);
		try {
			for(int i =0;i<hero.ArmourSlots;i++) {	
				hero.equipItem(armour);
			}

			hero.equipItem(armour);
			assertTrue(false);

		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	void equipItem_Potion_enoughSpace() throws Exception {
		Potion potion = new Potion("Potion1");
			hero.equipItem(potion);
			assertEquals(hero.getPotions()[0], potion);
	}
	
	@Test
	void equipItem_Potion_notEnoughSpace() {
		Potion potion = new Potion("Potion1");
		try {
			for(int i =0;i<hero.PotionSlots;i++) {	
				hero.equipItem(potion);
			}

			hero.equipItem(potion);
			assertTrue(false);

		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	@Test
	void pickUpItem() throws Exception {
		Item item = new Item("Item1") {};
			hero.pickUpItem(item);
			assertEquals(hero.getBag().getSlots()[0],item);
	}

}
