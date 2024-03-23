package company;

public class UserDetails {
	private final int id;
	private String firstName;
	private String lastName;
	private int telephone;
	private User user;
	
	public UserDetails(int id, String firstName, String lastName, int telephone, User user) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.user = user;
	}
}
