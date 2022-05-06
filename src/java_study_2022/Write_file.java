package java_study_2022;

import java.io.*;
import java.util.*;
import java.util.Arrays;

public class Write_file {

	public static void main(String[] args) {
		InputStreamReader in = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("c:\\Temp\\words.txt");
			in = new InputStreamReader(fin, "UTF-8"); // 올바른 문자 집합 지정
			int c;
			
			
			System.out.println("인코딩 문자 집합은 " + in.getEncoding());
			while ((c = in.read()) != -1) {
				System.out.print((char)c);
				

			}
			
			in.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}


	}

}
