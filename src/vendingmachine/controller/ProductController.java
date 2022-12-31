package vendingmachine.controller;

import java.util.ArrayList;
import java.util.Scanner;

import vendingmachine.view.ProductView;
import vendingmachine.vo.ProductDAO;
import vendingmachine.vo.ProductVO;

public class ProductController {

	public static final int STOP = 0;
	
	
	public static void main(String[] args) {
		
		ProductDAO dao = new ProductDAO();
		String[] names = {"사이다", "콜라", "백포도웰치스", "적포도웰치스", "제로콜라", "초록매실", "오렌지쥬스", "비락식혜", "비타500"}; 
		int[] prices = {800, 900, 1100, 1100, 1500, 1600, 2000, 1000, 700};
		ProductVO pvo = null;
		ArrayList<ProductVO> pvoList = dao.select();
		
		for (int i = 0; i < names.length; i++) {
			pvo = new ProductVO();
			pvo.setName(names[i]);
			pvo.setPrice(prices[i]);
			pvo.setProductNum(i);
			pvo.setStockNum(10);
			pvoList.add(pvo);
		}
		
		ProductView view = new ProductView();
		view.setProductList(pvoList);
		view.displayProducts();
//		자판기 제품 구매 화면
		Scanner sc = view.getSc();
		
		while(true) {
			view.inputPurchase();
			System.out.print("!!제품을 계속 구매하시겠습니까?(Continue:1, Stop:0) : ");
			int state = sc.nextInt();
			System.out.println();
			if(state == STOP)
				break;
			view.displayProducts();
		}
		
		sc.close();

	}

}
