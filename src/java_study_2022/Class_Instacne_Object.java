package java_study_2022;

class Calculator{
	int left, right;//�ν��Ͻ� ����, (Ŭ������ �ν��Ͻ� ����, �ν��Ͻ� �޼ҵ� ������ �Ұ����ϴ�.
	static double PI = 3.14; //Ŭ���� ����
	static int base = 0;
	
	public void setOprands(int left, int right) {//�ν��Ͻ� ����
		this.left = left;
		this.right = right;
	}
	public void sum(){
		System.out.println(this.left + this.right + base);
	}
	public void avg() {
		System.out.println((this.left + this.right + base)/2);
	}
	public static void div(int left, int right) {//Ŭ���� �޼ҵ�
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
		Calculator.div(24, 6);//���� c1,c2�� �������� �ʰ� �ٷ� Ŭ�������� ���ϴ� �� ������
		
	}

}
