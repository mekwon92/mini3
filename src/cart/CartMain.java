package cart;

import miniCustomer.MiniUtils;
import miniBook.*;

public class CartMain {
	public static void main(String[] args) {
		// UI
		// Create Read Update Delete
		  CartService cs = new CartService();
		
		while(true) {
			try {
				int input = MiniUtils.next("1.구매 " , Integer.class, n -> n >= 1 && n <= 5, "1~5사이의 값을 입력하세요");
				switch (input) {
				case 1:
					cs.cartlist();
					break;
//				case 2:
//					cs.back();
//					break;
//				case 3:
//					cs.add(); //
//					break;
<<<<<<< HEAD
//				}
//			}
//			catch (NumberFormatException e) {
//				System.out.println("정확한 숫자를 입력하세요");
//			}
//			catch (RuntimeException e) {
//				System.out.println(e.getMessage());
//				e.printStackTrace();
//			}
//			
//		}
//	}
//}

import java.util.List;

import miniBook.Book;

public void add(Book a) {
		a.clone();// 책 복사
		List<Book> list = cart.getCarts();
		if (list.contains(a)) {

		}
		boolean flag = false;
		Book tmp = null;
		for (Book book : list) {
			if (book.getBookId().equals(a.getBookId())) {
				flag = true;// 조건이 트루일때
				tmp = book; // 책을 탬에 담는다
				break;
			}
		}
		// 담으려는 책이 카트에 존재하는가?
		// 이미 있던 책의 수량 ++
		if (flag) {
			tmp.increaseBookCount();
		}
		// add(클론대상)
		else {
			list.add(a.clone());
		}
	}
=======
				case 4:
					cs.remove();
//					break;
//				case 5:
//					System.out.println("책 구매을 종료합니다");
//					cs.cancel();				
					return;
				default:
					break;
				}
			}
			catch (NumberFormatException e) {
				System.out.println("정확한 숫자를 입력하세요");
			}
			catch (RuntimeException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
		}
	}
}
>>>>>>> 3baa2fa5fb8d106f6b804d3d211de35f81a34c1d
