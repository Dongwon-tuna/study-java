package java_study_2022;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class TextAreaEx1 extends JFrame{
    TextAreaEx1(){
        this.setTitle("텍스트영역 만들기 예제");
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
            btn=new JButton("추가");
            
            btn.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    ta.append(tf.getText()+"\n");
                }
            });
            ta=new JTextArea("hello",7,20);
            add(new JLabel("아래 창에 문자열을 입력하고 버튼을 클릭하세요."));
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
