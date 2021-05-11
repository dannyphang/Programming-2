package entity;

import java.util.*;

import template.Product;
import util.Utility;

public class Cart {
	// Declaration
	private List<CartItem> cartItemList;
	private List<CartItemHistory> ciHistory = new ArrayList<CartItemHistory>();
	private static int listingLimit = 5;

	public Cart() {
		cartItemList = new ArrayList<CartItem>();
	}

	public Cart(List<CartItem> ciList) {
		this.cartItemList = new ArrayList<CartItem>();
		for (CartItem ci : ciList) {
			cartItemList.add(new CartItem(ci));
		}
	}

	public List<CartItem> getCartItemList() {
		return new ArrayList<CartItem>(cartItemList);
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		cartItemList = new ArrayList<CartItem>(cartItemList);
	}

	public List<CartItemHistory> getCiHistory() {
		return new ArrayList<CartItemHistory>(ciHistory);
	}

	public void setCiHistory(List<CartItemHistory> ciHistory) {
		this.ciHistory = new ArrayList<CartItemHistory>(ciHistory);
	}

	public static int getListingLimit() {
		return listingLimit;
	}

	public static void setListingLimit(int listingLimit) {
		Cart.listingLimit = listingLimit;
	}

	public void clearCart() {
		cartItemList.clear();
	}

	public double getTotal() {
		double total = 0;
		for (CartItem ci : cartItemList)
			total += ci.getSubtotal();
		return total;
	}

	public void addToCartItemList(CartItem cartItem) {
		boolean cartItemExist = false;
		for (CartItem ci : cartItemList) {
			if (ci.getProduct().equals(cartItem.getProduct())) {
				ci.setQuantity(ci.getQuantity() + cartItem.getQuantity());
				ci.setAddDate(cartItem.getAddDate());
				cartItemExist = true;
			}
		}
		if (!cartItemExist) {
			cartItemList.add(cartItem);
			if (cartItem.getAddDate().compareTo(new Date()) == 0)
				ciHistory
						.add(new CartItemHistory("Added", new CartItem(cartItem.getProduct(), cartItem.getQuantity()))); // alternative
																															// copy
																															// constructor
		}
	}

	public void updateCartItem(CartItem cartItem, int index) throws IndexOutOfBoundsException {
		try {
			cartItemList.set(index, cartItem);
			ciHistory.add(new CartItemHistory("Edited", new CartItem(cartItem.getProduct(), cartItem.getQuantity()))); // alternative
																														// copy
																														// constructor
		} catch (IndexOutOfBoundsException ex) {
			throw ex;
		}
	}

	public void removeCartItem(int index) throws IndexOutOfBoundsException {
		try {
			ciHistory.add(new CartItemHistory("Removed",
					new CartItem(cartItemList.get(index).getProduct(), cartItemList.get(index).getQuantity()))); // alternative
																													// copy
																													// constructor
			cartItemList.remove(index);
		} catch (IndexOutOfBoundsException ex) {
			throw ex;
		}
	}

        public List<CartItem> getCartItemList(int page) {
		if (cartItemList.isEmpty())
			return null;

		List<CartItem> result = new ArrayList<CartItem>();
		// if next page is empty, start from previous page page
		int startIndex = (page - 1) * listingLimit >= cartItemList.size() ? (page - 2) * listingLimit
				: (page - 1) * listingLimit < 0 ? 0 : (page - 1) * listingLimit;
		// if endIndex is more than power supply list, the power supply last index will
		// be the end index
		int endIndex = startIndex + listingLimit - 1 > cartItemList.size() - 1 ? cartItemList.size() - 1
				: startIndex + listingLimit - 1;
		for (; startIndex <= endIndex; startIndex++) {

			result.add(cartItemList.get(startIndex));
		}

		return result;
	}
                
	// heading without subtotal
	public static String heading2() {
		return "Check Out Session\n\n" + Product.heading2()
				+ String.format("%-12s %-3s %11s\n", "Added Date", "Quantity", "Subtotal(RM)")
				+ Utility.repeat(112, "=");
	}

	// heading with subtotal
	public static String heading1(List<CartItem> ciList, int page) {
		return "Page " + page + " /" + String.format("%2.0f", Math.ceil((double) ciList.size() / listingLimit)) + "\n\n"
				+ Product.heading2() + String.format("%-12s %-8s\n", "Added Date", "Quantity")
				+ Utility.repeat(99, "=");
	}
}