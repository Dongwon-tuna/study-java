package java_study_2022;

import java.io.*;

public class Direct_typing {
	public static void main(String[] args) {
		FileReader fin = null;
		try {
			fin = new FileReader("c:\\windows\\system.ini"); // ���� �Է� ��Ʈ�� ����
			int c;
			while ((c = fin.read()) != -1) { // �� ���ھ� ���� ������ �д´�.
				System.out.print((char)c);
			}
			fin.close();
		}
		catch (IOException e) {
			System.out.println("����� ����");
		}
	}
}
