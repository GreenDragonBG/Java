package projectManager;

import java.util.ArrayList;
import java.util.List;

public class Project {
	List<Epic> epics;
	
	public Project() {
		this.epics = new ArrayList<Epic>();
	}
	
	public List<Epic> getEpics() {
		return epics;
	}
	public void setEpics(List<Epic> epics) {
		this.epics = epics;
	}
}
