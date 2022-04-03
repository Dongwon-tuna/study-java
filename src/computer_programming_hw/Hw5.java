package computer_programming_hw;

class Point{
	int x,y;
	
	Point(){};
	
	public Point(int x, int y) {//x��y�� ��ǥ�� �Է¹޴� ������.
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	protected void move(int x, int y) {//��ӵǴ� Ŭ�������� ��� ������ �Լ�.
		this.x = x;
		this.y = y;
	}
}

class ColorPoint extends Point{
	String color;
	public ColorPoint() { // ó�� 0,0�� ���� ���� �����ϰ� ������ ������.
		this(0,0);
	}
	
	public ColorPoint(int x, int y) {
	
		super(x,y);//�θ� Ŭ������ xy�� ���� ����.
		color = "Black";//�⺻���� ������ ��������.
	}
	
	public void setXY(int x, int y) {//move�Լ��� ����Ͽ� ������ 0,0���� �ٸ� ��ǥ�� �����Ҷ� ��� �Ǵ� �Լ�
		move(x,y);
	}
	
	public String setColor(String color) {
		this.color =color;
		return this.color;
	}
	
	public String toString(){//��ǥ�� ���� ������ �˷��ִ� �Լ�
		String xx = color +"����" + "(" + this.x +","+ this.y +")" +"�� ��";
		return xx;
	} 
}
public class Hw5 {

	public static void main(String[] args) {
		ColorPoint zeroPoint = new ColorPoint();//�⺻���� ������ 0.0�� Black�� ��µȴ�.
		System.out.println(zeroPoint.toString() + "�Դϴ�");
		
		ColorPoint cp = new ColorPoint(10,10);//Black�� ���� 10,10���� �ٲ�
		cp.setXY(5, 5);//5,5�� �缳�� �� ��
		cp.setColor("RED");//������ RED�� �ٲپ���
		System.out.println(cp.toString() + "�Դϴ�");//��µǴ� �ٲ� ��ǥ�� ����.
	}

}
