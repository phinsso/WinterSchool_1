package library.controller;

import java.util.ArrayList;
import java.util.Scanner;

import library.view.BookView;
import library.vo.BookDAO;
import library.vo.BookVO;

public class BookController {

	public static final int CONTINUE = 1;
	public static final int BREAK = 0;
	
	ArrayList<String> isbns = new ArrayList<String>(); 
	ArrayList<String> bookNames = new ArrayList<String>();
	ArrayList<String> publishs = new ArrayList<String>();
	ArrayList<String> authors = new ArrayList<String>(); 
	ArrayList<Integer> prices = new ArrayList<Integer>();
	ArrayList<String> categorys = new ArrayList<String>();
	
	public void consoleToList() {
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		int flag = CONTINUE;
		
		while(true) {
			if(flag == CONTINUE) {
				System.out.print("== 도서번호: ");
				isbns.add(sc1.nextLine());
				System.out.print("== 도서명: ");
				bookNames.add(sc1.nextLine());
				System.out.print("== 출판사: ");
				publishs.add(sc1.nextLine());
				System.out.print("== 저자명: ");
				authors.add(sc1.nextLine());
				System.out.print("== 가격: ");
				prices.add(sc2.nextInt());
				System.out.print("== 분류명: ");
				categorys.add(sc1.nextLine());
			} else if(flag == BREAK) {
				break;
			}
			
			System.out.print("계속 입력하시겠습니까? (계속: 1,  종료: 0): ");
			flag = sc2.nextInt();
			System.out.println();
		}
		
		sc1.close();
		sc2.close();
	}
	
	public void voToDAO(BookDAO dao) {
		for(int i = 0; i < isbns.size(); i++) {
			BookVO bvo = new BookVO(isbns.get(i), bookNames.get(i), publishs.get(i), authors.get(i), prices.get(i), categorys.get(i));
			dao.insert(bvo);
		}
	}
	
	public static void main(String[] args) {
		BookController controller = new BookController();
		//콘솔창에서 입력 받은 값을 각각의 정보를 저장하는 ArrayList에 저장하는 메소드
		controller.consoleToList();
		//입력받은 값들을 사용하여 StudentVO객체를 생성하여 DAO의 ArrayList에 저장하는 메소드
		BookDAO dao = new BookDAO();
		controller.voToDAO(dao);
		//화면에 출력
		BookView bView = new BookView();
		bView.view(dao.select());


	}

}
