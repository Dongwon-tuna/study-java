package java_study_2022;

class booktitle{
	String title,author;
	
	public void books(String title, String author) {
		this.title = title;
		this.author = author;
		
	}
	
	public void date(){
		System.out.println("30일 뒤 반납하세요");
	}
}

public class Library_program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		booktitle b1 = new booktitle();
		booktitle b2 = new booktitle();
		b1.books("가나다라", "황동원");
		b2.books("수학의 정석", "조정석");
		
		System.out.println(b1.title + " " + b1.author);
		b1.date();

	}

}
