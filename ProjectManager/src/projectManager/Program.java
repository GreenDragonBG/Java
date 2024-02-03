package projectManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Program {
	Map<Employee, Project> employees;
	
	public Program() {
		this.employees = new HashMap<Employee, Project>(); 
	}
	
	public List<Story> getAllStories(Status status){
		
		List<Story> output = new ArrayList<Story>();
		
		for(Employee e : employees.keySet()) {
			
			List<List<Story>> current = employees.get(e).getEpics().stream()
			.map(epic -> epic.getStories())
			.collect(Collectors.toList());
			
			for(List<Story> list : current) {
				list.stream()
				.filter(story -> story.status.equals(status))
				.forEach(s -> output.add(s));
			}
			
		}
		
		return output;
	}
	
	public List<Story> getAllStories(Status status, int epicId){
		
		List<Story> output = new ArrayList<Story>();
		
		for(Employee e : employees.keySet()) {
			
			List<List<Story>> current = employees.get(e).getEpics().stream()
			.filter(epic -> epic.getId()== epicId)
			.map(epic -> epic.getStories())
			.collect(Collectors.toList());
			
			for(List<Story> list : current) {
				list.stream().filter(story -> story.status.equals(status)).forEach(s -> output.add(s));
			}
			
		}
		
		return output;
	}

	public Map<Status, Map<Epic, List<Story>>> getAllStoriesByEpicByStatus (){
		 Map<Status, Map<Epic, List<Story>>> output = new HashMap<Status, Map<Epic,List<Story>>>();
		 
		 for(Status status : Status.values()) {
			 Map<Epic, List<Story>> current = new HashMap<Epic, List<Story>>();
			 for(Employee empl : employees.keySet()) {
				 for(Epic epic : employees.get(empl).getEpics()) {
					 current.put(epic, epic.getStories().stream()
							 			.filter(s -> s.getStatus().equals(status))
							 			.collect(Collectors.toList()));
					 
				 }
			 }
			 output.put(status, current);
		 }
		 return output;
	}
	
} 
