package java_study_2022;

public class Scope {
	
	static int i = 0;	//��������
	
	static void a() {
		i = 0;
		//int i = 0; 	//��������
						//a()�޼ҵ� �ȿ����� i ������ ���� �ȿ����� ���� ������ �� ����.
	}

	public static void main(String[] args) {
		for( i = 0; i<5; i++) {		//static int i�� ���� �ҷ���
			a();					//���⼭ a()�� ���� i�� ���� ���� �� ��.
			System.out.println(i);
		}

	}

}
/*
 * �޼ҵ� �ȿ��� �������� ������ �޼ҵ� �ȿ����� ��ȿ�ϴ�.
 */
