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

	public void cartlist() {
        // 책 정보
        printCart();

<<<<<<< HEAD
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
		default:
			System.out.println("책 검색 화면으로 돌아가기");
			sw.bookSearcher();
			break;

		}
	}
=======
        int input = MiniUtils.next("1.결제 2.수량 변경 3.돌아가기", Integer.class, i -> i <= 3 && i >= 1, "1이상 5이하의 값을 입력하세요");
        switch (input) {
        case 1:
            printCart();
            saleService.add(cart);
            System.out.println("결제완료");
            cart.getCarts().clear(); // 장바구니 비우기
            saleService.getMySale();

            break;
        case 2:
            if (cart.getCarts().isEmpty()) {
                System.out.println("장바구니가 비었습니다");
                return;
            }
            System.out.println("수량 변경하기");
            modifyAmount();
            System.out.println("수량 변경이 완료되었습니다.");
            break;
        case 3:
            int back = MiniUtils.next("1.로그인 화면 2.책 검색 화면", Integer.class, i -> true,"1~2의 값을 입력해주세요");
            if(back==1) {
                CustomerService.getInstance().login();
            }else {
                BookService.getInstance().bookSearcher();
            }
            break;
        default:
            return;
        }
    }
>>>>>>> 418ad13cbbbf346757ece4c730c211a4b9ac3a15

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