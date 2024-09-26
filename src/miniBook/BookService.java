package miniBook;

import java.util.ArrayList;
import java.util.List;

public class BookService {
// 책 목록
private List bookList = new ArrayList();
private static final int TMPCOUNT = 1000;

// 초기화 블럭
{
	System.out.println("초기 데이터를 삽입합니다.");
	bookList.add(new Book("000", "홍길동전", "홍길동", "길동사","00-0000-0000","디테일", 10000, 1000, false));
	System.out.println("초기데이터 삽입 완료.");
}

public static void main(String[] args) {
// booklist.forEach(System.out::println);
// System.out.println());
}

public void addBook() {	
	
}
// public void



}