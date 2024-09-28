//package cart;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//import java.util.List;
//import miniBook.Book;
//
//
//
//
//public class CartService {	
//	
//	//1.구매 2. 취소 3.장바구니로 이동 4.뒤로 가기 5.종료
//	private List<Book> carts = new ArrayList<Book>(); //장바구니
//	private List<Book> back;
//	//private List<Book> buy;
//	private List<Book> cancel;
//	
//	
//	
//
//	{
//		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("money"))) {
//			carts = (List<Book>) ois.readObject();
//		} catch (FileNotFoundException e) {
////			System.out.println("파일 검색 실패, 초기화 더미 데이터 처리 완료");
//		} catch (IOException | ClassNotFoundException e) {
//			e.printStackTrace();//예외 정보 출력
//		} 
//		
//	}
//	
//	
////	
////	public void buy() { //구매
////		List<Book> tmpList = new ArrayList<Book>()
////		(BookService.getBookList().get(findby("")));
////		carts.add();
////		
////	}
//	
//	public void buy() { //구매
//		List<Book> bookList = new ArrayList<Book>()
//		(BookService.getBookList().get(findby("")));
//		
//	}
//	
//	public void cancel() { //담은 책 취소
//		List<Book> bookList = new ArrayList<Book>()
//		(BookService.getBookList().get(findby("")));
//		List<Book> bookcancel= null; //취소 할 책을 없애기
//	}
//	
//	public void back() { //뒤돌아가기
//		List<Book> bookList = new ArrayList<Book>()
//		(BookService.getBookList().get(findby("")));
//		
//	}
//	
//
//	private Book findBy(String buy) {
//		Book cart = null;
//		for(int i = 0 ; i < carts.size() ; i++) {
//			if(carts.get(i).getBookId() == buy) {
//				cart = carts.get(i);
//			}
//		}
//		return cart;
//	}
//	
//	
//
////장바구니 들어왔을때
//		public void  cartlist() {// 구매 조회
//			//책 정보
//			int input = MiniUtils.next("1.구매 2.취소 3.뒤로가기", Integer.class, i -> i <= 3 && i >= 1, "1이상 3이하의 값을 입력하세요");
//			List<Book> tmp = null;
//			switch (input) {
//			case 1:
//				System.out.println("장바구니에 담습니다.");
//				tmp = buy;
//				
//				break;
//			case 2:
//				System.out.println("취소합니다.");
//				
//				tmp = cancel;
//				break;
//			case 3:
//				System.out.println("목록으로 돌아가기");
//				tmp = back;
//
//				break;
//			default:
//				System.out.println("????");
//				break;
//			}
//			for(int i = 0 ; i < tmp.size() ; i++) {
////				System.out.println(students[i]);
//				System.out.println(tmp.get(i));
//			}
//		}
//	public void remove() { //장바구니에 서적 삭제
//		Book cs = findBy(MiniUtils.next("책 번호를 입력하세요", String.class, n -> findBy(n) != null, "입력한 책은 존재하지 않습니다."));
//		carts.remove(cs);
//	}
//	
//
////	public void save() { //매출 관련
////		try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
////			stream.writeObject(students);
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////	}
//// 장바구니 재고 같은경우 클론을 복제하여 장바구니에서 취소할 경우 그 원본과 장바구니 재고가 같게 한다	
//		
//
//
//	
//}
//
//
//
//
//
//
