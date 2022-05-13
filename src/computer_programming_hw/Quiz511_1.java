package computer_programming_hw;

import javax.swing.*;

import java.awt.*;

public class Quiz511_1 extends JFrame {
	public Quiz511_1() {
		setTitle("GridLayout Sample"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		GridLayout grid = new GridLayout(4, 2); 
		grid.setVgap(5); 
		
		Container c = getContentPane();
		c.setLayout(grid); 
		c.add(new JLabel(" ID"));
		c.add(new JTextField(""));
		c.add(new JLabel(" PW"));
		c.add(new JTextField(""));
		c.add(new JButton("LOG IN"));
	

		setSize(300, 300);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Quiz511_1();
	}
}


