package java_study_2022;

import java.io.*;

public class Quiz_howmany {

	public static void main(String[] args) {
		
		 System.out.println("0.0 ~ 1.0 ������ ���� 1�� �߻� : " + Math.random());
	        System.out.println("0 ~ 10 ������ ���� 1�� �߻� : " + (int)((Math.random()*10000)%10));
	        System.out.println("0 ~ 100 ������ ���� 1�� �߻� : " + (int)(Math.random()*100));
	}

}
