package java_study_2022;

import java.io.*;

public class Quiz2 {

	public static void main(String[] args) {
		InputStreamReader in = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("c:\\Temp\\phone.txt");
			in = new InputStreamReader(fin, "MS949"); // �ùٸ� ���� ���� ����
			int c;

			System.out.println("���ڵ� ���� ������ " + in.getEncoding());
			while ((c = in.read()) != -1) {
				System.out.print((char)c);
			}
			in.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("����� ����");
		}

	}

}
