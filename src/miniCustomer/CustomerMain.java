package miniCustomer;

public class CustomerMain {
	public static void main(String[] args) {
		CustomerService cs = new CustomerService();
		
		cs.login();
		cs.customerAdd();
		cs.customerRemove();
		cs.printCustomer();
		while(true) {
			int input = MiniUtils.next("1. 로그인 2. 회원가입 3. 종료", Integer.class);
			switch (input) {
			case 1:
				cs.login();
			case 2:
				cs.customerAdd();
				break;
			case 3:
				System.out.println("감사합니다");
				return;
			default:
				break;
			}
			
		}
	}

}
