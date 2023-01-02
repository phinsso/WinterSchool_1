package vendingmachine.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import vendingmachine.vo.ProductVO;

public class ProductView {

	ArrayList<ProductVO> pvoList;
	ArrayList<JLabel> lblList = new ArrayList<JLabel>();
	
	public JPanel displayProducts() {
		JPanel panC = new JPanel(new GridLayout(3,3));
		for (ProductVO pvo : pvoList) {
			ImageIcon icon = new ImageIcon("image/" + pvo.getImageName() + ".jpg");
			JLabel lbl = new JLabel(icon);
			lblList.add(lbl);
			panC.add(lbl);
		}
		return panC;
	}

	public void inputPurchase() {
		
	}
	
	
	public void setProductList(ArrayList<ProductVO> pvoList) {
		this.pvoList = pvoList;
	}

}
