package java_study_2022;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.Arrays;


public class Alphabet {

	public static void main(String[] args) {
		   // TODO Auto-generated method stub
	      System.out.println("���� �ؽ�Ʈ�� �Է��ϰ� �����ݷ��� �Է��ϼ���.");
	      StringBuffer sb = new StringBuffer(); // ��Ʈ�� ���۸� �����Ͽ� Ű�� �Է¹޴´�.
	      Scanner scanner = new Scanner(System.in);
	      while(true) { 
	         String line = scanner.nextLine(); // �ۼ��� �ؽ�Ʈ ������ ����Ѵ�.
	         line = line.toLowerCase(); // toLowerCase�� Ȱ���Ͽ��� �빮�ڸ� �ҹ��ڷ� �ٲ۴�. 
	         sb.append(line); 
	      
	      //--------------------------------------------------------------------------------------------------------------Ư�����ڸ� ������ �ִ� �˰���
	      Pattern nonValidPattern = Pattern.compile("[a-zA-Z]");

	      Matcher matcher = nonValidPattern.matcher(sb); //���ڿ����� ��ȿ���� ���� Ư�����ڸ� ã�Ƴ��� matcher
	      String result = ""; 
	        
	      while (matcher.find()) {
	          result += matcher.group();    //Ư�����ڰ� ���ŵ� ���ڿ��� result�� �����Ѵ�.
	      }                                                                                    
	      //--------------------------------------------------------------------------------------------------------------
	      String[] resultarray = result.split("");
	      
	   
	      
	      if(line.length() == 1 && line.charAt(0)==';'){//;�� �Էµ� ��� �����Ų��. �����Ű�� ������ �Էµ� ��°����� ��� ����Ѵ�.
	         
	         //System.out.println("���ĺ� �󵵼�: 1�Է� \r���ĺ� �� �󵵼�: 2�Է�");
	         /*
	         int press = scanner.nextInt();
	         if (press == 1) {
	            
	         }
	         
	         if (press == 2 ) {
	            
	         }
	         
	         else {
	            System.out.println("�߸� �����̳׿� �����մϴ٤�");
	            break;
	         }
	         */
	         //----------------------------------------------------------------------------------------------------------------���ĺ� ���� ���ϴ� �˰���
	         int[] alphabet = new int[26];//���ĺ� �ҹ����� ���� 26���� �ִ�. �ƽ�Ű�ڵ忡�� ����ҹ��ڴ�  97 = 'a' ����  122 = 'z' ����
	         for(int i = 0; i < result.length(); i++) {
	               char ch = result.charAt(i);
	               alphabet[ch - 'a']++;
	           }
	         
	         
	           for(int i = 0; i < 26; i++) {
	              int howmany =alphabet[i];
	              System.out.println((char)(97+i)+ ":" + alphabet[i] );
	              for(int j = 0; j<howmany; j++) {
	                 System.out.print('@');
	              }
	              System.out.println();
	               
	           }
	           
	         //-----------------------------------------------------------------------------------------------------------------------
	         break;
	      }
	         
	      
	      
	      //System.out.println(result);



	      
	   }


	}

}
