package figureContainer;

public class Triangle extends Figure{
	Point a;
	Point b; 
	Point c;
	
	public Triangle(Point a , Point b , Point c) {
		this.a = a;
		this.b = b; 
		this.c = c;
	}
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.a = new Point(x1, y1);
		this.b = new Point(x2, y2);
		this.c = new Point(x3, y3);
	}
	@Override
	public double getPerameter() {
		int abX = b.getX()-a.getX();
		int abY = b.getY()-a.getY();
		double ab = Math.sqrt(abX*abX - abY*abY);
		
		int bcX = c.getX()-b.getX();
		int bcY = c.getY()-b.getY();
		double bc = Math.sqrt(bcX*bcX - bcY*bcY);
		
		int caX = a.getX()-c.getX();
		int caY = a.getY()-c.getY();
		double ca = Math.sqrt(caX*caX - caY*caY);
		
		return ab+bc+ca;
	}
	public double calculateAreaOfTriangle(int x1 , int y1, int x2, int y2, int x3, int y3) {
		
		int aSide = x1*(y2-y3);
		int bSide = x2*(y3-y1);
		int cSide = x3*(y1-y2);
		
		return Math.abs(aSide+bSide+cSide) * 0.5;
	}
	
	public double calculateAreaOfTriangle(Point p1 , Point p2, Point p3) {
		
		int aSide = p1.getX()*(p2.getY()-p3.getY());
		int bSide = p2.getX()*(p3.getY()-p1.getY());
		int cSide = p3.getX()*(p1.getY()-p2.getY());
		
		return Math.abs(aSide+bSide+cSide) * 0.5;
	}
	@Override
	public double getArea() {
		return calculateAreaOfTriangle(this.a, this.b, this.c);
	}
	@Override
	public boolean isPointIn(Point p) {
		double pab = calculateAreaOfTriangle(p, a, b);
		double pbc = calculateAreaOfTriangle(p, b, c);
		double pac = calculateAreaOfTriangle(p, a, c);
		
		if(getArea() == (pab+pbc+pac)) {
			return true;
		}
		return false;
	}
	@Override
	public boolean isPointIn(int x, int y) {
		Point p = new Point(x, y);
		
		double pab = calculateAreaOfTriangle(p, a, b);
		double pbc = calculateAreaOfTriangle(p, b, c);
		double pac = calculateAreaOfTriangle(p, a, c);
		
		if(getArea() == (pab+pbc+pac)) {
			return true;
		}
		return false;
	}

}
