package java_study_2022;

public class Array_sending {
	static void plus(int a[]) {
		for(int i = 0; i<a.length; i++) {
			a[i] ++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a [] = {1,2,3,4};
		plus(a);
		
		for(int i = 0; i<a.length; i++) {
			System.out.println(a[i]);
		}

	}

}
