package score.vo;

import java.util.ArrayList;

public class ScoreDAO {

	ArrayList<ScoreVO> svoList = new ArrayList<ScoreVO>();
	
	public void insert(ScoreVO svo) {
		svoList.add(svo);
	}
	
	//select(): ArrayList 참조값 반환
	public ArrayList<ScoreVO> select() {
		return svoList;
	}
	
	public void delete(int row) {
		svoList.remove(row);
	}
}
