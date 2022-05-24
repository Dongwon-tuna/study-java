package java_study_2022;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 

class MyDialog extends JDialog{
	private JTextField tf = new JTextField(10); 
	private JButton okButton = new JButton("전송하기"); 
	
	public MyDialog(JFrame frame, String title) {
		super(frame,title);
		setLayout(new FlowLayout());
		add(tf);
		add(okButton);
		setSize(400, 200);
	
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
			}
		});
	}

}

public class Main extends JFrame {
 
	private MyDialog dialog; 
	private MyDialog dialog1;
	
    public Main() {
 
        JPanel panel = new JPanel();
 
        JLabel label = new JLabel("ID : ");
 
        JLabel pswrd = new JLabel("PassWord : ");
 
        JTextField txtID= new JTextField(10);
 
        JPasswordField txtPass = new JPasswordField(10);
 
        JButton logBtn = new JButton("Log in");
        dialog = new MyDialog(this, "Test Dialog");
        dialog1 = new MyDialog(this, "Test Dialog1");
 
 
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
 
                                    	
                            				dialog.setVisible(true); // 다이얼로그를 출력하고 작동시킨다.
                            				dialog1.setVisible(true); // 다이얼로그를 출력하고 작동시킨다.
                            			
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
 
        new Main();
 
  }
}
