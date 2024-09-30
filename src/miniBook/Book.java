package miniBook;

import java.io.Serializable;

public class Book implements Serializable, Cloneable{
	// 필드
	private String bookId; // 책 번호(서점용)
	private String bookName; // 책 제목
	private String bookWriter; // 책 작가
	private String bookPublisher; // 책 출판사
	private String ISBookNum; // 책 번호(ISBN 데이터 활용)
	private String bookDetail; // 책 상세설명
	private int bookPrice; // 책 가격
	public int bookCount; // 책 재고 // + 상품목록에서의 재고 + 클론을 통해서 다른 변수로 관리
	private boolean ifChecked; // 책 구매의사 확인용 체크박스
	private boolean isSearch; // 장바구니 액션시 가져갈 불린값.

	// 생성자
	public Book(String bookId, String bookName, String bookWriter, String bookPublisher, String ISBookNum,
			String bookDetail, int bookPrice, int bookCount, boolean ifChecked, boolean isSearch) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.bookPublisher = bookPublisher;
		this.ISBookNum = ISBookNum;
		this.bookDetail = bookDetail;
		this.bookPrice = bookPrice;
		this.bookCount = bookCount;
		this.ifChecked = ifChecked;
		this.isSearch = isSearch;
	}

	@Override
	public String toString() {
		return "\n-------------------------------------------------------------------------------------------------------\n"
				+ "| *제목 = " + bookName + " | *저자 = " + bookWriter + " | *출판 =" + bookPublisher + " | *도서번호 = " + bookId
				+ " | *재고 =" + bookCount + " |"
				+ " \n-------------------------------------------------------------------------------------------------------";
	}

	// getter, setter
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookWriter() {
		return bookWriter;
	}

	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getISBookNum() {
		return ISBookNum;
	}

	public void setISBookNum(String iSBookNum) {
		ISBookNum = iSBookNum;
	}

	public String getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(String bookDetail) {
		this.bookDetail = bookDetail;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public boolean isIfChecked() {
		return ifChecked;
	}

	public void setIfChecked(boolean ifChecked) {
		this.ifChecked = ifChecked;
	}

	public boolean isSearch() {
		return isSearch;
	}

	public void setSearch(boolean isSearch) {
		this.isSearch = isSearch;
	}

	@Override
	public Book clone() {
		Book book = null;
		try {
			book = (Book) super.clone();
			// 클론 지정 (목표 : 장바구니에 담기 목표)
			book.bookCount = 1; // 
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	
	// 장바구니용 수량 증가 메서드
	public void increaseBookCount() {
		bookCount++;
	}

	
	
}
