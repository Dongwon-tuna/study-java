package chatting;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import chatting.FileSenderFrame.FileChooseActionListener;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.io.*;

class  ChatClientObject extends JFrame implements ActionListener,Runnable{
	private JTextArea output; 
	private JTextField input; 
	private JButton sendBtn, btn33;
	private Socket socket;
	private ObjectInputStream reader=null;
	private ObjectOutputStream writer=null; 
	private String nickName;
	private String filePath = null;
	private JTextField fileNameTf = new JTextField("");
	public ChatClientObject() {
	
		output = new JTextArea();
		output.setFont(new Font("맑은 고딕",Font.BOLD,15));
		output.setEditable(false);
		output.setBackground(Color.YELLOW);
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout()); 
		input = new JTextField();
		btn33 = new JButton("file");
		btn33.addActionListener(new FileChooseActionListener());
		sendBtn = new JButton("보내기");
		bottom.add("West", btn33);
		bottom.add("Center",input); 
		bottom.add("East",sendBtn);  
		//container에 붙이기
		Container c = this.getContentPane();
		c.add("Center", scroll);  
		c.add("South", bottom);  
		
		
		setBounds(200,200,600,600);
		setVisible(true);

		
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){ 
				
				try{
					InfoDTO dto = new InfoDTO();
					dto.setNickName(nickName);
					dto.setCommand(Info.EXIT1);
					writer.writeObject(dto); 
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
			chooser= new JFileChooser();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					        "JPG & GIF & PNG Images", 
					        "jpg", "gif", "png"); 

			chooser.setFileFilter(filter);
		
			int ret = chooser.showOpenDialog(null);
			if(ret != JFileChooser.APPROVE_OPTION) { 
				JOptionPane.showMessageDialog(ChatClientObject.this, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			filePath = chooser.getSelectedFile().getPath(); 
			fileNameTf.setText(filePath);
		}
	}

	public void service(){
		
		String serverIP= "192.168.91.128";
		if(serverIP==null || serverIP.length()==0){  
			System.out.println("서버 IP가 입력되지 않았습니다.");
			System.exit(0);
		}
		
		nickName= JOptionPane.showInputDialog(this,"닉네임을 입력하세요","닉네임" ,JOptionPane.INFORMATION_MESSAGE);
		if(nickName == null || nickName.length()==0){
			nickName="guest";
		}
		
		try{
			socket = new Socket(serverIP,9999);
		
			reader= new ObjectInputStream(socket.getInputStream());
			writer = new ObjectOutputStream(socket.getOutputStream());
			
			
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
			
			InfoDTO dto = new InfoDTO();
			dto.setCommand(Info.JOIN);
			dto.setNickName(nickName);
			writer.writeObject(dto);  
			writer.flush();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		
		Thread t = new Thread(this);
		t.start();
		input.addActionListener(this);
		sendBtn.addActionListener(this);  
	}
	
	@Override
	public void run(){
		InfoDTO dto= null;
		while(true){
			try{
				dto = (InfoDTO) reader.readObject();
				if(dto.getCommand()==Info.EXIT1){  
					reader.close();
					writer.close();
					socket.close();
					System.exit(0);
				} else if(dto.getCommand()==Info.SEND){
					
					output.append(dto.getMessage()+".\n");
					
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
	
	@Override
	public void actionPerformed(ActionEvent e){
			try{
				
				String msg=input.getText();
				InfoDTO dto = new InfoDTO();
				//dto.setNickName(nickName);
				if(msg.equals("GameStart")){
					dto.setCommand(Info.EXIT1);
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
		new ChatClientObject().service();
	}
}
