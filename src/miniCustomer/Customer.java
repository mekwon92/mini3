package miniCustomer;

import java.util.List;

public class Customer {
	private String id;
	private String pw;
	private int userNum;
//	private List<Book?> purchaseList;
	

	public Customer(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}


	@Override
	public String toString() {
		return "아이디("+ id + ") 비밀번호(" + pw+")";
	}
	
	
	
	
}
