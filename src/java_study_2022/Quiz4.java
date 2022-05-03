package java_study_2022;

import java.io.*;
import java.util.Scanner;


public class Quiz4 {

	public static void main(String[] args) {
		
		System.out.println("c:\\windows\\system.ini 파일을 읽어 출력합니다.");
		try {
			Scanner fScanner = new Scanner(new FileReader("c:\\windows\\system.ini")); // 파일로부터 읽기 위한 목적
			int lineNumber = 1;
			
			
			while(fScanner.hasNext()) { // 읽을게 있는 동안에 while
				String line = fScanner.nextLine();
				System.out.printf("%4d", lineNumber++); // 행번호
				System.out.println(": "+line); 
			}
			fScanner.close();
		} catch (IOException e) {
			System.out.println("입출력 오류가 발생했습니다.");
		}

	


	}

}
