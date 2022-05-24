package java_study_2022;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class TextAreaEx1 extends JFrame{
    TextAreaEx1(){
        this.setTitle("�ؽ�Ʈ���� ����� ����");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.add(new MyCenterPanel(), BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.setSize(300,300);
        this.setVisible(true);
    }
    class MyCenterPanel extends JPanel{
        JTextField tf;
        JButton btn;
        JTextArea ta;
        MyCenterPanel(){
            tf=new JTextField(20);
            btn=new JButton("�߰�");
            
            btn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    ta.append(tf.getText()+"\n");
                }
            });
            ta=new JTextArea("hello",7,20);
            add(new JLabel("�Ʒ� â�� ���ڿ��� �Է��ϰ� ��ư�� Ŭ���ϼ���."));
            add(tf);
            add(btn);
            add(new JScrollPane(ta));
        }
    }
}
public class TextAreaEx {
    public static void main(String[] args) {
        new TextAreaEx();
    }
}
