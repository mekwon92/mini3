package miniBook;

import java.util.List;

// 출력 확인부
import miniCustomer.*;
import miniCustomer.MiniUtils;

public class BookTest {
	public static void main(String[] args) throws Exception {
		BookService bookService = BookService.getInstance();
		bookService.bookSearcher();
//		bookService.bookAdd();
		
//		public void bookSearcher() {
//			boolean flag = true;
//			while (flag) {
//				Book b = null;
//				System.out.printf("SYSTEM :: 도서를 검색합니다.\n1.도서번호 2.ISBN 3.제목 4.저자 5.전체 6.뒤로가기");
//				int input = MiniUtils.next("입력", Integer.class, i -> i >= 1 && i <= 6, "1~6 사이의 숫자 입력");
//				printBooks(bookList);
//				switch (input) {
//				case 1: {
//					b = findByBookId(MiniUtils.next("SYSTEM :: 도서번호를 입력하세요", String.class, s -> findByBookId(s) != null,
//							"존재하지 않는 도서번호입니다."));
//					if (b != null) {
//						System.out.println("==================== 검색 결과 ====================");
//						System.out.println(b);
//						showBookDetails(b);
//						System.out.println("SYSTEM :: 출력이 완료되었습니다.");
//					} else {
//						System.out.println("SYSTEM :: 해당 도서를 찾을 수 없습니다.");
//					}
//					break;
//				}
//				case 2: {
//					b = findByBookISBN(MiniUtils.next("SYSTEM :: ISBN을 입력하세요", String.class, s -> true, 
//							"존재하지 않는 ISBN입니다."));
//					if (b != null) {
//						System.out.println("==================== 검색 결과 ====================");
//						System.out.println(b);
//						showBookDetails(b);
//						System.out.println("SYSTEM :: 출력이 완료되었습니다.");
//					} else {
//						System.out.println("SYSTEM :: 해당 도서를 찾을 수 없습니다.");
//					}
//					break;
//				}
//				case 3: {
//					String title = MiniUtils.next("SYSTEM :: 제목을 입력하세요", String.class);
//					List<Book> books = findByBookName(title);
//					if (!books.isEmpty()) {
//						System.out.println("==================== 검색 결과 ====================");
//						printBooks(books);
//						System.out.println("SYSTEM :: 출력이 완료되었습니다.");
//						// 추후 추가될 장바구니쪽 메서드 추가해야 함
//					} else {
//						System.out.println("SYSTEM :: 해당 제목의 도서를 찾을 수 없습니다.");
//					}
//					break;
//				}
//				case 4: {
//					String author = MiniUtils.next("SYSTEM :: 저자를 입력하세요", String.class);
//					List<Book> books = findByWriter(author);
//					if (!books.isEmpty()) {
//						System.out.println("==================== 검색 결과 ====================");
//						printBooks(books);
//						System.out.println("SYSTEM :: 출력이 완료되었습니다.");
//					} else {
//						System.out.println("SYSTEM :: 해당 제목의 도서를 찾을 수 없습니다.");
//					}
//					break;
//				}
//				case 5: {
//					break;
//				}
//				case 6: {
//					System.out.println("SYSTEM :: 이전 메뉴로 돌아갑니다.");
//					flag = false;
//				}
//				default:
//					break;
//				}
//			}
//		}
		
//		private List<Book> bookSearcher(){
//			String [] category = {"1-도서", "2-번호",  "3-제목",  "4-저자",  "5-돌아가기"};
//			int input = MiniUtils.next("SYSTEM :: 1.번호 2.ISBN 3.제목 4.저자 5.돌아가기", Integer.class);
//			switch(category[input - 1]) {
//			
//				case "1-도서" :{
//				
//				}
//				
//					
//				case "2-번호" :{
//					
//				}
//					
//				case "3-제목" :{
//					
//				}
//					
//				case "4-저자" :
//					
//				case "5-돌아가기" :
//					
//					
//					
//			
//			}
			
			
			
		}
		
		
	}

