package util;

public class Utility {
	final static String leftTopCorner = "\u2554";
	final static String rightTopCorner = "\u2557";
	final static String leftBottomCorner = "\u255A";
	final static String rightBottomCorner = "\u255D";
	final static String horizontalBorder = "\u2550";
	final static String verticalBorder = "\u2551";

	public static void clearScreen() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void formatMenu(String[] arr) {
		int maxLength = longestString(arr);
		System.out.println(leftTopCorner + repeat(maxLength + 6, horizontalBorder) + rightTopCorner);
		System.out.println(verticalBorder + repeat(maxLength + 6, " ") + verticalBorder);

		for (String s : arr)
			if (s == null)
				System.out.println(verticalBorder + repeat(maxLength + 6, " ") + verticalBorder);
			else
				System.out.println(
						verticalBorder + repeat(1, " ") + s + repeat(maxLength - s.length() + 5, " ") + verticalBorder);

		System.out.println(verticalBorder + repeat(maxLength + 6, " ") + verticalBorder);
		System.out.println(leftBottomCorner + repeat(maxLength + 6, horizontalBorder) + rightBottomCorner);
	}

	public static String repeat(int count, String with) {
		return new String(new char[count]).replace("\0", with);
	}

	public static int longestString(String[] arr) {
		int max = Integer.MIN_VALUE;
		for (String s : arr)
			if (s != null)
				max = s.length() > max ? s.length() : max;

		return max;
	}

	public static String capitalizeName(String name) {
		String[] temp = name.split(" ");
		String result = "";

		for (int i = 0; i < temp.length; i++) {
			if (!temp[i].isEmpty()) {
				if (i > 0)
					result += " ";

				result += temp[i].substring(0, 1).toUpperCase() + temp[i].substring(1, temp[i].length());
			}
		}
		return result;
	}
}
