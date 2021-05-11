import java.text.*;
import java.util.*;

import entity.*;
import util.*;
import template.*;
import factory.ReportFactory;

public class AssignmentNoGUI {
	static Scanner in = new Scanner(System.in);

	final static String[] mainMenu = { "[1] Login", "[2] Register", "[E] Exit" };
	final static String[] userMenu = { "[1] Account Information", "[2] Browse Product", "[3] Shopping Cart",
			"[4] View Reports", "[L] Logout" };
	final static String[] cartMenu = { "[1] Add Product", "[2] Edit Product", "[3] Checkout", "[4] Discount Info",
			"[B] Back" };
	final static String[] editProductMenu = { "[1] Edit Quantity", "[2] Remove Product", "[B] Back" };
	final static String[] accountInfoMenu = { "[1] Edit Name", "[2] Edit Address", "[3] Edit Email",
			"[4] Add Credit/Debit Card", "[5] Remove Credit/Debit Card", "[B] Back" };
	final static String[] viewReportMenu = { "[1] Generate Discount Report", "[2] Generate Order Report", "",
			"[4] Generate Cart Item Report", "[E] Exit" };
	final static String[] productCategoryMenu = { "[1] Processor", "[2] Graphic Card", "[3] RAM", "[4] Storage",
			"[5] Power Supply", "[6] Warranty Info", "[B] Back" };
	final static String[] reportTypeMenu = { "[1] Discount History Report", "[2] Order History Report",
			"[3] Cart Item History", "[B] Back" };
	final static String[] reportDetailMenu = { "[1] Last Week", "[2] Last Month", "[3] Last Year", "[4] Overall",
			"[B] Back" };
	final static String inputQuestion = "Please enter a selection: ";
	final static String idlingMsg = "Press enter to continue...";
	final static String invalidInputMsg = "Invalid input, please try again.";
	final static String updateSuccessMsg = "Congratulations, successfully updated.";
	final static String invalidEmailMsg = "We're sorry, this is an invalid email";

	// Constant for shoppingCart();
	final static String emptyCartMsg = "Uh oh, seems like your cart is currently empty.";

	// Constant for browseProduct();
	static String prevPageMes = "\nEnter 'b' to return to previous menu";
	static String defPromptMes = prevPageMes + "\nEnter 'n' to next page\nEnter 'p' to previous page\n";
	static String firstPageMes = "\nYou're in the first page!\n";
	static String lastPageMes = "\nYou've reached the last page!\n";

