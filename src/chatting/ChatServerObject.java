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

	
	
	public ChatServerObject(){
		
		try{
			serverSocket= new ServerSocket (9999);
			System.out.println("¼­¹ö ON");
			list = new  ArrayList<ChatHandlerObject>();
			while(true){
				Socket socket = serverSocket.accept();
				ChatHandlerObject handler = new  ChatHandlerObject(socket,list); 
				handler.start();  
				list.add(handler);  
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

