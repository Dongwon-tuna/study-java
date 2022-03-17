package computer_programming_hw;

import java.util.Scanner;

public class Hw2 {

	public static void main(String[] args) {
	Scanner s = new Scanner(System.in); // s객체를 생성하였다
		
		int array[] = new int[3];//입력한 정수를 답을 수 있는 배열
		
		System.out.println("정수 3개 입력>>");
		for(int i = 0; i<3; i++) {
			array[i] = s.nextInt(); //s객체의 netInt를 사용하여 입력받은 문자를 배열에 넣는다.
		}

		
		for(int i=0; i<array.length; i++) {
			for(int j=i+1; j<array.length; j++) {
				if(array[i] > array[j]) { //오름차순 알고리즘이다.
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
		
		System.out.println("중간값은 " + array[1]); //중간값 출력
		

	}


}
