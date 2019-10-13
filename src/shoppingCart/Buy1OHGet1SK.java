package shoppingCart;

import java.util.ArrayList;
import java.util.List;

//Free Sky Tower for every Opera House tour Sold 
public class Buy1OHGet1SK implements PromotionRule {

	public List<ShoppingItem> checkPromotion(List<ShoppingItem> shoppingList) {

		List<ShoppingItem> promoList = new ArrayList<ShoppingItem>();

		int countOH = 0;
		int countSK = 0;

		for (ShoppingItem sItem : shoppingList) {
			if (sItem.getItemId() == "OH") {
				countOH += 1;
			}
			if (sItem.getItemId() == "SK") {
				countSK += 1;
			}
		}

		if (countOH != 0 && countSK != 0) {
			if (countOH >= countSK)
				promoList.add(new ShoppingItem("B2G1OH",
						"Buy2 Get1 Free for Opera House", countSK * -30.0));
			else
				promoList.add(new ShoppingItem("B2G1OH",
						"Buy2 Get1 Free for Opera House", countOH * -30.0));
		}

		return promoList;
	}
}
