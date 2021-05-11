import java.util.*;

public class Cart {
	// Declaration
	private List<CartItem> cartItemList;
	private static int listingLimit = 5;

	public Cart() {
		cartItemList = new ArrayList<CartItem>();
	}

	public List<CartItem> getCartItemList() {
		return new ArrayList<CartItem>(cartItemList);
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = new ArrayList<CartItem>(cartItemList);
	}

	public void addToCartItemList(CartItem cartItem) {
		cartItemList.add(cartItem);
	}

	public static String printHeadings() {
		return String.format("%-12s %-10s %-23s", "Product ID", "Brand", "Product Name")
				+ String.format(" %15s %18s", "Quantity", "Added Date") + String.format(" %-12s", "Price (RM)");
	}

	public List<CartItem> displayCart(int page) {
		if (cartItemList.isEmpty())
			return null;

		List<CartItem> result = new ArrayList<CartItem>();
		// if next page is empty, start from previous page page
		int startIndex = (page - 1) * listingLimit >= cartItemList.size() ? (page - 2) * listingLimit
				: (page - 1) * listingLimit < 0 ? 0 : (page - 1) * listingLimit;
		System.out.println("test 1" + startIndex);
		// if endIndex is more than power supply list, the power supply last index will
		// be the end index
		int endIndex = startIndex + listingLimit - 1 > cartItemList.size() - 1 ? cartItemList.size() - 1
				: startIndex + listingLimit - 1;

		for (; startIndex <= endIndex; startIndex++) {
			result.add(cartItemList.get(startIndex));
		}

		return result;
	}

	public double getTotal() {
		double total = 0;
		for (CartItem ci : cartItemList)
			total += ci.getSubtotal();

		return total;
	}
}