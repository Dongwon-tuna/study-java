package computer_programming_hw;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Midterm_3 {

   public static void main(String[] args) {
      System.out.println("���� �ؽ�Ʈ�� �Է��ϰ� �����ݷ��� �Է��ϼ���.");
      StringBuffer sb = new StringBuffer(); // ��Ʈ�� ���۸� �����Ͽ� Ű�� �Է¹޴´�.
      Scanner scanner = new Scanner(System.in);

      while (true) {
         String line = scanner.nextLine(); // �ۼ��� �ؽ�Ʈ ������ ����Ѵ�.

         if (line.equals(";")) {
            break; // ����ڷ� ���� �����ݷ��� �ԷµǸ� EOF�� �ؼ�
         }

         sb.append(line.toLowerCase()); // toLowerCase�� Ȱ���Ͽ��� �빮�ڸ� �ҹ��ڷ� �ٲ۴�.
      }

      // --------------------------------------------------------------------------------------------------------------Ư�����ڸ� �����ϴ� �˰���
     
      Pattern validPattern = Pattern.compile("[a-zA-Z]");

      Matcher matcher = validPattern.matcher(sb); // ���ڿ����� ��ȿ���� ���� Ư�����ڸ� ã�Ƴ��� matcher
      String resultString = "";

      while (matcher.find()) {
         resultString += matcher.group(); // Ư�����ڰ� ���ŵ� ���ڿ��� result�� �����Ѵ�.
      }

      // ----------------------------------------------------------------------------------------------------------------���ĺ����� ���ϴ� �˰���
      

      // ���ĺ� �ҹ����� ���� 26���� �ִ�. ���� 26���� ���� �迭�� ���ĺ��� �� ���ĺ��� ������ ���� 26*2 �迭 ����
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
      
      System.out.println("1�� ������ abc��\r2�� ������ �󵵼�\r3�� ������ ���󵵼�");
      int line = scanner.nextInt();
      
      if(line == 1 ) {
    	  // a b c �� ���
          System.out.println("ABC �� ����Դϴ�.");
          for (char[] cs : alphabet) {
             System.out.printf("%c: ", cs[0]);
             for (int i = 0; i < cs[1] ; i++) {
                System.out.print("@");
             }
             System.out.println();
          }
      }
      
      if(line == 2 ) {
    	  // ���������� ���� �������� ����
          for (int i = 0; i < alphabet.length - 1; i++) {
             for (int j = 1; j < alphabet.length - i; j++) {
                if (alphabet[j][1] > alphabet[j - 1][1]) {
                   char[] temp = alphabet[j - 1];
                   alphabet[j - 1] = alphabet[j];
                   alphabet[j] = temp;
                }
             }
          }

          System.out.println("\n\n�󵵼� ����Դϴ�.");
          for (char[] cs : alphabet) {
             System.out.printf("%c: ", cs[0]);
             for (int i = 0; i < cs[1] ; i++) {
                System.out.print("@");
             }
             System.out.println();
          }
      }
 
      if(line == 3 ) {
    	  // ���������� �̿��� �������� ����
          for (int i = 0; i < alphabet.length - 1; i++) {
             for (int j = 1; j < alphabet.length - i; j++) {
                if (alphabet[j][1] < alphabet[j - 1][1]) {
                   char[] temp = alphabet[j - 1];
                   alphabet[j - 1] = alphabet[j];
                   alphabet[j] = temp;
                }
             }
          }

          System.out.println("\n\n���󵵼� ����Դϴ�.");
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