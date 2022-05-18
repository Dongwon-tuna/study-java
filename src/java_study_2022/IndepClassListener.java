package java_study_2022;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;


public class IndepClassListener extends JFrame {
	public IndepClassListener() {
		setTitle("Action");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener()); // Action 이벤트 리스너 달기
		c.add(btn);
		JButton btn1 = new JButton("1");
		btn.addActionListener(new MyActionListener()); // Action 이벤트 리스너 달기
		c.add(btn1);
		JButton btn2 = new JButton("2");
		btn.addActionListener(new MyActionListener()); // Action 이벤트 리스너 달기
		c.add(btn2);
		JButton btn3 = new JButton("3");
		btn.addActionListener(new MyActionListener()); // Action 이벤트 리스너 달기
		c.add(btn3);
		
		setSize(350, 150);
		setVisible(true);
	}

	
	
	
	
	
	
	public static void main(String [] args) {
		new IndepClassListener();
	}
} 
// 독립된 클래스로 이벤트 리스너를 작성한다.
class MyActionListener implements ActionListener {
	
	
	static int remove_Duplicate_Elements(int arr[], int n){  
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
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource(); // 이벤트 소스 버튼 알아내기
		
		
		
		
		if(b.getText().equals("Action")) { // 버튼의 문자열이 "Action"인지 비교
			b.setText("액션"); // 버튼의 문자열을 "액션"으로 변경
			int number = 3;
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
			
	        
			
		}
		else
			b.setText("Action"); // 버튼의 문자열을 "Action"으로 변경
	}
}