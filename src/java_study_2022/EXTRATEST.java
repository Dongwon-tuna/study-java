package java_study_2022;
import java.util.Scanner;
public class EXTRATEST {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = "abcdefghijklmnopqrstuvwxyz";
		String[] b = a.split("");
		String text = sc.nextLine();
		String[] t = text.split("");
		int[] e = new int[b.length]; 
		for (int i = 0; i < t.length; i++) {
				for (int j = 0; j < b.length; j++)
					if(t[i].equals(b[j])) e[j]++;
			}
		for (int i = 0; i < e.length; i++) {//Ãâ·Â
			System.out.println(b[i]+":"+e[i]);
		}
	}
	
}
