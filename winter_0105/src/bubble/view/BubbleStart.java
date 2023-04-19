package bubble.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BubbleStart extends JFrame {
	
	public static final int FRAME_WIDTH = 700;
	public static final int FRAME_HEIGHT = 600;
	
	public BubbleStart() {
		JButton btnStart = new JButton("게임시작");
		add(btnStart);
		btnStart.setBounds(270, 250, 150, 50);
		btnStart.addActionListener(btnL);
		setLayout(null);
		setTitle("버블티 만들기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(10, 10, FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
	}
	
	ActionListener btnL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			new BubbleView();			
		}
	};
}
