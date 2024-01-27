package figureContainer;

public class Rectangle extends Figure{
	Point lowerLeft;
	Point upperRight;
	public Rectangle(Point lowerLeft, Point upperRight) {
		this.lowerLeft = lowerLeft;
		this.upperRight = upperRight;
	}
	public Rectangle(int llX, int llY, int urX, int urY) {
		this.lowerLeft = new Point(llX, llY);
		this.upperRight = new Point(urX, urY);	
	}
	
	@Override
	public double getPerameter() {
		double xSide = (upperRight.getX()-lowerLeft.getX());
		double ySide = (upperRight.getY()-lowerLeft.getY());
		return (2*xSide) +(2*ySide);
	}

	@Override
	public double getArea() {
		double xSide = (upperRight.getX()-lowerLeft.getX());
		double ySide = (upperRight.getY()-lowerLeft.getY());
		return xSide*ySide;
	}
	@Override
	public boolean isPointIn(Point p) {
		if(p.getX()>= lowerLeft.getX() && p.getX() <= upperRight.getX() && p.getY() >= lowerLeft.getY() && p.getY() <= upperRight.getY()) {
			return true;
		}
		return false;
	}
	@Override
	public boolean isPointIn(int x, int y) {
		if(x>= lowerLeft.getX() && x <= upperRight.getX() && y >= lowerLeft.getY() && y <= upperRight.getY()) {
			return true;
		}
		return false;
	}

}
