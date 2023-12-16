package carWash;

import java.io.Console;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception {
		CarWash wash = new CarWash("A026K",6, 1000);
		
		Service exterior=new Service("Exterior wash", (double)100);
		Service interior=new Service("Interior vacuum", 50.60);
		Service windows=new Service("Windows swipe", 26.80);
		
		wash.addService(exterior);
		wash.addService(interior);
		wash.addService(windows);
		
		HashSet<Service> e = new HashSet<Service>();
		e.add(exterior);
		HashSet<Service> i = new HashSet<Service>();
		i.add(interior);
		HashSet<Service> w = new HashSet<Service>();
		w.add(windows);
		HashSet<Service> e_w = new HashSet<Service>();
		e_w.add(exterior); 
		e_w.add(windows); 
		HashSet<Service> e_i = new HashSet<Service>();
		e_i.add(exterior);
		e_i.add(interior);
		HashSet<Service> i_w = new HashSet<Service>();
		i_w.add(interior);
		i_w.add(windows);
		HashSet<Service> e_i_w = new HashSet<Service>();
		e_i_w.add(exterior);
		e_i_w.add(interior);
		e_i_w.add(windows);
		
		
		System.out.println(wash.addOrder(new Car(Manufacturers.MERCEDES_BENZ_AG, "ASD3"), e_i_w));
		System.out.println(wash.addOrder(new Car(Manufacturers.MERCEDES_BENZ_AG, "ASD3"), e_w));
		System.out.println(wash.addOrder(new Truck(Manufacturers.MERCEDES_BENZ_AG, "ASD3"), e_i));
		System.out.println(wash.addOrder(new SUV(Manufacturers.MERCEDES_BENZ_AG, "ASD3"), w));
		

			for(int j =0;j<wash.getActiveOrders().size();) {
				wash.completeOrder(wash.getActiveOrders().get(j).getId());
			}
			
		System.out.println(wash.getOverview());
	
	}
}
