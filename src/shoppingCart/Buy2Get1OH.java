package shoppingCart;

import java.util.List;
import java.util.ArrayList;

//3 for 2 deal on Opera House Ticket
public class Buy2Get1OH implements PromotionRule {

	public List<ShoppingItem> checkPromotion(List<ShoppingItem> shoppingList) {

		List<ShoppingItem> promoList = new ArrayList<ShoppingItem>();

		int countOH = 0;

		for (ShoppingItem sItem : shoppingList) {
			if (sItem.getItemId() == "OH") {
				countOH += 1;
				if (countOH == 3) {
					countOH = 0;
					promoList.add(new ShoppingItem("B2G1OH",
							"Buy2 Get1 Free for Opera House", -300.0));
				}
			}
		}

		return promoList;
	}
}
