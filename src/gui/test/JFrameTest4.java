package gui.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Anonymous(익명) 클래스로 액션리스너 구현
public class JFrameTest4 extends JFrame {

	ImageIcon icon = new ImageIcon("images/frog.png");
	JLabel label = new JLabel(icon, JLabel.CENTER);
	JButton Button1 = new JButton("LUCY");
	JButton Button2 = new JButton("New Jeans");
	JButton Button3 = new JButton("DAY6");
	
	public JFrameTest4() {
		
		add(label);
		
		JPanel panel = new JPanel();

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
		new JFrameTest4();
	}
	
	ActionListener btnListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object btnSource = e.getSource();
			if(btnSource == Button1) {
				icon = new ImageIcon("images/LUCY.jpg");
			} else if(btnSource == Button2) {
				icon = new ImageIcon("images/NewJeans.jpg");
			} else {
				icon = new ImageIcon("images/DAY6.jpg");
			}
			
			label.setIcon(icon);
			
		}
	};
}