	public static void main(String[] args) {
		boolean isExit = false, isLoggedout = true;
		Calendar calendar = Calendar.getInstance();
		String input, errorMessage = "";
		Customer.register(new Customer("john123", "John", "", "test@test.com"));
		ReportFactory reportFactory = new ReportFactory();
		List<CartItemHistory> test;
		// Operation
		Customer currentUser = Customer.getCustomer(0);// get customer entity

		// dummy data for report generation -- 2 order and 4 cartitem for each order
		calendar.add(Calendar.YEAR, -2);
		currentUser.getCart().addToCartItemList(new CartItem(GraphicCard.getProduct("GC1"), 1, calendar.getTime()));
		test = currentUser.getCart().getCiHistory();
		test.add(new CartItemHistory("Added", new CartItem(GraphicCard.getProduct("GC1"), 1, calendar.getTime())));
		currentUser.getCart().addToCartItemList(new CartItem(RAM.getProduct("RA1"), 1, calendar.getTime()));
		test.add(new CartItemHistory("Added", new CartItem(RAM.getProduct("RA1"), 1, calendar.getTime())));
		currentUser.checkout(9999, new Payment(currentUser.getPaymentOption(0), 8888), new Discount(10, 5),
				calendar.getTime());
		calendar.add(Calendar.YEAR, 2);
		calendar.add(Calendar.MONTH, -10);
		currentUser.getCart().addToCartItemList(new CartItem(PowerSupply.getProduct("PS1"), 1, calendar.getTime()));
		test.add(new CartItemHistory("Added", new CartItem(PowerSupply.getProduct("PS1"), 1, calendar.getTime())));
		currentUser.getCart().addToCartItemList(new CartItem(Storage.getProduct("ST1"), 1, calendar.getTime()));
		test.add(new CartItemHistory("Added", new CartItem(Storage.getProduct("ST1"), 1, calendar.getTime())));
		currentUser.checkout(9999, new Payment(currentUser.getPaymentOption(0), 8888), new Discount(10, 5),
				calendar.getTime());
		calendar.add(Calendar.MONTH, 10);

		calendar.add(Calendar.DATE, -14);
		currentUser.getCart().addToCartItemList(new CartItem(GraphicCard.getProduct("GC2"), 1, calendar.getTime()));
		test.add(new CartItemHistory("Added", new CartItem(GraphicCard.getProduct("GC2"), 1, calendar.getTime())));
		currentUser.getCart().addToCartItemList(new CartItem(RAM.getProduct("RA2"), 1, calendar.getTime()));
		test.add(new CartItemHistory("Added", new CartItem(RAM.getProduct("RA2"), 1, calendar.getTime())));
		currentUser.checkout(9999, new Payment(currentUser.getPaymentOption(0), 8888), new Discount(10, 3),
				calendar.getTime());
		calendar.add(Calendar.DATE, 14);
		calendar.add(Calendar.DATE, -3);
		currentUser.getCart().addToCartItemList(new CartItem(PowerSupply.getProduct("PS2"), 1, calendar.getTime()));
		test.add(new CartItemHistory("Added", new CartItem(PowerSupply.getProduct("PS2"), 1, calendar.getTime())));
		currentUser.getCart().addToCartItemList(new CartItem(Storage.getProduct("ST2"), 1, calendar.getTime()));
		test.add(new CartItemHistory("Added", new CartItem(Storage.getProduct("ST2"), 1, calendar.getTime())));
		currentUser.checkout(9999, new Payment(currentUser.getPaymentOption(0), 8888), new Discount(10, 3),
				calendar.getTime());
		calendar.add(Calendar.DATE, 3);

		currentUser.getCart().setCiHistory(test);
		
		do {
			printLogo();
			Utility.formatMenu(mainMenu);

			if (!errorMessage.isEmpty())
				System.out.println(errorMessage + "\n");

			errorMessage = "";

			System.out.print(inputQuestion);
			input = in.nextLine().toLowerCase();

			switch (input) {
			case "1":
			case "2":
				errorMessage = "";

				currentUser = input.equals("1") ? loginMenu() : registerMenu();
				// If they didnt revoke the register or login process
				if (currentUser != null) {
					isLoggedout = false;

					do {
						printLogo();
						System.out.println("Hi there, " + currentUser.getName() + ".");
						Utility.formatMenu(userMenu);

						if (!errorMessage.isEmpty())
							System.out.println(errorMessage + "\n");

						errorMessage = "";

						System.out.print(inputQuestion);
						input = in.nextLine().toLowerCase();

						switch (input) {
						case "1":
							accountInformation(currentUser);
							break;
						case "2":
							browseProduct(currentUser);
							break;
						case "3":
							shoppingCart(currentUser); // let them add, or remove product or checkout.
							break;
						case "4":
							viewReport(reportFactory, currentUser);
							break;
						case "l":
							System.out.println("Customer Logged Out.\n\n" + idlingMsg);
							in.nextLine();
							isLoggedout = true;
							break;
						default:
							errorMessage = invalidInputMsg;
						}
					} while (!isLoggedout);
				}
				break;

			case "e":
				System.out.println("Happy Shopping, see you again!\n\n" + idlingMsg);
				in.nextLine();
				isExit = true;
				break;
			default:
				errorMessage = invalidInputMsg;
			}
		} while (!isExit);
		in.close();
	}

	public static Customer registerMenu() {
		String[] question = { "Pick a username. ", "What's your name? ", "Where do you stay? ", "What's your email? " };
		String[] errorMessage = { "Uh oh, username was taken.", "", "", invalidEmailMsg };
		String[] answer = new String[4];
		boolean validInput;

		for (int i = 0; i < question.length; i++) {
			validInput = true;
			do {
				printLogo();

				if (!validInput)
					System.out.println(errorMessage[i]);
				System.out.println(prevPageMes);

				System.out.print(question[i]);

				answer[i] = in.nextLine();

				if (answer[i].equals("b") || answer[i].equals("B"))
					return null;

				switch (i) {
				case 0:
					validInput = !Customer.checkUsernameExist(answer[i].toLowerCase());
					break;
				case 3:
					validInput = Input_Validator.validateEmail(answer[i]);
					break;
				}
			} while (!validInput);
		}

		Customer newUser = new Customer(answer[0].toLowerCase(), answer[1], answer[2], answer[3]);
		Customer.register(newUser);

		return newUser;
	}

