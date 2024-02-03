package projectManager;

import java.util.ArrayList;
import java.util.List;

public class Epic {
	int id;
	String name;
	Status status;
	List<Story> stories;
	
	public Epic(int id, String name) {
		this.id = id;
		this.name = name;
		status = Status.Waiting;
		stories = new ArrayList<Story>();
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
	
	public List<Story> getStories() {
		return stories;
	}
	public void setStories(List<Story> stories) {
		this.stories = stories;
	}
	
}
