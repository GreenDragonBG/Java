package figureContainer;

public class Circle extends Figure{
	Point center;
	int radius;
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = Math.abs(radius);
	}
	
	public Circle(int x , int y, int radius) {
		this.center = new Point(x, y);
		this.radius = radius;
	}
	
	@Override
	public double getPerameter() {
		return 2*Math.PI*radius;
	}

	@Override
	public double getArea() {
		return Math.PI*radius*radius;
	}

	@Override
	public boolean isPointIn(Point p) {
		if(p.getX()>=center.getX()-radius && p.getX()<=center.getX()+radius && p.getY()>=center.getY()-radius && p.getY()<=center.getY()+radius) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isPointIn(int x, int y) {
		if(x>=center.getX()-radius && x<=center.getX()+radius && y>=center.getY()-radius && y<=center.getY()+radius) {
			return true;
		}
		return false;
	}

}
