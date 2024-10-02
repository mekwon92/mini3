package cart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import miniBook.*;
import miniCustomer.Customer;
import miniCustomer.CustomerService;
import miniCustomer.MiniUtils;
import sale.Sale;
import sale.SaleService;

//cs.getLoggedInId() 로그인한 객체 가져오는법

//카트 서비스 싱글턴
public class CartService {
    private static CartService CartService = new CartService();

    private CartService() {

    }

    public static CartService getCartService() {
        return CartService;
    }

    SaleService saleService = SaleService.getInstance();
    
    Cart cart = new Cart();
    public List<Book> cartList = cart.getCarts();
    private List<Book> booklist = new ArrayList<Book>();
    BookService sw = BookService.getInstance();

    public void printCart() {
        int cnt = 1;
        for(Book book : cartList) {
            System.out.println(cnt++ + "::" + book.getBookName()+":::" +book.getBookCount() + "권");
        }    
        
         int sum =cartList.stream().mapToInt(b -> b.getBookCount()* b.getBookPrice()).sum();
         System.out.println("총 금액은"+sum+"원 입니다");
    }

    public void add(Book a) {
//        a.clone();// 책 복사
        List<Book> list = cart.getCarts();
        boolean flag = false;
        Book tmp = null;
        for (Book book : list) {
            if (book.getBookId().equals(a.getBookId())) {
                flag = true;// 조건이 트루일때
                tmp = book; // 책을 탬에 담는다
                break;
            }
        }
        if (flag) {
            tmp.increaseBookCount();
        }
        else {
            list.add(a.clone());
        }
    }

    public void remove() { // 장바구니에 서적 삭제
        Book cs = findBy(MiniUtils.next("책 번호를 입력하세요", String.class, n -> findBy(n) != null, "입력한 책은 존재하지 않습니다."));
        cart.getCarts().remove(cs);
    }

    public void remove(List<Book> targetlist) { // 오버로딩
        for (int i = 0; i < targetlist.size(); i++)
            targetlist.remove(i);
    }

    public Book findBy(String bookid) {
        Book newcart = null;
        for (Book ss : booklist) {
            if (ss.getBookId() == bookid) {
                newcart = ss;
            }

        }
        return newcart;
    }

    public void printbook() {
        List<Book> blist = new ArrayList<Book>();
        for (Book se : blist) {
            System.out.println(se);
            
        }

    }
//갯타입에 객체하나 리턴하는 느낌인데 단체로 검색되는 경우 제목 저자로 나올때 리스트를 던진다