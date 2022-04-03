package computer_programming_hw;

class Point{
	int x,y;
	
	Point(){};
	
	public Point(int x, int y) {//x와y의 좌표를 입력받는 생성자.
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	protected void move(int x, int y) {//상속되는 클래스에서 사용 가능한 함수.
		this.x = x;
		this.y = y;
	}
}

class ColorPoint extends Point{
	String color;
	public ColorPoint() { // 처음 0,0의 값을 갖고 시작하게 설정한 생성자.
		this(0,0);
	}
	
	public ColorPoint(int x, int y) {
	
		super(x,y);//부모 클래스의 xy의 값에 대입.
		color = "Black";//기본으로 검정색 설정해줌.
	}
	
	public void setXY(int x, int y) {//move함수를 사용하여 기존의 0,0에서 다른 좌표로 설정할때 사용 되는 함수
		move(x,y);
	}
	
	public String setColor(String color) {
		this.color =color;
		return this.color;
	}
	
	public String toString(){//좌표와 점의 색깔을 알려주는 함수
		String xx = color +"색의" + "(" + this.x +","+ this.y +")" +"의 점";
		return xx;
	} 
}
public class Hw5 {

	public static void main(String[] args) {
		ColorPoint zeroPoint = new ColorPoint();//기본적인 설정인 0.0과 Black이 출력된다.
		System.out.println(zeroPoint.toString() + "입니다");
		
		ColorPoint cp = new ColorPoint(10,10);//Black의 점을 10,10으로 바꿈
		cp.setXY(5, 5);//5,5로 재설정 해 줌
		cp.setColor("RED");//색깔을 RED로 바꾸었음
		System.out.println(cp.toString() + "입니다");//출력되는 바뀐 좌표와 색깔.
	}

}
