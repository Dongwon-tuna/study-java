package java_study_2022;

class Shape{
	public Shape next;
	public Shape() {next = null;}

	public void draw1() {
		System.out.println("Shape");
	}
}

class Line extends Shape{
	public void draw1() {
		System.out.println("Line");
	}
}

class Rect extends Shape{
	public void draw1() {
		System.out.println("Rect");
	}
}

class Circle extends Shape{
	public void draw1() {
		System.out.println("Circle");
	}
}


public class Overriding {
	
	static void paint(Shape p) {
		p.draw1();
	}

	public static void main(String[] args) {
		Line line =new Line();
		
		paint(line);
		
		paint(new Shape());
		
		Shape start, last, obj;
		
		start = new Line();
		last = start;
		obj = new Rect();
		last.next = obj;

	}

}
