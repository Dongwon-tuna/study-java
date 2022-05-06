package computer_programming_hw;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Quiz_5_4 {

	public static void main(String[] args) {
		
		ArrayList<String> a = new ArrayList<String>();
		
		Scanner scanner = new Scanner(System.in);
		
		InputStreamReader in = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("c:\\Temp\\words.txt");
			in = new InputStreamReader(fin, "UTF-8"); // 올바른 문자 집합 지정
			int c;
			
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
