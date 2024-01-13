package carWash;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringJoiner;

public class CarWash {
	private String id;
	private int slots;
	private double cash;
	private List<Order> activeOrders;
	private List<Order> completedOrders;
	private HashMap<String, Double> services;

	public CarWash(String id, int slots, double cash) {
		this.id = id;
		this.slots = slots;
		this.cash = cash;
		this.activeOrders = new ArrayList<Order>();
		this.completedOrders = new ArrayList<Order>();
		this.services = new HashMap<String, Double>();
	}

	public void addService(Service service) {
		this.services.put(service.getName(), service.getPrice());
	}

	public int addOrder(Automobile automobile, Set<Service> services) throws Exception {

		boolean doExeption = true;
		for (Service s : services) {
			for (String name : this.services.keySet()) {
				if (s.getName().equals(name)) {
					doExeption = false;
				}
			}
		}
		if (doExeption) {
			throw new Exception("Service isnt offered!");
		}
		if (!(activeOrders.size() < slots)) {
			throw new Exception("Out of slots!");
		}
		Order temp = new Order(automobile, services);
		activeOrders.add(temp);
		return temp.getId();

	}

	public void completeOrder(int id) throws Exception{	
		boolean doException = true;
		for (int i = 0; i < activeOrders.size(); i++) {
			if ((int)activeOrders.get(i).getId() == id) {
				doException = false;
				for (Service s : activeOrders.get(i).getServices()) {
						this.cash += s.getPrice() * activeOrders.get(i).getAutomobile().getPriceMultiplayer();
				}
			}

				completedOrders.add(activeOrders.get(i));
				activeOrders.remove(i);
		}
		if(doException) {
			throw new Exception("No such ID");
		}
	}

	public String getOverview() {
		StringJoiner output = new StringJoiner("\n");
		int car = 0;
		int suv = 0;
		int truck = 0;
		for(String name : services.keySet()) {
			car = 0;
			suv = 0;
			truck = 0;
			for(Order order : completedOrders) {
				for(Service service : order.getServices()) {
					if(order.getAutomobile() instanceof Car && service.getName() == name) {
						car++;
					}else if(order.getAutomobile() instanceof SUV && service.getName() == name) {
						suv++;
					}else if(order.getAutomobile() instanceof Truck && service.getName() == name) {
						truck++;
					}
				}
			}
			int sum = car + suv + truck;
			output.add("  "+name+" - " + sum);
			output.add("Car - " + car);
			output.add("SUV - " + suv);
			output.add("Truck - " + truck);
			output.add("");
		}
		
		return output.toString();
	}

	public HashMap<String, Double> getServices() {
		return services;
	}
	
	public List<Order> getActiveOrders() {
		return activeOrders;
	}
	
	public List<Order> getCompletedOrders() {
		return completedOrders;
	}
}
