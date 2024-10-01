package cart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import miniBook.*;
import miniCustomer.Customer;
import miniCustomer.CustomerService;
import miniCustomer.MiniUtils;
import sale.Sale;

//cs.getLoggedInId() 로그인한 객체 가져오는법

//카트 서비스 싱글턴
public class CartService {
//	private static CartService CartService = new CartService();

//	private CartService() {
//
//	}
//
//	public static CartService getCartService() {
//		return CartService;
//	}

	Sale sale = Sale.getinstance();
	Cart cart = new Cart();
	public List<Book> cartList = new Cart().getCarts();
	private List<Book> booklist = new ArrayList<Book>();


	public void add(Book a) {
		a.clone();// 책 복사
		List<Book> list = cart.getCarts();
		boolean flag = false;
		Book tmp = null;
		for (Book book : list) {
			if (book.getBookId().equals(a.getBookId())) {
				flag = true;// 조건이 트루일때
				tmp = book; // 책을 탬에 담는다
				break;
			}
		}
		if (flag) {
			tmp.increaseBookCount();
		}
		else {
			list.add(a.clone());
		}
	}

	public void remove() { // 장바구니에 서적 삭제
		Book cs = findBy(MiniUtils.next("책 번호를 입력하세요", String.class, n -> findBy(n) != null, "입력한 책은 존재하지 않습니다."));
		cart.getCarts().remove(cs);
	}

	public void remove(List<Book> targetlist) { // 오버로딩
		for (int i = 0; i < targetlist.size(); i++)
			targetlist.remove(i);
	}

	public Book findBy(String bookid) {
		Book newcart = null;
		for (Book ss : booklist) {
			if (ss.getBookId() == bookid) {
				newcart = ss;
			}

		}
		return newcart;
	}

	public void printbook() {
		List<Book> blist = new ArrayList<Book>();
		for (Book se : blist) {
			System.out.println(se);
			
		}

	}

//장바구니 들어왔을때 책번호랑 
	public void cartlist() {
		// 책 정보
		List<Book> list=cart.getCarts();
		int input = MiniUtils.next("1.결제 2.수량 변경 3.돌아가기", Integer.class, i -> i <= 5 && i >= 1,
				"1이상 5이하의 값을 입력하세요");
		switch (input) {
		case 1:	{
			boolean flag = true;
				int input1 = MiniUtils.next("목록의 원하시는 부분을 입력하세요.", Integer.class, n -> n <= 5 && n >=1, "1.선택 결제 2.전체 결제");
				if (input1 == 2)
					flag = false;
				if(flag) {
					// 추후에 구현,선택구매
					for(int i = 0; i < list.size(); i++) {
						int input2 = MiniUtils.next("목록의 원하시는 부분을 입력하세요.", Integer.class, n -> n <= list.size() && n >=0, "1.선택 결제 2.전체 결제");
						remove();
					}
				}
				else {
					System.out.println("장바구니의 모든 항목을 결제합니다. 총" + sale.total() +"원 입니다.");
					remove(list);
				}
				break;
		}
		case 2:{
			System.out.println("초기 화면으로 돌아가기");
			break;
		}
// 장바구니의 1번 상품 " 책 제목 " 을 선택하셨습니다. 다음 책 선택
	// 와일 문으로 플래그값 하나 세워두고 고객이 입력했던 모든 입력값을 버퍼로 받아서 저장하다가 
// 특정 탈출값을 입력받거나 입력받은 번호의 갯수가 장바구니 리스트.size() 를 오버할 경우 종료!
// 전체를 구매하시려면 몇번을 누르세요. 정도는 있으면 편리할 것 같습니다.
		case 3:{
			System.out.println("책 화면으로 돌아가기");
			break;
		}
		default:
			break;

		}
	}

}
