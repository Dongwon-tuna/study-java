package java_study_2022;

class Point1{
	int x,y;
	
	Point1(){};
	
	public Point1(int x, int y) {//x��y�� ��ǥ�� �Է¹޴� ������.
		this.x = x;
		this.y = y;
	}
	
	
	protected void move(int x, int y) {//��ӵǴ� Ŭ�������� ��� ������ �Լ�.
		this.x = x;
		this.y = y;
	}
}

class Point3D extends Point1{
	int z;
	public Point3D(int x, int y, int z){
		super(x,y);
		this.z = z;
	}
	
	public void moveUp() {
		this.z ++;
	}
	
	public String toString() {
		String xxx = this.x+ ","+ this.y +","+ this.z + "�Դϴ�"; 
		return xxx;
	}
	
	public void move(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z =z;
	}
}

public class Point_of_3D {

	public static void main(String[] args) {
		Point3D p = new Point3D(1,2,3);
		System.out.println(p.toString());
		p.moveUp();
		System.out.println(p.toString());
		p.move(12, 12);
		System.out.println(p.toString());
		p.move(12, 1, 11);
		System.out.println(p.toString());
		
		

	}

}
