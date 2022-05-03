package java_study_2022;

import java.io.*;
import java.util.Arrays;

public class Write_file {

	public static void main(String[] args) {
		InputStreamReader in = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("c:\\Temp\\ss.txt");
			in = new InputStreamReader(fin, "UTF-8"); // 올바른 문자 집합 지정
			int c;
			int i = 0;
			
			int[] arr = new int[i];
			
		
			
			System.out.println("인코딩 문자 집합은 " + in.getEncoding());
			while ((c = in.read()) != -1) {
				System.out.print((char)c);
				System.out.print(c);
				//arr[3] = 3;
				i++;
			}
			System.out.println(i);
			
			
			
			//System.out.println(Arrays.toString(arr));
			//System.out.println(arr[3]);

			
			
			in.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}

		
		
		/*int[] arr = {42, 456, 7898, 156, 123, 77, 9, 498, 2142, 2, 3, 241, 65756, 553, 767};
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) { //오름차순
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			if(i+1 != arr.length) {
				System.out.print(", ");
			}
		}
		*/

	}

}
