package miniCustomer;

import miniBook.BookService;

public class CustomerMain {
	public static void main(String[] args) {
		CustomerService cs = CustomerService.getInstance();
	System.out.println(cs.getLoggedInUser()+"\n");
	//cs.getLoggedInUser().getId();
		System.out.println("****얼라딘입니다. 어서오세요****");
		while(true) {
			int input = MiniUtils.next("1. 로그인 2. 회원가입 3. 관리자 전용 페이지 4. 종료", Integer.class ,  t -> t >= 1 && t <= 4, "1에서 4 사이의 수");
			switch (input) {
				case 1:
					cs.login();
					break;
				case 2:
					cs.customerAdd();
					break;
				case 3:
					cs.manager();
					break;
				case 4:
					System.out.println("안녕히가세요");
					return;
				default:
					break;
			}
			while(cs.getLoggedInUser()!=null) {
			cs.afterLogin();
			}
		}
	}
}

