package cart;

import static CartMain.BookCart.next;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;



public class BookCart {	
	
	//1.구매 2. 취소 3.장바구니로 이동 4.뒤로 가기 5.종료
	private List<book>cart =new ArrayList<book>(); //장바구니
	private List<book>buy;
	private List<book>cancel;
	private List<book>back;
	

	{
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("money"))) {
			cart = (List<book>) ois.readObject();
		} catch (FileNotFoundException e) {
//			System.out.println("파일 검색 실패, 초기화 더미 데이터 처리 완료");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();//예외 정보 출력
		} 
		cloneAndSort();
	}
	
	
	
//public void buy() { //구매
//		
		String booknum=MiniUtils.next("책 이름", String.class, n -> findBy(n) == null, "정확한 책 이름을 입력하세요");
//		String name = next("이름", String.class, n -> n.matches("^[가-힣]{2,4}"), "올바른 이름을 입력하세요(한글, 2~4글자)");
//		int kor = next("국어", Integer.class, i -> i <= 100 && i >= 0, "0이상 100이하의 값을 입력하세요");
//		int eng = next("영어", Integer.class, i -> i <= 100 && i >= 0, "0이상 100이하의 값을 입력하세요");
//		int mat = next("수학", Integer.class, i -> i <= 100 && i >= 0, "0이상 100이하의 값을 입력하세요");
//		
//		students.add(new Student(no, name, kor, eng, mat));
	
//장바구니 들어왔을때
		public void  cartlist() {// 구매 조회

			int input = next("1.구매  2.취소 3.뒤로가기  4. 석차순", Integer.class, i -> i <= 3 && i >= 1, "1이상 3이하의 값을 입력하세요");
			List<Student> tmp = null;
			switch (input) {
			case 1:
				tmp = buy;
				
				break;
			case 2:
				tmp = cancel;
//				break;
//			case 3:
//				tmp = back;

//				break;
//			case 4:
//				tmp = 
//				break;
//			default:
//				System.out.println("????");
//				break;
//			}
	
//	public void remove() { //장바구니에 서적 삭제
//		Student s = findBy(next("학번", Integer.class, n -> findBy(n) != null, "입력한 학번은 존재하지 않습니다."));
//		students.remove(s);
//	}
	

//	public void save() { //매출 관련
//		try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
//			stream.writeObject(students);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
// 장바구니 재고 같은경우 클론을 복제하여 장바구니에서 취소할 경우 그 원본과 장바구니 재고가 같게 한다	
		
		private Cart findBy(int no) {
			Cart cart = null;
			for(int i = 0 ; i < Cart.size() ; i++) {
				if(Cart.get(i).getNo() == no) {
					cart = Cart.get(i);
				}
			}
			return cart;
		}
}



