package java_study_2022;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MyFrame extends Frame implements ActionListener, WindowListener{
	private TextField idT, pwdT;
	private Button login, exit;
	private Label idL, pwdL;
	private final String ID="hong";
	private final String PWD="1234";
	private String id,pwd;
	public boolean loginResult;
	
	public MyFrame() {
		setLayout(null);
		idL = new Label("아이디");
		pwdL = new Label("비밀번호");
		idT = new TextField();
		pwdT = new TextField();
		
		idL.setBounds(50,100,50,30);
		idT.setBounds(120,100,100,30);
		pwdL.setBounds(50,150,50,30);
		pwdT.setBounds(120,150,100,30);
		
		login = new Button("로그인");
		login.setBounds(90,200,50,30);
		exit = new Button("취소");
		exit.setBounds(150,200,50,30);
		
		add(exit);
		add(login);
		add(idL); add(idT);
		add(pwdL); add(pwdT);
		
		this.setBackground(Color.YELLOW);
		setBounds(900,100,300,300);
		setVisible(true);
		
		this.addWindowListener(this);
		login.addActionListener(this);
		exit.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="로그인") {
			this.id=idT.getText();
			this.pwd=pwdT.getText();

			if(ID.equals(id)&&PWD.equals(pwd)) {
				loginResult=true;
				new LoginResult1(loginResult);
				new talk(loginResult);
				new talk2(loginResult);
				dispose();
			}
			else {
				loginResult=false;
				new LoginResult1(loginResult);
			}
		}
		else if(e.getSource()==exit) {
			idT.setText(" "); idT.setText("");
			pwdT.setText(" "); pwdT.setText("");
		}
	}
	public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {setVisible(false);}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	
	public static void main(String args[]) {
		new MyFrame();
	}	
	
	private JTextArea t1 = new JTextArea("",200,20);
	private JTextArea t2 = new JTextArea("",200,20);
	
	class talk extends JFrame{
		public boolean answer;
		public talk(Boolean answer) {
			this.answer = answer;
			setTitle("chat");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Font font;
			
			font = new Font("궁서체",Font.PLAIN,20);
			
			Container c = getContentPane();
			c.setBackground(Color.YELLOW);
			c.setLayout(null);
			
			t1.setBounds(0,0,300,410);
			t1.setBackground(new Color(155,187,212));
			t1.setOpaque(true);
			add(t1);
			
			JTextField t = new JTextField("");
			t.setSize(200,55);
			t.setLocation(0,408);
			add(t);
			
			JButton s = new JButton("Send");
			s.setLocation(200,408);
			s.setSize(100,55);
			s.setBackground(Color.YELLOW);
			add(s);
			
			setSize(300,500);
			setLocation(300,0);
			setVisible(true);
			
			t.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					t1.append("사람2:"+t.getText()+"\n");
					t2.append("사람2:"+t.getText()+"\n");
					t.setText("");
				}
			});
			
			s.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					t1.append("사람2:"+t.getText()+"\n");
					t2.append("사람2:"+t.getText()+"\n");
					t.setText("");
				}
			});
		}
	}

	class talk2 extends JFrame{
		public boolean answer;
		public talk2(Boolean answer) {
			this.answer = answer;
			setTitle("chat");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Font font;
			
			font = new Font("궁서체",Font.PLAIN,20);
			
			Container c = getContentPane();
			c.setBackground(Color.YELLOW);
			c.setLayout(null);
			
			t2.setBounds(0,0,300,410);
			t2.setOpaque(true);
			t2.setBackground(new Color(155,187,212));
			add(t2);
			
			JTextField t = new JTextField("");
			t.setSize(200,55);
			t.setLocation(0,408);
			add(t);
			
			JButton s = new JButton("Send");
			s.setLocation(200,408);
			s.setSize(100,55);
			s.setBackground(Color.YELLOW);
			add(s);
			
			setSize(300,500);
			setVisible(true);
			
			t.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					t2.append("사람1:"+t.getText()+"\n");
					t1.append("사람1:"+t.getText()+"\n");
					t.setText("");
				}
			});
			
			s.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					t1.append("사람1:"+t.getText()+"\n");
					t2.append("사람1:"+t.getText()+"\n");
					t.setText("");
				}
			});
		}
	}
	
}

class LoginResult1 extends Frame implements WindowListener {
	public boolean answer;
	public LoginResult1(Boolean answer) {
		this.answer = answer;
		setBounds(700,100,200,200);
		setVisible(true);
		
		this.addWindowListener(this);
	}
	
	public void paint(Graphics g) {
		if(answer==true) {
			g.drawString("로그인에 성공하셨습니다!",20,100);
			
		} else {
			g.drawString("로그인에 실패하셨습니다.",20,100);
		}
	}
	public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {setVisible(false);}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
}