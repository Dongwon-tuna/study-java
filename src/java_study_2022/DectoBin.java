package java_study_2022;

import java.util.Scanner;

public class DectoBin {
	static
	int man = 0;

public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	
	int size =  s.nextInt();
	int cal = size;
	
	//������ Ƚ�� ���
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
	   
	    //for ���� Ȱ���� �迭�� ���� �����ϱ�
		
	}
	*/


	int many = 0;
	
	do {
		numbers[many] = cal%2;
		cal = cal/2;
		
		System.out.println(cal); // ���๮
		
		many++;
		
	} while (cal > 0); // ���ǽ�
	
	for (int i = numbers.length - 1, j = 0; i >= 0; i--, j++) {
		aaa[j] = numbers[i];
		}


		
	
	
	
	
	for(int abc: aaa) {
		System.out.print(abc);
	}
	
	
	}
	
	

}
