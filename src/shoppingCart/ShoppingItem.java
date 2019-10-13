package shoppingCart;

public class ShoppingItem {

	String itemId;
	String itemName;
	double itemPrice;

	public ShoppingItem() {
		itemId = "";
		itemName = "";
		itemPrice = 0.0;
	}

	public ShoppingItem(String id, String name, double price) {
		setItemId(id);
		setItemName(name);
		setItemPrice(price);
	}

	String getItemId() {
		return itemId;
	}

	void setItemId(String id) {
		itemId = id;
	}

	String getItemName() {
		return itemName;
	}

	void setItemName(String name) {

		itemName = name;
	}

	double getItemPrice() {
		return itemPrice;
	}

	void setItemPrice(double price) {
		itemPrice = price;
	}

}
