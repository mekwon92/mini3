package cart;

import java.util.ArrayList;
import java.util.List;

import miniBook.Book;

public class Cart {
	private List<Book> carts = new ArrayList<Book>(); // 장바구니

	public List<Book> getCarts() {
		return carts;
	}

	public void setCarts(List<Book> carts) {
		this.carts = carts;
	}
	
}

