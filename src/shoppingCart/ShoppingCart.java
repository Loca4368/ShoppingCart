package shoppingCart;

import java.util.ArrayList;
import java.util.List;

/*
 * ShoppingCart System for Sydney Tour
 * 
 * Created by: Ming
 */

public class ShoppingCart {

	public static void main(String[] args) {

		List<PromotionRule> promoRules = new ArrayList<PromotionRule>();
		promoRules.add(new Buy2Get1OH());
		promoRules.add(new Buy1OHGet1SK());
		promoRules.add(new BuyMoreThan4BCDiscount());
		ShoppingCart sp = new ShoppingCart(promoRules);
		ShoppingItem tour1 = new ShoppingItem("OH", "Opera house tour", 300.0);
		ShoppingItem tour2 = new ShoppingItem("BC", "Sydney Bridge Climb",
				110.0);
		ShoppingItem tour3 = new ShoppingItem("SK", "Sydney Sky Tower", 30.0);

		// Sample One:
		// sp.add(tour1);
		// sp.add(tour1);
		// sp.add(tour1);
		// sp.add(tour2);
		//

		// Sample Two:
		// sp.add(tour1);
		// sp.add(tour3);

		// Sample Three:
		sp.add(tour2);
		sp.add(tour2);
		sp.add(tour2);
		sp.add(tour2);
		sp.add(tour2);
		sp.add(tour1);

		System.out.println("Total price: " + sp.total());

	}

	List<ShoppingItem> userShoppingList;
	List<ShoppingItem> promotionItemsList;

	List<PromotionRule> promotionRules;

	public ShoppingCart(List<PromotionRule> promoRules) {

		userShoppingList = new ArrayList<ShoppingItem>();
		promotionItemsList = new ArrayList<ShoppingItem>();

		promotionRules = promoRules;
	}

	public void add(ShoppingItem item) {
		userShoppingList.add(item);
	}

	private void recalculatePromotion() {
		promotionItemsList.clear();
		for (PromotionRule prRule : promotionRules) {
			promotionItemsList.addAll(prRule.checkPromotion(userShoppingList));
		}

	}

	public double total() {
		recalculatePromotion();

		double purchasePrice = 0, promotionAdjustment = 0, totalPrice = 0;

		// calculate total price before promotion adjustment
		for (ShoppingItem sItem : userShoppingList) {
			purchasePrice += sItem.getItemPrice();
		}

		// calculate promotion adjustments
		for (ShoppingItem sItem : promotionItemsList) {
			promotionAdjustment += sItem.getItemPrice();
		}

		totalPrice = purchasePrice + promotionAdjustment;

		return totalPrice;

	}
}
