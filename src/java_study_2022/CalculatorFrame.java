package java_study_2022;

import java.awt.*;
import javax.swing.*;


public class CalculatorFrame extends JFrame {
	public CalculatorFrame() {
		super("계산기 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane(); 
		
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		
		c.add(new NorthPanel(), BorderLayout.NORTH);
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CalculatorFrame();
	}

}

class SouthPanel extends JPanel {
	public SouthPanel() {
		setBackground(Color.GRAY);
		setOpaque(true);
		setLayout(new FlowLayout(FlowLayout.LEFT)); 
		add(new JLabel(""));
		
		add(new JTextField(15));
		add(new JButton("전송하기"));
	}
}

class NorthPanel extends JPanel {
	public NorthPanel() {
		setBackground(Color.LIGHT_GRAY);
		setOpaque(true);
		setLayout(new FlowLayout()); 	
		add(new JLabel("그룹채팅"));
		
	}
}