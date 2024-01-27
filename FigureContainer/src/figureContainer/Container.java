package figureContainer;

import java.util.ArrayList;
import java.util.List;

public class Container<E extends Figure> {
	private List<E> container;
	
	public Container(){
		container = new ArrayList<E>();
	} 
	
	public List<E> getContainer() {
		return container;
	}
	public E get(int index) {
		return container.get(index);
	}
	
	public List<E> getAllByArea(double area){
		
		List<E> figures  = new ArrayList<E>() {};
		
		for(E figure : container) {
			if(figure.getArea() == area) {
				figures.add(figure);
			}
		}
		return figures;
	}
	
	public double getTotalArea() {
		double total = 0;
		for(E figure : container) {
			total+= figure.getArea();
		}
		return total;
	}
	
	public List<E> getAllContaining(Point p){
		
		List<E> figures  = new ArrayList<E>() {};
		
		for(E figure : container) {
			
			if(figure.isPointIn(p)) {
				figures.add(figure);
			}
		}
		
		return figures;
	}
	
	public E getBiggest() {
		double biggestArea = -1;
		E biggestFigure = (E) new Circle(1, 2, 3);
		for(E figure : container) {
			
			if(figure.getArea()>biggestArea) {
				biggestArea = figure.getArea();
				biggestFigure = figure;
			}
		}
		return biggestFigure;
	}
	
	public E getSmallest() {
		double smallestArea = getTotalArea();
		E smallestFigure = (E) new Circle(1, 2, 3);
		for(E figure : container) {
			
			if(figure.getArea()<smallestArea) {
				smallestArea = figure.getArea();
				smallestFigure = figure;
			}
		}
		return smallestFigure;
	}
	
	public void orderDescending() {
		for(int i =0;i<container.size();i++) {
			for(int j=0;j<container.size();j++) {
				if(container.get(i).getArea()>container.get(j).getArea()) {
					E temp = container.get(i);
					container.set(i, container.get(j));
					container.set(j, temp);
				}
			}
		}
	}
	

}
