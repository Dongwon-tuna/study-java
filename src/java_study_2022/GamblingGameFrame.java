package java_study_2022;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;

public class GamblingGameFrame extends JFrame{
	public GamblingGameFrame() {
		super("rockps"); // Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new GamePanel()); // GamePanel�� ����Ʈ������ ����Ѵ�. 

		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener()); // Action �̺�Ʈ ������ �ޱ�
		c.add(btn);
		
		
		setSize(300,400);
		setVisible(true);
		
		// GamePanel�� Ű �̺�Ʈ�� ���� �� �ֵ��� ��Ŀ���� �����Ѵ�.
		getContentPane().setFocusable(true);
		getContentPane().requestFocus(); 
		
		
	}
	
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
	
	
	
	// ����Ʈ���� ���Ǵ� �г� Ŭ����
	class GamePanel extends JPanel {
		private JLabel [] label = new JLabel [3]; // 3 ���� ���� ǥ���ϴ� ���̺� �迭
		private JLabel result = new JLabel("�����մϴ�."); // ����� ����ϴ� ���̺�
		
		public GamePanel() {
			setLayout(null); // ��ġ�����ڸ� ������� �ʰ� ���� ��ġ�� ������Ʈ�� ��ġ�Ѵ�.
			
			// 3 ���� ���̺��� �����Ͽ� �����̳ʿ� �ܴ�.
			for(int i=0; i<label.length; i++) {
				label[i] = new JLabel("0"); // ���̺� ����
				label[i].setSize(60, 30); // ���̺� ũ��
				label[i].setLocation(30+80*i, 50); // ���̺� ��ġ
				label[i].setHorizontalAlignment(JLabel.CENTER); // ���̺� ��µǴ� ���� ���͸�
				label[i].setOpaque(true); // ���̺� ���� ������ �����ϵ��� �Ѵ�.
				label[i].setBackground(Color.MAGENTA); // ���̺��� ������ �����Ѵ�.
				label[i].setForeground(Color.YELLOW); //���̺��� ���� ���� �����Ѵ�.				
				label[i].setFont(new Font("Tahoma", Font.ITALIC, 30)); // ���̺� ������ ��Ʈ�� �����Ѵ�.	
				add(label[i]); // ���̺��� �����Ѵ�.
			}
			
			// ����� ����� ���̺��� �����ϰ� �����̳ʿ� �����Ѵ�.
			result.setSize(200, 20);
			result.setLocation(100, 120);
			add(result);
			
			// Ű �����ʸ� �����Ѵ�.
			addKeyListener(new KeyAdapter() { // KeyAdapter �̿�
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyChar() == '\n') { //<Enter>Ű�� �Էµ� ���
						/*int x1 = (int)(Math.random()*3); // 0~4������ ������
						label[0].setText(Integer.toString(x1));
						int x2 = (int)(Math.random()*3);
						label[1].setText(Integer.toString(x2));
						int x3 = (int)(Math.random()*3);
						label[2].setText(Integer.toString(x3));	
						*/
						int number = 3;
						int[] arr =  new int[number]; //�ο�����ŭ �迭 ���� �Ҵ�
						int[] members = new int[number]; 
						for(int i = 0; i< number; i++) {			//1���������� n�� �������� �� ������������ �����ϴ� �迭
							int a = (int)(Math.random() * 3) + 1;
							arr[i] = a;	
							members[i] = a;
							label[i].setText(Integer.toString(a));
						}
						
						 for(int abc: members) {
								System.out.print(abc);
							}
						
						Arrays.sort(arr);  //remove_Duplicate_Elements �� ���ĵ� �迭���� �۵��ϱ⿡ �迭�� �������־���
					
						int length = arr.length;  
						
				        length = remove_Duplicate_Elements(arr, length);    
				        int[] storage = new int[length]; // ��ġ�� ���� ������ ���ڸ� ������ �迭
				     
				        for (int i=0; i<length; i++) {
				        	storage[i] = arr[i];
				        }	
				        
				        int win = 0; //�������������� �¸��� ���ڸ� ����, 0�� ���, 1���� 2 ���� 3 ��
						
				        if (storage.length != 2) {
				        	result.setText("���");
				        }        
				        else {
				        	if (storage[0] == 1) {
				        		if(storage[1] ==2) {
				        			result.setText("2����� �¸�");
				        			win = 2;
				        		}        		
				        		if(storage[1] ==3) {
				        			result.setText("1 �� �����");
				        			win = 1;
				        		}        		
				        	}        	
				        	if (storage[0] == 2) {
				        		if(storage[1] ==3) {
				        			result.setText("3 ����� ��");        			
				        			win = 3;
				        		}
				        	}
				        } 
						
					
					}
				}
			});
			
			// ���콺�� �����г��� Ŭ���ϸ� ��Ŀ���� ������ ������ ������ �ϱ� ���� ���콺 ������
			addMouseListener(new MouseAdapter() { 
				@Override
				public void mouseClicked(MouseEvent e) {
					Component c = (Component)e.getSource(); // ���콺�� Ŭ���� ������Ʈ
					c.requestFocus(); // ���콺�� Ŭ���� ������Ʈ���� ��Ŀ�� ����
				}
			}); 

		}
	}
	
	static public void main(String[] arg) {
		new GamblingGameFrame();
	}
}
