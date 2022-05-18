package java_study_2022;

import javax.swing.*;

import java.awt.event.*;
 
public class Main extends JFrame {
 
    public Main() {
 
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
 
                                String id = "Rewind";
                                String pass = "1234";
 
 
                                    if(id.equals(txtID.getText()) &&  pass.equals(txtPass.getText())) {
 
                                            JOptionPane.showMessageDialog( null, "you have logged in successfully" );
                                    } else {
 
                                        JOptionPane.showMessageDialog( null , " you failed to log in ");
 
                                    }
 
                        }
                } );
 
        add(panel);
 
 
        setVisible(true);
 
        setSize( 600 , 400);
 
        setLocationRelativeTo(null);
 
        setResizable(false);
 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    }
 
 
 
  public static void main(String[] args) {
 
        new Main();
 
 
  }
 
 
 
}
