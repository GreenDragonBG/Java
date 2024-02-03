package projectManager;

public class Employee {
	int id;
	String firstName;
	String lastName;
	EmployeePosition position;
	
	public Employee(int id, String firstName, String lastName, EmployeePosition position) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		
	}
	
	public static enum EmployeePosition {
		Developer,
		QA,
		PO
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public EmployeePosition getPosition() {
		return position;
	}
	public void setPosition(EmployeePosition position) {
		this.position = position;
	}
}
