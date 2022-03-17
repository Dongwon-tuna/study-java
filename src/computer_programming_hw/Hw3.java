package computer_programming_hw;

import java.util.Scanner;

public class Hw3 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int money = s.nextInt();
		int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};
		
		int number = 0 ; // 돈 단위별로 이동하게 해 주는 변수
		
		int [] howmany = new int[8]; // 갯수를 저장하는배열
		
	
		
		System.out.println(howmany[number]);
		
		while (money > 0) {
			howmany[number] = money / unit[number];
			if(howmany[number] > 0) {	
				money = money - howmany[number]*unit[number];		//전체 금액에서 갯수 파악이 완료된 화폐의 값을 빼는 식
			}
			number ++;
		}
		
	
		for(int i = 0; i < 8; i++) {
			System.out.println(unit[i] + "원 짜리 : " + howmany[i] + "개"); // 결과물 출력
		}
		
	}

}

