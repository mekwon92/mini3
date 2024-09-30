package miniCustomer;

import miniBook.*;
import cart.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;;

/* 추후 해야할 작업
 * 1. 정규식 이용해서 matchs
 * 2. 입출력으로 영속화
 * 3. 구매내역 확인
 * 4. (관리자하게되면) 회원리스트
 * 
 * 생각해볼것
 * 1. id입력 안받고 바로 삭제하는 방법이 있나..?!
 * 2. switch문 말고 다른방법
 * 3. 입력받은 id를 계속 사용할방법..?
 * 구매내역확인 ..... findBy를 이용해서 갖고와야함....
 * */
//
//회원번호 id 수량 
//사용자아이디만 알아도됨
//책번호로 책... id...회원

public class CustomerService {
	private List<Customer> customers = new ArrayList<Customer>();
	private Customer loggedInId;
	BookService bs = new BookService();

	public Customer getLoggedInId() {
		return loggedInId;
	}

	{
		Customer customer = new Customer("id1", "pw1");
		Customer customer2 = new Customer("id2", "pw2");
		customer.setUserNum(998);
		customer2.setUserNum(999);
		customers.add(customer);
		customers.add(customer2);
	}

//
	// 로그인
	public void login() {

		String id = MiniUtils.next("ID", String.class);
		String pw = MiniUtils.next("PW", String.class);

		if (findBy(id) == null) {
			System.out.println("해당하는 아이디가 없습니다");
			return;

		} else {
			for (Customer c : customers) {
				if (c.getId().equals(id) && c.getPw().equals(pw)) {
					System.out.println("로그인 성공");
					afterLogin();
					loggedInId = c;
					return;
				}
			}
			System.out.println("비밀번호 불일치");
			return;


		}
	}

	// 로그인 후
	public void afterLogin() {
	
			int input = MiniUtils.next("1.도서 검색  2.회원정보  3. 로그아웃 ", Integer.class, t -> t >= 1 && t <= 3,
					"1에서 3 사이의 수");
			switch (input) {
			case 1:
				bs.bookSearcher();
				break;
			case 2:
				customerInfo();
				break;
			case 3:
				return;
			default:
				break;
			}
		}
	

	// 아이디 생성
	int cnt = 1000;

	public void customerAdd() {
		System.out.println("회원가입 화면입니다.");
		String id = MiniUtils.next("ID", String.class, s -> findBy(s) == null, "중복아이디 존재. 가입불가");
		String pw = MiniUtils.next("PW", String.class);

		Customer c = new Customer(id, pw);
		c.setUserNum(cnt);
		customers.add(c);
		System.out.println("ID(" + id + ") PASSWORD(" + pw + ") 생성 완료. 회원 번호 부여: " + c.getUserNum());
		cnt++;

	}

	// 아이디 제거
//	public void customerRemove() {
//		System.out.println("삭제를 원하시면 본인의 아이디와 비밀번호를 입력하세요");
//		String id = MiniUtils.next("ID", String.class); //남의 아이디를 입력해도 되는 문제가 있다.
//		String pw = MiniUtils.next("PW", String.class);
//		if(findBy(id) == null) {
//			System.out.println("해당하는 아이디가 없습니다");
//			return;
//		}
//		else {
//			for(Customer c : customers) {
//				if(c.getId().equals(id)&&c.getPw().equals(pw)) {
//					customers.remove(c);
//					System.out.println("삭제완료");
//					return;
//				}
//			}	
//			System.out.println("비밀번호가 틀렸습니다. 다시시도하세요");
//			return;
//		}
//	}

	public void customerRemove() {
		Customer cc = loggedInId;
		System.out.println("삭제를 원하시면 본인의 비밀번호를 입력하세요");
		String pw = MiniUtils.next("PW", String.class);
		if (loggedInId.getPw().equals(pw)) {
			for (Customer c : customers) {
				if (c.getId().equals(cc.getId())) {
					customers.remove(c);
					System.out.println("삭제완료");
					return;
				}
			}
			System.out.println("비밀번호가 틀렸습니다");
			return;
		} else
			System.out.println("비밀번호가 틀렸습니다. 다시입력하세요");
		return;

	}

	// 회원정보 관리
	public void customerInfo() {
		while (true) {
			System.out.println("****마이페이지****");
			int input = MiniUtils.next("1. 구매이력 확인 2. 회원 삭제 3. 뒤로가기 ", Integer.class, t -> t >= 1 && t <= 3,
					"1에서 3 사이의 수");
			switch (input) {
			case 1:
				System.out.println("구매이력 서비스 예정. 다시입력하세요 ");
				break;
			case 2:
				customerRemove();
				break;
			case 3:
				return;
			default:
				break;
			}
		}
	}

	// 고객출력

	public void printCustomer() {
		System.out.println("==============================");
		System.out.println("회원번호       ID     PASSWORD");
		System.out.println("==============================");
		for (Customer c : customers) {
			System.out.printf("%5d %11s %11s", c.getUserNum(), c.getId(), c.getPw());
			System.out.println();
		}
	}

	// 중복체크 메서드

	private Customer findBy(String id) {
		Customer customer = null;
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getId().equals(id)) {
				customer = customers.get(i);
			}
		}
		return customer;

	}
}
