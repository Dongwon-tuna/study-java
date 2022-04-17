package computer_programming_hw;
import java.util.Scanner;
abstract class Converter {
	abstract protected double convert(double src); //-----------------------�� �޼ҵ� ���� �� 3���� �޼ҵ�� �߻�޼ҵ� �̱� ������ ����� �ʿ��ϴ�.
	abstract protected String srcString(); // (�ٲٱ� �� ���� �޼ҵ�)
	abstract protected String destString(); //(�ٲ� �� ���� �޼ҵ�)
	protected double ratio; // ���� >1������ km�� ȯ��
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(srcString() + " �� " + destString() + " �� �ٲߴϴ�.");
		System.out.print(srcString() + " �� �Է��ϼ���>> ");
		double val = scanner.nextDouble();
		double res = convert(val);
		System.out.println(" ��ȯ ���: " + res + destString() + " �Դϴ�");
		scanner.close();
	}
}
class Km2Mile extends Converter { //Km2Mile �̶� Ŭ������ Converter�� ��ӹ޾Ҵ�.
	public Km2Mile(double ratio) {//1 ������ ȯ�� �� km ���� �Է¹޴� ������
		this.ratio = ratio;
	}
	protected String srcString() {//�߻�޼ҵ� scrString �� �������̵� �Ͽ���
		return " Km "; //km�� �����Ͽ� ��ӹ��� run�޼ҵ忡�� km�� �ʿ��� ���� ��� ����
	} 

	protected String destString() { // �߻�޼ҵ� destString �� �������̵� �Ͽ���
		return " mile ";// mile�� �����Ͽ� ��ӹ��� run�޼ҵ忡�� mile�� �ʿ��� ���� ��� ����
	} 

	protected double convert(double src) { //�߻�޼ҵ� convert �� �������̵� �Ͽ���. �Է��� km�Ÿ��� 1������ km�� ��ŭ �����ش�. ex)30km/1.6lm
		return src/ratio;					// �Է��� km�Ÿ��� 1������ km�� ��ŭ �����ش�. ex)30km/1.6lm
	}	
}	
public class Midterm1 {	
	public static void main(String[] args) {
		
		Km2Mile toMile = new Km2Mile(1.6); // 1������ 1.6Km���� �⺻ ��ȭ�� ����
		
		toMile.run();
	}
}
