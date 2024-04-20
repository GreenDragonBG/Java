package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import company.SmallSizePackage;

class SmallSizePackageTest {
	SmallSizePackage pack;

	@Test
	void getDeliveryPrice() {
		pack = new SmallSizePackage(1, 3);
		assertTrue(pack.getDeliveryPrice()==3*3);
	}
	
	@Test
	void sizeLimeter_under() {
		pack = new SmallSizePackage(1, -3);
		assertTrue(pack.getSize() == 1);
	}
	
	@Test
	void sizeLimeter_above() {
		pack = new SmallSizePackage(1, 8);
		assertTrue(pack.getSize() == 3);
	}

}
