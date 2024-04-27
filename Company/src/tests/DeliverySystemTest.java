package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import company.Address;
import company.DeliverySystem;
import company.Order;
import company.Package;
import company.Role;
import company.SmallSizePackage;
import company.Status;
import company.User;

class DeliverySystemTest {
	DeliverySystem deliverySystem;
	User administator;
	String newUserUsername;
	String newUserPassword;
	Address address_true;
	Address address_false;
	Order order;
	Package pack;
	
	@BeforeEach
	void setUp() {
		deliverySystem = new DeliverySystem();
		newUserUsername = "newUser";
		newUserPassword = "342456";
	}
	
	void addressSetUp(User user) {
		address_true = new Address(12, "Country1", "City1", "Street1", user.getId());
		address_false = new Address(11, "Country2", "City2", "Street2",user.getId()-10);
	}
	void orderSetUp(Address address) {
		order = new Order(0, address.getId(), Status.CREATED);
	}

	@Test
	void login_success() {
		deliverySystem.login("admin", "admin123");
		assertTrue(deliverySystem.getCurrentUser()!=null);
	}
	@Test
	void login_fail() {
		assertThrows(RuntimeException.class,() -> deliverySystem.login("nonExistingUser", "nonExistingPass"));
	}
	
	@Test
	void logout() {
		login_success();
		deliverySystem.logout();
		assertTrue(deliverySystem.getCurrentUser()==null);
	}
	
	@Test
	void registerUser_success() {
		login_success();
		deliverySystem.registerUser(newUserUsername, newUserPassword);
		assertTrue(deliverySystem.getUsers().containsKey(newUserUsername));
	}
	
	@Test
	void registerUser_fail_UserAlreadyExists() {
		registerUser_success();
		assertThrows(RuntimeException.class, () ->deliverySystem.registerUser(newUserUsername, newUserPassword));
	}
	
	@Test
	void registerUser_fail_CurrentUserNotAnAdmin() {
		registerUser_success();
		deliverySystem.login(newUserUsername, newUserPassword);
		assertThrows(RuntimeException.class,() -> deliverySystem.registerUser("thirdUser","thirdPassword3"));
	}
	
	@Test
	void registerDriver_success() {
		login_success();
		deliverySystem.registerDriver(newUserUsername, newUserPassword);
		assertTrue(deliverySystem.getUsers().containsKey(newUserUsername));
		assertTrue(deliverySystem.getUsers().get(newUserUsername).getRole().equals(Role.DRIVER));
		
	}
	
	@Test
	void registerDriver_fail_UserAlreadyExists() {
		registerDriver_success();
		assertThrows(RuntimeException.class, () ->deliverySystem.registerDriver(newUserUsername, newUserPassword));	
	}
	
	@Test
	void registerDriver_fail_CurrentUserNotAnAdmin() {
		registerUser_success();
		deliverySystem.login(newUserUsername, newUserPassword);
		assertThrows(RuntimeException.class,() -> deliverySystem.registerDriver("thirdUser","thirdPassword3"));
	}
	
	@Test
	void addAddress_success() {
		registerUser_success();
		deliverySystem.login(newUserUsername, newUserPassword);
		addressSetUp(deliverySystem.getCurrentUser());
		deliverySystem.addAddress(address_true);
		assertTrue(!deliverySystem.getAddresses().isEmpty());
	}
	
	@Test
	void addAddress_fail_CurrentUserNotCustomer() {
		registerUser_success();
		addressSetUp(deliverySystem.getCurrentUser());
		assertThrows(RuntimeException.class,() -> deliverySystem.addAddress(address_true));
	}
	
	@Test
	void addAddress_fail_addressIsNotCurrentUsers() {
		registerUser_success();
		deliverySystem.login(newUserUsername, newUserPassword);
		addressSetUp(deliverySystem.getCurrentUser());
		assertThrows(RuntimeException.class,() -> deliverySystem.addAddress(address_false));
	}
	
	@Test
	void addOrder_success() {
		addAddress_success();
		orderSetUp(address_true);
		deliverySystem.addOrder(order);
		assertTrue(!deliverySystem.getOrders().isEmpty());
	}
	
	@Test
	void addOrder_fail_CurrentUserNotCustomer() {
		addAddress_success();
		orderSetUp(address_true);
		login_success();
		assertThrows(RuntimeException.class, () -> deliverySystem.addOrder(order));
	}
	
	@Test
	void addOrder_fail_orderAddressIsntCurrentUsers() {
		addAddress_success();
		orderSetUp(address_false);
		assertThrows(RuntimeException.class, () -> deliverySystem.addOrder(order));
	}

	@Test
	void addPackage_success() {
		addOrder_success();
		deliverySystem.addPackage(new SmallSizePackage(1, 2), order.getId());
		assertTrue(!order.getPackages().isEmpty());
	}
	
	@Test
	void addPackage_fail_CurrentUserNotCustomer() {
		addOrder_success();
		login_success();
		assertThrows(RuntimeException.class,() -> deliverySystem.addPackage(new SmallSizePackage(1, 2), order.getId()));
	}
	
	@Test
	void addPackage_fail_orderIsntCurrentUsers() {
		addOrder_success();
		assertThrows(RuntimeException.class,() -> deliverySystem.addPackage(new SmallSizePackage(1, 2), order.getId()-10));
	}
	
	@Test
	void getOrderToDeliver_Random_success() {
		addPackage_success();
		deliverySystem.getOrderToDeliver();
		assertTrue(order.getStatus().equals(Status.DELIVERING));
	}
	
	@Test
	void getOrderToDeliver_Random_fail_NoOrdersToStartDelivering() {
		getOrderToDeliver_Random_success();
		assertThrows(RuntimeException.class, () -> deliverySystem.getOrderToDeliver());
	}
	
	@Test
	void getOrderToDeliver_success() {
		addPackage_success();
		deliverySystem.getOrderToDeliver(order.getId());
		assertTrue(order.getStatus().equals(Status.DELIVERING));
	}
	
	@Test
	void getOrderToDeliver_fail_NoOrdersToStartDelivering() {
		getOrderToDeliver_success();
		assertThrows(RuntimeException.class, () -> deliverySystem.getOrderToDeliver(order.getId()));
	}
	
	@Test
	void deliverOrder_success() {
		getOrderToDeliver_success();
		deliverySystem.deliverOrder(order.getId());
		assertTrue(order.getStatus().equals(Status.DELIVERED));
	}
	
	@Test
	void deliverOrder_NoDeliveringOrdersAtTheMoment() {
		deliverOrder_success();
		assertThrows(RuntimeException.class, () -> deliverySystem.deliverOrder(order.getId()));
	}
	
}
