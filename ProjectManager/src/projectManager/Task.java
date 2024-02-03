package projectManager;

import java.util.ArrayList;

public class Task {
	int id;
	String name;
	Status status;
	Employee assignee;
	
	public Task(int id, String name, String description,Employee assignee) {
		this.id = id;
		this.name = name;
		status = Status.Waiting;
		this.assignee = assignee;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Employee getAssignee() {
		return assignee;
	}
	public void setAssignee(Employee assignee) {
		this.assignee = assignee;
	}
}
