package chatting;

import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.Button;
import java.awt.Container;
import java.awt.Label;
import java.awt.TextField;
import java.io.IOException;

class ChatServerObject extends JFrame
{
	private ServerSocket serverSocket;
	private List <ChatHandlerObject> list;
	private TextField idT, pwdT;
	private Button send, end;
	private Label idL, pwdL;
	private JTextArea t1 = new JTextArea("",200,20);
	
	public ChatServerObject(){
		setTitle("�����Դϴ�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		//idL = new Label("���̵�");
		//idL.setBounds(50,100,50,30);
		//c.add(idL);
		
		send = new Button("Start");
		send.setBounds(100,400,50,30);
		end = new Button("End");
		end.setBounds(300,400,50,30);
		add(send);
		add(end);
		
		
		t1.setBounds(0,0,500,310);
		//t1.setBackground(new Color(155,187,212));
		t1.setOpaque(true);
		add(t1);
		//--------------------------------------------------------------
		//JTextField t = new JTextField("");
		//t.setSize(200,55);
		//t.setLocation(0,408);
		//add(t);
		
		
		setSize(500,500);
		setLocation(300,0);
		setVisible(true);
		
		
		try{
			serverSocket= new ServerSocket (9999);
			System.out.println("���� �غ� �Ϸ�");
			list = new  ArrayList<ChatHandlerObject>();
			while(true){
				Socket socket = serverSocket.accept();
				ChatHandlerObject handler = new  ChatHandlerObject(socket,list);  //�����带 ������ ���̶� ������! ������ �������־�� 
				handler.start();  //������ ����- ������ ����
				list.add(handler);  //�ڵ鷯�� ����( �� ����Ʈ�� ������ Ŭ���̾�Ʈ�� ����!!)
			}//while
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) 
	{
		new ChatServerObject();
	}
}
//Ŭ���̾�Ʈ�� ���ÿ� ä���ϱ����ؼ� �����尡 �ʿ��ϵ��� �� �����带 ���ÿ� �޾Ƶ��� �� �ִ� ���� ���� �����尡 �Ǿ��־�� ��!
