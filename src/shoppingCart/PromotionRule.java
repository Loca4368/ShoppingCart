package shoppingCart;

import java.util.List;

//Interface for Promotional Rule
public interface PromotionRule {

	List<ShoppingItem> checkPromotion(List<ShoppingItem> shoppingList);
}
