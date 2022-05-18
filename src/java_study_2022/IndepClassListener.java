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
		btn.addActionListener(new MyActionListener()); // Action �̺�Ʈ ������ �ޱ�
		c.add(btn);
		JButton btn1 = new JButton("1");
		btn.addActionListener(new MyActionListener()); // Action �̺�Ʈ ������ �ޱ�
		c.add(btn1);
		JButton btn2 = new JButton("2");
		btn.addActionListener(new MyActionListener()); // Action �̺�Ʈ ������ �ޱ�
		c.add(btn2);
		JButton btn3 = new JButton("3");
		btn.addActionListener(new MyActionListener()); // Action �̺�Ʈ ������ �ޱ�
		c.add(btn3);
		
		setSize(350, 150);
		setVisible(true);
	}

	
	
	
	
	
	
	public static void main(String [] args) {
		new IndepClassListener();
	}
} 
// ������ Ŭ������ �̺�Ʈ �����ʸ� �ۼ��Ѵ�.
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
		JButton b = (JButton)e.getSource(); // �̺�Ʈ �ҽ� ��ư �˾Ƴ���
		
		
		
		
		if(b.getText().equals("Action")) { // ��ư�� ���ڿ��� "Action"���� ��
			b.setText("�׼�"); // ��ư�� ���ڿ��� "�׼�"���� ����
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
			
	        
			
		}
		else
			b.setText("Action"); // ��ư�� ���ڿ��� "Action"���� ����
	}
}