package chatting;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class FileReceiverFrame extends JFrame {
	private JTextArea log = new JTextArea(); 
	private JLabel imageLabel = new JLabel();
	
	public FileReceiverFrame() {
		super("파일 받는 서버");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new JScrollPane(log), BorderLayout.NORTH);
		c.add(imageLabel, BorderLayout.CENTER);
		
		setSize(300,300);
		setVisible(true);
		
		startService();
		
	}
	
	private void startService() {
		ServerThread server = new ServerThread();
		server.start();
	}
	
	
	private void drawImage(String file) {
		ImageIcon icon = new ImageIcon(file);
		imageLabel.setIcon(icon);
		this.pack();
	}
	
	private class ServerThread extends Thread {
		
		@Override
		public void run() {
			BufferedInputStream fin = null;
			BufferedOutputStream fout = null;
			ServerSocket listener = null;
			Socket socket = null;
			String saveFileName = null;
			try {
				listener = new ServerSocket(9999);
			} catch (IOException e1) {
				e1.printStackTrace();
			} // 서버 소켓 생성
			
			while(true) {
				try {	
					socket = listener.accept(); // waiting client connection
					log.setText("연결됨\n");
					fin = new BufferedInputStream(socket.getInputStream()); // 클라이언트로부터의 입력 스트림
					int cmd;
					String fileName = null;
					long length=0;
					
					cmd = fin.read();
					if (cmd == Command.FILE_NAME) { // FILE_NAME 명령 수신
						int nameSize = receiveInt(fin); // 파일 이름 크기
						log.append("전송받은 파일 이름 길이 :" + nameSize + "\n");
						byte fname[] = new byte[nameSize];
						fin.read(fname); 
						fileName = new String(fname);
						log.append("전송받은 파일 이름:" + fileName + "\n");
						saveFileName = "copy_" + fileName;
						log.append("저장할 파일 이름:" + saveFileName + "\n");
						fout = new BufferedOutputStream(new FileOutputStream(saveFileName));
					} else {
						log.append("명령 수신 오류" + cmd + "\n");
						socket.close(); // 클라이언트와 통신용 소켓 닫기
						listener.close(); // 서버 소켓 닫기
						return;
					}
					cmd = fin.read();
					if (cmd == Command.FILE_SIZE) { // FILE_SIZE 명령 수신
						int lenghLow = receiveInt(fin); // 파일 크기의 하위 4바이트
						int lenghHigh = receiveInt(fin); // 파일 크기의 상위 4바이트
						length = lenghHigh;
						length <<= 32; // 상위 바이트로 만들기 위해 32비트 쉬프트
						length += lenghLow; // 하위 4 바이트 더하기
						log.append("전송받은 파일 크기:" + length + "\n");
					} else {
						log.append("명령 수신 오류" + cmd + "\n");
						if (fout != null)
							fout.close();
						socket.close(); // 클라이언트와 통신용 소켓 닫기
						listener.close(); // 서버 소켓 닫기
						return;
					}
					cmd = fin.read();
					if (cmd == Command.SEND_BEGIN) {
						int numberToRead;
						while (length >0) {
							byte b[] = new byte[2048];
							if (length < b.length) 
								numberToRead = (int)length;
							else
								numberToRead = b.length;
							int numRead = fin.read(b, 0, numberToRead);
							if (numRead <= 0) { 
								if (length > 0) { // 더 이상 읽을 것이 없는데 아직 파일 크기만큼 못 읽은 경우
									log.append("전송 오류가 발생했습니다. 읽은 바이트: " + numRead + " 남은 바이트:" + length + "\n");
									break;
								}
							} else {
								log.append("."); // 진행 상태 표시 
								fout.write(b, 0, numRead);
								length -= numRead;
							}
						}
						cmd = fin.read();
						if (cmd == Command.SEND_END) { // SEND_END 명령
							log.append("\n파일 수신 성공. 현재 퐅더에 저장되었습니다.\n");
						} else {
							log.append("\n명령 수신 오류" + cmd + "\n");
						}
						if (fout != null)
							fout.close();
						socket.close(); // 클라이언트와 통신용 소켓 닫기					
						drawImage(saveFileName);
					}
				} catch (IOException e) {
					e.printStackTrace();
					log.append("파일 수신 중 오류가 발생했습니다.\n");
				}
			} // end of while
		}

	}

	private int receiveInt(BufferedInputStream fin) throws IOException {
		int value;
		value = fin.read();
		value |= fin.read() << 8;
		value |= fin.read() << 16;
		value |= fin.read() << 24;
		return value;
	}
	
	public static void main(String[] args) {
		new FileReceiverFrame();
	}



}
