package java_study_2022;

import java.io.*;

public class Quiz_howmany {

	public static void main(String[] args) {
		
		 System.out.println("0.0 ~ 1.0 사이의 난수 1개 발생 : " + Math.random());
	        System.out.println("0 ~ 10 사이의 난수 1개 발생 : " + (int)((Math.random()*10000)%10));
	        System.out.println("0 ~ 100 사이의 난수 1개 발생 : " + (int)(Math.random()*100));
	}

}
