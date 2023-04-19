package vendingmachine.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vendingmachine.vo.ProductVO;

public class ProductView {

	ArrayList<ProductVO> pvoList;
	ArrayList<JLabel> lblList = new ArrayList<JLabel>();
	JTextField insertTf = new JTextField(10);
	JLabel lblResult = new JLabel("제품이 나올 부분");
	JFrame frame;
	ProductVO pvo;
	JLabel eLbl;
	
	public JPanel displayProducts(JFrame frame) {
		this.frame = frame;
		JPanel panC = new JPanel(new GridLayout(3,3));
		for (ProductVO pvo : pvoList) {
			ImageIcon icon = new ImageIcon("image/" + pvo.getImageName() + ".jpg");
			JLabel lbl = new JLabel();
			lbl.setIcon(icon);
			lbl.setText(Integer.toString(pvo.getPrice()) + "원");
			lbl.setHorizontalTextPosition(JLabel.CENTER);
			lbl.setVerticalTextPosition(JLabel.BOTTOM);
			lbl.setHorizontalAlignment(JLabel.CENTER);
			
			lbl.addMouseListener(lblL);
			lbl.setOpaque(true); //라벨 불투명하게 설정
			lbl.setBackground(Color.WHITE);
			lblList.add(lbl);
			panC.add(lbl);
		}
		return panC;
	}

	public JPanel inputPurchase() {
		JPanel panS = new JPanel();
		JLabel lblMoney = new JLabel("금액: ");
		JButton btnInsert = new JButton("투입");
		btnInsert.addActionListener(btnL);
		panS.add(lblMoney); panS.add(insertTf); panS.add(btnInsert);
		panS.add(lblResult);
		return panS;
	}
	
	
	public void setProductList(ArrayList<ProductVO> pvoList) {
		this.pvoList = pvoList;
	}
	
	MouseAdapter lblL = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			
			eLbl = (JLabel)e.getSource();
			
			for(int i = 0; i < lblList.size(); i++) {
				if(e.getSource() == lblList.get(i)) {
					lblList.get(i).setBackground(Color.BLUE);
					pvo = pvoList.get(i);
				}
			}
			JOptionPane.showMessageDialog(frame, "제품명: " + pvo.getName() + ", 제품가격: " + pvo.getPrice() + "원" );

		}
	};
	
	ActionListener btnL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int money = (Integer.parseInt(insertTf.getText()));
			if(money >= pvo.getPrice()) {
				lblResult.setText("");
				lblResult.setIcon(new ImageIcon("image/" + pvo.getImageName() + ".jpg"));
				JOptionPane.showMessageDialog(frame,  "거스름돈은 " + (money - pvo.getPrice()) + "원");
			} else {
				JOptionPane.showMessageDialog(frame, "투입금액이 부족하여 구매가 불가합니다.");
			}
			
			eLbl.setBackground(Color.WHITE);
			insertTf.setText(null);
			lblResult.setIcon(null);
		}
	};

}
