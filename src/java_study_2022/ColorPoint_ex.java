package java_study_2022;

import java.util.Scanner;

class Point{
	private double a,b;
	
	void set(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public void xy_express(){
		System.out.println(a + "," + b);
	}
}

class Color extends Point{
	private String color;	
	
	void setcolor(String color) {
		this.color = color;
	}
	
	void color_express() {
		System.out.print(color);
		xy_express();
	}
}

public class ColorPoint_ex {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("��ǥ�� �Է��ϼ���");
		int x,y;
		x = s.nextInt();
		y = s.nextInt();		
		Point p = new Point();
		p.set(x, y);
		p.xy_express();
		
		
		System.out.println("���� �Է��Ͻÿ�");
		Color c = new Color();
		String color;
		color = s.next();
		c.set(x, y);
		c.setcolor(color);
		c.color_express();
	}

}
