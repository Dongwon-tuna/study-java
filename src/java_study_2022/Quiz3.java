package java_study_2022;

import java.io.*;

public class Quiz3 {

	public static void main(String[] args) {
		
		InputStreamReader in = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("c:\\windows\\system.ini");
			in = new InputStreamReader(fin, "UTF-8"); // 올바른 문자 집합 지정
			int c;

			System.out.println("인코딩 문자 집합은 " + in.getEncoding());
			while ((c = in.read()) != -1) {
				char a = (char)c;
				if(Character.isLowerCase(a))
					a = Character.toUpperCase(a);
				System.out.print((char)a);

			}
			in.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}


	}

}
