//package cart;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//import student.Student;
//
//public class BookTrade {	
//	
//	//1.구매 2. 취소 3.장바구니로 이동 4.뒤로 가기 5.종료
//	
//	
//	private List<book>bookcart =new ArrayList<book>(); //장바구니
//	
//	
//	
////public void add() { //장바구니에 서적 추가
////		
//		String bookName =MiniUtils.next("책 이름", String.class, n -> findBy(n) == null, "정확한 책 이름을 입력하세요");
////		String name = next("이름", String.class, n -> n.matches("^[가-힣]{2,4}"), "올바른 이름을 입력하세요(한글, 2~4글자)");
////		int kor = next("국어", Integer.class, i -> i <= 100 && i >= 0, "0이상 100이하의 값을 입력하세요");
////		int eng = next("영어", Integer.class, i -> i <= 100 && i >= 0, "0이상 100이하의 값을 입력하세요");
////		int mat = next("수학", Integer.class, i -> i <= 100 && i >= 0, "0이상 100이하의 값을 입력하세요");
////		
////		students.add(new Student(no, name, kor, eng, mat));
//	
////	// 
////		public void  cartlist() { 장바구니에 담긴 서적 조회
////			System.out.println("list()");
////			int input = next("1. 입력순 2. 학번순 3. 이름순 4. 석차순", Integer.class, i -> i <= 4 && i >= 1, "1이상 4이하의 값을 입력하세요");
////			List<Student> tmp = null;
////			switch (input) {
////			case 1:
////				tmp = buybook;
////				break;
////			case 2:
////				tmp = cancel;
////				break;
////			case 3:
////				tmp = gocart;
////				break;
////			case 4:
////				tmp = back;
////				break;
////			default:
////				System.out.println("????");
////				break;
////			}
//	
////	public void remove() { //장바구니에 서적 삭제
////		Student s = findBy(next("학번", Integer.class, n -> findBy(n) != null, "입력한 학번은 존재하지 않습니다."));
////		students.remove(s);
////	}
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
//		private Cart findBy(int no) {
//			Student student = null;
////			int no = nextInt("학번");
//			for(int i = 0 ; i < students.size() ; i++) {
//				if(students.get(i).getNo() == no) {
//					student = students.get(i);
//				}
//			}
//			return student;
//		}
//}
package cart;


