package java_study_2022;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorderLayoutEx extends JFrame {
	
	public BorderLayoutEx() {
		setTitle("BorderLayout Sample"); // �������� Ÿ��Ʋ  �ޱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ �����츦 ������ ���α׷� ����
		
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
		
		
		
		JButton btn = new JButton("����");
		btn.setLocation(170,310);
		btn.setSize(70,60);
		add(btn);
		
		text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				ta.append(t.getText() + "\n"); // �ؽ�Ʈ�ʵ��� ���ڿ��� �ؽ�Ʈ���� â�� ���� 
				t.setText(""); // ���� �ؽ�Ʈ�ʵ忡 �Էµ� ���� �����
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