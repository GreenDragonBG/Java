package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import company.BigSizePackage;

class BigSizePackageTest {

	private BigSizePackage pack;
		
	@Test
	void getDeliveryPrice() {
		pack = new BigSizePackage(1,7);
		assertTrue(pack.getDeliveryPrice()==7*5);
	}
	
	@Test
	void sizeLimeter_under() {
		pack = new BigSizePackage(1,3);
		assertTrue(pack.getSize()==7);
	}
	
	@Test
	void sizeLimeter_above() {
		pack = new BigSizePackage(1,14);
		assertTrue(pack.getSize()==9);
	}


}
