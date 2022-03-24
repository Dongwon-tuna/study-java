package computer_programming_hw;

import java.util.Scanner;

class Add {
	private int a, b;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int calculate() {
		return a+b;
	}
}

class Sub {
	private int a, b;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int calculate() {
		return a-b;
	}
}

class Mul {
	private int a, b;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int calculate() {
		return a*b;
	}
}

class Div {
	private int a, b;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int calculate() {
		return a/b;
	}
}




public class Hw4 {

	public static void main(String[] args) {
		
		System.out.println("두 정수와 연산자를 입력하시오>>");
		Scanner scan = new Scanner(System.in);
		Add add = new Add();
		Sub sub = new Sub();
		Mul mul = new Mul();
		Div div = new Div();
		int first = scan.nextInt();
		int second = scan.nextInt();
		String signal = scan.next();
		
		if(signal.equals("+")) {
			add.setValue(first, second);
			System.out.println(add.calculate());
		}
		
		else if(signal.equals("-")) {
			sub.setValue(first, second);
			System.out.println(sub.calculate());
		}
		
		else if(signal.equals("*")) {
			mul.setValue(first, second);
			System.out.println(mul.calculate());
		}
		
		else if(signal.equals("/")) {
			div.setValue(first, second);
			System.out.println(div.calculate());
		}
		
		
		
	}

}
