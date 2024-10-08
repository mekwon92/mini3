package sale;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import miniBook.Book;
import miniCustomer.Customer;

public class Sale implements Serializable {
    private int saleId; // PK
    private String id; // Customer id
    private List<Book> books = new ArrayList<Book>(); 
    private long regDate = System.currentTimeMillis(); // 구매했을때 시간
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
 // 총액 계산 메서드
    public int total() {
//        int sum = 0;
        return books.stream().mapToInt(b -> b.getBookCount() * b.getBookPrice()).sum();
    }

    // 책정보 조회 메서드

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public long getRegDate() {
        return regDate;
    }

    public void setRegDate(long regDate) {
        this.regDate = regDate;
    }
   
    
    @Override
    public String toString() {
        return " 구매번호 " + saleId +  " ::: 주문금액 " + total() + "원 ::: 구매시간 " +sdf.format(new Date(regDate)) ;
    
    }
}