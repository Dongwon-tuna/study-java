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
		setTitle("연습입니다");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		//idL = new Label("아이디");
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
			System.out.println("서버 준비 완료");
			list = new  ArrayList<ChatHandlerObject>();
			while(true){
				Socket socket = serverSocket.accept();
				ChatHandlerObject handler = new  ChatHandlerObject(socket,list);  //스레드를 생성한 것이랑 동일함! 떄문에 시자해주어야 
				handler.start();  //스레드 시작- 스레드 실행
				list.add(handler);  //핸들러를 담음( 이 리스트의 개수가 클라이언트의 갯수!!)
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
//클라이언트가 동시에 채팅하기위해서 스레드가 필요하듯이 그 스레드를 동시에 받아들일 수 있는 서버 역시 스레드가 되어주어야 함!
