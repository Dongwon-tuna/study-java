package computer_programming_hw;

import java.util.Scanner;

public class Hw2 {

	public static void main(String[] args) {
	Scanner s = new Scanner(System.in); // s��ü�� �����Ͽ���
		
		int array[] = new int[3];//�Է��� ������ ���� �� �ִ� �迭
		
		System.out.println("���� 3�� �Է�>>");
		for(int i = 0; i<3; i++) {
			array[i] = s.nextInt(); //s��ü�� netInt�� ����Ͽ� �Է¹��� ���ڸ� �迭�� �ִ´�.
		}

		
		for(int i=0; i<array.length; i++) {
			for(int j=i+1; j<array.length; j++) {
				if(array[i] > array[j]) { //�������� �˰����̴�.
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
		
		System.out.println("�߰����� " + array[1]); //�߰��� ���
		

	}


}
