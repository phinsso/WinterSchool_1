package info.vo;

//VO: Value Object
public class StudentVO {

	private String name;     //이름
	private int stuId;       //학번
	private int grade;       //학년
	private String major;    //학과
	private String mobile;   //전화번호
	
	//생성자: 필드 값 초기화
	//필드(전역변수): 기본초기값 O (String: null, int: 0)
	//지역변수: 초기값 X
	
	public StudentVO(String name, int stuId, int grade, String major, String mobile) {
		this.name = name;
		this.stuId = stuId;
		this.grade = grade;
		this.major = major;
		this.mobile = mobile;
	}
	
	//setter: 필드(메소드 밖에서 선언되는 변수) 값 설정
	//getter: 필드 값 변환
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Override //부모 클래스가 명시되지 않으면 자동으로 Object가 부모 클래스가 됨 (최상위 클래스)
	public String toString() {
		return "StudentVO [name=" + name + ", stuId=" + stuId + ", grade=" + grade + ", major=" + major + ", mobile="
				+ mobile + "]";
	}
	
	
	
	
}
