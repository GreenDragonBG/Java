package carWash;


import java.util.Random;
import java.util.Set;

public class Order {
	private int id;
	private Automobile automobile;
	private Set<Service> services;
	private Random rand;

	public Order(Automobile automobile,Set<Service> services) {
		rand = new Random();
		id = (int)rand.hashCode();
		this.automobile = automobile;
		this.services = services;
	}
	public int getId() {
		return id;
	}
	public Automobile getAutomobile() {
		return automobile;
	}
	
	public Set<Service> getServices() {
		return services;
	}

}