	public static Customer loginMenu() {
		String errorMessage = "", username;
		int index;

		for (int i = 1; i <= 3; i++) {
			printLogo();

			if (!errorMessage.isEmpty())
				System.out.println(errorMessage + "\n");

			errorMessage = "";

			System.out.print("Please enter a username: ");
			username = in.nextLine();
			index = Customer.login(username);
			if (index != -1)
				return Customer.getCustomer(index);
			else
				errorMessage = "User not found, please try again.";
		}
		System.out.println("Three attempts failed, back to main menu...");
		idle();

		return null;
	}

	public static void accountInformation(Customer customer) {
		String[] question = { "New Name: ", "New Address: ", "New Email: " };
		String errorMessage = "";
		String input = "";
		boolean cardOperation;
		int backOption;
		do {
			backOption = 0;
			do {
				cardOperation = true;
				printLogo();
				System.out.println(customer.toString());
				Utility.formatMenu(accountInfoMenu);

				if (!errorMessage.isEmpty())
					System.out.println(errorMessage);

				errorMessage = "";

				System.out.print(inputQuestion);
				input = in.nextLine().toLowerCase();

				switch (input) {
				case "1":
					printLogo();
					System.out.println(prevPageMes);
					System.out.print(question[0]);

					input = in.nextLine();
					if (input.equals("b") || input.equals("B")) {
						backOption++;
						break;
					}
					customer.setName(input);
					break;
				case "2":
					printLogo();
					System.out.println(prevPageMes);
					System.out.print(question[1]);
					input = in.nextLine();
					if (input.equals("b") || input.equals("B")) {
						backOption++;
						break;
					}
					customer.setAddress(input);
					break;
				case "3":
					do {
						printLogo();
						if (!errorMessage.isEmpty())
							System.out.println(errorMessage);

						errorMessage = "";
						System.out.println(prevPageMes);
						System.out.print(question[2]);
						input = in.nextLine();
						if (input.equals("b") || input.equals("B")) {
							backOption++;
							break;
						} else if (Input_Validator.validateEmail(input)) {
							customer.setEmail(input);
							errorMessage = "";
						} else {
							errorMessage = invalidEmailMsg;
						}
					} while (!Input_Validator.validateEmail(input));
					break;
				case "4":
					cardOperation = addCreditCard(customer);
					break;
				case "5":
					cardOperation = removeCreditCard(customer);
					break;
				case "b":
					break;
				default:
					errorMessage = invalidInputMsg;
				}

				if (errorMessage.isEmpty() && cardOperation == true && !input.equals("b") && !input.equals("B")) {
					System.out.println(updateSuccessMsg);
					idle();
				}
			} while (!input.equals("b"));
		} while (backOption != 0);
	}

	public static boolean addCreditCard(Customer customer) {
		String[] question = {
				"\nCriteria:\n1) 12 digits\n2) starts with prefix 87/49\n3) only numbers\n\nPlease enter your Card Number: ",
				"\nCriteria:\n1) 3 digits\n2) only numbers\n\nPlease enter your CVV: ",
				"\nCriteria:\n1) in MM/yy format\n\nPlease enter the Expiry Date: " };
		String[] errorMessage = { "Invalid Card Number", "Invalid CVV", "Invalid Expiry Date" };
		String[] answer = new String[3];
		boolean validInput = true;

		for (int i = 0; i < question.length; i++) {
			validInput = true;
			do {

				printLogo();
				System.out.println(prevPageMes);

				validInput = true;

				System.out.print(question[i]);
				answer[i] = in.nextLine().toLowerCase();

				if (answer[i].equals("b"))
					return false;

				switch (i) {
				case 0:
					validInput = Card.validateCardNum(answer[i]);
					break;
				case 1:
					validInput = Card.validateCVV(answer[i]);
					break;
				case 2:
					try {
						validInput = Card.validateExpDate(answer[i]);

						if (!validInput)
							System.out.println("Card has expired");
					} catch (ParseException e) {
						validInput = false;
					}
					break;
				}

				if (!validInput) {
					System.out.println(errorMessage[i]);
					idle();
				}
			} while (!validInput);
		}

		customer.addPaymentOption(new Card(answer[0], answer[1], answer[2]));
		return true;
	}

