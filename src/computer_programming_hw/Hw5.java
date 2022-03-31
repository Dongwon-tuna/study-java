package computer_programming_hw;

class Point{
	private int x,y;
	
	void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	protected void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class ColorPoint extends Point{
	private String x;
	
	public ColorPoint(int x, int y) {
		
	}
	
	void setColor(String x) {
		this.x = x;
	}
	
	String tostring() {
		return x;
	}
	
		
}


public class Hw5 {

	public static void main(String[] args) {
		//ColorPoint zeroPoint = new ColorPoint();
		//System.out.println(zeroPoint.toString());
		
		ColorPoint cp = new ColorPoint(5,5);
		cp.setXY(5, 5);
		cp.setColor("RED");
		System.out.println( "¿‘¥œ¥Ÿ");

	}

}
