package miniBook;

// 출력 확인부
import miniCustomer.*;

public class BookTest {
	public static void main(String[] args) throws Exception {
		BookService bookService = BookService.getInstance();
//		bookService.bookSearcher();
		bookService.bookAdd();
		
	}
}