	public static boolean removeCreditCard(Customer customer) {
		String input, errorMessage = "";
		int index;
		HashMap<Integer, Card> cardList = new HashMap<Integer, Card>();

		if (customer.getPaymentOption().size() > 1) {
			do {
				index = 1;

				printLogo();
				System.out.println(customer.getName() + "'s Valuable Credit Card");
				System.out.println(Card.heading());

				for (PaymentOption po : customer.getPaymentOption()) {
					if (po instanceof Card) {
						System.out.println("[" + index + "] " + po.toString());
						cardList.put(customer.getPaymentOption().indexOf(po), (Card) po);
						index++;
					}
				}

				System.out.println(prevPageMes);

				if (!errorMessage.isEmpty())
					System.out.println(errorMessage);

				errorMessage = "";

				System.out.print(inputQuestion);
				input = in.nextLine().toLowerCase();
				if (input.equals("b")) {
					return false;
				} else if (input.matches("[1-" + cardList.size() + "]")) {
					try {
						Integer key = (Integer) cardList.keySet().toArray()[Integer.valueOf(input) - 1];

						customer.removePaymentOption(key);
					} catch (Exception e) {
						System.out.println(e);
						idle();
					}
				} else {
					errorMessage = invalidInputMsg;
				}
			} while (!errorMessage.isEmpty());
		} else {
			System.out.println("No Credit/Debit Card");
			idle();
			return false;
		}

		return true;
	}

	public static void browseProduct(Customer customer) {
		String categoryChoice = "";
		boolean isInputValid = true;

		while (!categoryChoice.equals("b")) {
			printLogo();
			Utility.formatMenu(productCategoryMenu);// The product category main menu

			if (!isInputValid) {
				System.out.println(invalidInputMsg);
				isInputValid = true;
			}

			System.out.print("Choose a category to browse (1 - 6): ");
			categoryChoice = in.nextLine().toLowerCase();

			switch (categoryChoice) {
			case "b":
				return; // go back to the beginning of the loop to recheck condition
			case "1":
				operateProduct(customer, Processor.getProcessorList());
				break;
			case "2":
				operateProduct(customer, GraphicCard.getGcList());
				break;
			case "3":
				operateProduct(customer, RAM.getRamList());
				break;
			case "4":
				operateProduct(customer, Storage.getStorageList());
				break;
			case "5":
				operateProduct(customer, PowerSupply.getPsList());
				break;
			case "6":
				displayWarrantyInfo();
				break;
			default:
				isInputValid = false; // validate input
			}
		}
	}

	public static void displayWarrantyInfo() {
		int page = 1;
		String warrantyChoice = "";
		List<Warranty> result = new ArrayList<Warranty>();

		while (!warrantyChoice.equals("b")) {
			printLogo();
			result = Warranty.getResult(page);
			System.out.print(Warranty.heading(page));
			for (int i = 0; i < result.size(); i++)
				if (result.get(i).getWarrantyCoverage().length != 0 || !result.get(i).getWarrantyYearLength().isEmpty())
					System.out.println(result.get(i).toString(page));

			System.out.print(defPromptMes + "\nInput: ");
			warrantyChoice = in.nextLine().toLowerCase();

			switch (warrantyChoice) {
			case "b":
				return;
			case "n":
				if (page < Math.ceil((double) Warranty.getWarrantyList().size() / Warranty.getListingLimit())) {
					page++;
				} else {// if page = 2 and total page = 2, then it is the last page
					System.out.println(lastPageMes);
					idle();
				}
				break;
			case "p":
				if (page > 1) {
					page--;
				} else {
					System.out.println(firstPageMes);
					idle();
				}
				break;
			default:
				System.out.println(invalidInputMsg); // invalid input for product submenu
				idle();
			}
		}
	}

