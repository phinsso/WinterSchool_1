package vendingmachine.vo;

import java.util.ArrayList;

public class ProductDAO {

	ArrayList<ProductVO> pvoList = new ArrayList<ProductVO>();
	
	public void insert(ProductVO pvo) {
		pvoList.add(pvo);
	}
	
	public ArrayList<ProductVO> select() {
		return pvoList;
	}
}
