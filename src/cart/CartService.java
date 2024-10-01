//package cart;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//import java.util.List;
//import miniBook.*;
//import miniCustomer.Customer;
//import miniCustomer.CustomerService;
//import miniCustomer.MiniUtils;
//
//
////cs.getLoggedInId() 로그인한 객체 가져오는법
//
//
//public class CartService {
//	Cart cart = new Cart();
//	private List<Book> booklist = new ArrayList<Book>();
//	
//	
//	
//	// 일단 출력 보려고 필드에 선언을 해 놓은 상태
////	private List<Book> carts = new ArrayList<Book>(); // 장바구니
////	private List<Customer> users = new ArrayList<Customer>(); 
////	private List<Book> back;
////	private List<Book> buy;
////	private List<Book> cancel;
////	private List<Book> add;
//
////	{
////		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"))) {// 폴더를 만들어서 그 전에 금액을 저장
////			carts = (List<Book>) ois.readObject();
////		} catch (FileNotFoundException e) {
//////			System.out.println("파일 검색 실패, 초기화 더미 데이터 처리 완료");
////		} catch (IOException | ClassNotFoundException e) {
////			e.printStackTrace();// 예외 정보 출력
////		}
////
////	}
//
////	public void buy() { //구매
////		List<Book> tmpList = new ArrayList<Book>();
////		(BookService.getBookList().get(findby("책 ID넣기")));
////		carts.add();
////		
////	}
////	
//	
<<<<<<< HEAD
	
/**
 * add 메서드 구현, 오버로딩
 * 
 * @author LSW
 * @param Book book
 */
	
