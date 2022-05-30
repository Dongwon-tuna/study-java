package java_study_2022;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 

class MyDialog extends JDialog{
	JTextField tf = new JTextField(10); 
	JButton btn = new JButton("전송"); 
	JTextArea ta = new JTextArea(7, 20);
	public MyDialog(JFrame frame, String title) {
		super(frame,title);

		Container con = getContentPane();
		con.setBackground(Color.GRAY);
		con.setLayout(null);
		
		//JTextField text = new JTextField(10);
		tf.setSize(150,55);
		tf.setLocation(0,310);
		add(tf);
		
		//JTextArea ta;
		//ta= new JTextArea(7, 20);
		ta.setSize(230,290);
		ta.setLocation(0,15);
		add(ta);
		
		
		
		//JButton btn = new JButton("전송");
		btn.setLocation(170,310);
		btn.setSize(70,60);
		add(btn);
		
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				String csdfa = get();
				ta.append(t.getText() + "\n"); 
				t.setText(""); 
			}
		});
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s11 = tf.getText();
				
				ta.append(s11 + "\n"); 
				tf.setText("");
			}
		});
	
		
		setSize(250,400);
		
		
	}
	
	public String get() {
		return tf.getText();
	}
	
	/*public void dodo(String some) {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s11 = some;
				
				ta.append(s11 + "\n"); 
				tf.setText("");
			}
		});
		
	}
	*/
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
 
              String id = "hdw";
              String pass = "1";
 
 
                   if(id.equals(txtID.getText()) &&  pass.equals(txtPass.getText())) {
 
                                    	
                    dialog.setVisible(true); // 
                    //String cc1 = dialog.get();
                    //dialog.dodo(cc1);
                    dialog1.setVisible(true); 
                    //dialog1.dodo(cc1);		
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
