package computer_programming_hw;

import java.util.Scanner;

abstract class Shape {
	
	private Shape next;
	public Shape() { next = null;}
	public void setNext(Shape obj) {next = obj;} 
	public Shape getNext() {return next;}
	public abstract void draw();
}

class Line extends Shape {
	
	public void draw() {
		
		 System.out.println("Line");
	}
}

class Rect extends Shape {
	
	public void draw() {
		 System.out.println("Rect");
	}

}
class Circle extends Shape {
	
	public void draw() {
		 System.out.println("Circle");
	}

}

public class Hw6 {

	public static void main(String[] args) {
		
		System.out.println("삽입(1), 삭제(2), 모두보기(3), 종료(4)");
		 Scanner sc = new Scanner(System.in);
		 
		 int choice = 0;
		 choice = sc.nextInt();

		 switch (choice) {
			case 1:	// 삽입
				System.out.print("Line(1), Rect(2), Circle(3)>>");
				int num = sc.nextInt();
				switch(num) {
				case 1:
					System.out.println("Line");
					break;
				case 2:
					System.out.println("Rect");
					break;
				case 3:
					System.out.println("Circle");
					break;
				}
				break;
			case 2:	
				System.out.print("삭제할 도형의 위치>>");
				int num1 = sc.nextInt();
				break;
			case 3:	
				break;
			case 4:
				break;
			
		}
	}
	
}


