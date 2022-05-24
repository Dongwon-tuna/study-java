package computer_programming_hw;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TEST extends JFrame{
	JPanel jp = new JPanel(); // 패널 초기화
	JButton jb = new JButton("버튼"); // 버튼 초기화
	JLabel jl = new JLabel("레이블"); // 레이블 초기화
	JTextField tf = new JTextField(10); // 텍스트필드 초기화
	
	public TEST(){
		super("Test"); // JFrame의 생성자에 값을 입력하면 윈도창에 해당 값이 입력됩니다.
		
		jp.add(jb); // jp라는 패널에 jb라는 버튼 추가
		jp.add(jl); // jp라는 패널에 jl라는 레이블 추가
		jp.add(tf); // jp라는 패널에 tf라는 텍스트필드 추가
		add(jp); // JFrame에 jp라는 패널 추가
		
		setSize(400, 300); // 윈도우의 크기 가로x세로
		setVisible(true); // 창을 보여줄떄 true, 숨길때 false
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x 버튼을 눌렀을때 종료
	}

	public static void main(String[] args){
		new TEST();
	}
}
