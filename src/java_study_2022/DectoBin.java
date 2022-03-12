package java_study_2022;

import java.util.Scanner;

public class DectoBin {
	static
	int man = 0;

public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	
	int size =  s.nextInt();
	int cal = size;
	
	//나누는 횟수 계산
	do {
		size = size/2;
		man++;
	} while (size> 0);
	
	System.out.println(man);
	
	
	int[] numbers =  new int[man];
	int[] aaa =  new int[man];
	/*
	for(int i=0; i<numbers.length; i++) {
	    numbers[i]=i;
	   
	    //for 문을 활용한 배열에 숫자 저장하기
		
	}
	*/


	int many = 0;
	
	do {
		numbers[many] = cal%2;
		cal = cal/2;
		
		System.out.println(cal); // 실행문
		
		many++;
		
	} while (cal > 0); // 조건식
	
	for (int i = numbers.length - 1, j = 0; i >= 0; i--, j++) {
		aaa[j] = numbers[i];
		}


		
	
	
	
	
	for(int abc: aaa) {
		System.out.print(abc);
	}
	
	
	}
	
	

}
