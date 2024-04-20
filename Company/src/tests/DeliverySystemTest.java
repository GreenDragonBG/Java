package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import company.DeliverySystem;
import company.Role;
import company.User;

class DeliverySystemTest {
	DeliverySystem deliverySystem;
	User administator;
	String newUserUsername;
	String newUserPassword;
	
	@BeforeEach
	void setUp() {
		deliverySystem = new DeliverySystem();
		newUserUsername = "newUser";
		newUserPassword = "342456";
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

}
