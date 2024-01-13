package Main;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import junit.framework.AssertionFailedError;

class BagTest {
	static final String BAG_NAME="Bag1";
	static final String ITEM_NAME="Item1";
	Bag bag;
	Item item;
	@BeforeEach
	void Setup() {
		bag = new Bag(BAG_NAME);
		item = new Item(ITEM_NAME) {};
	}
	@Test
	void add_enoughSpaceInFirstBag() throws Exception {
			bag.add(item);
			assertTrue(bag.getSlots()[0].equals(item));
	}
	@Test
	void add_notEnoughSpaceInFirstBag_hasBagInBag() throws Exception {
			
			for(int i =0;i<5;i++) {
				bag.add(item);
			}
			Bag bag2 = new Bag("Bag2");
			bag.add(bag2);
			
			bag.add(item);
			assertTrue(bag.getSlots()[bag.getSlots().length-1].equals(bag2));
			assertTrue(bag2.getSlots()[0].equals(bag2));
	}
	
	@Test
	void add_notEnoughSpaceInBag() {
		try {
			for(int i =0;i<6;i++) {
				bag.add(item);
			}
			bag.add(item);
			assertFalse(true);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

}
