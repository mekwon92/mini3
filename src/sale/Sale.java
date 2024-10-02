package sale;

import java.util.ArrayList;
import java.util.List;

import miniBook.Book;
import miniCustomer.Customer;

public class Sale {
	private String id;
	private List<Book> books = new ArrayList<Book>(); // 클론예정
	private long regDate = System.currentTimeMillis(); //구매했을때 시간
	
	//싱글턴
	private static Sale sale = new Sale();
	
	private Sale() {
		
	}
	
	public static Sale getinstance() {
		return sale;
	}
//사게되면 돈이랑 구매이력을 파일에 저장
	//산 책은 NULL값으
	
	
	public void salelist() {
		
		
		
	}
	// 총액 계산 메서드
	public int total() {
		int sum = 0;
		for(Book book : books) {
			sum += book.getBookCount() * book.getBookPrice();
		}
		return sum;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", books=" + books + ", regDate=" + regDate + ", total()=" + total() + "]";
	}
	
	
}
