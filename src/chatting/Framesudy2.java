package chatting;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Framesudy2 extends JFrame{
	private JTextArea t1 = new JTextArea("",200,20);
	private TextField username, message;
	private Label name;
	private Button connect, disconnect, file, send;
	public Framesudy2() {
		setTitle("연습입니다");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		t1.setBounds(10,90,480,310);
		//t1.setBackground(new Color(155,187,212));
		t1.setOpaque(true);
		add(t1);
		
		connect = new Button("Connect");
		connect.setBounds(250,10,80,30);
		add(connect);
		disconnect = new Button("Disconnect");
		disconnect.setBounds(250,50,80,30);
		add(disconnect);
		file = new Button("File Transfer");
		file.setBounds(360,30,100,30);
		add(file);
		
		
		name = new Label("Username");
		name.setBounds(30,20,80,50);
		add(name);
		
		username = new TextField("");
		username.setBounds(115,35,90,20);
		add(username);
		
		
		message = new TextField("");
		message.setBounds(10,420,350,20);
		add(message);
		
		send = new Button("Send");
		send.setBounds(380,420,80,30);
		add(send);
	
		
		
		
		
		setSize(500,500);
		setLocation(300,0);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Framesudy2();
	}

}