	public static void operateProduct(Customer customer, List<? extends Product> result) {
		int page = 1;
		int totalListSize;
		String productChoice = " ";

		totalListSize = result.size();// This is list size of each static Product list

		while (!productChoice.matches("b")) {
			printLogo();
			List<? extends Product> temp = Product.displayProduct(page, result);

			// will print table above
			if (!temp.isEmpty()) {
				if (temp.get(0) instanceof Processor) {
					System.out.println(Processor.heading(page));
				} else if (temp.get(0) instanceof GraphicCard) {
					System.out.println(GraphicCard.heading(page));
				} else if (temp.get(0) instanceof RAM) {
					System.out.println(RAM.heading(page));
				} else if (temp.get(0) instanceof Storage) {
					System.out.println(Storage.heading(page));
				} else if (temp.get(0) instanceof PowerSupply) {
					System.out.println(PowerSupply.heading(page));
				}

				for (int i = 1; i <= temp.size(); i++) {
					System.out.println("[" + i + "] " + temp.get(i - 1).toString());
				}
			}
			// input
			System.out.print(defPromptMes + "\nOr enter 1-" + temp.size() + " to add to cart: "); // the prompt input
																									// message
			productChoice = in.nextLine().toLowerCase();

			if (productChoice.matches("b"))
				continue; // exit while loop, go back to the beginning of the loop to recheck condition

			else if (productChoice.matches("n")) {
				if (page < Math.ceil((double) totalListSize / Product.getListinglimit())) {
					page++;
				} else {// if page = 2 and total page = 2, then it is the last page
					System.out.println(lastPageMes);
					idle();
				}
			}

			else if (productChoice.matches("p")) {
				if (page > 1) {
					page--;
				} else {
					System.out.println(firstPageMes);
					idle();
				}
			}

			else if (productChoice.matches("[1-" + temp.size() + "]")) {
				addToCart(customer, temp.get(Integer.valueOf(productChoice) - 1));
			} else {
				System.out.println(invalidInputMsg); // invalid input for product submenu
				idle();
			}
		}
	}

	public static boolean addToCart(Customer customer, Product product) {
		String input, errorMessage = "";

		System.out.println("\nSelected product: ");
		System.out.printf("%-80s %s\n", product.toString1(),
				product.getWarranty() != null ? product.getWarranty().toString() : "");

		do {
			if (!errorMessage.isEmpty()) {
				System.out.println(errorMessage);
				idle();
			}

			errorMessage = "";

			System.out.print(
					"\nEnter 'c' to cancel 'Add to Cart' action\nEnter quantity of product (will be added to cart): ");
			input = in.nextLine().toLowerCase();

			if (Input_Validator.isNumeric(input)) {
				if (product.getStockAmount() < Integer.valueOf(input)) {
					System.out.println("\nSorry, we are short by " + (Integer.valueOf(input) - product.getStockAmount())
							+ " pieces requested. Please try again.");
					idle();
					continue;
				}
				if (Integer.valueOf(input) <= 0) {
					System.out.println("\nPlease enter a quantity more than 0.\n");
					idle();
					continue;
				}
				CartItem cartItem = new CartItem(product, Integer.valueOf(input));
				// Cart.getCiHistory().add(new CartItemHistory("Added", new CartItem(product,
				// Integer.valueOf(input)))); // add to history
				customer.getCart().addToCartItemList(cartItem);
				product.setStockAmount(product.getStockAmount() - Integer.valueOf(input)); // deduct from stock
				// System.out.println(cartItem.toString());
				System.out.println("\nAdded to cart!\n");
				idle();
				return true;
			} else if (!input.equals("c")) {
				errorMessage = invalidInputMsg;
			}
		} while (!input.equals("c"));

		return false;
	}

