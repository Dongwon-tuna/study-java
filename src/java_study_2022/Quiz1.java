package java_study_2022;

import java.io.*;
import java.util.*;

public class Quiz1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		FileWriter fout = null;
		int c;
		try {
			fout = new FileWriter("c:\\Temp\\phone.txt"); // ���ϰ� ����� ��� ���� ��Ʈ�� ����
			while(true) {
				System.out.println("�̸� ��ȭ��ȣ >>");
				String line = scanner.nextLine();
				if(line.equals("�׸�"))
					break;
				fout.write(line, 0, line.length()); 
				fout.write("\r\n", 0, 2); // \r\n�� ���Ͽ� ���
			}
			System.out.println(" c:\\Temp\\phone.txt �� �����Ͽ����ϴ�.");

			
			fout.close();
		} catch (IOException e) {
			System.out.println("����� ����");
		}
		scanner.close();


	}

}
