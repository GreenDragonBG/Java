package figureContainer;

import java.io.Console;

public class Main {

	public static void main(String[] args) {
		Container<Figure> cont = new Container<Figure>();
		cont.getContainer().add(new Rectangle(1,2 , 3,3));
		cont.getContainer().add(new Circle(3,-3 , 3));
		cont.getContainer().add(new Triangle(2,2 ,3,4  ,3,1));
		
		cont.orderDescending();
		for(Figure f : cont.getContainer()) {
			System.out.println(f.getClass());
		}
		
		
	}

}