	public static void shoppingCart(Customer customer) {
		String menuChoice = "", errorMessage = "";
		boolean isInputValid = true, editProduct = false;
		int page = 1, index, productStockAmount = 0;
		CartItem ci;
		Product tempProduct;
		List<CartItem> c = new ArrayList<CartItem>();

		while (!menuChoice.equals("b")) {
			while (editProduct) {
				printLogo();
				c = customer.getCart().getCartItemList(page);

				if (customer.getCart().getCartItemList().size() != 0) {
					System.out.println(Cart.heading1(customer.getCart().getCartItemList(), page));
					for (int i = 1; i <= c.size(); i++) {
						try {
							System.out.println("[" + i + "] " + c.get(i - 1).toString1());
						} catch (NullPointerException e) {
							System.out.println("Empty Product");
						}
					}
				}

				System.out.println(defPromptMes);

				if (!errorMessage.isEmpty())
					System.out.println(errorMessage);

				errorMessage = "";

				System.out.print("Please select a product: ");
				menuChoice = in.nextLine().toLowerCase();
				switch (menuChoice) {
				case "b":
					editProduct = false;
					page = 1;
					break;
				case "n":
					if (page < Math
							.ceil((double) customer.getCart().getCartItemList().size() / Cart.getListingLimit())) {
						page++;
					} else {// if page = 2 and total page = 2, then it is the last page
						System.out.println(lastPageMes);
						idle();
					}
					break;
				case "p":
					if (page > 1) {
						page--;
					} else {
						System.out.println(firstPageMes);
						idle();
					}
					break;
				default:
					if (menuChoice.matches("[1-" + c.size() + "]")) {

						index = (page - 1) * Cart.getListingLimit() + Integer.valueOf(menuChoice) - 1;
						ci = customer.getCart().getCartItemList().get(index);



						if (ci.getProduct() instanceof Processor)
							tempProduct = Processor.getProduct(ci.getProduct().getProductID());
						else if (ci.getProduct() instanceof GraphicCard)
							tempProduct = GraphicCard.getProduct(ci.getProduct().getProductID());
						else if (ci.getProduct() instanceof RAM)
							tempProduct = RAM.getProduct(ci.getProduct().getProductID());
						else if (ci.getProduct() instanceof Storage)
							tempProduct = Storage.getProduct(ci.getProduct().getProductID());
						else
							tempProduct = PowerSupply.getProduct(ci.getProduct().getProductID());

						if (tempProduct != null)
							productStockAmount = tempProduct.getStockAmount();

						do {
							errorMessage = "";
							printLogo();
							System.out.println(Cart.heading1(customer.getCart().getCartItemList(), page));
							System.out.println("    " + ci.toString1());

							Utility.formatMenu(editProductMenu);
							System.out.print(inputQuestion);
							menuChoice = in.nextLine().toLowerCase();
							switch (menuChoice) {
							case "b":
								editProduct = false;
								break;
							case "1":
								System.out.print("Enter a quantity: ");
								menuChoice = in.nextLine();
								if (Input_Validator.isNumeric(menuChoice)) {
									if (Integer.valueOf(menuChoice) > 0
											&& Integer.valueOf(menuChoice) <= productStockAmount) {
										tempProduct.setStockAmount(
												productStockAmount - (Integer.valueOf(menuChoice) - ci.getQuantity()));
										ci.setQuantity(Integer.valueOf(menuChoice));
										try {
											// Cart.getCiHistory().add(new CartItemHistory ("Edited", new CartItem
											// (ci.getProduct(), Integer.valueOf(menuChoice))));
											customer.getCart().updateCartItem(ci,
													(page - 1) * Cart.getListingLimit() + index);
											System.out.println(updateSuccessMsg);
											idle();
										} catch (Exception e) {
											errorMessage = e.toString();
										}
									} else {
										errorMessage = invalidInputMsg;
									}
								} else {
									errorMessage = invalidInputMsg;
								}
								break;
							case "2":
								try {
									// Cart.getCiHistory().add(new CartItemHistory ("Removed", new CartItem
									// (ci.getProduct(), Integer.valueOf(menuChoice))));
									tempProduct.setStockAmount(productStockAmount + ci.getQuantity());
									customer.getCart().removeCartItem((page - 1) * Cart.getListingLimit() + index);
									System.out.println(updateSuccessMsg);
									idle();
									if (customer.getCart().getCartItemList().size() == 0) {
										System.out.println(emptyCartMsg);
										idle();
									}
								} catch (Exception e) {
									errorMessage = e.toString();
								}
								break;
							default:
								errorMessage = invalidInputMsg;
							}

							if (!errorMessage.isEmpty()) {
								System.out.println(errorMessage);
								idle();
							}
						} while (editProduct && !errorMessage.isEmpty());
						menuChoice = "";
					} else {
						errorMessage = invalidInputMsg; // invalid input for product submenu
					}
				}
			}

			if (!editProduct) {
				printLogo();
				c = customer.getCart().getCartItemList(page);

				if (customer.getCart().getCartItemList().size() != 0) {
					System.out.println(Cart.heading1(customer.getCart().getCartItemList(), page));
					for (int i = 1; i <= c.size(); i++) {
						try {
							System.out.println("[" + i + "] " + c.get(i - 1).toString1());
						} catch (NullPointerException e) {
							System.out.println("Empty Product");
						}
					}
				}

				Utility.formatMenu(cartMenu);
				if (!isInputValid) {
					System.out.println(invalidInputMsg);
					isInputValid = true;
				}
				System.out.println(defPromptMes);
				System.out.print(inputQuestion);
				menuChoice = in.nextLine().toLowerCase();
			}

			editProduct = false;

			switch (menuChoice) {
			case "b":
				if (editProduct) {
					page = 1;
					menuChoice = "";
					editProduct = false;
				}
				break;
			case "n":
				if (page < Math.ceil((double) customer.getCart().getCartItemList().size() / Cart.getListingLimit())) {
					page++;
				} else {// if page = 2 and total page = 2, then it is the last page
					System.out.println(lastPageMes);
					idle();
				}
				break;
			case "p":
				if (page > 1) {
					page--;
				} else {
					System.out.println(firstPageMes);
					idle();
				}
				break;
			case "1":
				browseProduct(customer);
				break;
			case "2":
				if (customer.getCart().getCartItemList().size() == 0) {
					System.out.println(emptyCartMsg);
					idle();
				} else {
					page = 1;
					editProduct = true;
				}
				break;
			case "3":
				if (customer.getCart().getCartItemList().size() == 0) {
					System.out.println(emptyCartMsg);
				} else if (checkout(customer, page)) {
					System.out.println("Transaction successful.");
				}
				idle();
				break;
			case "4":
				Discount.displayDiscountInfo();
				idle();
				break;
			default:
				isInputValid = false;
			}
		}
	}

