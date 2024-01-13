package carWash;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarWashTest {
	String CAR_WASH_ID = "S2aB1";
	int CAR_WASH_SLOTS = 5;
	double CAR_WASH_CASH = 1000;
	CarWash carWash;
	Automobile automobile;
	Service service;
	HashSet<Service> services;

	@BeforeEach
	void setUp() {
		carWash = new CarWash(CAR_WASH_ID, CAR_WASH_SLOTS, CAR_WASH_CASH);
		automobile = new Car(Manufacturers.FORD_MOTOR_CO, "ASD3");
		service = new Service("service1", 19.99);
		services = new HashSet<Service>();
		
	}

	@Test
	void addService_success() {
		carWash.addService(service);
		assertTrue(carWash.getServices().get(service.getName()) == service.getPrice());
	}

	@Test
	void addOrder_existingService() throws Exception {
		services.add(service);

		carWash.addService(service);
		carWash.addOrder(automobile, services);

		assertTrue(carWash.getActiveOrders().get(0).getAutomobile().equals(automobile));
		assertTrue(carWash.getActiveOrders().get(0).getServices().equals(services));
	}

	@Test
	void addOrder_noService() throws Exception {
		carWash.addService(service);
		assertThrows(Exception.class, () -> {
			carWash.addOrder(automobile, services);
		});

	}
	
	@Test
	void addOrder_notExistingService() throws Exception {
		services.add(service);

		carWash.addService(new Service("service2", 24.99));
		assertThrows(Exception.class, () -> {
			carWash.addOrder(automobile, services);
		});

	}
	
	@Test
	void addOrder_notEnoughSlots() throws Exception {
		services.add(service);

		carWash.addService(service);
		for(int i =1;i<=CAR_WASH_SLOTS;i++) {
			carWash.addOrder(automobile, services);
		}
		assertThrows(Exception.class, () -> {
			carWash.addOrder(automobile, services);
		});
	}
	
	@Test
	void completeOrder_existingID() throws Exception {
		services.add(service);
		carWash.addService(service);
		carWash.addOrder(automobile, services);
		
		carWash.completeOrder(carWash.getActiveOrders().get(0).getId());
		
		assertTrue(carWash.getActiveOrders().isEmpty());
		assertTrue(carWash.getCompletedOrders().get(0).getAutomobile().equals(automobile));
		assertTrue(carWash.getCompletedOrders().get(0).getServices().equals(services));
		
	}
	@Test
	void completeOrder_notExistingID() throws Exception {
		services.add(service);
		carWash.addService(service);
		carWash.addOrder(automobile, services);
		
		assertThrows(Exception.class, () -> {
			carWash.completeOrder(-1045);
		});
	}
}
