package computer_programming_hw;

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

class ChatS extends JFrame
{
	private ServerSocket serverSocket;
	private List <Server_Client> list;

	private JTextArea t1 = new JTextArea("",200,20);
	
	public ChatS(){
		
		try{
			serverSocket= new ServerSocket (9999);
			System.out.println("서버 준비 완료");
			list = new  ArrayList<Server_Client>();
			while(true){
				Socket socket = serverSocket.accept();
				Server_Client handler = new  Server_Client(socket,list);  //스레드를 생성한 것이랑 동일함! 떄문에 시자해주어야 
				handler.start();  //스레드 시작- 스레드 실행
				list.add(handler);  //핸들러를 담음( 이 리스트의 개수가 클라이언트의 갯수!!)
			}//while
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) 
	{
		new ChatS();
	}
}
//클라이언트가 동시에 채팅하기위해서 스레드가 필요하듯이 그 스레드를 동시에 받아들일 수 있는 서버 역시 스레드가 되어주어야 함!