	public static boolean checkout(Customer customer, int page) {
		System.out.println(customer.getCart().getCartItemList().size());
		String[] question = { "Are you a member(y,n)? ", "What's your payment option? ", "How much are you paying?  ",
				"Confirm Payment(y,n)? " };
		String[] answer = new String[4];
		boolean validInput = true;
		double total = 0, discountedAmount = 0, grandTotal = 0, paidAmount = 0;
		PaymentOption paymentOption = null;
		Discount discount = new Discount();
		List<PaymentOption> paymentOptionList = new ArrayList<PaymentOption>();

		total = customer.getCart().getTotal();
		discount.calculateTradeDiscount(total);
		String orderedProducts = "";
		for (int i = 0; i < question.length; i++) {
			if (i == 2 && paymentOption instanceof Card)
				continue;

			grandTotal = (total - discount.getTotalCashRebate()) * (100 - discount.getTotalPercentage()) / 100;
			discountedAmount = grandTotal - total;

			do {
				printLogo();
				System.out.println(Cart.heading2());

				for (CartItem ci : customer.getCart().getCartItemList()) {
					try {
						System.out.println("    " + ci.toString2());
					} catch (NullPointerException ex) {
						System.out.println("Corrupted Cart Item");
					}
				}

				System.out.println(String.format("%112s\n%112s\n%112s", Utility.repeat(30, "-"),
						String.format("Total %11.2f", customer.getCart().getTotal()), Utility.repeat(30, "-")));

				if (i > 0) {
					System.out.println(String.format("%112s\n%112s\n%112s", Utility.repeat(30, "-"),
							String.format("Discounted Amount %11.2f", discountedAmount), Utility.repeat(30, "-")));
					System.out.println(String.format("%112s\n%112s\n%112s", Utility.repeat(30, "="),
							String.format("Grand Total %11.2f", grandTotal), Utility.repeat(30, "=")));
				}

				if (i == 1) {
					int j = 1, lastIndex = 1;
					// Store user's Payment Option into a temporary list
					if (paymentOptionList.size() == 0) {
						System.out.println();
						// Add card first
						for (PaymentOption po : customer.getPaymentOption()) {
							if (po instanceof Card) {
								if (j == 1)
									System.out.println(Card.heading());
								System.out.println("[" + j + "] " + po.toString());
								paymentOptionList.add(po);
								lastIndex = ++j;
							}
						}

					}
					System.out.println();
					// Then add cash
					for (PaymentOption po : customer.getPaymentOption()) {
						if (po instanceof Cash) {
							if (j == lastIndex)
								System.out.println(Cash.heading());

							System.out.println("[" + j + "] " + po.toString());
							paymentOptionList.add(po);
							j++;
						}

					}
				}

				if (i != 3)
					System.out.println(prevPageMes);

				if (!validInput)
					System.out.println(invalidInputMsg);

				validInput = true; // reset validInput variable

				System.out.print(question[i]);

				answer[i] = in.nextLine().toLowerCase();

				if (answer[i].equals("b") && i != 3)
					return false;

				switch (i) {
				case 0:
					if (answer[i].equals("y") || answer[i].equals("n"))
						discount.applyMemberDiscount(answer[i].equals("y"));
					else
						validInput = false;
					break;
				case 1:
					if (answer[i].matches("[1-" + paymentOptionList.size() + "]"))
						paymentOption = paymentOptionList.get(Integer.valueOf(answer[i]) - 1);
					else
						validInput = false;
					break;
				case 2:
					if (Input_Validator.isNumeric(answer[i])) {
						if (Integer.valueOf(answer[i]) >= grandTotal) {// grandtotal is basically greater than 0
							paidAmount = Integer.valueOf(answer[i]);
							System.out.println("Your changes: RM " + String.format("%17.2f", paidAmount - grandTotal));
						} else {
							System.out.println("Please enter an amount more than or equal to the grand total.");
							validInput = false;
						}
						idle();
					} else {
						validInput = false;
					}
					break;
				case 3:
					if (answer[i].equals("y") || answer[i].equals("n")) {
						if (answer[i].equals("n")) {
							System.out.println("Transaction cancelled.");
							return false;
						}
					} else {
						validInput = false;
					}
					break;
				}
			} while (!validInput);
		}
		customer.checkout(grandTotal,
				new Payment(paymentOption, paymentOption instanceof Card ? grandTotal : paidAmount), discount);

		return true;
	}

