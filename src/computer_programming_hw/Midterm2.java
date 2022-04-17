package computer_programming_hw;

import java.util.Scanner;

import java.util.Arrays;

public class Midterm2 {
	//------------------------------------------------------------------------------------ 배열에서 중복되는 수를 제거해주는 메소드, 위 메소드는 정렬된 숫자에서만 작동함.
	public static int remove_Duplicate_Elements(int arr[], int n){  
        if (n==0 || n==1){  
            return n;  
        }  
        int[] tempA = new int[n];  
        int j = 0;  
        for (int i=0; i<n-1; i++){  
            if (arr[i] != arr[i+1]){  
                tempA[j++] = arr[i];  
            }  
         }  
        tempA[j++] = arr[n-1];       
        for (int i=0; i<j; i++){  
            arr[i] = tempA[i];  
        }  
        return j;  
    }  
//---------------------------------------------------------------------------------------------------------------------	
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		int number = scanner.nextInt();
		
		
		int[] arr =  new int[number]; //인원수만큼 배열 공간 할당
		int[] members = new int[number]; 
		for(int i = 0; i< number; i++) {			//1번선수부터 n번 선수까지 낸 가위바위보를 저장하는 배열
			int a = (int)(Math.random() * 3) + 1;
			arr[i] = a;	
			members[i] = a;
		}
		
		Arrays.sort(arr);  //remove_Duplicate_Elements 는 정렬된 배열에서 작동하기에 배열을 정렬해주었음
	
		int length = arr.length;  
		
        length = remove_Duplicate_Elements(arr, length);    
        int[] storage = new int[length]; // 겹치는 것을 제외한 숫자를 저장한 배열
     
        for (int i=0; i<length; i++) {
        	storage[i] = arr[i];
        }	
        
        int win = 0; //가위바위보에서 승리한 숫자를 저장, 0은 비김, 1가위 2 바위 3 보
		//------------------------------------------------------------------------------------------------ 승패 여부 판단 알고리즘
        if (storage.length != 2) {
        	System.out.println("비겼어");	
        }        
        else {
        	if (storage[0] == 1) {
        		if(storage[1] ==2) {
        			System.out.println("2를 낸 사람이 이김");
        			win = 2;
        		}        		
        		if(storage[1] ==3) {
        			System.out.println("1을 낸 사람이 이김");
        			win = 1;
        		}        		
        	}        	
        	if (storage[0] == 2) {
        		if(storage[1] ==3) {
        			System.out.println("3을 낸 사람이 이김");        			
        			win = 3;
        		}
        	}
        } 
        //--------------------------------------------------------------------------------------------------
        
       for(int abc: members) {
			System.out.print(abc);
		}
       System.out.println("<< 첫번째 선수부터 마지막 선수들이 차례대로 낸 것");
       
		for(int i = 0; i<members.length; i++) {
			if (win == members[i]) {
				int resultnum = i +1;
				System.out.println(resultnum + "번째 선수 승리");
			}
		}	
		
		
		
	}
	
}
