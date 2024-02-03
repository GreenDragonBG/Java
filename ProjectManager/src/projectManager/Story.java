package projectManager;

import java.util.ArrayList;
import java.util.List;

public class Story {
	int id;
	String name;
	Status status;
	int points;
	Employee assignee;
	List<Task> tasks;
	
	public Story(int id, String name, String description, int points,Employee assignee) {
		this.id = id;
		this.name = name;
		status = Status.Waiting;
		this.points = points;
		this.assignee = assignee;
		tasks = new ArrayList<Task>();
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
	
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
	public Employee getAssignee() {
		return assignee;
	}
	public void setAssignee(Employee assignee) {
		this.assignee = assignee;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
