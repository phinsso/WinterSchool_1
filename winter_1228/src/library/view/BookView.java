package library.view;

import java.util.ArrayList;
import library.vo.BookVO;

public class BookView {

	public void view(ArrayList<BookVO> bvoList) {
		for(BookVO bvo : bvoList) {
			System.out.println("-------------------");
			System.out.println("-- 도서번호: " + bvo.getIsbn());
			System.out.println("-- 도서명: " + bvo.getBookName());
			System.out.println("-- 출판사: " + bvo.getPublish());
			System.out.println("-- 저자명: " + bvo.getAuthor());
			System.out.println("-- 가격: " + bvo.getPrice());
			System.out.println("-- 카테고리: " + bvo.getCategory());
			System.out.println("-------------------");
		}
	}
}