	public static void viewReport(ReportFactory rf, Customer customer) {
		String input, errorMessage = "";
		boolean backToMenu, viewReportMenu;
		Report report;

		do {
			backToMenu = false;
			viewReportMenu = true;

			printLogo();
			Utility.formatMenu(reportTypeMenu);

			if (!errorMessage.isEmpty())
				System.out.println(errorMessage + "\n");

			errorMessage = "";

			System.out.print("Choose a type of report: ");
			input = in.nextLine().toLowerCase();

			if (input.equals("b"))
				return;

			report = rf.generateReport(customer, input);

			if (report == null)
				errorMessage = invalidInputMsg;
			else
				viewReportMenu = false;

			while (!viewReportMenu) {
				printLogo();
				Utility.formatMenu(reportDetailMenu);

				if (!errorMessage.isEmpty())
					System.out.println(errorMessage + "\n");

				errorMessage = "";

				System.out.print("Choose a type of report: ");
				input = in.nextLine().toLowerCase();

				printLogo();
				try {
					switch (input) {
					case "1":
						report.printByWeek();
						break;
					case "2":
						report.printByMonth();
						break;
					case "3":
						report.printByYear();
						break;
					case "4":
						report.printReport();
						break;
					case "b":
						viewReportMenu = true;
						break;
					default:
						errorMessage = invalidInputMsg;
						viewReportMenu = false;
					}
				} catch (NullPointerException e) {
					System.out.println("Report generate failed, it might be caused by empty shopping record\n");
				} catch (UnsupportedOperationException e) {
					System.out.println("We're sorry, report is not available. :(\n");
				} catch (Exception e) {
					System.out.println("Error " + e);
				}

				if (errorMessage.isEmpty() && !viewReportMenu) {
					idle();
				}
			}

		} while (!backToMenu);
	}

	public static void printLogo() {
		Utility.clearScreen();

		System.out.println(
				" _______                                              ______                             _______          _             _                 ______                              \n"
						+ "(_______)                         _                  / _____)                           (_______)        | |           (_)               / _____)             _               \n"
						+ " _       ___  ____  ____  _   _ _| |_ _____  ____   ( (____  ____  _____  ____           _     _  ____ __| |_____  ____ _ ____   ____   ( (____  _   _  ___ _| |_ _____ ____  \n"
						+ "| |     / _ \\|    \\|  _ \\| | | (_   _) ___ |/ ___)   \\____ \\|  _ \\| ___ |/ ___)         | |   | |/ ___) _  | ___ |/ ___) |  _ \\ / _  |   \\____ \\| | | |/___|_   _) ___ |    \\ \n"
						+ "| |____| |_| | | | | |_| | |_| | | |_| ____| |       _____) ) |_| | ____( (___          | |___| | |  ( (_| | ____| |   | | | | ( (_| |   _____) ) |_| |___ | | |_| ____| | | |\n"
						+ " \\______)___/|_|_|_|  __/|____/   \\__)_____)_|      (______/|  __/|_____)\\____)          \\_____/|_|   \\____|_____)_|   |_|_| |_|\\___ |  (______/ \\__  (___/   \\__)_____)_|_|_|\n"
						+ "		   |_|                                      |_|                         				       (_____|          (____/                        \n");
	}

	public static void idle() {
		System.out.println(idlingMsg);
		in.nextLine();
	}
}
