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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}
	
}
