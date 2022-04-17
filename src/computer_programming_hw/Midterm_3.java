package computer_programming_hw;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Midterm_3 {

   public static void main(String[] args) {
      System.out.println("영문 텍스트를 입력하고 세미콜론을 입력하세요.");
      StringBuffer sb = new StringBuffer(); // 스트링 버퍼를 생성하여 키를 입력받는다.
      Scanner scanner = new Scanner(System.in);

      while (true) {
         String line = scanner.nextLine(); // 작성한 텍스트 라인을 출력한다.

         if (line.equals(";")) {
            break; // 사용자로 부터 세미콜론이 입력되면 EOF로 해석
         }

         sb.append(line.toLowerCase()); // toLowerCase를 활용하여서 대문자를 소문자로 바꾼다.
      }

      // --------------------------------------------------------------------------------------------------------------특수문자를 제거하는 알고리즘
     
      Pattern validPattern = Pattern.compile("[a-zA-Z]");

      Matcher matcher = validPattern.matcher(sb); // 문자열에서 유효하지 않은 특수문자를 찾아내는 matcher
      String resultString = "";

      while (matcher.find()) {
         resultString += matcher.group(); // 특수문자가 제거된 문자열을 result에 저장한다.
      }

      // ----------------------------------------------------------------------------------------------------------------알파벳갯수 구하는 알고리즘
      

      // 알파벳 소문자의 경우는 26개가 있다. 따라서 26개의 길이 배열에 알파벳과 그 알파벳의 개수를 담을 26*2 배열 선언
      char[][] alphabet = new char[26][2]; 
      int sumOfAlphabets = 0;
      for (int i = 0; i < alphabet.length; i++) {
         alphabet[i][0] = (char) ('a' + i);
         alphabet[i][1] = 0;
      }
      for (int i = 0; i < resultString.length(); i++) {
         char ch = resultString.charAt(i);
         alphabet[ch - 'a'][1]++;
         sumOfAlphabets++;
      }
      
      System.out.println("1를 누르면 abc순\r2를 누르면 빈도순\r3을 누르면 역빈도순");
      int line = scanner.nextInt();
      
      if(line == 1 ) {
    	  // a b c 순 출력
          System.out.println("ABC 순 출력입니다.");
          for (char[] cs : alphabet) {
             System.out.printf("%c: ", cs[0]);
             for (int i = 0; i < cs[1] ; i++) {
                System.out.print("@");
             }
             System.out.println();
          }
      }
      
      if(line == 2 ) {
    	  // 버블정렬을 통한 내림차순 정렬
          for (int i = 0; i < alphabet.length - 1; i++) {
             for (int j = 1; j < alphabet.length - i; j++) {
                if (alphabet[j][1] > alphabet[j - 1][1]) {
                   char[] temp = alphabet[j - 1];
                   alphabet[j - 1] = alphabet[j];
                   alphabet[j] = temp;
                }
             }
          }

          System.out.println("\n\n빈도순 출력입니다.");
          for (char[] cs : alphabet) {
             System.out.printf("%c: ", cs[0]);
             for (int i = 0; i < cs[1] ; i++) {
                System.out.print("@");
             }
             System.out.println();
          }
      }
 
      if(line == 3 ) {
    	  // 버블정렬을 이용한 오름차순 정렬
          for (int i = 0; i < alphabet.length - 1; i++) {
             for (int j = 1; j < alphabet.length - i; j++) {
                if (alphabet[j][1] < alphabet[j - 1][1]) {
                   char[] temp = alphabet[j - 1];
                   alphabet[j - 1] = alphabet[j];
                   alphabet[j] = temp;
                }
             }
          }

          System.out.println("\n\n역빈도순 출력입니다.");
          for (char[] cs : alphabet) {
             System.out.printf("%c: ", cs[0]);
             for (int i = 0; i < cs[1] ; i++) {
                System.out.print("@");
             }
             System.out.println();
          }
      }

    

    

   }
}