package miniLibrary;

import java.util.ArrayList;
import java.util.List;

import miniCustomer.*;
import miniBook.*;

public class Rental {
	
	private List<Book> bookList; // 도서정보
	private List<Customer> customerList; // 고객정보
	private List<Book> occupideBooks = new ArrayList<Book>(); // 회원별로 대여된 서적 조회하기
}
