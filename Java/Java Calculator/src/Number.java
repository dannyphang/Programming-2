import java.util.*;

public class Number {
    // static Addition addition = new Addition();
    private static double value = 0;

    public static double getValue() {
        return value;
    }

    public static void setValue(double value) {
        
        Number.value = value;
    }

    public static void StringtoDouble(String inputString) {
        List<Character> toCharList = new ArrayList<Character>();
        char[] toCharArr = new char[inputString.length()];
        char[] numArr = new char[toCharArr.length];
        int count = 0;

        for (int i = 0; i < inputString.length(); i++) {
            toCharList.add(inputString.charAt(i));

        }
        for(int j = 0; j < toCharList.size(); j++){
            if (toCharList.get(j) == '+') {
                count++;
            }
            
        }
        
        for(int k = 0; k <= count; k++){
            for (int i = 0; i < toCharList.size(); i++) {
                if (toCharList.get(i) == ' ') {
                    toCharList.remove(i);
                    // 123+456
                }
            }
        }
        
        
        
        for(int i = 0; i < toCharList.size(); i++){
            numArr[i] = toCharList.get(i);
        }
        
        String string = new String(numArr);
        
        String[] stringAdd = string.split("\\+");
        String[] stringSub = string.split("\\-");
        String[] stringMul = string.split("\\*");
        String[] stringDiv = string.split("\\/");
        
        for(int i = 0; i < stringAdd.length; i++){
            double num = Double.parseDouble((stringAdd[i]));
            setValue(num);
            Addition.setAddValue(num);
        }
        
        for(int i = 0; i < stringSub.length; i++){
            
        }
        
        // for(int i = 0; i < stringSub.length; i++){
        //     double num = Double.parseDouble((stringSub[i]));
        //     setValue(num);
        //     Subtraction.setSubValue(num);
        // }
        
        setValue(Double.parseDouble((stringAdd[0])));
        
    }
    
    
    
}