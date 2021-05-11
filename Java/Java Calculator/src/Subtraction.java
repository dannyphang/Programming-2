public class Subtraction {
    private static double subValue;

    public static void Test() {
        System.out.println();
    }

    public static double getSubValue() {
        return subValue;
    }

    public static void setSubValue(double value) {
        Subtraction.subValue = value - subValue;
        
    }
    
    
    
    public String toString() {
        return String.valueOf(getSubValue());
    }
}
