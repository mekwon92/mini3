package miniCustomer;

public class CustomerMain {
	public static void main(String[] args) {
		CustomerService cs = new CustomerService();
		
		System.out.println("****얼라딘입니다. 어서오세요****");

		while(true) {
			int input = MiniUtils.next("1. 로그인 2. 회원가입 3. 비회원 구매 4. 종료", Integer.class ,  t -> t >= 1 && t <= 4, "1에서 4 사이의 수");
			switch (input) {
			case 1:
				cs.login();
				cs.afterLogin();
				break;
			case 2:
				cs.customerAdd();
				break;
			case 3:
				System.out.println("비회원구매 서비스 예정 첫화면으로 돌아갑니다");
				break;
			case 4:
				System.out.println("감사합니다");
				return;
			default:
				break;
			}
			
		}
	}

}
