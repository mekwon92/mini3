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
	public static List<Book> bookList = new ArrayList<Book>();
	private static final int TMPCOUNT = 1000;

// 초기화 블럭
	{
		System.out.println("초기 데이터를 삽입합니다.");
		bookList.add(new Book("000", "홍길동전", "홍길동", "길동사", "00-0000-0000", "디테일", 10000, TMPCOUNT, false));
		System.out.println("초기데이터 삽입 완료.");
	}

	public static void main(String[] args) throws Exception {
		bookList.forEach(x -> System.out.print(x + " "));
//		new BookQuerry().call();
	}

}