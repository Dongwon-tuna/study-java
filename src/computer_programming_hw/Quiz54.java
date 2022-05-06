package computer_programming_hw;

import java.io.*;
import java.util.*;

public class Quiz54 {
	private Vector<String> wordVector = new Vector<String>();
	
	String longest;
	public Quiz54() { }
	
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
	
	String processQuery() { 
		Scanner scanner = new Scanner(System.in);
		
			boolean found = false;
			System.out.print("�ܾ�>>");
			String searchWord = scanner.nextLine(); 
			
			ArrayList<String> wor = new ArrayList<String>();
			
			for(int i=0; i<wordVector.size(); i++) {
				String word = wordVector.get(i); 
				if(word.length() < searchWord.length()) 
					continue;
				
				String frontPart = word.substring(0, searchWord.length());
				
				
				
				if(searchWord.equals(frontPart)) { 
					System.out.println(word); 
					wor.add(word);
					found = true;
				}
			}
			int longestIndex = 0; 
			for(int i=1; i<wor.size(); i++) {
				if(wor.get(longestIndex).length() < wor.get(i).length()) 
					longestIndex = i;
			}
			System.out.println("\n���� �� �̸��� : " + wor.get(longestIndex));
			
			FileWriter fout = null;
			
			try {
				fout = new FileWriter("c:\\Temp\\out.txt");
				fout.write(wor.get(longestIndex));
				fout.close();
			}catch(IOException e) {
				System.out.println("������ �ȵƾ��");
			}
			
		
			if(!found) 
				System.out.println("�߰��� �� ����");
		
		scanner.close();
		
		return wor.get(longestIndex);
		
	}
	
	public void run() {
		boolean res = readFile(); 
		if(res == true)
			processQuery();
		
		
	}
	
	
	public static void main(String[] args) {
		Quiz54 ws = new Quiz54();
		ws.run();
		
		
	}
}
