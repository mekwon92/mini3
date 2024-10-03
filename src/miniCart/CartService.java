package miniCart;

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
import sale.SaleService;

//cs.getLoggedInId() 로그인한 객체 가져오는법

//카트 서비스 싱글턴
public class CartService {
	private static CartService CartService = new CartService();

	private CartService() {
	}

	public static CartService getCartService() {
		return CartService;
	}

	SaleService saleService = SaleService.getInstance();

	Cart cart = new Cart();
	public List<Book> cartList = cart.getCarts();
	private List<Book> booklist = new ArrayList<Book>();
	BookService sw = BookService.getInstance();

	public void printCart() {
		int cnt = 1;
		for (Book book : cartList) {
			System.out.println(cnt++ + "::" + book.getBookName() + ":::" + book.getBookCount() + "권");
		}

		int sum = cartList.stream().mapToInt(b -> b.getBookCount() * b.getBookPrice()).sum();
		System.out.println("총 금액은" + sum + "원 입니다");
	}

	public void add(Book a) {
//        a.clone();// 책 복사
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
		} else {
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

//갯타입에 객체하나 리턴하는 느낌인데 단체로 검색되는 경우 제목 저자로 나올때 리스트를 던진다
//장바구니 들어왔을때 책번호랑 
	public void cartlist() {
		// 책 정보
		printCart();

		int input = MiniUtils.next("1.결제 2.수량 변경 3.돌아가기", Integer.class, i -> i <= 3 && i >= 1, "1이상 5이하의 값을 입력하세요");
		switch (input) {
		case 1:
			printCart();
//            System.out.println("위 내역에 대한것에 결제를 진행하시겠습니까?");
			saleService.add(cart);
			System.out.println("결제완료");
			cart.getCarts().clear(); // 장바구니 비우기
			saleService.getInstance().getMySale();

			break;
		case 2:
			if (cart.getCarts().isEmpty()) {
				System.out.println("장바구니가 비었습니다");
				return;
			}
			System.out.println("수량 변경하기");
			modifyAmount();
//            boolean flag=false;
//                int input2 = MiniUtils.next("1.수량 변경할 책을 입력하세요 2.변경 취소",Integer.class , n-> n<=2 && n>=1, "1번이나 2번을 눌러주세요");
//                Book tmp = null;
//                for(Book book  :list )
//                    if(book.getBookId().equals(list))
//                        flag=true;
//                //tmp=Book;
//            break;
// 장바구니의 1번 상품 " 책 제목 " 을 선택하셨습니다. 다음 책 선택
			// 와일 문으로 플래그값 하나 세워두고 고객이 입력했던 모든 입력값을 버퍼로 받아서 저장하다가
// 특정 탈출값을 입력받거나 입력받은 번호의 갯수가 장바구니 리스트.size() 를 오버할 경우 종료!
// 전체를 구매하시려면 몇번을 누르세요. 정도는 있으면 편리할 것 같습니다.
		default:
			System.out.println("책 검색 화면으로 돌아가기");
			sw.bookSearcher();
			break;

		}
	}

	public void modifyAmount() {
		printCart();
		Book book = cart.getCarts().get(
				MiniUtils.next("수정할 항목입력", Integer.class, i -> i >= 1 && i <= cart.getCarts().size(), "올바른 범위의 값 입력")
						- 1);

		int amount = MiniUtils.next("변경할 수량을 입력", Integer.class, i -> i < book.getBookCount() && i >= 0,
				"올바른 범위의 값 입력");
		if (amount == 0) {
			cart.getCarts().remove(book);
		} else {
			book.setBookCount(amount);
		}
	}

}