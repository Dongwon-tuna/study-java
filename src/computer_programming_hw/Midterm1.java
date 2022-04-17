package computer_programming_hw;
import java.util.Scanner;
abstract class Converter {
	abstract protected double convert(double src); //-----------------------위 메소드 포하 밑 3개의 메소드는 추상메소드 이기 때문에 상속이 필요하다.
	abstract protected String srcString(); // (바꾸기 전 단위 메소드)
	abstract protected String destString(); //(바꾼 후 단위 메소드)
	protected double ratio; // 비율 >1마일을 km로 환산
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(srcString() + " 을 " + destString() + " 로 바꿉니다.");
		System.out.print(srcString() + " 을 입력하세요>> ");
		double val = scanner.nextDouble();
		double res = convert(val);
		System.out.println(" 변환 결과: " + res + destString() + " 입니다");
		scanner.close();
	}
}
class Km2Mile extends Converter { //Km2Mile 이란 클래스는 Converter를 상속받았다.
	public Km2Mile(double ratio) {//1 마일의 환산 된 km 값을 입력받는 생성자
		this.ratio = ratio;
	}
	protected String srcString() {//추상메소드 scrString 에 오버라이딩 하였음
		return " Km "; //km을 리턴하여 상속받은 run메소드에서 km이 필요한 곳에 사용 가능
	} 

	protected String destString() { // 추상메소드 destString 에 오버리이딩 하였음
		return " mile ";// mile을 리턴하여 상속받은 run메소드에서 mile이 필요한 곳에 사용 가능
	} 

	protected double convert(double src) { //추상메소드 convert 에 오버라이딩 하였음. 입력한 km거리를 1마일의 km값 만큼 나눠준다. ex)30km/1.6lm
		return src/ratio;					// 입력한 km거리를 1마일의 km값 만큼 나눠준다. ex)30km/1.6lm
	}	
}	
public class Midterm1 {	
	public static void main(String[] args) {
		
		Km2Mile toMile = new Km2Mile(1.6); // 1마일은 1.6Km으로 기본 변화율 설정
		
		toMile.run();
	}
}
