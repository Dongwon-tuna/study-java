package computer_programming_hw;

import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz511_2 extends JFrame {
	public Quiz511_2() {
		
		
		super("Chatting");
		
		JTextField tf = new JTextField(20);
		JTextArea ta = new JTextArea(7, 20); // ���ٿ� 20�� �Է� ����, 7�� �Է�â
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane(); 
		
		
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(tf);
		c.add(new JScrollPane(ta));
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				ta.append(t.getText() + "\n"); // �ؽ�Ʈ�ʵ��� ���ڿ��� �ؽ�Ʈ���� â�� ���� 
				t.setText(""); // ���� �ؽ�Ʈ�ʵ忡 �Էµ� ���� �����
			}
		});
		
		
		
		
		
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
		add(new JButton("�����ϱ�"));
		add(new JButton("���Ϻ�����"));
		
	}
}

class NorthPanel extends JPanel {
	public NorthPanel() {
		setBackground(Color.LIGHT_GRAY);
		setOpaque(true);
		setLayout(new FlowLayout()); 	
		add(new JLabel("�׷�ä��"));
		
	}
}
