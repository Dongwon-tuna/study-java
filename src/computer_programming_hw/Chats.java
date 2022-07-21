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
			System.out.println("���� �غ� �Ϸ�");
			list = new  ArrayList<Server_Client>();
			while(true){
				Socket socket = serverSocket.accept();
				Server_Client handler = new  Server_Client(socket,list);  //�����带 ������ ���̶� ������! ������ �������־�� 
				handler.start();  //������ ����- ������ ����
				list.add(handler);  //�ڵ鷯�� ����( �� ����Ʈ�� ������ Ŭ���̾�Ʈ�� ����!!)
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
//Ŭ���̾�Ʈ�� ���ÿ� ä���ϱ����ؼ� �����尡 �ʿ��ϵ��� �� �����带 ���ÿ� �޾Ƶ��� �� �ִ� ���� ���� �����尡 �Ǿ��־�� ��!
