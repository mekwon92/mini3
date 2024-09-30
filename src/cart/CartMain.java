cartmain
package cart;

public class CartMain {
	public static void main(String[] args) {
		// UI
		// Create Read Update Delete
		  CartService cs = new CartService();
		
		while(true) {
			try {
				int input = MiniUtils.next("1.구매 2.뒤로가기 3.책 추가하기 4.책 삭제 5.종료하기" , Integer.class, n -> n >= 1 && n <= 5, "1~5사이의 값을 입력하세요");
				switch (input) {
				case 1:
					cs.cartlist();
					break;
				case 2:
					cs.back();
					break;
				case 3:
					cs.add(); //
					break;
				case 4:
					cs.remove();
					break;
				case 5:
					System.out.println("책 구매을 종료합니다");
					cs.cancel();				
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
