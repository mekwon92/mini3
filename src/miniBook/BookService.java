package miniBook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookService {
// 책 목록
	private static List<Book> bookList = new ArrayList<Book>();
	private static final int TMPCOUNT = 1000;

// 초기화 블럭

	{
		System.out.println("SYSTEM :: 초기 데이터를 삽입합니다.");
		bookList.add(new Book("000", "홍길동전", "홍길동", "길동사", "0000000001", "디테일1", 10000, TMPCOUNT, false));
		bookList.add(new Book("001", "경애하는 경애에게", "홍길동", "길동사", "0000000002", "디테일2", 11000, TMPCOUNT, false));
		bookList.add(new Book("002", "상수의 마음", "홍길동", "길동사", "0000000003", "디테일3", 12000, TMPCOUNT, false));
		bookList.add(new Book("003", "참을 수 없는 존재의 가벼움", "홍길동", "길동사", "0000000004", "디테일4", 13000, TMPCOUNT, false));
		bookList.add(new Book("004", "달과6펜스", "홍길동", "길동사", "0000000005", "디테일5", 14000, TMPCOUNT, false));
		System.out.println("SYSTEM :: 초기데이터 삽입 완료.");
		System.out.println("SYSTEM :: 임시재고는" + TMPCOUNT + "입니다. 추후에 변동예정");
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("C:\\Users\\tj\\eclipse-workspace\\mini\\src\\miniBook"));) {
			bookList = (List<Book>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

// GETTER , SETTER 
	public static List<Book> getBookList() {
		return bookList;
	}

	public static void setBookList(List<Book> bookList) {
		BookService.bookList = bookList;
	}

	/**
	 * 셔플 후 출력 확인부
	 * @author KHM
	 */
	public void printBook() { // 출력확인용 셔플
		System.out.println("*****서적 목록은 다음과 같습니다.*****");
		List<Book> pBook = new ArrayList<>(bookList);
		Collections.shuffle(pBook);
		pBook.forEach(x -> System.out.print(x + "\n"));
	}

	/**
	 * 도서번호를 통한 검색
	 * @param String bookID
	 * @author KHM
	 */
	public Book findByBook(String no) { // 도서번호로 검색
		Book bookname = null;
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getBookId() == no) {
				bookname = bookList.get(i);
			}
		}
		return bookname;
	}

	public void bookSearcher() {
		System.out.printf("SYSTEM :: 도서를 검색합니다.\n1.도서번호 2.ISBN 3.제목 4.저자");
		
	}
// 검색, 상세정보, 재고
// 1. 검색 메서드 구현(제가 만들었던 셔플 리스트 이외에도 스트링 명령어 사용해서 검색어를 통해 )
}