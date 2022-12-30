package gui.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ButtonListener implements ActionListener {

	JButton Button1, Button2;
	JLabel label;
	
	
	public ButtonListener(JButton Button1, JButton Button2, JLabel label) {
		this.Button1 = Button1;
		this.Button2 = Button2;
		this.label = label;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		ImageIcon icon = null;
		
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

}
