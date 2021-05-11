package TestFile;

public class ClearScreen {
    public static void Case1() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
