package mini;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* 추후 해야할 작업
 * 1. 정규식 이용해서 matchs
 * 2. 입출력으로 영속화
 * 3. 구매내역 확인
 * 4. (관리자하게되면) 회원리스트
 * */

public class CustomerService {
	private List<Customer> customers = new ArrayList<Customer>();
	private Map<Integer, Customer> usermap = new HashMap<Integer, Customer>();
	
	
		{
			customers.add(new Customer("id1","pw1"));
			customers.add(new Customer("id2","pw2"));
			
		}
	
	// 아이디 생성
		int cnt = 1000;
	public void customerAdd() {
		String id = MiniUtils.next("ID", String.class, s->findBy(s) == null , "중복아이디 존재. 가입불가");
		String pw = MiniUtils.next("PW", String.class);
		
		Customer c = new Customer(id, pw);
		c.setUserNum(cnt);
		customers.add(c);
		System.out.println("아이디 : "+id+ " 비밀번호 : " +pw +" 생성되었습니다. 회원 번호 : " + c.getUserNum());
		usermap.put(cnt, c);
		cnt++;
		
	}
	
	// 아이디 제거
	public void customerRemove() {
		Customer c = findBy(MiniUtils.next("삭제할 ID를 입력하세요", String.class , s->findBy(s) != null, "해당하는 아이디가 없습니다."));
		customers.remove(c);
		System.out.println("삭제완료");
	}
	
	
	//로그인
	public void login() {
		String id = MiniUtils.next("ID", String.class);
		String pw = MiniUtils.next("PW", String.class);
				
		if(findBy(id) == null) {
			System.out.println("해당하는 아이디가 없습니다");
			return;
		}
		else {
			for(Customer c : customers) {
				if(c.getId().equals(id)&&c.getPw().equals(pw)) {
					System.out.println("로그인 완료");
					return;
				}
			}	
			System.out.println("비밀번호 불일치");
		}
	}
	
	//고객출력
	public void printCustomer() {
	
	}
	
	
	//중복체크 메서드
	
	private Customer findBy(String id) {
		Customer customer = null;
		for(int i = 0; i<customers.size(); i++) {
			if(customers.get(i).getId().equals(id)) {
				customer = customers.get(i);
			}
		}
		return customer;
		
	}
}
