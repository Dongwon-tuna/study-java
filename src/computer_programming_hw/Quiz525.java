package computer_programming_hw;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


class c1 extends JFrame{
	JTextField tf = new JTextField(20);
	JTextArea ta = new JTextArea(7, 20);
	JTextField tf1 = new JTextField(20);
	JTextArea ta1 = new JTextArea(7, 20);
	public c1() {
		setTitle("텍스트영역 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(new JLabel("입력 후 <Enter> 키를 입력하세요"));
		c.add(tf);
		c.add(tf1);
		
		c.add(new JScrollPane(ta));
		
		
		// 텍스트필드에 <Enter> 키 입력 때 발생하는 Action 이벤트의 리스너 등록
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				ta.append(t.getText() + "\n");
				ta1.append(t.getText() + "\n"); 
				t.setText(""); // 현재 텍스트필드에 입력된 내용 지우기
			}
		});

		setSize(300,300);
		setVisible(true);
		
		
	}
	
	void c2() {
		setTitle("텍스트영역 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(new JLabel("입력 후 <Enter> 키를 입력하세요"));
		
		c.add(tf1);
		
		c.add(new JScrollPane(ta1));
		
		
		// 텍스트필드에 <Enter> 키 입력 때 발생하는 Action 이벤트의 리스너 등록
		tf1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				ta.append(t.getText() + "\n");
				ta1.append(t.getText() + "\n"); 
				t.setText(""); // 현재 텍스트필드에 입력된 내용 지우기
			}
		});

		setSize(300,300);
		setVisible(true);
		
		
	}
}



public class Quiz525 extends JFrame {
	private JTextField tf = new JTextField(20);
	private JTextArea ta = new JTextArea(7, 20); // 한줄에 20개 입력 가능, 7줄 입력창
	
	public Quiz525() {
		setTitle("텍스트영역 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(new JLabel("입력 후 <Enter> 키를 입력하세요"));
		c.add(tf);
		c.add(new JScrollPane(ta));
		
		// 텍스트필드에 <Enter> 키 입력 때 발생하는 Action 이벤트의 리스너 등록
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				ta.append(t.getText() + "\n"); // 텍스트필드의 문자열을 텍스트영역 창에 붙임 
				t.setText(""); // 현재 텍스트필드에 입력된 내용 지우기
			}
		});

		setSize(300,300);
		setVisible(true);
		
		
	}
	
	
	
		
	public static void main(String [] args) {
		//new Quiz525();
	
		c1 s = new c1();
		s.c2();
	}
}
