package computer_programming_hw;

import java.util.Scanner;

import java.util.Arrays;

public class Midterm2 {
	//------------------------------------------------------------------------------------ �迭���� �ߺ��Ǵ� ���� �������ִ� �޼ҵ�, �� �޼ҵ�� ���ĵ� ���ڿ����� �۵���.
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
		
		
		int[] arr =  new int[number]; //�ο�����ŭ �迭 ���� �Ҵ�
		int[] members = new int[number]; 
		for(int i = 0; i< number; i++) {			//1���������� n�� �������� �� ������������ �����ϴ� �迭
			int a = (int)(Math.random() * 3) + 1;
			arr[i] = a;	
			members[i] = a;
		}
		
		Arrays.sort(arr);  //remove_Duplicate_Elements �� ���ĵ� �迭���� �۵��ϱ⿡ �迭�� �������־���
	
		int length = arr.length;  
		
        length = remove_Duplicate_Elements(arr, length);    
        int[] storage = new int[length]; // ��ġ�� ���� ������ ���ڸ� ������ �迭
     
        for (int i=0; i<length; i++) {
        	storage[i] = arr[i];
        }	
        
        int win = 0; //�������������� �¸��� ���ڸ� ����, 0�� ���, 1���� 2 ���� 3 ��
		//------------------------------------------------------------------------------------------------ ���� ���� �Ǵ� �˰���
        if (storage.length != 2) {
        	System.out.println("����");	
        }        
        else {
        	if (storage[0] == 1) {
        		if(storage[1] ==2) {
        			System.out.println("2�� �� ����� �̱�");
        			win = 2;
        		}        		
        		if(storage[1] ==3) {
        			System.out.println("1�� �� ����� �̱�");
        			win = 1;
        		}        		
        	}        	
        	if (storage[0] == 2) {
        		if(storage[1] ==3) {
        			System.out.println("3�� �� ����� �̱�");        			
        			win = 3;
        		}
        	}
        } 
        //--------------------------------------------------------------------------------------------------
        
       for(int abc: members) {
			System.out.print(abc);
		}
       System.out.println("<< ù��° �������� ������ �������� ���ʴ�� �� ��");
       
		for(int i = 0; i<members.length; i++) {
			if (win == members[i]) {
				int resultnum = i +1;
				System.out.println(resultnum + "��° ���� �¸�");
			}
		}	
		
		
		
	}
	
}
