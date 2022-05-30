package computer_programming_hw;


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



//濡쒓렇?몄갹??留뚮뱶?몄슂 

public class quiz4 extends JFrame{
	
	
	quiz4(){
		setTitle("login window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container ctp=getContentPane();
		ctp.setBackground(Color.yellow);
		ctp.setLayout(null);
		
		JLabel la=new JLabel("ID");
		la.setLocation(120,130);
		la.setSize(100,30);
		JLabel lala=new JLabel("PW");
		lala.setLocation(120,170);
		lala.setSize(100,30);
		JTextField jt=new JTextField("");
		jt.setLocation(160,130);
		jt.setSize(100,30);
		JTextField jtjt=new JTextField("");
		jtjt.setLocation(160,170);
		jtjt.setSize(100,30);
		JButton jb=new JButton("Login");
		jb.setLocation(150,250);
		jb.setSize(100,30);
		jb.addActionListener(new logal());
		ctp.add(la);
		ctp.add(lala);
		ctp.add(jtjt);
		ctp.add(jt);
		ctp.add(jb);
		setSize(400,650);
		setVisible(true);
	}
		class logal implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				JButton b=(JButton)e.getSource();
				if(b.getText().equals("Login")) {
					dispose();
					new chat();
					new chat1();
				}
			
			}
		}

		
		
	
	
	
	

	public static void main(String[] args) {
		
		
	new quiz4();
	
	}
	
	private JTextArea ja=new JTextArea("",200,20);
	private JTextArea ja1=new JTextArea("",200,20);
	class chat extends JFrame{
		String []str=new String[10];
		
		
		chat(){
			setTitle("chat log window");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c=getContentPane();
			c.setBackground(Color.yellow);
			c.setLayout(null);
			
			JLabel jf=new JLabel("?곷?諛⑹씠由?");
			jf.setLocation(180,0);
			jf.setSize(100,50);
			c.add(jf);

			JButton jb=new JButton("<");
			jb.setLocation(0,0);
			jb.setSize(50,50);
			c.add(jb);
			
			JButton j=new JButton("?뗫낫湲?");
			j.setLocation(350,0);
			j.setSize(50,50);
			c.add(j);
			
			JTextField jt=new JTextField("");
			jt.setLocation(100,500);
			jt.setSize(200,100);
			
			c.add(jt);
			
			
			ja.setBounds(0,60,400,420);
			c.add(ja);
			
			JButton jbf=new JButton("+");
			jbf.setLocation(0,500);
			jbf.setSize(100,100);
			c.add(jbf);
			
			JButton jbff=new JButton("send");
			jbff.setLocation(300,500);
			jbff.setSize(100,100);
			c.add(jbff);
			jt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ja.append("\t\t\t"+jt.getText()+":沅뚮퀝李?n");
					ja1.append("沅뚮퀝李?"+jt.getText()+"\n");
					jt.setText("");
				}
			});
			jbff.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										
					ja.append("\t\t\t"+jt.getText()+":沅뚮퀝李?n");
					ja1.append("沅뚮퀝李?"+jt.getText()+"\n");
					jt.setText("");
				}
			});
			
			
			setSize(400,650);
			setVisible(true);
			
		}
	}
	class chat1 extends JFrame{
		String []str1=new String[10];
		
		
		chat1(){
			setTitle("chat1 log window");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c1=getContentPane();
			c1.setBackground(Color.yellow);
			c1.setLayout(null);
			
			JLabel jf1=new JLabel("?곷?諛⑹씠由?");
			jf1.setLocation(180,0);
			jf1.setSize(100,50);
			c1.add(jf1);

			JButton jb1=new JButton("<");
			jb1.setLocation(0,0);
			jb1.setSize(50,50);
			c1.add(jb1);
			
			JButton j1=new JButton("?뗫낫湲?");
			j1.setLocation(350,0);
			j1.setSize(50,50);
			c1.add(j1);
			
			JTextField jt1=new JTextField("");
			jt1.setLocation(100,500);
			jt1.setSize(200,100);
			
			c1.add(jt1);
			
			
			ja1.setBounds(0,60,400,420);
			c1.add(ja1);
			
			JButton jbf1=new JButton("+");
			jbf1.setLocation(0,500);
			jbf1.setSize(100,100);
			c1.add(jbf1);
			
			JButton jbff1=new JButton("send");
			jbff1.setLocation(300,500);
			jbff1.setSize(100,100);
			c1.add(jbff1);
			jt1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ja1.append("\t\t\t"+jt1.getText()+":源?ы샇\n");
					ja.append("源?ы샇:"+jt1.getText()+"\n");
					jt1.setText("");
				}
			});
			jbff1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ja1.append("\t\t\t"+jt1.getText()+":源?ы샇\n");
					ja.append("源?ы샇:"+jt1.getText()+"\n");
					jt1.setText("");
				}
			});
			
			
			setSize(400,650);
			setVisible(true);
			setLocation(400,0);
			
		}

}
}
