package gasStation;

public class Main {
	public static void main(String[] args) {
		GasStation gs = new GasStation();
		Product gas = new Product(0.5, 21, "l.", gs.getFuel());
		gs.getBasket().put(gas, 51);
		gs.getDiscounts().add(new Discount<Items>("50l. gas", 0, 10, true,gs.getBasket().containsKey(gas)));
		gs.chekout();
	}
}
