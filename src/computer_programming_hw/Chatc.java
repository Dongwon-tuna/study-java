package computer_programming_hw;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.io.*;

class  Chatc extends JFrame implements ActionListener,Runnable{
	private JTextArea output; 
	private JTextField input; 
	private JButton sendBtn, btn33;
	private Socket socket;
	private ObjectInputStream reader=null;
	private ObjectOutputStream writer=null; 
	//private String msg;
	//private InfoDTO dto;
	private String nickName;
	private String filePath = null;
	private JTextField fileNameTf = new JTextField("");
	public Chatc() {
		//센터에 TextArea만들기
		output = new JTextArea();
		output.setFont(new Font("맑은 고딕",Font.BOLD,15));
		output.setEditable(false);
		output.setBackground(Color.lightGray);
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  //항상 스크롤바가 세로로 떠있음
		
		//JPanel top = new JPanel();
		//top.setLayout(new BorderLayout()); 
		
		
		
		
		
		
		
		//top.add("East",btn33);  //센터에 붙이기
		
		
		
		//하단에 버튼과 TextArea넣기 
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout()); 
		input = new JTextField();
		btn33 = new JButton("file");
		btn33.addActionListener(new FileChooseActionListener());
		sendBtn = new JButton("보내기");
		bottom.add("West", btn33);
		bottom.add("Center",input);  //센터에 붙이기
		bottom.add("East",sendBtn);  //동쪽에 붙이기
		//container에 붙이기
		Container c = this.getContentPane();
		c.add("Center", scroll);  //센터에 붙이기
		c.add("South", bottom);  //남쪽에 붙이기
		
		//윈도우 창 설정
		setBounds(200,200,600,600);
		setVisible(true);

		//윈도우 이벤트
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){ 
				//System.exit(0);
				try{
					//InfoDTO dto = new InfoDTO(nickName,Info.EXIT);
					InfoDTO dto = new InfoDTO();
					dto.setNickName(nickName);
					dto.setCommand(Info.EXIT);
					writer.writeObject(dto);  //역슬러쉬가 필요가 없음
					writer.flush();
				}catch(IOException io){
					io.printStackTrace();
				}
			}
		});
	}
	
	class FileChooseActionListener implements ActionListener {
		private JFileChooser chooser;
		
		public FileChooseActionListener() {
			chooser= new JFileChooser(); // 파일 다이얼로그 생성
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					        "JPG & GIF & PNG Images", // 파일 이름에 창에 출력될 문자열
					        "jpg", "gif", "png"); // 파일 필터로 사용되는 확장자. *.jpg. *.gif, *.png만 나열됨

			chooser.setFileFilter(filter); // 파일 다이얼로그에 파일 필터 설정
				
			// 파일 다이얼로그 출력
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) { // 사용자가  창을 강제로 닫았거나 취소 버튼을 누른 경우
				JOptionPane.showMessageDialog(Chatc.this, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
				
			// 사용자가 파일을 선택하고 "열기" 버튼을 누른 경우
			filePath = chooser.getSelectedFile().getPath(); // 파일 경로명을 알아온다.
			fileNameTf.setText(filePath);
		}
	}

	public void service(){
		//서버 IP 입력받기
		//String serverIP = JOptionPane.showInputDialog(this, "서버IP를 입력하세요","서버IP",JOptionPane.INFORMATION_MESSAGE);
		String serverIP= "192.168.0.5";//JOptionPane.showInputDialog(this,"서버IP를 입력하세요","192.168.0.5");  //기본적으로 아이피 값이 입력되어 들어가게 됨
		if(serverIP==null || serverIP.length()==0){  //만약 값이 입력되지 않았을 때 창이 꺼짐
			System.out.println("서버 IP가 입력되지 않았습니다.");
			System.exit(0);
		}
		
		nickName= JOptionPane.showInputDialog(this,"닉네임을 입력하세요","닉네임" ,JOptionPane.INFORMATION_MESSAGE);
		if(nickName == null || nickName.length()==0){
			nickName="guest";
		}
		
		try{
			socket = new Socket(serverIP,9999);
			//에러 발생
			reader= new ObjectInputStream(socket.getInputStream());
			writer = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("전송 준비 완료!"); 
			
		} catch(UnknownHostException e ){
			System.out.println("서버를 찾을 수 없습니다.");
			e.printStackTrace();
			System.exit(0);
		} catch(IOException e){
			System.out.println("서버와 연결이 안되었습니다.");
			e.printStackTrace();
			System.exit(0);
		}
		try{
			//서버로 닉네임 보내기
			
			InfoDTO dto = new InfoDTO();
			dto.setCommand(Info.JOIN);
			dto.setNickName(nickName);
			writer.writeObject(dto);  //역슬러쉬가 필요가 없음
			writer.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		//스레드 생성
		
		Thread t = new Thread(this);
		t.start();
		input.addActionListener(this);
		sendBtn.addActionListener(this);  //멕션 이벤트 추가
	}
	//스레드 오버라이드 
	@Override
	public void run(){
		//서버로부터 데이터 받기
		InfoDTO dto= null;
		while(true){
			try{
				dto = (InfoDTO) reader.readObject();
				if(dto.getCommand()==Info.EXIT){  //서버로부터 내 자신의 exit를 받으면 종료됨
					reader.close();
					writer.close();
					socket.close();
					System.exit(0);
				} else if(dto.getCommand()==Info.SEND){
					output.append(dto.getMessage()+"\n");
					
					int pos=output.getText().length();
					output.setCaretPosition(pos);
				}
			}catch(IOException e){
				e.printStackTrace();
			}catch(ClassNotFoundException e){
				e.printStackTrace();
			}	
		}
	}
	//ActionPerformed
	@Override
	public void actionPerformed(ActionEvent e){
			try{
				//서버로 보냄 
				//JTextField값을 서버로보내기
				//버퍼 비우기
				String msg=input.getText();
				InfoDTO dto = new InfoDTO();
				//dto.setNickName(nickName);
				if(msg.equals("exit")){
					dto.setCommand(Info.EXIT);
				} else {
					dto.setCommand(Info.SEND);
					dto.setMessage(msg);
					dto.setNickName(nickName);
				}
				writer.writeObject(dto);
				writer.flush();
				input.setText("");
				
			}catch(IOException io){
				io.printStackTrace();
			}
	}

	public static void main(String[] args) 
	{
		new Chatc().service();
	}
}
//동시 채팅을 위해 쓰레드를 생성해주어야 함