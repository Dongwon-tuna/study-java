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
		setTitle("�ؽ�Ʈ���� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(new JLabel("�Է� �� <Enter> Ű�� �Է��ϼ���"));
		c.add(tf);
		c.add(tf1);
		
		c.add(new JScrollPane(ta));
		
		
		// �ؽ�Ʈ�ʵ忡 <Enter> Ű �Է� �� �߻��ϴ� Action �̺�Ʈ�� ������ ���
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				ta.append(t.getText() + "\n");
				ta1.append(t.getText() + "\n"); 
				t.setText(""); // ���� �ؽ�Ʈ�ʵ忡 �Էµ� ���� �����
			}
		});

		setSize(300,300);
		setVisible(true);
		
		
	}
	
	void c2() {
		setTitle("�ؽ�Ʈ���� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(new JLabel("�Է� �� <Enter> Ű�� �Է��ϼ���"));
		
		c.add(tf1);
		
		c.add(new JScrollPane(ta1));
		
		
		// �ؽ�Ʈ�ʵ忡 <Enter> Ű �Է� �� �߻��ϴ� Action �̺�Ʈ�� ������ ���
		tf1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				ta.append(t.getText() + "\n");
				ta1.append(t.getText() + "\n"); 
				t.setText(""); // ���� �ؽ�Ʈ�ʵ忡 �Էµ� ���� �����
			}
		});

		setSize(300,300);
		setVisible(true);
		
		
	}
}



public class Quiz525 extends JFrame {
	private JTextField tf = new JTextField(20);
	private JTextArea ta = new JTextArea(7, 20); // ���ٿ� 20�� �Է� ����, 7�� �Է�â
	
	public Quiz525() {
		setTitle("�ؽ�Ʈ���� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		c.add(new JLabel("�Է� �� <Enter> Ű�� �Է��ϼ���"));
		c.add(tf);
		c.add(new JScrollPane(ta));
		
		// �ؽ�Ʈ�ʵ忡 <Enter> Ű �Է� �� �߻��ϴ� Action �̺�Ʈ�� ������ ���
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				ta.append(t.getText() + "\n"); // �ؽ�Ʈ�ʵ��� ���ڿ��� �ؽ�Ʈ���� â�� ���� 
				t.setText(""); // ���� �ؽ�Ʈ�ʵ忡 �Էµ� ���� �����
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
