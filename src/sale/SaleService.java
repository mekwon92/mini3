package sale;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import miniCart.*;
import miniBook.*;
import miniCustomer.*;

@SuppressWarnings("unchecked")
public class SaleService {
	// 싱글턴
	private CustomerService customerService;
	private static SaleService saleService = new SaleService();

	private SaleService() {
	}

	public static SaleService getInstance() {
		return saleService;
	}
	public void setcustomerService() {
		customerService=CustomerService.getInstance();
	}
			
	private List<Sale> sales = new ArrayList<Sale>();

	{
        Sale sale = new Sale();
        sale.setSaleId(1);
        sale.setId("id1");
        List<Book> list = new ArrayList<Book>();
        list.add(new Book("0000", "홍길동전", "홍길동", "길동사", "0000000000001", "정의의 사도 홍길동의 모험", 10_000, 2, false,
                false));
        list.add(new Book("0003", "참을 수 없는 존재의 가벼움", "홍길동", "길동사", "0000000000004", "길고도 복잡한 이야기를 원한다면.", 13_000,
                1, false, false));
        sale.setBooks(list);
        sales.add(sale);
    }

	public List<Sale> getSales() {
		return sales;
	}


	// 회원에서 현재 로그인한 사용자의 구매내역
	public List<Sale> getMySale() {
		String id = customerService.getLoggedInUser().getId();

		List<Sale> ret = new ArrayList<>();
		for (Sale s : sales) {
			if (s.getId().equals(id)) {
				ret.add(s);
			}
		}
		save();// 저장한거 호출
		return ret;
	}

	// 구매 진행
	public void add(Cart c) {
		Sale sale = new Sale();
		List<Book> list = new ArrayList<Book>(c.getCarts());
		String id = customerService.getLoggedInUser().getId();

		sale.setId(id);
		sale.setSaleId(sales.isEmpty() ? 1 : sales.get(sales.size() - 1).getSaleId() + 1);
		sale.setBooks(list);

		sales.add(sale);
	}

	// 매출 기록 삭제
	public void remove() {
		int input = MiniUtils.next("취소할 구매 번호를 입력", Integer.class);
		Sale s = findBy(input);
		if (s == null) {
			System.out.println("올바른 구매번호가 아닙니다");
			return;
		}
		sales.remove(s);
	}

	public Sale findBy(int saleId) {
		for (Sale s : sales) {
			if (saleId == s.getSaleId()) {
				return s;
			}
		}
		return null;
	}

	public void save() {
		try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("./src/sale/money.ser"))) {
			stream.writeObject(sales);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}