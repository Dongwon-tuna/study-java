package computer_programming_hw;

import java.util.Scanner;

public class Hw3 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int money = s.nextInt();
		int [] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};
		
		int number = 0 ; // �� �������� �̵��ϰ� �� �ִ� ����
		
		int [] howmany = new int[8]; // ������ �����ϴ¹迭
		
	
		
		System.out.println(howmany[number]);
		
		while (money > 0) {
			howmany[number] = money / unit[number];
			if(howmany[number] > 0) {	
				money = money - howmany[number]*unit[number];		//��ü �ݾ׿��� ���� �ľ��� �Ϸ�� ȭ���� ���� ���� ��
			}
			number ++;
		}
		
	
		for(int i = 0; i < 8; i++) {
			System.out.println(unit[i] + "�� ¥�� : " + howmany[i] + "��"); // ����� ���
		}
		
	}

}

