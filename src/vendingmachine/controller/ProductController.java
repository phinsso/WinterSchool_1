package vendingmachine.controller;

import java.util.ArrayList;
import java.util.Scanner;

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
		JPanel panC = view.displayProducts();
		add(panC, "Center");
		
		setTitle("음료 자판기");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 50, 600, 600); //setLocation + setSize
		setVisible(true);
	}
	
	//제품 채우기
	public void fullProduct() {
		ProductDAO dao = new ProductDAO();
		String[] names = {"사이다", "콜라", "백포도웰치스", "적포도웰치스", "제로콜라", "초록매실", "오렌지쥬스", "모구모구", "박카스"};
		String[] images = {"cider", "cola", "welchs_white", "welchs_grape", "zerocola", "choroc", "orange", "mogumogu", "f"};
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
