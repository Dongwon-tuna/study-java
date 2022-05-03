package java_study_2022;

import java.io.*;
import java.util.*;

public class Quiz1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		FileWriter fout = null;
		int c;
		try {
			fout = new FileWriter("c:\\Temp\\phone.txt"); // 파일과 연결된 출력 문자 스트림 생성
			while(true) {
				System.out.println("이름 전화번호 >>");
				String line = scanner.nextLine();
				if(line.equals("그만"))
					break;
				fout.write(line, 0, line.length()); 
				fout.write("\r\n", 0, 2); // \r\n을 파일에 기록
			}
			System.out.println(" c:\\Temp\\phone.txt 에 저장하였습니다.");

			
			fout.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
		scanner.close();


	}

}
