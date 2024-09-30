package cart;

import miniBook.Book;

public class Cart {


	private String booknum;
	private int bookPrice;
	private String user;

	public Cart() {
	}

	public Cart (String booknum, int bookprice, int buy, int cancle,int add) {

	
		this.booknum = booknum;
		this.bookPrice = bookprice;

	}

	public Cart(Cart cs) {
		setBooknum(cs.getBooknum());//원래는 학번으로 작동했는데 여기서는 북 넘버로 작동해야할듯?
	
	}

//	


	public String getBooknum() {
		return booknum;
	}

	public void setBooknum(String booknum) {//책 번호
		this.booknum = booknum;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}


}

