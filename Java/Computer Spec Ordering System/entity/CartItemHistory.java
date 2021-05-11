package entity;

public class CartItemHistory {
	private String action;
	private CartItem ci;

	public CartItemHistory(String action, CartItem ci) {
		this.action = action;
		this.ci = ci;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public CartItem getCi() {
		return ci;
	}

	public void setCi(CartItem ci) {
		this.ci = ci;
	}
}
