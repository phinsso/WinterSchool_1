package score.vo;

public class ScoreVO {

	int stuId; //학번
	String name; //이름
	int grade; //학년
	int classroom; //반
	
	int kor;
	int eng;
	int math;
	int sci;
	int total;
	double avg;
	
	
	public ScoreVO() {
		
	}
	
	public ScoreVO(int stuId, String name, int grade, int classroom, int kor, int eng, int sci, int total, int avg) {
		super();
		this.stuId = stuId;
		this.name = name;
		this.grade = grade;
		this.classroom = classroom;
		this.kor = kor;
		this.eng = eng;
		this.sci = sci;
		this.total = total;
		this.avg = avg;
	}

	
	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassroom() {
		return classroom;
	}

	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSci() {
		return sci;
	}

	public void setSci(int sci) {
		this.sci = sci;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal() {
		this.total = kor + eng + sci + math;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg() {
		this.avg = total / 4.0;
	}

	
	
}
