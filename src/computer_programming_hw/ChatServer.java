package computer_programming_hw;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;




public class ChatServer extends JFrame  {
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private ServerSocket listener = null;
	private Socket socket = null;
	//private Receiver receiver; // JTextArea�� ��ӹް� Runnable �������̽��� ������ Ŭ�����μ� ���� ������ ��� ��ü
	private JTextField sender; // JTextField ��ü�μ� ������ ������ ��� ��ü
	private JButton start, end;
	private JTextArea t1 = new JTextArea("",200,20);
	int count = 0;
	
	public ChatServer() {
		setTitle("���� ä�� â"); // ������ Ÿ��Ʋ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ ���� ��ư(X)�� Ŭ���ϸ� ���α׷� ����
		Container c = getContentPane();
		
		c.setLayout(null); //BorderLayout ��ġ�������� ���
		//receiver = new Receiver(); // Ŭ���̾�Ʈ���� ���� �޽����� ����� ���۳�Ʈ
		//receiver.setBounds(10,10,470,310);
		//receiver.setEditable(false); // ���� �Ұ�
		//add(receiver); // ��ũ�ѹٸ� ����  ScrollPane �̿�
		t1.setBounds(0,0,500,310);
		//t1.setBackground(new Color(155,187,212));
		t1.setOpaque(true);
		add(t1);
		
		

		sender = new JTextField();
		//sender.addActionListener(this);
		sender.setBounds(0,400,100,30);

		//add(receiver); // ��ũ�ѹٸ� ����  ScrollPane �̿�
		add(sender);
		
		setSize(500, 500); // �� 400 �ȼ�, ���� 200 �ȼ��� ũ��� ������ ũ�� ����
		setVisible(true); // �������� ȭ�鿡 ��Ÿ������ ����
		//------------------------------------------------------��ư�߰�
		start = new JButton("Start");
		start.setBounds(100,400,90,30);
		end = new JButton("End");
		end.setBounds(300,400,90,30);
		add(start);
		add(end);
		//------------------------��� ������
		int[]num = new int[2];
		num[0]=1;
		
		start.addActionListener(new Myact());
		if(count == 1) {
			try {
				setupConnection();
			} catch (IOException e) {
				handleError(e.getMessage());
			}
			
		}
		System.out.println(count+2);
		System.out.println(num[0]);
		
	}
	
	private class Myact implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Start")) {
				//num[0]=1;
				t1.append("\n���� ���۵�");
				synchronized(this) {
					count = 1;
				}
				System.out.print(count);
				//System.out.println(num[0]);
				
				//Thread th = new Thread(receiver); // ���κ��� �޽��� ������ ���� ������ ����
				//th.start();
				/*
				try {
					setupConnection();
				} catch (IOException e1) {
					handleError(e1.getMessage());
				}
				*/
			}	
			
		}
	
		
		
	}
	private void setupConnection() throws IOException {
		listener = new ServerSocket(9999); // ���� ���� ����
		socket = listener.accept(); // Ŭ���̾�Ʈ�κ��� ���� ��û ���
		t1.append("Ŭ���̾�Ʈ ������");
		//System.out.println("�����");
		//receiver.append("Ŭ���̾�Ʈ�κ��� ���� �Ϸ�");
		//int pos = receiver.getText().length();
		//receiver.setCaretPosition(pos); // caret �������� ���� ���������� �̵�
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Ŭ���̾�Ʈ�κ����� �Է� ��Ʈ��
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // Ŭ���̾�Ʈ���� ��� ��Ʈ��
	}

	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	
	
	/*
	private class Receiver extends JTextArea implements Runnable {
		@Override
		public void run() {
			String msg = null;
			while (true) {
				try {
					msg = in.readLine(); // ���κ��� �� ���� ���ڿ� �ޱ�
				} catch (IOException e) {
					handleError(e.getMessage());
				} 
				this.append("\n  Ŭ���̾�Ʈ : " + msg); // ���� ���ڿ��� JTextArea�� ���
				int pos = this.getText().length();
				this.setCaretPosition(pos); // caret �������� ���� ���������� �̵�
			}
		}
	}
*/
	/*
	@Override
	public void actionPerformed(ActionEvent e) { // JTextField�� <Enter> Ű ó��
		if (e.getSource() == sender) {
			String msg = sender.getText(); // �ؽ�Ʈ �ʵ忡�� ���ڿ� ����
			try {
				out.write(msg+"\n"); // ���ڿ� ����
				out.flush();
				
				receiver.append("\n���� : " + msg);// JTextArea�� ���
				int pos = receiver.getText().length();
				receiver.setCaretPosition(pos); // caret �������� ���� ���������� �̵�
				sender.setText(null); // �Է�â�� ���ڿ� ����
			} catch (IOException e1) {
				handleError(e1.getMessage());
			} 
		}
	}
	*/
	public static void main(String[] args) {
		new ChatServer();
	}

}
