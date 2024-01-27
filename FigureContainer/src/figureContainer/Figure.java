package figureContainer;

public abstract class Figure {

	public abstract double getPerameter();
	public abstract double getArea();
	public abstract boolean isPointIn(Point p);
	public abstract boolean isPointIn(int x, int y);
}
