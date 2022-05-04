package java_study_2022;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.Arrays;


public class Alphabet {

	public static void main(String[] args) {
		   // TODO Auto-generated method stub
	      System.out.println("영문 텍스트를 입력하고 세미콜론을 입력하세요.");
	      StringBuffer sb = new StringBuffer(); // 스트링 버퍼를 생성하여 키를 입력받는다.
	      Scanner scanner = new Scanner(System.in);
	      while(true) { 
	         String line = scanner.nextLine(); // 작성한 텍스트 라인을 출력한다.
	         line = line.toLowerCase(); // toLowerCase를 활용하여서 대문자를 소문자로 바꾼다. 
	         sb.append(line); 
	      
	      //--------------------------------------------------------------------------------------------------------------특수문자를 제거해 주는 알고리즘
	      Pattern nonValidPattern = Pattern.compile("[a-zA-Z]");

	      Matcher matcher = nonValidPattern.matcher(sb); //문자열에서 유효하지 않은 특수문자를 찾아내는 matcher
	      String result = ""; 
	        
	      while (matcher.find()) {
	          result += matcher.group();    //특수문자가 제거된 문자열을 result에 저장한다.
	      }                                                                                    
	      //--------------------------------------------------------------------------------------------------------------
	      String[] resultarray = result.split("");
	      
	   
	      
	      if(line.length() == 1 && line.charAt(0)==';'){//;이 입력된 경우 종료시킨다. 종료시키기 이전에 입력된 출력값들을 모두 출력한다.
	         
	         //System.out.println("알파벳 빈도순: 1입력 \r알파벳 역 빈도순: 2입력");
	         /*
	         int press = scanner.nextInt();
	         if (press == 1) {
	            
	         }
	         
	         if (press == 2 ) {
	            
	         }
	         
	         else {
	            System.out.println("잘못 누르셨네요 종료합니다ㅣ");
	            break;
	         }
	         */
	         //----------------------------------------------------------------------------------------------------------------알파벳 갯수 구하는 알고리즘
	         int[] alphabet = new int[26];//알파벳 소문자의 경우는 26개가 있다. 아스키코드에서 영어소문자는  97 = 'a' 부터  122 = 'z' 까지
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