//	public void add() {
//		
//		BookService bookService = new BookService();
//		bookService.bookSearcher();
//	}
public void add(Book a) {
	List<Book> list = cart.getCarts();
	if(list.contains(a)) {
		
	}
	boolean flag = false;
	Book tmp = null;
	for(Book book : list) {
		if(book.getBookId().equals(a.getBookId())) {
			flag = true;
			tmp = book; 
			break;
		}
	}
	// 담으려는 책이 카트에 존재하는가?
	// 이미 있던 책의 수량 ++
	if(flag) {
		tmp.increaseBookCount();	
	}
	// add(클론대상)
	else {
		list.add(a.clone());
	}
}
=======
>>>>>>> a2bca34a3e7d6c7485ece7defae72e0ff04b742e
///**
// * add 메서드 구현, 오버로딩
// * 
// * @author LSW
// * @param Book book
// */
//	
////	public void add() {
////		
////		BookService bookService = new BookService();
////		bookService.bookSearcher();
////	}
//public void add(Book a) {
//	a.clone();//책 복사
//	List<Book> list = cart.getCarts();
//	if(list.contains(a)) {
//		
//	}
//	boolean flag = false;
//	Book tmp = null;
//	for(Book book : list) {
//		if(book.getBookId().equals(a.getBookId())) {
//			flag = true;//조건이 트루일때 
//			tmp = book; //책을 탬에 담는다
//			break;
//		}
//	}
//	// 담으려는 책이 카트에 존재하는가?
//	// 이미 있던 책의 수량 ++
//	if(flag) {
//		tmp.increaseBookCount();	
//	}
//	// add(클론대상)
//	else {
//		list.add(a.clone());
//	}
//}
//
//public void remove() { // 장바구니에 서적 삭제
//	Book cs = findBy(MiniUtils.next("책 번호를 입력하세요", String.class, n -> findBy(n) != null, "입력한 책은 존재하지 않습니다."));
//	cart.getCarts().remove(cs);
//}
//	
//	public Book findBy(String bookid) {
//		Book newcart  = null;
//		for(Book ss :booklist) {
//			if(ss.getBookId()==bookid) {
//				newcart = ss;
//			}
//			
//			
//		}
//		return newcart;
//	}
//	
//	public void printbook(){
//		List<Book> blist = new ArrayList<Book>();
//		for(Book se:blist) { 
//			System.out.println(se);
//				
//			}
//			
//		}
//		
//	}
/////**
//// * add 메서드 구현, 오버로딩
//// * 
//// * @author LSW
//// * @param Customer customer
//// */
////public void add(Customer cs) {
////	users.add(cs);
////}
////
////public void buy(Customer cs){//회원정보 가져오기
////	
////	users.add(cs);
////	
////}
////
//////		
//////		students.add(new Student(no, name, kor, eng, mat));
//////	
//////	public void buy() { //구매
//////		List<Book> bookList = new ArrayList<Book>()
//////		(BookService.getBookList().get(findby("")));
//////		
//////	}
//////
////
////	private Book findBy(String book) {
////		Book cart = null;
////		for (int i = 0; i < carts.size(); i++) {
////			if (carts.get(i).getBookId() == book) {
////				cart = carts.get(i);
////			}
////		}
////		return cart;
////	}
////
//////장바구니 들어왔을때 책번호랑 
////	public void cartlist() {
////		// 책 정보
//////		BookService bs = new BookService();
////		int input = MiniUtils.next("1.결제 2.다른 책 검색 3.수량 변경 4.초기로 돌아가기", Integer.class, i -> i <= 5 && i >= 1,
////				"1이상 5이하의 값을 입력하세요");
////		List<Book> tmp = null;
////		switch (input) {
////		case 1:
////
////			buy((Customer) users);
////			System.out.println("결제 취소");
////
////			// 여기에 가격이랑 무슨책인지 나왔으면 좋겠음 회원
////
////			break;
//////		case 2:
//////			System.out.println("책 수량을 입력해주세요");
//////			// 1.책 입력
//////			// 2.책 번호를 입력하세요 후 입력하면 다시 이창이뜨면 좋곘음
//////			modify();
//////			break;
//////		case 3:
//////			System.out.println("검색할 책을 입력해주세요");
//////			bs.bookSearcher();
//////			return;
////		case 4:
////			System.out.println("초기 화면으로 돌아가기");
////			break;
////		
////		default:
////			System.out.println("????");
////			break;
////		}
//////		for (int i = 0; i < carts.size(); i++) {
////////				System.out.println(students[i]);
//////			System.out.println(carts.get(i));
//////		}
////	}
////
////
//////	public void modify() {
//////		// 1. 학번 입력
//////		// 2. 학번을 통한 탐색(배열) >> 학생
//////		Student s = findBy(next("학번", Integer.class, n -> findBy(n) != null, "입력한 학번은 존재하지 않습니다."));
//////		// 3. 이름, 국어, 영어, 수학 점수 변경
//////		String name = next("이름", String.class, str -> str.matches("^[가-힣]{2,4}"), "정확한 이름의 조건을 입력하세요");
//////		s.setName(name);
//////		int kor = next("국어", Integer.class, i -> i <= 100 && i >= 0, "0이상 100이하의 값을 입력하세요");
//////		int eng = next("영어", Integer.class, i -> i <= 100 && i >= 0, "0이상 100이하의 값을 입력하세요");
//////		int mat = next("수학", Integer.class, i -> i <= 100 && i >= 0, "0이상 100이하의 값을 입력하세요");
//////		s.setKor(kor);
//////		s.setEng(eng);
//////		s.setMat(mat);
//////		
//////	}
////	
////	
////	public void remove() { // 장바구니에 서적 삭제
////		Book cs = findBy(MiniUtils.next("책 번호를 입력하세요", String.class, n -> findBy(n) != null, "입력한 책은 존재하지 않습니다."));
////		carts.remove(cs);
////	}
////
//////	public void save() { //매출 관련
//////		try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
//////			stream.writeObject(students);
//////		} catch (IOException e) {
//////			e.printStackTrace();
//////		}
//////	}
////// 장바구니 재고 같은경우 클론을 복제하여 장바구니에서 취소할 경우 그 원본과 장바구니 재고가 같게 한다	
//
////}