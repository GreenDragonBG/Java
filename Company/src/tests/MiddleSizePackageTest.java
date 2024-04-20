package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import company.BigSizePackage;
import company.MiddleSizePackage;

class MiddleSizePackageTest {
	private MiddleSizePackage pack;
	
	@Test
	void GgetDeliveryPrice() {
		pack = new MiddleSizePackage(1, 5);
		assertTrue(pack.getDeliveryPrice()== 5*4);
	}
	
	@Test
	void sizeLimeter_under() {
		pack = new MiddleSizePackage(1, 1);
		assertTrue(pack.getSize()==4);
	}
	
	@Test
	void sizeLimeter_above() {
		pack = new MiddleSizePackage(1, 8);
		assertTrue(pack.getSize()==6);
	}

}
