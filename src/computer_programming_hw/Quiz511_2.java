package computer_programming_hw;

import javax.swing.*;



import java.awt.*;

public class Quiz511_2 extends JFrame {
	public Quiz511_2() {
		super("Chatting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane(); 
		
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		
		c.add(new NorthPanel(), BorderLayout.NORTH);
		setSize(400,700);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Quiz511_2();
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
