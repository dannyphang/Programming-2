package TestFile;

import java.util.*;

public class ArrayFrom {
    
    static Scanner in = new Scanner(System.in);
    static int errorMessage;
    
    public static void Case1() {
        
        // Convert letter from a string into array
        
        String words;
        char []lettersArray;
        
        System.out.print("Enter a string: ");
        words = in.nextLine();
        
        // Creating array of string length
        lettersArray = new char[words.length()];
        
        // Convert every letter by character into array
        for(int i = 0; i < words.length(); i++){
            lettersArray[i] = words.charAt(i);
        }
        
        // Display the letters
        for (int j = 0; j < lettersArray.length; j++){
            if(j != lettersArray.length - 1 && lettersArray[j + 1] != ' ' && lettersArray[j] != ' '){
                System.out.print(lettersArray[j] + "-");
            }
            else if(j != (lettersArray.length - 1) && lettersArray[j + 1] == ' '){
                // if the array is a 'space'
                System.out.print(lettersArray[j] + "\n");
            }
            else if(j == (lettersArray.length - 1)){
                // the last letter    
                System.out.println(lettersArray[j]);
            }
        }
    }
    
    public static void Case2(){
        
        
        
    }
    
}
