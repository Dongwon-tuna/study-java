package java_study_2022;

import java.util.Scanner;

class books{
	
	String title,author;
	
	books(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
}

public class Object_array {

	public static void main(String[] args) {
		
		
		Scanner s = new Scanner(System.in);
		
		books [] book1 = new books[2];
		
	
		for(int i = 0; i<book1.length; i++) {
			System.out.println("책의 제목과 저자를 입력하시오");
			String title = s.next();
			String author = s.next();
			book1[i]= new books(title, author);
		}
		
		for(int i = 0; i<book1.length; i++) {
			System.out.println(book1[i].title + "의 저자는 " + book1[i].author);
		}
		
	
	}

}
