package java_study_2022;


import java.io.*;
import java.util.*;

public class Make_flie {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		FileWriter fout = null;
		int c;
		try {
			fout = new FileWriter("c:\\Temp\\test.txt"); // ���ϰ� ����� ��� ���� ��Ʈ�� ����
			while(true) {
				String line = scanner.nextLine();
				if(line.length() == 0) // �� �ٿ� <Enter>Ű�� �Է��� ���
					break;
				fout.write(line, 0, line.length()); 
				fout.write("\r\n", 0, 2); // \r\n�� ���Ͽ� ���
			}
			fout.close();
		} catch (IOException e) {
			System.out.println("����� ����");
		}
		scanner.close();


	}

}