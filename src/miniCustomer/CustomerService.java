package miniCustomer;

import miniBook.*;

import java.util.ArrayList;
import java.util.List;

/* 추후 해야할 작업
 * 1. 정규식 이용해서 matchs
 * 2. 입출력으로 영속화
 * 3. 구매내역 확인

 * 
 * 생각해볼것
 * 구매내역확인 ..... findBy를 이용해서 갖고와야함....
*/
//회원번호 id 수량 
//사용자아이디만 알아도됨
//책번호로 책... id...회원

//리스트들을 묶어서 하나의 클래스에 모아서 영속화하는게 ... 편하다..

public class CustomerService {
	private static CustomerService costomerService = new CustomerService();
	private List<Customer> customers = new ArrayList<Customer>();
	private Customer loginUser;
	BookService bs = BookService.getInstance();
	
	private CustomerService() {
		// TODO Auto-generated constructor stub
	}
	
	public static CustomerService getInstance() {
		return costomerService;
	}

	public Customer getLoggedInUser() {
		return loginUser;
	}

	{
		Customer customer = new Customer("id1", "pw1","권미은");
		Customer customer2 = new Customer("id2", "pw2","김미미");
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
					loginUser = c;
					afterLogin();
					return;
				}
			}
			System.out.println("비밀번호 불일치");
			return;

		}
	}

	// 로그인 후
	public void afterLogin() {
		System.out.println(loginUser.getName()+"님. 원하시는 항목을 선택하세요");
		int input = MiniUtils.next("1.도서 검색  2.마이페이지  3. 로그아웃 ", Integer.class, t -> t >= 1 && t <= 3, "1에서 3 사이의 수");
		switch (input) {
		case 1:
			bs.bookSearcher();
			break;
		case 2:
			myPage();
			break;
		case 3:
			logout();
			break;
		default:
			break;
		}
	}
	

	//로그아웃
	public void logout() {
		loginUser = null;
	}
	
	// 아이디 생성
	int cnt = 1000;

	public void customerAdd() {
		System.out.println("회원가입 화면입니다.");
		String id = MiniUtils.next("ID", String.class, s -> findBy(s) == null, "중복아이디 존재. 가입불가");
		String pw = MiniUtils.next("PW", String.class);
		String name = MiniUtils.next("이름", String.class);

		Customer c = new Customer(id, pw, name);
		c.setUserNum(cnt);
		customers.add(c);
		System.out.println("ID(" + id + ") PASSWORD(" + pw + ") 생성 완료. 회원 번호 부여: " + c.getUserNum());
		cnt++;

	}


	// 마이페이지
	public void myPage() {
		System.out.println("****마이페이지****");
		while(loginUser!=null) {
			int input = MiniUtils.next("1. 구매이력 확인 2. 비밀번호 변경 3. 회원 삭제 4. 뒤로가기 ", Integer.class, t -> t >= 1 && t <= 4,
					"1에서 4 사이의 수");
				switch (input) {
				case 1:
					System.out.println("구매이력 서비스 예정. 다시입력하세요 ");
					break;
				case 2:
					customerModify();
					break;
				case 3:
					customerRemove();
					break;
				case 4:
					return;
				default:
					break;
			}		
		}
	}
	
	//회원삭제
		public void customerRemove() {
			System.out.println("삭제를 원하시면 본인의 비밀번호를 입력하세요");
			String pw = MiniUtils.next
					("PW", String.class);
			if (loginUser.getPw().equals(pw)) {
				customers.remove(loginUser);
				loginUser = null;
				System.out.println("삭제완료");
				return;		
			}
			System.out.println("비밀번호가 틀렸습니다");
			return;
		}
		
	//비밀번호 수정
		public void customerModify() {
			String pw =  MiniUtils.next("수정할 비밀번호를 입력하세요", String.class,s-> !s.equals(loginUser.getPw()),"현재 본인 비밀번호와 같습니다. 다시 입력해주세요");
			loginUser.setPw(pw);
			System.out.println(pw + "로 수정되었습니다");
			
		}

	// 고객리스트 출력
	public void printCustomer() {
		System.out.println("==============================");
		System.out.println("회원번호       ID     PASSWORD");
		System.out.println("==============================");
		for (Customer c : customers) {
			System.out.printf("%5d %11s %11s", c.getUserNum(), c.getId(), c.getPw());
			System.out.println();
		}
	}
	//매출확인
	private void profit() {
		System.out.println();
		
	}
	
	//환불
	
	
	
	

	// 중복체크메서드(객체반환)
	private Customer findBy(String id) {
		Customer customer = null;
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getId().equals(id)) {
				customer = customers.get(i);
			}
		}
		return customer;

	}
	//관리자페이지
	public void manager() {
		System.out.println("****관리자 페이지****");
		String key = MiniUtils.next("관리자 키를 입력하세요", String.class);
		while(true) {
			if(key.equals("abcd")) {
				int input = MiniUtils.next("1. 매출확인 2. 책정보 변경 3. 회원내역 확인 4. 뒤로가기 ", Integer.class, t -> t >= 1 && t <= 4, "1에서 4 사이의 수");
				switch (input) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					printCustomer();
					break;
				case 4:
					return;
				default:
					break;
				}
			}
			else {
				System.out.println("관리자 키 불일치. 접근불가");
				return;
			}
		}
		
		
		
		
	}
}
