package chatting;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileSenderFrame extends JFrame {
	private JTextField fileNameTf = new JTextField(20);
	private JButton selBtn = new JButton("이미지 선택");
	private JButton sendBtn = new JButton("파일 전송");
	private String filePath = null;
	
	public FileSenderFrame() {
		setTitle("파일 전송 클라이언트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(fileNameTf);
		c.add(selBtn);
		c.add(sendBtn);
		
		selBtn.addActionListener(new FileChooseActionListener());
		sendBtn.addActionListener(new MyActionListener());
		setSize(350,150);
		setVisible(true);
	
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
				JOptionPane.showMessageDialog(FileSenderFrame.this, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
				
			// 사용자가 파일을 선택하고 "열기" 버튼을 누른 경우
			filePath = chooser.getSelectedFile().getPath(); // 파일 경로명을 알아온다.
			fileNameTf.setText(filePath);
		}
	}
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(filePath == null)
				return; // 파일이 선택되지 않았음
			
			FileInputStream fin = null; // BufferedInputStream
			File f = null;
			BufferedOutputStream fout = null;
			Scanner scanner  = new Scanner(System.in);
			Socket socket = null;
			try {
				socket = new Socket("localhost", 9999); // 클라이언트 소켓 생성
				f = new File(filePath);
				long length = f.length();
				fin = new FileInputStream(f); // 키보드로부터의 입력 스트림
				fout = new BufferedOutputStream(socket.getOutputStream()); // 서버로의 출력 스트림
				
				byte[] fname = f.getName().getBytes(); // 경로를 제외한 파일 이름
				int nameSize = fname.length;
				fout.write(Command.FILE_NAME); // FILE_NAME 명령 전송
				sentInt(fout, nameSize);  // 파일 이름 크기 전송
				fout.write(fname); // 실제 파일 이름 전송
				
				fout.write(Command.FILE_SIZE); // FILE_SIZE 명령 전송
				sentInt(fout, (int)length);
				sentInt(fout, (int)(length >>> 32));
				
				fout.write(Command.SEND_BEGIN); // SEND_BEGIN 명령 전송
				int count = 0;
				byte b[] = new byte[512];
				while (length > 0) {
					int numRead = fin.read(b,0,b.length);
					if (numRead <= 0) { 
						if (length > 0) { // 더 이상 읽을 것이 없는데 아직 파일 크기만큼 못 읽은 경우
							System.out.println("전송 오류가 발생했습니다. 읽은 바이트: " + count + " 남은 바이트:" + length);					
							break;
						} 
					} else {
						fout.write(b, 0, numRead);
						length -= numRead;
						fout.flush();
						count += numRead;
					}
				}
				fout.write(Command.SEND_END); // SEND_END 명령 전송
				fout.flush();
				fin.close();
				socket.close(); // 클라이언트 소켓 닫기
				System.out.println("파일 전송이 완료되었습니다.");
			} catch (IOException e2) {
				System.out.println("파일 전송 중 오류가 발생했습니다.");
			}
			
		}
		
	}
	
	private void sentInt(BufferedOutputStream fout, int value) throws IOException {
		fout.write(value & 0x000000ff);
		fout.write((value & 0x0000ff00)>>8);
		fout.write((value & 0x00ff0000)>>16);
		fout.write((value & 0xff000000)>>24);
	}
	
	public static void main(String[] args) {
		new FileSenderFrame();
	}

	
}
