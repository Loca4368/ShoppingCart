package shoppingCart;

import java.util.ArrayList;
import java.util.List;

//Price Discount for over 4 Bridge Climb Ticket
public class BuyMoreThan4BCDiscount implements PromotionRule {

	public List<ShoppingItem> checkPromotion(List<ShoppingItem> shoppingList) {

		List<ShoppingItem> promoList = new ArrayList<ShoppingItem>();

		int countBC = 0;

		for (ShoppingItem sItem : shoppingList) {
			if (sItem.getItemId() == "BC") {
				countBC += 1;

			}
		}
		if (countBC > 4) {
			promoList.add(new ShoppingItem("B4BC",
					"Buy More than 4 Bridge Climb", -countBC * 20));

		}

		return promoList;
	}
}
