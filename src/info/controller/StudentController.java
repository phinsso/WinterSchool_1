package info.controller;

import java.util.ArrayList;
import java.util.Scanner;

import info.view.StudentView;
import info.vo.StudentDAO;
import info.vo.StudentVO;

public class StudentController {

	public static final int CONTINUE = 1;
	public static final int BREAK = 0;

	//콘솔창에서 입력받은 학생정보를 사용하여 각각의 ArrayList에 저장해둔다.
	//여러 학생 정보(동적인원수)를 입력 받기 위해서
	ArrayList<String> names = new ArrayList<String>();
	ArrayList<Integer> stuIds = new ArrayList<Integer>();
	ArrayList<Integer> grades = new ArrayList<Integer>();
	ArrayList<String> majors = new ArrayList<String>();
	ArrayList<String> mobiles = new ArrayList<String>();

	public void consoleToList() {
		//콘솔에 입력받기 위해 스캐너 생성
		Scanner sc1 = new Scanner(System.in); //문자열용
		Scanner sc2 = new Scanner(System.in); //숫자용


		//flag: 콘솔창에서 학생정보를 입력 받을 때 계속 입력받을 것인지 멈출 것인지의 상태를 저장하는 변수
		int flag = CONTINUE;

		while(true) {
			if(flag == CONTINUE) {
				System.out.print("== 성명: ");
				names.add(sc1.nextLine());
				System.out.print("== 학번: ");
				stuIds.add(sc2.nextInt());
				System.out.print("== 학년: ");
				grades.add(sc2.nextInt());
				System.out.print("== 학과: ");
				majors.add(sc1.nextLine());
				System.out.print("== 전화번호: ");
				mobiles.add(sc1.nextLine());
			} else if(flag == BREAK) {
				break;
			}

			System.out.print("학생정보를 계속 입력하시겠습니까? (계속: 1,  중지: 0)");
			flag = sc2.nextInt();
			System.out.println();
		}

		sc1.close();
		sc2.close();
	}

	//콘솔창에서 입력받은 학생정보를 사용하여 StudentVO 객체를 생성하고
	//생성된 StudentVO 객체를 StudentDAO 객체의 ArrayList에 저장한다
	public void voToDAO(StudentDAO dao) {
		for(int i = 0; i < names.size(); i++) {
			StudentVO svo = new StudentVO(names.get(i), stuIds.get(i), grades.get(i), majors.get(i), mobiles.get(i));
			dao.insert(svo);
		}
	}

	public static void main(String[] args) {
		StudentController controller = new StudentController();
		//콘솔창에서 입력 받은 값을 각각의 정보를 저장하는 ArrayList에 저장하는 메소드
		controller.consoleToList();
		//입력받은 값들을 사용하여 StudentVO객체를 생성하여 DAO의 ArrayList에 저장하는 메소드
		StudentDAO dao = new StudentDAO();
		controller.voToDAO(dao);
		//화면에 출력
		StudentView sView = new StudentView();
		sView.view(dao.select());


	}
}
