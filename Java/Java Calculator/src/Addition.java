public class Addition{
    
    private static double addValue = 0;

    public static void Test() {
        System.out.println();
    }

    public static double getAddValue() {
        return addValue;
    }

    public static void setAddValue(double value) {
        Addition.addValue += value;
    }
    
    
    
    public String toString() {
        return String.valueOf(getAddValue());
    }
}
