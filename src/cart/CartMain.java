package cart;

import miniCustomer.MiniUtils;
import miniBook.*;

public class CartMain {
	public static void main(String[] args) {
		// UI
		// Create Read Update Delete
		  CartService cs = CartService.getCartService();
		
		while(true) {
			try {
				int input = MiniUtils.next("1.구매 " , Integer.class, n -> n >= 1 && n <= 5, "1~5사이의 값을 입력하세요");
				switch (input) {
				case 1:
					cs.cartlist();
					break;
					
				case 5:
					System.out.println("bye");
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
			

