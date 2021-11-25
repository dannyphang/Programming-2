package TestFile;

import java.util.*;

public class Mainfile {
    
    static Scanner in2 = new Scanner(System.in);
    static int errorMessage;
    
    public static void main(String[] args) {
        
        // ClearScreen.Case1();
        // AsteriskPattern.Case1();
        // AsteriskPattern.Case2();
        // AsteriskPattern.Case3();
        // AsteriskPattern.Case4();
        // AsteriskPattern.Case5();
        // AsteriskPattern.Case6();
        // AsteriskPattern.Case7();
        // GuessNumber.Case1();
        // ClockwiseArray.Case1();
        // PasswordValidate.Case1();
        // PasswordValidate.Case2();
        // PasswordValidate.Case3();
        // ArrayFrom.Case1();
        // ArrayFrom.Case2();
        // NumberTest.Case1();
        // NumberTest.Case2();
        // NumberTest.Case3();
        // NumberTest.Case4();
        // NumberTest.Case5();
        // NumberTest.Case6();
        // NumberTest.Case7();
        // NumberTest.Case8();
        // StringTest.Case1();
        // StringTest.Case2();
        // StringTest.Case3();
        // InsideCode.Case1();
        // InsideCode.Case2();
        // InsideCode.Case3();
        // InsideCode.Case4();
        
        // int num = 123456;
        // Integer[] digit = getDigits(num);
        // // System.out.println(Math.log10(num) + 1);
        // for(int i = 0; i < (Math.log10(num)); i++){
        //     System.out.println(digit[i]);
        // }
        
        int n = in2.nextInt();
        int[] l = new int[n];
        
        for(int i = 0; i < n; i++) {
            l[i] = in2.nextInt();
        }
        
        for(int i = 0; i < n; i++) {
            if(l[i] % 2 == 0){
                System.out.println(l[i] + ": 0");
                continue;
            }
            else if(l[i] < 10 && l[i] % 2 != 0){
                System.out.println(l[i] + ": -1");
                continue;
            }
            else{
                Integer[] digit = getDigits(l[i]); // digit = {1, 3, 5, 7, 8, 9}
                
                int ll = -11;
                String str = String.valueOf(l[i]); // str = "135789"
                
                String reverse = new StringBuilder(str).reverse().toString();
                String temp = "hi";
                String tempLeft = "str2";
                
                String rTemp = "ih";
                
                if(Integer.parseInt(reverse) % 2 == 0){
                    System.out.println(l[i] + ": 1");
                }
                else {
                    for(ll = 1; ll < digit.length; ll++){
                        temp = str.substring(0, ll + 1); // temp = "13"
                        tempLeft = str.substring(ll + 1);
                        rTemp = new StringBuilder(temp).reverse().toString();
                        str = rTemp + tempLeft;
                        if(Integer.parseInt(str) % 2 == 0){
                            System.out.println(l[i] + ": " + ll);
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public static Integer[] getDigits(int num) {
        List<Integer> digits = new ArrayList<Integer>();
        collectDigits(num, digits);
        return digits.toArray(new Integer[]{});
    }
    
    private static void collectDigits(int num, List<Integer> digits) {
        if(num / 10 > 0) {
            collectDigits(num / 10, digits);
        }
        digits.add(num % 10);
    }
    
}
