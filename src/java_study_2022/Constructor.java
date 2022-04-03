package java_study_2022;

class Cal{
	int left, right;
	
	public Cal() {}	//�⺻������
	
	public Cal(int left, int right) {  //������
		this.left = left;
		this.right = right;
	}
	
	public void sum() {
		System.out.println(this.left + this.right);
	}
	
	public void avg() {
		System.out.println((this.left + this.right)/2);
	}

	
}

class Su extends Cal{
	public Su(int left, int right) {
		super(left, right); //�θ��� �����ڿ� ���� ����
	}
	public void sub() {
		System.out.println(this.left - this.right);
	}
	
	public void sum() {
		System.out.println("�������̵� ����������" + (this.left + this.right)); //�������̵�. (������) ,�θ��� return���İ� ���ƾ� ������ ���� �ʴ´�.
		
	}
	
}
public class Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cal c1 = new Cal(10,20);//������
		Su c2 = new Su(12,2);
		
		c1.sum();
		c1.avg();

		c2.sub();
		c2.sum();
	}

}
