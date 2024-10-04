package miniBook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import miniCustomer.*;
import miniCart.CartService;

/**
 * 서적 서비스부 싱글턴 적용할 것
 * 
 * @author HHJ, KHM
 */
public class BookService {
// 싱글턴 적용
//	필드 초기화
	private static BookService BookService = new BookService();
	CartService cartService = CartService.getCartService();

	private BookService() {
		// TODO Auto-generated constructor stub
	}

	public static BookService getInstance() {
		return BookService;
	}

	// 책 목록
	private List<Book> bookList = new ArrayList<Book>();
	public List<Book> bookRes = new ArrayList<Book>();
	public final int TMPCOUNT = 1000;

// 초기화 블럭
	{
		System.out.println("SYSTEM :: 초기 데이터를 삽입합니다.");
		bookList.add(new Book("0000", "홍길동전", "홍길동", "길동사", "0000000000001", "정의의 사도 홍길동의 모험", 10_000, TMPCOUNT, false,
				false));
		bookList.add(new Book("0001", "경애하는 경애에게", "홍길동", "길동사", "0000000000002", "경애는 회사를 그만두고 무작정 베트남으로 떠난다.", 11_000,
				TMPCOUNT, false, false));
		bookList.add(new Book("0002", "상수의 마음", "홍길동", "길동사", "0000000000003", "어느날 상수에게 경애가 다가온다. 그의 마음은 움직였다.",
				12_000, TMPCOUNT, false, false));
		bookList.add(new Book("0003", "참을 수 없는 존재의 가벼움", "홍길동", "길동사", "0000000000004", "길고도 복잡한 이야기를 원한다면.", 13_000,
				TMPCOUNT, false, false));
		bookList.add(new Book("0004", "달과6펜스", "홍길동", "길동사", "0000000000005", "위대한 개츠비, 더블린 사람들의 뒤를 잇는 고전필독서", 14_000,
				TMPCOUNT, false, false));
		System.out.println("SYSTEM :: 초기데이터 삽입 완료.");
		System.out.println("SYSTEM :: 임시재고는" + TMPCOUNT + "입니다. 추후에 변동예정");
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"));) {
			bookList = (List<Book>) ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("SYSTEM :: 불러오기 오류 발생");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("SYSTEM :: 불러오기 오류 발생");
		}
	}

	/**
	 * 검색 메서드 구현 도서번호 리딩 제로 제외하고도 잘 나오게 추가할 것
	 * 
	 * @author KHM
	 */
	public void bookSearcher() {
		while (true) {
			Book b = null;
			System.out.printf("SYSTEM :: 도서를 검색합니다.\n 1.도서번호 2.ISBN 3.제목 4.저자 5.전체 6.뒤로 7.장바구니");
			int input = MiniUtils.next(" ::: 카테고리 입력", Integer.class, i -> i >= 1 && i <= 7, "1~7 사이의 숫자 입력");
			switch (input) {
			case 1: {
				b = findByBookId(MiniUtils.next("SYSTEM :: 도서번호를 입력하세요", String.class, s -> true, "존재하지 않는 도서번호입니다."));
				System.out.println("========================= 검색 결과 =========================");
				System.out.println(b);
				System.out.println("SYSTEM :: 출력이 완료되었습니다.");
				System.out.println("SYSTEM :: " + b.getBookName() + "의 상세정보를 로드합니다.");
				showBookDetails(b);
				break;
			}
			case 2: {
				b = findByBookISBN(
						MiniUtils.next("SYSTEM :: ISBN을 입력하세요", String.class, s -> true, "존재하지 않는 ISBN입니다."));
				System.out.println("========================= 검색 결과 =========================");
				System.out.println(b);
				System.out.println("SYSTEM :: 출력이 완료되었습니다.");
				System.out.println("SYSTEM :: " + b.getBookName() + "의 상세정보를 로드합니다.");
				showBookDetails(b);
				break;
			}
			case 3: {
				String title = MiniUtils.next("SYSTEM :: 제목을 입력하세요", String.class);
				List<Book> books = findByBookName(title);
				if (!books.isEmpty()) {
					System.out.println("========================= 검색 결과 =========================");
					for (int i = 0; i < books.size(); i++) {
						System.out.print("순번 : " + (i + 1));
						System.out.println(books.get(i));
					}
					System.out.println("SYSTEM :: 출력이 완료되었습니다.=================================");
				}
				int input2 = MiniUtils.next("번호로 책을 골라주세요", Integer.class, s -> s >= 1 && s <= books.size(),
						"올바른 값 입력");
				System.out.println("SYSTEM :: " + books.get(input2 - 1).getBookName() + "의 상세정보를 로드합니다.");
				showBookDetails(books.get(input2 - 1));
				break;
			}
			case 4: {
				String author = MiniUtils.next("SYSTEM :: 저자를 입력하세요", String.class);
				List<Book> books = findByWriter(author);
				if (!books.isEmpty()) {
					System.out.println("========================= 검색 결과 =========================");
					for (int i = 0; i < books.size(); i++) {
						System.out.print("순번 : " + (i + 1));
						System.out.println(books.get(i));
					}
					System.out.println("SYSTEM :: 출력이 완료되었습니다.");
					int input2 = MiniUtils.next("번호로 책을 골라주세요", Integer.class, s -> s >= 1 && s <= books.size(),
							"올바른 값 입력");
					System.out.println("SYSTEM :: " + books.get(input2 - 1).getBookName() + "의 상세정보를 로드합니다.");
					showBookDetails(books.get(input2 - 1));
				}
				break;
			}
			case 5: {
				printBooks(bookList);
				break;
			}

			case 6: {
				System.out.println("SYSTEM :: 이전 메뉴로 돌아갑니다.");
				return;
			}
			case 7: {
				System.out.println("SYSTEM :: 추후 구현 예정입니다.");
				cartService.cartlist();
				return;
			}
			default:
				break;
			}
		}
	}

	/**
	 * 무작위 초입 출력부 + shuffle
	 * 
	 * @author KHM
	 */
	public void printBooks() {
		List<Book> pBook = new ArrayList<>(bookList);
		Collections.shuffle(pBook);
		System.out.println("SYSTEM :: 도서 리스트를 출력합니다.");
		pBook.forEach(x -> System.out.print(x + "\n"));
		System.out.println("SYSTEM :: 출력이 완료되었습니다.");
	}

	/**
	 * 리스트를 통한 출력부, printBooks 오버로딩
	 * 
	 * @param
	 * @author KHM
	 */
	public void printBooks(List<Book> listTarget) {
		List<Book> pBook = new ArrayList<>(listTarget);
		pBook.sort((p1, p2) -> p1.getBookName().compareTo(p2.getBookName()));
		pBook.forEach(x -> System.out.print(x + "\n"));
	}

	/**
	 * 
	 * @param String bookID
	 * @author KHM
	 */
	public Book findByBookId(String no) {
		Book book = null;
		boolean flag = false;
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getBookId().contains(no)) {
				book = bookList.get(i);
				flag = true;
			}
		}
		if (flag == true) {
			System.out.println("SYSTEM :: 일치하는 검색결과를 출력합니다.");
		} else {
			System.out.println("SYSTEM :: 일치하는 검색결과가 없습니다.");
		}
		return book;
	}

	public Book findByBookISBN(String no) {
		Book book = null;
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getISBookNum().contains(no)) {
				book = bookList.get(i);
			}
		}
		return book;
	}

	/**
	 * + 후에 트림 사용해서 띄어쓰기 이슈 해결 필요, 해외작가의경우 성과 이름이 떨어져 있을 확률이 높으므로 이에 대한 고려도 필요
	 * 
	 * @param String writer
	 * @author KHM
	 */
	public List<Book> findByWriter(String writer) {
		List<Book> tmp = new ArrayList<>();
		for (Book book : bookList) {
			if (book.getBookWriter().contains(writer)) {
				tmp.add(book);
			}
		}
		return tmp;
	}

	/**
	 * + findByBookName 메서드가 List<Book>을 반환하도록 수정
	 * 
	 * @param String bookName
	 * @author KHM
	 */
	public List<Book> findByBookName(String bookName) {
		List<Book> tmp = new ArrayList<>();
		for (Book book : bookList) {
			if (book.getBookName().contains(bookName)) {
				tmp.add(book);
			}
		}
		return tmp;
	}

	/**
	 * 도서 상세정보 페이지 구현 오버로딩 (Book 객체)
	 * 
	 * @param Book book
	 * @author KHM
	 */
	public void showBookDetails(Book a) {
		System.out.println("*소개 : " + bookList.get(Integer.parseInt(a.getBookId())).getBookDetail() + "\n | *정가 : "
				+ a.getBookPrice() + " |" + "1.장바구니 2.뒤로가기");
		CartService cs = CartService.getCartService();
		int key = MiniUtils.next("입력", Integer.class, i -> i >= 1 && i <= 2, "SYSTEM :: INPUT ERROR");
		switch (key) {
		case 1: {
			if (a.getBookPrice() == 0) {
				System.out.println("절판된 상품입니다. 구매 불가");
			}
			cs.add(a);
			System.out.println("SYSTEM :: 장바구니에 상품이 담겼습니다.");
			cs.printCart();
		}
		case 2: {
			System.out.println("초기 화면으로 돌아갑니다.");
			break;
		}
		}
	}

	/**
	 * 도서 추가 등록
	 * 
	 * @author HHJ
	 */
	public void bookAdd() {
		String bookId = MiniUtils.next("책 번호(서점용)", String.class, n -> n.length() == 4, "올바른 책 번호를 입력하세요 (4자리의 숫자)");
		String bookName = MiniUtils.next("책 제목", String.class);
		String bookWriter = MiniUtils.next("저자명", String.class);
		String bookPublisher = MiniUtils.next("출판사", String.class);
		String ISBookNum = MiniUtils.next("책 번호(ISBN)", String.class, n -> n.length() == 13,
				"올바른 책 번호를 입력하세요 (13자리의 숫자)");
		String bookDetail = MiniUtils.next("상세설명", String.class);
		int bookPrice = MiniUtils.next("책 가격", Integer.class, n -> true, "올바른 숫자를 입력하세요");
		int bookCount = MiniUtils.next("책 재고", Integer.class, n -> true, "올바른 숫자를 입력하세요");
		boolean ifChecked = false;
		boolean isSearch = false;

		bookList.add(new Book(bookId, bookName, bookWriter, bookPublisher, ISBookNum, bookDetail, bookPrice, bookCount,
				ifChecked, isSearch));
	}

	/**
	 * 도서 정보 수정
	 */
	public void bookModify() {
		Book b = findBy(MiniUtils.next("책 번호(서점용)", String.class, n -> true, null));
		String bookId = MiniUtils.next("책 번호(서점용)", String.class, n -> n.length() == 4, "올바른 책 번호를 입력하세요 (4자리의 숫자)");
		b.setBookId(bookId);
		String bookName = MiniUtils.next("책 제목", String.class);
		b.setBookName(bookName);
		String bookWriter = MiniUtils.next("저자명", String.class);
		b.setBookWriter(bookWriter);
		String bookPublisher = MiniUtils.next("출판사", String.class);
		b.setBookPublisher(bookPublisher);
		String ISBookNum = MiniUtils.next("책 번호(ISBN)", String.class, n -> n.length() == 13,
				"올바른 책 번호를 입력하세요 (13자리의 숫자)");
		b.setISBookNum(ISBookNum);
		String bookDetail = MiniUtils.next("상세설명", String.class);
		b.setBookDetail(bookDetail);
		int bookPrice = MiniUtils.next("책 가격", Integer.class);
		b.setBookPrice(bookPrice);
		int bookCount = MiniUtils.next("책 재고", Integer.class);
		b.setBookCount(bookCount);
	}

	/**
	 * 도서 삭제
	 * 
	 * @author HHJ
	 */
	public void bookRemove() {
		Book b = findBy(MiniUtils.next("책 번호", String.class, n -> findBy(n) != null, "입력한 책 번호는 존재하지 않습니다"));
		bookList.remove(b);
	}

	private Book findBy(String bookId) {
		Book book = null;
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getBookId() == bookId) {
				book = bookList.get(i);
			}
		}
		return book;
	}

}