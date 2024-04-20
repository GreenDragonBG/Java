package company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

public class DeliverySystem {
	private Map<String, User> users;
	private List<Order> orders;
	private List<Address> addresses;
	private User currentUser;
	
	public DeliverySystem() {
		this.users = new HashMap<String,User>() {};
		this.users.put("admin", new User("admin", "admin123", Role.ADMINISTRATOR));
		this.orders = new ArrayList<Order>() {};
		this.addresses = new ArrayList<Address>() {};
		this.currentUser = null;
	}
	
	public void login(String username, String password){
		if(users.containsKey(username) && users.get(username).getPassword().equals(password)) {
			setCurrentUser(users.get(username));
		}else {
			throw new RuntimeException("No such user");
		}
	}
	
	public void logout() {
		this.currentUser = null;
	}
	
	public void registerUser(String username, String password) {
		if(getCurrentUser().getRole()==Role.ADMINISTRATOR && !users.containsKey(username)) {
				users.put(username, new User(username, password, Role.CUSTOMER));
		}else {
			throw new RuntimeException("You are not a Administrator or the username has been already used!");
		}
	}
	
	public void registerDriver(String username, String password) {
		if(getCurrentUser().getRole()==Role.ADMINISTRATOR && !users.containsKey(username)) {
			users.put(username, new User(username, password, Role.DRIVER));
	}else {
		throw new RuntimeException("You are not a Administrator or the username has been already used!");
	}
	}
	
	public void addAddress(Address address) {
		if(getCurrentUser().getRole()==Role.CUSTOMER && address.getUserId()==getCurrentUser().getId()) {
			getAddresses().add(address);
	}else {
		throw new RuntimeException("You are not a Customer or the user is not current user!");
	}
	}
	
	public void addOrder (Order order) {
		if(getCurrentUser().getRole()==Role.CUSTOMER) {
				

		}else {
		throw new RuntimeException("You are not a Customer or the user is not current user!");
	}
	}
	
	
	
	
	

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	
	
}
