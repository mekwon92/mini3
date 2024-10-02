package sale;

import java.util.ArrayList;
import java.util.List;

import miniBook.Book;
import miniCustomer.Customer;

public class Sale {
    private int saleId; // PK
    private String id; // Customer id
    private List<Book> books = new ArrayList<Book>(); // 클론예정
    private long regDate = System.currentTimeMillis(); // 구매했을때 시간

// 총액 계산 메서드
    public int total() {
        int sum = 0;
        return sum;
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
        return "Sale [saleId=" + saleId + ", id=" + id + ", regDate=" + regDate + ", total()=" + total() + "]";
    }
}