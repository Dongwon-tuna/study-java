package java_study_2022;

class jobage{
	public String name;
	public String job;
	public int age; 
	
	public int multiply(int a) {
		return a*10;
		
	}
}

class hobbyse{
	public String hobby;
	public String sex;
	
}


public class Person {

	public static void main(String[] args) {
		jobage dw = new jobage();
		hobbyse dw1 = new hobbyse();
		
		jobage dd = new jobage();
		
		dw.name = "Ȳ����";
		dd.name = "��� ��Ϲ�";
		dw1.hobby = "����Ա�";
		
		
		System.out.println(dw.name);
		System.out.println(dw.multiply(11));
		System.out.println(dw1.hobby);
		System.out.println(dd.name);
		
	}

}
