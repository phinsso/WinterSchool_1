package vendingmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import vendingmachine.view.ProductView;
import vendingmachine.vo.ProductDAO;
import vendingmachine.vo.ProductVO;

public class ProductController extends JFrame {

	public static final int STOP = 0;
	ArrayList<ProductVO> pvoList;
	
	public ProductController() {
		
		//JFrame 배경색 변경
		
		ProductView view = new ProductView();
		fullProduct();
		view.setProductList(pvoList);
		JPanel panC = view.displayProducts(this);
		JPanel panS = view.inputPurchase();
		add(panC, "Center");
		add(panS, "South");
		
		setTitle("음료 자판기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 20, 600, 750); //setLocation + setSize
		setVisible(true);
	}
	
	//제품 채우기
	public void fullProduct() {
		ProductDAO dao = new ProductDAO();
		String[] names = {"사이다", "콜라", "초코우유", "적포도웰치스", "토레타", "초록매실", "오렌지쥬스", "모구모구", "박카스"};
		String[] images = {"cider", "cola", "chocomilk", "welchs_grape", "toleta", "choroc", "orange", "mogumogu", "f"};
		int[] prices = {1200, 1200, 1000, 1000, 1400, 700, 800, 1500, 900};
		ProductVO pvo = null;
		pvoList = dao.select();
		
		for (int i = 0; i < names.length; i++) {
			pvo = new ProductVO();
			pvo.setName(names[i]);
			pvo.setPrice(prices[i]);
			pvo.setImageName(images[i]);
			pvo.setProductNum(i);
			pvo.setStockNum(10);
			pvoList.add(pvo);
		}
	}
	
	public static void main(String[] args) {
		new ProductController();
	}

}
