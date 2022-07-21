package java_study_2022;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainActivity13 {
	
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//TODO 부모 프레임 생성
		JFrame frm = new JFrame("");
 
		//TODO 부모 프레임 크기 설정 (가로, 세로)
		frm.setSize(350, 300);
 
		//TODO 부모 프레임을 화면 가운데에 배치
		frm.setLocationRelativeTo(null);
 
		//TODO 부모 프레임을 닫았을 때 메모리에서 제거되도록 설정
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
		//TODO 부모 레이아웃 설정
		frm.getContentPane().setLayout(null);
 
		//TODO 자식 컴포넌트 생성
		JButton btn1 = new JButton("시작");
		
		JLabel txt1=new JLabel("0"); 
		JLabel txt2=new JLabel("0"); 
		JLabel txt3=new JLabel("0"); 
		JLabel txt4=new JLabel("승리자"); 
		JLabel txt5=new JLabel("1은 가위, 2는 바위, 3은 보자기"); 
		
 
		//TODO 자식 컴포넌트  버튼 위치와 크기 설정
		btn1.setBounds(110, 170, 122, 30); //setBounds(가로위치, 세로위치, 가로길이, 세로길이);
		
		txt1.setBounds(120, 50, 90, 50); //setBounds(가로위치, 세로위치, 가로길이, 세로길이);
		txt1.setHorizontalAlignment(JLabel.CENTER); //텍스트 센터 표시 설정
		txt2.setBounds(250, 50, 90, 50); 
		txt3.setBounds(200, 50, 90, 50); 
		txt4.setBounds(120, 120, 190, 50); 
		txt5.setBounds(90, 20, 190, 50); 
        
		//TODO 자식 컴포넌트 이벤트 정의
		ActionListener btn1_action = new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				
				txt5.setBounds((int)(Math.random() * 100) , 20, 190, 50); 
				// 버튼 클릭을 함에 따라서 랜덤으로 움직이는 숫자.
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
				
				
			
				txt1.setText(String.valueOf(arr[0]));		
				txt2.setText(String.valueOf(arr[1]));	
				txt3.setText(String.valueOf(arr[2]));
				
			      if (storage.length != 2) {
			    	  txt4.setText("비김");
			        }        
			        else {
			        	if (storage[0] == 1) {
			        		if(storage[1] ==2) {
			        			txt4.setText("2(바위) 낸사람 이김");
			        			win = 2;
			        		}        		
			        		if(storage[1] ==3) {
			        			txt4.setText("1(가위) 낸사람 이김");
			        			win = 1;
			        		}        		
			        	}        	
			        	if (storage[0] == 2) {
			        		if(storage[1] ==3) {
			        			txt4.setText("3(보) 낸 사람 이김");     			
			        			win = 3;
			        		}
			        	}
			        } 
					
				
			}
		};
		btn1.addActionListener(btn1_action);
		
		
 
		//TODO 부모 프레임에다가 자식 컴포넌트 추가
		frm.getContentPane().add(btn1);
		
		frm.getContentPane().add(txt1);
		frm.getContentPane().add(txt2);
		frm.getContentPane().add(txt3);
		frm.getContentPane().add(txt4);
		frm.getContentPane().add(txt5);
		//TODO 부모 프레임이 보이도록 설정
		frm.setVisible(true);
		
	}

}