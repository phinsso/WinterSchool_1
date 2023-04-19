package library.vo;

import java.util.ArrayList;

public class BookDAO {

	//ArrayList
	ArrayList<BookVO> bvoList = new ArrayList<BookVO>();
	
	//insert(): ArrayList에 도서정보객체 추가
	public void insert(BookVO bvo) {
		bvoList.add(bvo);
	}
	
	//select(): ArrayList 참조값 반환
	public ArrayList<BookVO> select() {
		return bvoList;
	}
}
