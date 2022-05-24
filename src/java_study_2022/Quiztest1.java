package java_study_2022;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Quiztest1 {
	public static void main(String[] args) {
	
		JFrame frm = new JFrame("랜덤으로 글자 출력");
 
		frm.setSize(500, 500);
 
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.getContentPane().setLayout(null);
		JButton btn1 = new JButton("OPEN");
		JButton btn2 = new JButton("READ");
		JButton btn3 = new JButton("CLOSE");
		JLabel txt1=new JLabel("LOVE");        
		JLabel txt2=new JLabel("JAVA");  
		JLabel txt3=new JLabel("READ");  
 
		btn1.setBounds(30, 10, 122, 30); 
		btn2.setBounds(182, 10, 122, 30); 
		btn3.setBounds(334, 10, 122, 30); 
		txt1.setBounds(120, 50, 90, 50); 
		txt2.setBounds(180, 50, 90, 50); 
		txt3.setBounds(240, 50, 90, 50); 
	
		ActionListener btn1_action = new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				txt1.setBounds((int)(Math.random() * 300), (int)(Math.random() * 300), 90, 50); 
				txt2.setBounds((int)(Math.random() * 300), (int)(Math.random() * 300), 90, 50); 
				txt3.setBounds((int)(Math.random() * 300), (int)(Math.random() * 300), 90, 50); 
				
			}
		};
		btn1.addActionListener(btn1_action);
		
		ActionListener btn2_action = new ActionListener(){			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub			
				txt1.setText("0");				
			}
		};
		btn2.addActionListener(btn2_action);
 
		frm.getContentPane().add(btn1);
		frm.getContentPane().add(btn2);
		frm.getContentPane().add(btn3);
		frm.getContentPane().add(txt1);
		frm.getContentPane().add(txt2);
		frm.getContentPane().add(txt3);
 
		frm.setVisible(true);
		
	}

	
}
