package computer_programming_hw;



import java.io.*;
import java.util.*;

public class Quiz_1 {
private Vector<String> wordVector = new Vector<String>();
	
	public Quiz_1() { }
	
	private boolean readFile() { 
		try {
			Scanner fScanner = new Scanner(new FileInputStream("c:\\Temp\\words.txt"));
			while(fScanner.hasNext()) 
				wordVector.add(fScanner.nextLine()); 
			fScanner.close();
		}catch(FileNotFoundException e) { 
			System.out.println("������Ʈ ���� ���� words.txt ������ �����ϴ�");
			return false;
		} 
		System.out.println("������Ʈ ���� ���� words.txt ������ �о����ϴ�...");
		return true;
	}
	
	private void processQuery() { 
		Scanner scanner = new Scanner(System.in);
		
			boolean found = false;
			System.out.print("�ܾ�>>");
			String searchWord = scanner.nextLine(); 
			
			FileWriter fout = null;
			try {
				fout = new FileWriter("c:\\Temp\\out.txt");
				for(int i=0; i<wordVector.size(); i++) {
					String word = wordVector.get(i); 
					if(word.length() < searchWord.length()) 
						continue;
					
					String frontPart = word.substring(0, searchWord.length());
					
					ArrayList<String> wor = new ArrayList<String>();
					
					if(searchWord.equals(frontPart)) { 
						System.out.println(word); 
						fout.write(word);
						fout.write("\r\n", 0, 2);
						wor.add(word);
						found = true;
					}
				}
				if(!found) 
					System.out.println("�߰��� �� ����");
				
			}catch (IOException e) {
				System.out.println("����� ����");
		
			}
		scanner.close();

	}
	
	public void run() {
		boolean res = readFile(); 
		if(res == true)
			processQuery();
		
	}
	
	public static void main(String[] args) {
		Quiz_1 ws = new Quiz_1();
		ws.run();

	
	}
}

