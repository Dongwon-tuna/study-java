package chatting;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class Frmaestudy extends JFrame {
	private TextField idT, pwdT;
	private Button send, end;
	private Label idL, pwdL;
	private JTextArea t1 = new JTextArea("",200,20);
	
	//-----------------------------------------------
	
	
	public Frmaestudy() {
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
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Frmaestudy();

	}

}
