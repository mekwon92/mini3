package miniBook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class BookService {
// 책 목록
	private static List<Book> bookList = new ArrayList<Book>();
	private static final int TMPCOUNT = 1000;

// 초기화 블럭
	{
		System.out.println("초기 데이터를 삽입합니다.");
		bookList.add(new Book("000", "홍길동전", "홍길동", "길동사", "00-0000-0000", "디테일", 10000, TMPCOUNT, false));
		System.out.println("초기데이터 삽입 완료.");
		System.out.println("임시재고는" + TMPCOUNT + "입니다.");
	}

	public void printBook() { // 출력확인용
		List<Book> pBook = new ArrayList<>(bookList);
		System.out.println(pBook);
	}

}