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
		
		
		//TODO �θ� ������ ����
		JFrame frm = new JFrame("");
 
		//TODO �θ� ������ ũ�� ���� (����, ����)
		frm.setSize(350, 300);
 
		//TODO �θ� �������� ȭ�� ����� ��ġ
		frm.setLocationRelativeTo(null);
 
		//TODO �θ� �������� �ݾ��� �� �޸𸮿��� ���ŵǵ��� ����
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
		//TODO �θ� ���̾ƿ� ����
		frm.getContentPane().setLayout(null);
 
		//TODO �ڽ� ������Ʈ ����
		JButton btn1 = new JButton("����");
		
		JLabel txt1=new JLabel("0"); 
		JLabel txt2=new JLabel("0"); 
		JLabel txt3=new JLabel("0"); 
		JLabel txt4=new JLabel("�¸���"); 
		JLabel txt5=new JLabel("1�� ����, 2�� ����, 3�� ���ڱ�"); 
		
 
		//TODO �ڽ� ������Ʈ  ��ư ��ġ�� ũ�� ����
		btn1.setBounds(110, 170, 122, 30); //setBounds(������ġ, ������ġ, ���α���, ���α���);
		
		txt1.setBounds(120, 50, 90, 50); //setBounds(������ġ, ������ġ, ���α���, ���α���);
		txt1.setHorizontalAlignment(JLabel.CENTER); //�ؽ�Ʈ ���� ǥ�� ����
		txt2.setBounds(250, 50, 90, 50); 
		txt3.setBounds(200, 50, 90, 50); 
		txt4.setBounds(120, 120, 190, 50); 
		txt5.setBounds(90, 20, 190, 50); 
        
		//TODO �ڽ� ������Ʈ �̺�Ʈ ����
		ActionListener btn1_action = new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub	
				
				txt5.setBounds((int)(Math.random() * 100) , 20, 190, 50); 
				// ��ư Ŭ���� �Կ� ���� �������� �����̴� ����.
				int number = 3;
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
				
				
			
				txt1.setText(String.valueOf(arr[0]));		
				txt2.setText(String.valueOf(arr[1]));	
				txt3.setText(String.valueOf(arr[2]));
				
			      if (storage.length != 2) {
			    	  txt4.setText("���");
			        }        
			        else {
			        	if (storage[0] == 1) {
			        		if(storage[1] ==2) {
			        			txt4.setText("2(����) ����� �̱�");
			        			win = 2;
			        		}        		
			        		if(storage[1] ==3) {
			        			txt4.setText("1(����) ����� �̱�");
			        			win = 1;
			        		}        		
			        	}        	
			        	if (storage[0] == 2) {
			        		if(storage[1] ==3) {
			        			txt4.setText("3(��) �� ��� �̱�");     			
			        			win = 3;
			        		}
			        	}
			        } 
					
				
			}
		};
		btn1.addActionListener(btn1_action);
		
		
 
		//TODO �θ� �����ӿ��ٰ� �ڽ� ������Ʈ �߰�
		frm.getContentPane().add(btn1);
		
		frm.getContentPane().add(txt1);
		frm.getContentPane().add(txt2);
		frm.getContentPane().add(txt3);
		frm.getContentPane().add(txt4);
		frm.getContentPane().add(txt5);
		//TODO �θ� �������� ���̵��� ����
		frm.setVisible(true);
		
	}

}