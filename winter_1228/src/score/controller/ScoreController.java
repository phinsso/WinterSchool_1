package score.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import score.view.ScoreView;
import score.vo.ScoreDAO;
import score.vo.ScoreVO;

public class ScoreController extends JFrame{

	ScoreDAO dao;
	ArrayList<ScoreVO> svoList;
	ScoreView view;
	JTable table;
	
	public ScoreController() {
		dao = new ScoreDAO();
		view = new ScoreView();
		svoList = dao.select();
		view.setScoreVOList(svoList);
		view.initView();
		JButton btnAdd = view.getBtnAdd();
		btnAdd.addActionListener(btnAddL);
		table = view.getTable();
		table.addMouseListener(tableL);
		add(view, "Center");
		
		setTitle("성적처리프로그램");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200, 200);
		setSize(600, 500);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new ScoreController();

	}
	
ActionListener btnAddL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//panS에 있는 JTextField에 입력된 값들과 JComboBox의 값을 BookVO에 필드값들을 초기화하여 BookVO 객체 참조값을 반환하는 메소드
			ScoreVO vo = view.neededInsertData();
			dao.insert(vo);
			svoList = dao.select();
			view.setScoreVOList(svoList);
			view.putResult();
			view.initInsertData();			
		}
	};
	
	MouseAdapter tableL = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int state = 1;
			if(e.getClickCount() == 2) {
				state = JOptionPane.showConfirmDialog(ScoreController.this, "정말 삭제하시겠습니까?", "삭제여부", JOptionPane.YES_NO_OPTION);
				if(state == JOptionPane.YES_OPTION) {
					dao.delete(table.getSelectedRow());
					svoList = dao.select();
					view.setScoreVOList(svoList);
					view.putResult();
				}
			}
		}
	};

}
