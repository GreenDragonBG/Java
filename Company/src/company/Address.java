package company;

public class Address {
	private final int id;
	private String country;
	private String city;
	private String street;
	private int userId;
	
	public Address(int id, String country, String city, String street, int userId) {
		this.id = id;
		this.country = country;
		this.city = city;
		this.street = street;
		this.userId = userId;
	}
}
