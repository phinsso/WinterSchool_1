package score.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import score.vo.ScoreVO;

public class ScoreView extends JPanel{

	JTable table;
	DefaultTableModel model;
	ArrayList<ScoreVO> ScoreVOList;
	
	String[] header = {"학번", "성명", "학년", "반", "국어", "영어", "수학", "과학", "총점", "평균"};
	JPanel panS;
	JLabel[] lbls = new JLabel[header.length - 2];
	JTextField[] tf = new JTextField[header.length - 2];
	JButton btnAdd = new JButton("학생추가");
	
	public ScoreView() {
		setLayout(new BorderLayout()); //배치관리자를 Flow에서 Border로 변경
		
		panS = new JPanel();
		panS = new JPanel(new GridLayout(5, 4));
		
		for(int i = 0; i < tf.length; i++) {
			lbls[i] = new JLabel(header[i]);
			panS.add(lbls[i]);
			
				tf[i] = new JTextField();
				panS.add(tf[i]);
		}
		
		for(int i = 0; i < 3; i++) {
			panS.add(new JLabel(""));
		}
		panS.add(btnAdd);
		
	}
	
	public void initView() {
		model = new DefaultTableModel(header, ScoreVOList.size()) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; //편집 불가능하도록
			}
		};
		
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(50);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.getColumnModel().getColumn(9).setPreferredWidth(100);
		
		JScrollPane scroll = new JScrollPane(table);
		
		putResult();
		
		add("Center", scroll);
		add("South", panS);
	}
	
	public void putResult() { //셀 값 설정
		model.setRowCount(ScoreVOList.size());
		ScoreVO vo = null;
		
		for(int i = 0; i < ScoreVOList.size(); i++) {
			vo = ScoreVOList.get(i);
			
			//i: 행번호   0: 열번호
			model.setValueAt(vo.getStuId(), i, 0);
			model.setValueAt(vo.getName(), i, 1);
			model.setValueAt(vo.getGrade(), i, 2);
			model.setValueAt(vo.getClassroom(), i, 3);
			model.setValueAt(vo.getKor(), i, 4);
			model.setValueAt(vo.getEng(), i, 5);
			model.setValueAt(vo.getMath(), i, 6);
			model.setValueAt(vo.getSci(), i, 7);
			model.setValueAt(vo.getTotal(), i, 8);
			model.setValueAt(vo.getAvg(), i, 9);
		}
	}
	
	public void setScoreVOList(ArrayList<ScoreVO> ScoreVOList) {
		this.ScoreVOList = ScoreVOList;
	}
	
	public JButton getBtnAdd() {
		return btnAdd;
	}
	
	public ScoreVO neededInsertData() {
		ScoreVO vo = new ScoreVO();
		vo.setStuId(Integer.parseInt(tf[0].getText()));
		vo.setName(tf[1].getText());
		vo.setGrade(Integer.parseInt(tf[2].getText()));
		vo.setClassroom(Integer.parseInt(tf[3].getText()));
		vo.setKor(Integer.parseInt(tf[4].getText()));
		vo.setEng(Integer.parseInt(tf[5].getText()));
		vo.setMath(Integer.parseInt(tf[6].getText()));
		vo.setSci(Integer.parseInt(tf[7].getText()));
		vo.setTotal();
		vo.setAvg();
		return vo;
	}
	
	public void initInsertData() { //초기화
		for(int i = 0; i < tf.length; i++) {
			tf[i].setText("");
		}
	}
	
	public JTable getTable() {
		return table;
	}
}
