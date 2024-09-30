package sale;

import java.util.ArrayList;
import java.util.List;

import miniBook.Book;

public class Sale {
	private String id;
	private List<Book> books = new ArrayList<Book>(); // 클론예정
	private long regDate = System.currentTimeMillis();
	
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
