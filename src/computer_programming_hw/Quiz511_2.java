package computer_programming_hw;

import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz511_2 extends JFrame {
	public Quiz511_2() {
		
		
		super("Chatting");
		
		JTextField tf = new JTextField(20);
		JTextArea ta = new JTextArea(7, 20); // 한줄에 20개 입력 가능, 7줄 입력창
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane(); 
		
		
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(tf);
		c.add(new JScrollPane(ta));
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				ta.append(t.getText() + "\n"); // 텍스트필드의 문자열을 텍스트영역 창에 붙임 
				t.setText(""); // 현재 텍스트필드에 입력된 내용 지우기
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
		add(new JButton("전송하기"));
		add(new JButton("파일보내기"));
		
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
