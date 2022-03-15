package java_study_2022;

public class Scope {
	
	static int i = 0;	//전역변수
	
	static void a() {
		i = 0;
		//int i = 0; 	//지역변수
						//a()메소드 안에서의 i 변수는 여기 안에서만 힘을 발휘할 수 있음.
	}

	public static void main(String[] args) {
		for( i = 0; i<5; i++) {		//static int i의 값을 불러옴
			a();					//여기서 a()의 변수 i는 힘을 발휘 못 함.
			System.out.println(i);
		}

	}

}
/*
 * 메소드 안에서 생성해준 변수는 메소드 안에서만 유효하다.
 */
