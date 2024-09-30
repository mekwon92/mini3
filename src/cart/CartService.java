package cart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import miniBook.Book;
import miniBook.BookService;

public class CartService {

	// 일단 출력 보려고 필드에 선언을 해 놓은 상태
	private List<Book> carts = new ArrayList<Book>(); // 장바구니
	private List<Book> back;
	private List<Book> buy;
	private List<Book> cancel;
	private List<Book> add;

	{
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("money"))) {// 폴더를 만들어서 그 전에 금액을 저장
			carts = (List<Book>) ois.readObject();
		} catch (FileNotFoundException e) {
//			System.out.println("파일 검색 실패, 초기화 더미 데이터 처리 완료");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();// 예외 정보 출력
		}

	}

//	public void buy() { //구매
//		List<Book> tmpList = new ArrayList<Book>();
//		(BookService.getBookList().get(findby("책 ID넣기")));
//		carts.add();
//		
//	}
//	
//public void add() {
//		
//		String booknum = MiniUtils.next("책 번호를 입력하세요", String.class, n -> findBy(n) == null, "정확한 책을 입력하세요");
//		//책 번호를 입력하세요 후 입력하면 구매와 뒤로가기 버튼이 나왔으면 좋겠음
//		
//		booklist.add() = new cart(Booknum);
//}

	public void add() {
		
		Book Cart = findBy(MiniUtils.next("책 번호", String.class, n -> findBy(n) != null, "입력한 책은 존재하지 않습니다."));

	}

//		
//		students.add(new Student(no, name, kor, eng, mat));
//	
//	public void buy() { //구매
//		List<Book> bookList = new ArrayList<Book>()
//		(BookService.getBookList().get(findby("")));
//		
//	}
//	
	public void cancel() { // 담은 책 취소

	}

	public void back() { // 뒤돌아가기

	}

	private Book findBy(String book) {
		Book cart = null;
		for (int i = 0; i < carts.size(); i++) {
			if (carts.get(i).getBookId() == book) {
				cart = carts.get(i);
			}
		}
		return cart;
	}

//장바구니 들어왔을때
	public void cartlist() {
		// 책 정보
		int input = MiniUtils.next("1.구매 2.책 삭제 3.추가 및 수량변경", Integer.class, i -> i <= 4 && i >= 1,
				"1이상 3이하의 값을 입력하세요");
		List<Book> tmp = null;
		switch (input) {
		case 1:
			System.out.println("구매완료.");
			tmp = buy;
			// 여기에 가격이랑 무슨책인지 나왔으면 좋겠음
			break;
		case 2:
			System.out.println("취소합니다.");
			// 현재 장바구니에 담긴 책 선택 삭제
			tmp = cancel;
			break;
		case 3:
			System.out.println("책 추가 할 책을 입력해주세요");
			// 1.책 입력
			// 2.책 번호를 입력하세요 후 입력하면 다시 이창이뜨면 좋곘음
			tmp = add;

			break;

		default:
			System.out.println("????");
			break;
		}
		for (int i = 0; i < tmp.size(); i++) {
//				System.out.println(students[i]);
			System.out.println(tmp.get(i));
		}
	}

	public void remove() { // 장바구니에 서적 삭제
		Book cs = findBy(MiniUtils.next("책 번호를 입력하세요", String.class, n -> findBy(n) != null, "입력한 책은 존재하지 않습니다."));
		carts.remove(cs);
	}

//	public void save() { //매출 관련
//		try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
//			stream.writeObject(students);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
// 장바구니 재고 같은경우 클론을 복제하여 장바구니에서 취소할 경우 그 원본과 장바구니 재고가 같게 한다	

}