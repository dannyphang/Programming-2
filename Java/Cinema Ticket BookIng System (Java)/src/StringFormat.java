public class StringFormat {
    final static String leftTopCorner = "\u2554";
	final static String rightTopCorner = "\u2557";
	final static String leftBottomCorner = "\u255A";
	final static String rightBottomCorner = "\u255D";
	final static String horizontalBorder = "\u2550";
    final static String verticalBorder = "\u2551";
    final static String TopLeft = "\u256D";
    final static String TopRight = "\u256E";
    final static String BottomRight = "\u256F";
    final static String BottomLeft= "\u2570";
    final static String Horizontal = "\u2500";
    final static String BottomVertical = "\u2502";
	
	public static void formatMenu(String[] arr) {
		int maxLength = longestString(arr);
		System.out.println(Space() + leftTopCorner + repeat(maxLength + 2, horizontalBorder) + rightTopCorner);
		System.out.println(Space() + verticalBorder + repeat(maxLength + 2, " ") + verticalBorder);

		for (String s : arr)
			if (s == null)
				System.out.println(Space() + verticalBorder + repeat(maxLength + 2, " ") + verticalBorder);
			else
				System.out.println(Space() + verticalBorder + repeat(1, " ") + s + repeat(maxLength - s.length() + 1, " ") + verticalBorder);

		System.out.println(Space() + verticalBorder + repeat(maxLength + 2, " ") + verticalBorder);
		System.out.println(Space() + leftBottomCorner + repeat(maxLength + 2, horizontalBorder) + rightBottomCorner);
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
    
    public static void FormatString(String[] arr) {
		int maxLength = longestString(arr);
		System.out.println(Space() + TopLeft + repeat(maxLength + 6, Horizontal) + TopRight);
		System.out.println(Space() + BottomVertical + repeat(maxLength + 6, " ") + BottomVertical);

		for (String s : arr)
			if (s == null)
				System.out.println(Space() + BottomVertical + repeat(maxLength + 6, " ") + BottomVertical);
			else
				System.out.println(Space() + BottomVertical + repeat(1, " ") + s + repeat(maxLength - s.length() + 5, " ") + BottomVertical);

		System.out.println(Space() + BottomVertical + repeat(maxLength + 6, " ") + BottomVertical);
		System.out.println(Space() + BottomLeft + repeat(maxLength + 6, Horizontal) + BottomRight);
	}
	
	public static String Space(){
		for(int spacing = 0; spacing < 50; spacing++){
			System.out.print(" ");
		}
		return "";
	}
	
	public static String Space2(){
		for(int spacing = 0; spacing < 42; spacing++){
			System.out.print(" ");
		}
		return "";
	}
}
