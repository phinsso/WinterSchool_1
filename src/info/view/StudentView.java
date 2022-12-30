package info.view;

import java.util.ArrayList;
import info.vo.StudentVO;

//화면에 출력하기 위한 객체
public class StudentView {
	
	//view(ArrayList<StudentVO> svoList): 화면에 출력을 위한 메소드
	public void view(ArrayList<StudentVO> svoList) {
		for (StudentVO svo : svoList) { //차례대로 출력할 떄는 개선된 for문이 용이
			System.out.println("=======================");
			System.out.println("== 성명: " + svo.getName());
			System.out.println("== 학번: " + svo.getStuId());
			System.out.println("== 학년: " + svo.getGrade());
			System.out.println("== 학과: " + svo.getMajor());
			System.out.println("== 전화번호: " + svo.getMobile());
			System.out.println("=======================");
		}
	}
}
