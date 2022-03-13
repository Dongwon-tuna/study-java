package java_study_2022;

class Calculator{
	int left, right;
	static double PI = 3.14; //클래스 변수
	static int base = 0;
	
	public void setOprands(int left, int right) {//인스턴스 변수
		this.left = left;
		this.right = right;
	}
	public void sum(){
		System.out.println(this.left + this.right + base);
	}
	public void avg() {
		System.out.println((this.left + this.right + base)/2);
	}
	public static void div(int left, int right) {
		System.out.println(left/right);
	}
}

public class Class_Instacne_Object {

	public static void main(String[] args) {
		
		Calculator c1 = new Calculator();
		c1.setOprands(10,20);
		c1.sum();
		c1.avg();
		System.out.println(c1.PI);
		Calculator c2 = new Calculator();
		c2.base = 10;
		c2.setOprands(10, 20);
		c2.sum();
		Calculator.div(24, 6);
		
	}

}
