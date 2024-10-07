package miniBook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import miniCart.CartService;
import miniCustomer.CustomerService;
import miniCustomer.MiniUtils;

/**
 * 서적 서비스부 싱글턴 적용할 것
 * 
 * @author HHJ, KHM
 */
public class BookService {
// 	싱글턴 적용
//	필드 초기화
	private Calendar calender = Calendar.getInstance();
	private int month = calender.get(Calendar.MONTH) + 1;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
	CartService cartService = CartService.getCartService();
	private static BookService BookService = new BookService();

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
		bookList.add(new Book("0000", "홍길동전", "홍길동", "길동사", "0000000000001", "정의의 사도 홍길동의 모험", 10_000, TMPCOUNT, false,
				false));
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"));) {
			bookList = (List<Book>) ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("SYSTEM :: 불러오기 오류 발생");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("SYSTEM :: 불러오기 오류 발생");
		}
	}

	/**
	 * 
	 * @author KHM
	 */
	public void bookSearcher() {
		bookEvent(bookList);
		boolean flag = true;
		System.out.print(""
				+ "=================================================================================================\n"
				+ "SYSTEM :: 얼라들의 알라딘, < 얼라딘 > 에서 무엇이든 검색하세요! 현재 날짜는 >> " + sdf.format(calender.getTime())
				+ "입니다. :: \n"
				+ "=================================================================================================\n");
		String[] categories = { "도서번호", "ISBN", "제목", "저자", "전체", "뒤로", "장바구니" };
		while (flag) {
			System.out.println("SYSTEM :: 도서를 검색합니다.");
			for (int i = 0; i < categories.length; i++) {
				System.out.printf(" %d.%s", (i + 1), categories[i]);
			}
			System.out.println();
			int input = MiniUtils.next(" SYSTEM :: 카테고리 입력", Integer.class, i -> i >= 1 && i <= 7, "1~7 사이의 숫자 입력 :: ");
			switch (input) {
			case 1:
			case 2:
			case 3:
			case 4: {
				searchBook(input, MiniUtils.next("SYSTEM :: 검색어를 입력하세요. :: ", String.class));
				break;
			}
			case 5: {
				printBooks(bookList);
				break;
			}
			case 6: {
				System.out.println("SYSTEM :: 이전 메뉴로 돌아갑니다. :: ");
				return;
			}
			case 7: {
				System.out.println("SYSTEM :: 장바구니를 불러옵니다. :: ");
				cartService.cartlist();
				flag = false;
				return;
			}
			default:
				break;
			}
		}
	}

	public void searchBook(int search, String target) {
		List<Book> books = null;
		switch (search) {
		case 1:
			books = findByBookId(target);
			break;
		case 2:
			books = findByBookISBN(target);
			break;
		case 3:
			books = findByBookName(target);
			break;
		case 4:
			books = findByWriter(target);
			break;
		default:
			return;
		}
		if (books != null && !books.isEmpty()) {
			System.out.println("============================== 검색 결과 ==============================");
			for (int i = 0; i < books.size(); i++) {
				System.out.print(" :: " + (i + 1) + " :: ");
				System.out.println(books.get(i));
			}
			System.out.println("SYSTEM :: 출력이 완료되었습니다. :: ");
			int sizebook = books.size();
			int input2 = MiniUtils.next("SYSTEM :: 번호로 책을 골라주세요", Integer.class, s -> s >= 1 && s <= sizebook,
					"SYSTEM :: INPUT ERROR :: ");
			System.out.println("SYSTEM :: " + books.get(input2 - 1).getBookName() + "의 상세정보를 로드합니다.");
			showBookDetails(books.get(input2 - 1));
		} else {
			System.err.println("SYSTEM :: 검색 결과가 없습니다. :: ");
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
		System.out.println("SYSTEM :: 도서 리스트를 출력합니다. :: ");
		pBook.forEach(x -> System.out.print(x + "\n"));
		System.out.println("SYSTEM :: 출력이 완료되었습니다. :: ");
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
	public List<Book> findByBookId(String no) {
		List<Book> tmp = new ArrayList<>();
		for (Book book : bookList) {
			if (book.getBookId().contains(no)) {
				tmp.add(book);
			}
		}
		return tmp;
	}

	public List<Book> findByBookISBN(String no) {
		List<Book> tmp = new ArrayList<>();
		for (Book book : bookList) {
			if (book.getBookId().contains(no)) {
				tmp.add(book);
			}
		}
		return tmp;

	}

	/**
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
		int key = MiniUtils.next("입력", Integer.class, i -> i >= 1 && i <= 2, "SYSTEM :: INPUT ERROR :: ");
		switch (key) {
		case 1: {
			if (a.getBookPrice() == 0) {
				System.out.println("SYSTEM :: 절판된 상품입니다. 구매가 불가합니다. 검색 화면으로 돌아갑니다. :: ");
				break;
			}
			cs.add(a);
			System.out.println("SYSTEM :: 장바구니에 상품이 담겼습니다. :: ");
			cs.printCart();
		}
		case 2: {
			System.out.println("SYSTEM :: 초기 화면으로 돌아갑니다. :: ");
			break;
		}
		}
	}

	/**
	 * 관리자 페이지의 책 정보 변경 하위 페이지
	 */
	public void bookAlter() {
		int input = MiniUtils.next(("1. 책 등록 2. 책 정보 수정 3. 책 삭제 4. 뒤로가기"), Integer.class, i -> i <= 4 && i >= 1,
				"1이상 4이하의 값을 입력하세요");
		List<Book> tmp = null;
		switch (input) {
		case 1:
			bookAdd();
			break;
		case 2:
			bookModify();
			break;
		case 3:
			bookRemove();
			break;
		default:
			return;
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
		boolean b1 = false;
		boolean b2 = false;

		bookList.add(new Book(bookId, bookName, bookWriter, bookPublisher, ISBookNum, bookDetail, bookPrice, bookCount,
				b1, b2));
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
		boolean b1 = false;
		boolean b2 = false;
		bookList.add(new Book(bookId, bookName, bookWriter, bookPublisher, ISBookNum, bookDetail, bookPrice, bookCount,
				b1, b2));
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

	public void bookEvent(List<Book> listTarget) {
		int ran = (int) (Math.random() * listTarget.size());
		CustomerService customer = CustomerService.getInstance();
		String name = customer.getLoggedInUser().getName();
		Book book = bookList.get(ran);
		System.out.println(" SYSTEM :: " + name + " 님, 어서오세요! 아래의 이벤트들을 확인해 보세요! :: ");
		System.out.println(month + " 월의 [ 추천 도서 :: < " + book.getBookName() + " > :: ]  " + month + " 월의 [ 얼라딘터뷰 :: < "
				+ book.getBookWriter() + " 작가 > :: ]");
	}

}