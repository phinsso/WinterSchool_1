package gui.test;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFrameTest1 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JLabel label = new JLabel("", JLabel.CENTER);
		ImageIcon icon = new ImageIcon("images/frog.png");
		label.setIcon(icon);
		frame.add(label);
		
		frame.setTitle("JFrame 연습 1");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(200, 200);
		frame.setSize(500, 300);
		frame.setVisible(true);
	}

}
