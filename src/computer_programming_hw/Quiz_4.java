package computer_programming_hw;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class Quiz_4 extends JFrame {
	 

    public Quiz_4() {
 
        JPanel panel = new JPanel();
 
        JLabel label = new JLabel("ID : ");
 
        JLabel pswrd = new JLabel("PassWord : ");
 
        JTextField txtID= new JTextField(10);
 
        JPasswordField txtPass = new JPasswordField(10);
 
        JButton logBtn = new JButton("Log in");
    
 
        panel.add(label);
        panel.add(txtID);
        panel.add(pswrd);
        panel.add(txtPass);
        panel.add(logBtn);
 
        logBtn.addActionListener( new ActionListener() {  
              public void actionPerformed(ActionEvent e) {
 
              String id = "hdw";
              String pass = "1";
 
 
                   if(id.equals(txtID.getText()) &&  pass.equals(txtPass.getText())) {
                	   new chat();
                	   new chat1();
                                    	
               	
                    JOptionPane.showMessageDialog( null, "you have logged in successfully" );
                    } else {
 
                      JOptionPane.showMessageDialog( null , " you failed to log in ");
 
                           }
                     }
                } );
        add(panel);
        setVisible(true);
        setSize( 500 , 250);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
  public static void main(String[] args) {
 
        new Quiz_4();
 
  }
  
  
	private JTextArea ja=new JTextArea("",200,20);
	private JTextArea ja1=new JTextArea("",200,20);
	
	class chat extends JFrame{
		String []str=new String[10];
		
		
		chat(){
			setTitle("chat");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c=getContentPane();
			c.setBackground(Color.GRAY);
			c.setLayout(null);
			
			JLabel jf=new JLabel("사용자 1");
			jf.setLocation(180,0);
			jf.setSize(100,20);
			c.add(jf);

			JTextField jt=new JTextField("");
			jt.setLocation(20,500);
			jt.setSize(280,100);
			
			c.add(jt);
			
			
			ja.setBounds(0,60,400,420);
			c.add(ja);
						
			JButton jbff=new JButton("send");
			jbff.setLocation(300,500);
			jbff.setSize(100,100);
			c.add(jbff);

			jbff.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
										
					ja.append(""+jt.getText()+"\n");
					ja1.append(""+jt.getText()+"\n");
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
			setTitle("chat1");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c1=getContentPane();
			c1.setBackground(Color.GRAY);
			c1.setLayout(null);
			
			JLabel jf1=new JLabel("사용자 2");
			jf1.setLocation(180,0);
			jf1.setSize(100,20);
			c1.add(jf1);

			
			JTextField jt1=new JTextField("");
			jt1.setLocation(20,500);
			jt1.setSize(280,100);
			
			c1.add(jt1);
			
			
			ja1.setBounds(0,60,400,420);
			c1.add(ja1);
			
		
			JButton jbff1=new JButton("send");
			jbff1.setLocation(300,500);
			jbff1.setSize(100,100);
			c1.add(jbff1);

			jbff1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					ja.append(""+jt1.getText()+"\n");
					ja1.append(""+jt1.getText()+"\n");
					jt1.setText("");
				}
			});
			
			
			setSize(400,650);
			setVisible(true);
			setLocation(400,0);
			
		}

}
}
