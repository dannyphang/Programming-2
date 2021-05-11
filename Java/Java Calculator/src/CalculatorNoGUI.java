import java.util.*;

public class CalculatorNoGUI {
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        
        String inputString = "";
        
        Addition addition = new Addition();
        Subtraction subtraction = new Subtraction();
        // Number.setValue(1.0);
        // Number.setValue(2.0);
        
        
        System.out.print("Input: ");
        inputString = in.nextLine();
        Number.StringtoDouble(inputString);
        
        System.out.println("Addition value: " + addition);
        System.out.println("Subtraction value: " + subtraction);
        System.out.println("Answer: " + Number.getValue());
        
        
        in.close();
    }
}
