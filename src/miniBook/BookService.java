package miniBook;

import java.util.ArrayList;
import java.util.List;

public class BookService {
// 책 목록
private static final int TMPCOUNT = 1000;

// 초기화 블럭
{
	System.out.println("초기 데이터를 삽입합니다.");
	System.out.println("초기데이터 삽입 완료.");
}


public static void main(String[] args) throws Exception {
	new BookQuerry().call();
}

}