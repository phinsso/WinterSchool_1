package info.vo;

import java.util.ArrayList;

//Data Access Object (데이터에 접근)
public class StudentDAO {
	//ArrayList: 학생 정보 객체(StudentVO)들을 저장하기 위해
	ArrayList<StudentVO> svoList = new ArrayList<StudentVO>(); //타입 명시를 생략하면 자동으로 OBject형 타입이 됨
	
	//insert: ArrayList에 학생정보객체(StudentVO)를 추가하는 메소드
	public void insert(StudentVO svo) {
		svoList.add(svo);
	}
	
	//select: ArrayList 참조값(전체 학생정보객체들)을 반환하는 메소드
	public ArrayList<StudentVO> select() {
		return svoList;
	}
 }
