package computer_programming_hw;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;




public class ChatServer extends JFrame  {
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private ServerSocket listener = null;
	private Socket socket = null;
	//private Receiver receiver; // JTextArea를 상속받고 Runnable 인터페이스를 구현한 클래스로서 받은 정보를 담는 객체
	private JTextField sender; // JTextField 객체로서 보내는 정보를 담는 객체
	private JButton start, end;
	private JTextArea t1 = new JTextArea("",200,20);
	int count = 0;
	
	public ChatServer() {
		setTitle("서버 채팅 창"); // 프레임 타이틀
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프레임 종료 버튼(X)을 클릭하면 프로그램 종료
		Container c = getContentPane();
		
		c.setLayout(null); //BorderLayout 배치관리자의 사용
		//receiver = new Receiver(); // 클라이언트에서 받은 메시지를 출력할 컴퍼넌트
		//receiver.setBounds(10,10,470,310);
		//receiver.setEditable(false); // 편집 불가
		//add(receiver); // 스크롤바를 위해  ScrollPane 이용
		t1.setBounds(0,0,500,310);
		//t1.setBackground(new Color(155,187,212));
		t1.setOpaque(true);
		add(t1);
		
		

		sender = new JTextField();
		//sender.addActionListener(this);
		sender.setBounds(0,400,100,30);

		//add(receiver); // 스크롤바를 위해  ScrollPane 이용
		add(sender);
		
		setSize(500, 500); // 폭 400 픽셀, 높이 200 픽셀의 크기로 프레임 크기 설정
		setVisible(true); // 프레임이 화면에 나타나도록 설정
		//------------------------------------------------------버튼추가
		start = new JButton("Start");
		start.setBounds(100,400,90,30);
		end = new JButton("End");
		end.setBounds(300,400,90,30);
		add(start);
		add(end);
		//------------------------통신 시작점
		int[]num = new int[2];
		num[0]=1;
		
		start.addActionListener(new Myact());
		if(count == 1) {
			try {
				setupConnection();
			} catch (IOException e) {
				handleError(e.getMessage());
			}
			
		}
		System.out.println(count+2);
		System.out.println(num[0]);
		
	}
	
	private class Myact implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Start")) {
				//num[0]=1;
				t1.append("\n서버 시작됨");
				synchronized(this) {
					count = 1;
				}
				System.out.print(count);
				//System.out.println(num[0]);
				
				//Thread th = new Thread(receiver); // 상대로부터 메시지 수신을 위한 스레드 생성
				//th.start();
				/*
				try {
					setupConnection();
				} catch (IOException e1) {
					handleError(e1.getMessage());
				}
				*/
			}	
			
		}
	
		
		
	}
	private void setupConnection() throws IOException {
		listener = new ServerSocket(9999); // 서버 소켓 생성
		socket = listener.accept(); // 클라이언트로부터 연결 요청 대기
		t1.append("클라이언트 연락됨");
		//System.out.println("연결됨");
		//receiver.append("클라이언트로부터 연결 완료");
		//int pos = receiver.getText().length();
		//receiver.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동
		
		in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 클라이언트로부터의 입력 스트림
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 클라이언트로의 출력 스트림
	}

	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1);
	}
	
	
	/*
	private class Receiver extends JTextArea implements Runnable {
		@Override
		public void run() {
			String msg = null;
			while (true) {
				try {
					msg = in.readLine(); // 상대로부터 한 행의 문자열 받기
				} catch (IOException e) {
					handleError(e.getMessage());
				} 
				this.append("\n  클라이언트 : " + msg); // 받은 문자열을 JTextArea에 출력
				int pos = this.getText().length();
				this.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동
			}
		}
	}
*/
	/*
	@Override
	public void actionPerformed(ActionEvent e) { // JTextField에 <Enter> 키 처리
		if (e.getSource() == sender) {
			String msg = sender.getText(); // 텍스트 필드에서 문자열 얻어옴
			try {
				out.write(msg+"\n"); // 문자열 전송
				out.flush();
				
				receiver.append("\n서버 : " + msg);// JTextArea에 출력
				int pos = receiver.getText().length();
				receiver.setCaretPosition(pos); // caret 포지션을 가장 마지막으로 이동
				sender.setText(null); // 입력창의 문자열 지움
			} catch (IOException e1) {
				handleError(e1.getMessage());
			} 
		}
	}
	*/
	public static void main(String[] args) {
		new ChatServer();
	}

}
