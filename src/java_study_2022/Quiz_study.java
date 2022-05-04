package java_study_2022;

import java.io.*;

public class Quiz_study {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStreamReader in = null;
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream("c:\\Temp\\quiz_study.txt");
			in = new InputStreamReader(fin,"MS949");
			
			int c;
			int i = 0;
			int arr[] = new int[10];
			
			while((c = in.read()) != -1){
				if((char)c != ' ' ) {
				
					arr[i] = c -48;
					i++;
					
				}
				
				
			}
			
		
			
			for (int k = 0; k<i; k++ ) {
				System.out.println(arr[k] + " ");
			}
			
			
			in.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("입출력 오류");
		}
			
	}

}
