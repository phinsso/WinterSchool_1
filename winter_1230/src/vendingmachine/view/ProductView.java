package vendingmachine.view;

import java.util.ArrayList;
import java.util.Scanner;

import vendingmachine.vo.ProductVO;

public class ProductView {

	ArrayList<ProductVO> pvoList;
	Scanner sc = new Scanner(System.in);

	public void displayProducts() {

		System.out.println("========== Drink Vending Machine ==========");

		for (ProductVO pvo : pvoList) {
			System.out.println((pvo.getProductNum() + 1) + ": " + pvo.getName() + "[가격: " + pvo.getPrice() + " 재고량: "
					+ pvo.getStockNum() + "]");
		}
		
		System.out.println("=============================\n");

	}

	public void inputPurchase() {
		System.out.println("---------- Purchase Drink ----------");
		System.out.print("구매하실 제품의 번호를 입력하세요: ");
		int productNum = sc.nextInt();
		do {
			System.out.print("다시 입력해주세요: ");
			productNum = sc.nextInt();
		} while(productNum < 0 || productNum > 10);
		
		ProductVO pvo = pvoList.get(productNum - 1);

		if(pvo.getStockNum() > 0) {
			System.out.print(pvo.getName() + "제품의 가격은 " + pvo.getPrice() + "원 돈을 투입: ");
			int price = sc.nextInt();
			
			
			if(price >= pvo.getPrice()) {
				System.out.println(pvo.getName() + "제품이 나왔습니다.");
				System.out.println("거스름돈: " + (price - pvo.getPrice()) + "원");
				pvo.setStockNum(pvo.getStockNum()-1);
				System.out.println();
			} else {
				System.out.println("투입하신 돈이 부족하여 구매가 불가합니다.");
				System.out.println();
			}
		} else {
			System.out.println("선택하신 제품은 재고가 없습니다.");
		}
	}
	
	public Scanner getSc() {
		return sc;
	}
	
	public void setProductList(ArrayList<ProductVO> pvoList) {
		this.pvoList = pvoList;
	}

}
