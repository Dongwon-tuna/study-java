package java_study_2022;

import java.io.*;

public class Quiz_howmany {

	public static void main(String[] args) {
		
		 System.out.println("0.0 ~ 1.0 ������ ���� 1�� �߻� : " + Math.random());
	        System.out.println("0 ~ 10 ������ ���� 1�� �߻� : " + (int)((Math.random()*10000)%10));
	        System.out.println("0 ~ 100 ������ ���� 1�� �߻� : " + (int)(Math.random()*100));
	        
	        
	        int[] arr = {42, 456, 7898, 156, 123, 77, 9, 498, 2142, 2, 3, 241, 65756, 553, 767};

			for(int i=0; i<arr.length; i++) {
				for(int j=i+1; j<arr.length; j++) {
					if(arr[i] > arr[j]) { //��������
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
			
			System.out.print("\n");
			
			
			for(int i=0; i<arr.length; i++) {
				for(int j=i+1; j<arr.length; j++) {
					if(arr[i] < arr[j]) { //��������
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
	}

}
