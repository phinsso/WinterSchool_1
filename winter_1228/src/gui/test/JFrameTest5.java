package gui.test;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// 독립된 액션리스너 클래스를 사용
public class JFrameTest5 extends JFrame {

	ImageIcon icon = new ImageIcon("images/frog.png");
	JLabel label = new JLabel(icon, JLabel.CENTER);
	JButton Button1 = new JButton("LUCY");
	JButton Button2 = new JButton("New Jeans");
	JButton Button3 = new JButton("DAY6");
	
	public JFrameTest5() {
		
		add(label);
		
		JPanel panel = new JPanel();
		
		ButtonListener btnListener = new ButtonListener(Button1, Button2, label); //BtnListener의 객체 생성
		Button1.addActionListener(btnListener);
		Button2.addActionListener(btnListener);
		Button3.addActionListener(btnListener);
		panel.add(Button1);
		panel.add(Button2);
		panel.add(Button3);
		add(panel, "North");
		
		setTitle("JFrame 상속 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200, 200);
		setSize(500, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JFrameTest5();
	}
	
}
