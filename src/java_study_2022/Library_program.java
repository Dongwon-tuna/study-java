package java_study_2022;

class booktitle{
	String title,author;
	
	public void books(String title, String author) {
		this.title = title;
		this.author = author;
		
	}
	
	public void date(){
		System.out.println("30�� �� �ݳ��ϼ���");
	}
}

public class Library_program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		booktitle b1 = new booktitle();
		booktitle b2 = new booktitle();
		b1.books("�����ٶ�", "Ȳ����");
		b2.books("������ ����", "������");
		
		System.out.println(b1.title + " " + b1.author);
		b1.date();

	}

}
