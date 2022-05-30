package java_study_2022;

import javax.swing.*;
import java.awt.*;

public class talk extends JFrame {
	public talk() {
		setTitle("kakao");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font;
		
		font =new Font("±Ã¼­Ã¼",Font.PLAIN,20);
		
		Container c = getContentPane();
		c.setBackground(Color.YELLOW);
		c.setLayout(null);
		
		JTextField t = new JTextField("");
		t.setSize(150,55);
		t.setLocation(0,310);
		add(t);
		
		JButton s = new JButton("e");
		s.setLocation(150,310);
		s.setSize(40,60);
		add(s);
		
		setSize(200,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new talk();
	}
}