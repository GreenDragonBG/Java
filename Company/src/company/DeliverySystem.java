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
		if(getCurrentUser().getRole()==Role.CUSTOMER && addresses.stream().filter(a -> a.getUserId()==getCurrentUser().getId()).findFirst().get().getId()==order.getAddressId()) {
				order.setStatus(Status.CREATED);
				orders.add(order);
		}else {
		throw new RuntimeException("You are not a Customer or the address is wrong!");
	}
	}
	
	public void addPackage(Package pack, int orderId) {
		if(getCurrentUser().getRole()==Role.CUSTOMER && orders.stream().filter(o -> o.getAddressId()== addresses.stream().filter(a->a.getUserId()==getCurrentUser().getId()).findFirst().get().getId()).findFirst().get().getId()==orderId) {
			
			orders.stream().filter(o->o.getId()==orderId).findFirst().get().getPackages().add(pack);
		}else {
			throw new RuntimeException("You are not a Customer or the order ID is wrong!");
		}
	}
	
	public void getOrderToDeliver(){
		if(orders.stream().filter(o -> o.getAddressId()== addresses.stream().filter(a->a.getUserId()==getCurrentUser().getId()).findFirst().get().getId()).anyMatch(o-> o.getStatus().equals(Status.CREATED))) {
			orders.stream().filter(o -> o.getAddressId()== addresses.stream().filter(a->a.getUserId()==getCurrentUser().getId()).findFirst().get().getId()).filter(o->o.getStatus().equals(Status.CREATED)).findAny().get().setStatus(Status.DELIVERING);
		}else {
			throw new RuntimeException("There are no current orders for this user that are not beeing delivered or you are not a Customer");
		}
		
	}
	
	public void getOrderToDeliver(int id){
		if( orders.stream().filter(o-> o.getStatus().equals(Status.CREATED)).anyMatch(o->o.getId()==id)) {
			orders.stream().filter(o-> o.getStatus().equals(Status.CREATED)).filter(o->o.getId()==id).findFirst().get().setStatus(Status.DELIVERING);
		}else {
			throw new RuntimeException("There are no current orders for this user that are not beeing delivered or you are not a Customer");
		}	
	}

	public void deliverOrder(int id) {
		if(orders.stream().filter(o-> o.getStatus().equals(Status.DELIVERING)).anyMatch(o->o.getId()==id)) {
			orders.stream().filter(o-> o.getStatus().equals(Status.DELIVERING)).filter(o->o.getId()==id).findFirst().get().setStatus(Status.DELIVERED);
		}else {
			throw new RuntimeException("There are no current orders for this user that are not delivered or you are not a Customer");
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
