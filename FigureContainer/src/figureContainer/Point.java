package figureContainer;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			if(((Point) obj).getX()  ==this.getX() && ((Point) obj).getY()  ==this.getY()) {
				return true;
			}
		}
		return false;
	}
}
