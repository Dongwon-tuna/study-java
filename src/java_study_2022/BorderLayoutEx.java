package java_study_2022;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorderLayoutEx extends JFrame {
	
	public BorderLayoutEx() {
		setTitle("BorderLayout Sample"); // 프레임의 타이틀  달기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 프로그램 종료
		
		Container con = getContentPane();
		con.setBackground(Color.GRAY);
		con.setLayout(null);
		
		JTextField text = new JTextField(10);
		text.setSize(150,55);
		text.setLocation(0,310);
		add(text);
		
		JTextArea ta;
		ta= new JTextArea(7, 20);
		ta.setSize(230,290);
		ta.setLocation(0,15);
		add(ta);
		
		
		
		JButton btn = new JButton("전송");
		btn.setLocation(170,310);
		btn.setSize(70,60);
		add(btn);
		
		text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				ta.append(t.getText() + "\n"); // 텍스트필드의 문자열을 텍스트영역 창에 붙임 
				t.setText(""); // 현재 텍스트필드에 입력된 내용 지우기
			}
		});

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
			}
		});
		
		
		setSize(250,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new BorderLayoutEx();
	}
}