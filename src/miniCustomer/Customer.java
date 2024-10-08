package miniCustomer;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Customer implements Serializable{
	private String id;
	private String pw;
	private String name;
	

	public Customer(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
	


	@Override
	public String toString() {
		return "ID("+ id + ") PASSWORD(" + pw+")";
	}
	
	
	
	
}
