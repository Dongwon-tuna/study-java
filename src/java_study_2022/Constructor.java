package java_study_2022;

class Cal{
	int left, right;
	
	public Cal() {}	//기본생성자
	
	public Cal(int left, int right) {  //생성자
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
		super(left, right); //부모의 생성자에 값을 대입
	}
	public void sub() {
		System.out.println(this.left - this.right);
	}
	
	public void sum() {
		System.out.println("오버라이딩 조져버리기" + (this.left + this.right)); //오버라이딩. (재정의) ,부모의 return형식과 같아야 오류가 나지 않는다.
		
	}
	
}
public class Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cal c1 = new Cal(10,20);//생성자
		Su c2 = new Su(12,2);
		
		c1.sum();
		c1.avg();

		c2.sub();
		c2.sum();
	}

}
