package computer_programming_hw;

import java.util.Scanner;

class person{
	String name;
	Scanner sc = new Scanner(System.in);
	public person(String name) {
		this.name = name;
	}
	
	String getname(){
		return name;
		
	}
	
	boolean gamble() {
		System.out.println("["+getname()+"]:<ENTER>");
		sc.nextLine();
		int [] arr = new int[3];
		
		for(int i = 0; i<arr.length; i++) {
			arr[i] =  (int)(Math.random()*3 + 1); 
		}
		boolean result = true;
		
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] != arr[0]) {
				result = false;
			}
		
		}
		return result;
	}
	
	
}

public class Hw7 {

	public static void main(String[] args) {
		person [] player = new person[2];
		Scanner s = new Scanner(System.in);
		for(int i = 0; i<player.length; i++) {
			System.out.println((i +1) +  "번째 선수 이름>> ");
			player[i] = new person(s.nextLine());
			
		}
		int pl = 0;
		while(true) {
			if(player[pl].gamble()) {
				System.out.println(player[pl].getname() +"님이 이겼습니다.");
				break;
			}
			else {
				System.out.println("아쉽군요!");
				if(pl == 0) {
					pl =1;
				}
				else {
					pl = 0;
				}
				
			}
		}
	}

}
