package java_study_2022;

import java.io.*;
import java.util.Scanner;


public class Quiz4 {

	public static void main(String[] args) {
		
		System.out.println("c:\\windows\\system.ini ������ �о� ����մϴ�.");
		try {
			Scanner fScanner = new Scanner(new FileReader("c:\\windows\\system.ini")); // ���Ϸκ��� �б� ���� ����
			int lineNumber = 1;
			
			
			while(fScanner.hasNext()) { // ������ �ִ� ���ȿ� while
				String line = fScanner.nextLine();
				System.out.printf("%4d", lineNumber++); // ���ȣ
				System.out.println(": "+line); 
			}
			fScanner.close();
		} catch (IOException e) {
			System.out.println("����� ������ �߻��߽��ϴ�.");
		}

	


	}

}
