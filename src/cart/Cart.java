package cart;

import miniBook.Book;

public class Cart {

	private int cart;
	private String booknum;
//	private int buy;
	private int back;
	private int cancle;

	public Cart() {
	}

	public Cart(int cart, String booknum, int buy, int back, int cancle) {

		this.cart = cart;
		this.booknum = booknum;
//		this.buy = buy;
		this.back = back;
		this.cancle = cancle;

	}

	public Cart(Cart cs) {
//		setBuy(cs.getBuy());
		cart = cs.cart;
		booknum = cs.booknum;
//		buy = cs.buy;
		back = cs.back;
		// if(s.arr != null)
	}

//	
	public int getCart() {
		return cart;
	}

	public void setCart(int cart) {//장바구니
		this.cart = cart;
	}

	public String getBooknum() {
		return booknum;
	}

	public void setBooknum(String booknum) {//책 번호
		this.booknum = booknum;
	}

//	public int getBuy() {//구매
//		return buy;
//	}
//
//	public void setBuy(int buy) {
//		this.buy = buy;
//	}

	public int getBack() {//뒤로가기
		return back;
	}

	public void setBack(int back) {
		this.back = back;
	}

	public int getCancle() {//취소하기
		return cancle;
	}

	public void setCancle(int cancle) {
		this.cancle = cancle;
	}

	public static void remove(Cart cs) {
		// TODO Auto-generated method stub

	}

}
