package TestFile;

import java.util.*;
import java.util.regex.*;

public class StringTest {
    static Scanner in = new Scanner(System.in);
    static int errorMessage;
    
    // How do you print duplicate characters from a string?
    // How do you check if two strings are anagrams of each other?
    // How do you print the first non-repeated character from a string?
    // How can a given string be reversed using recursion?
    // How do you check if a string contains only digits?
    // How are duplicate characters found in a string?
    // // How do you count a number of vowels and consonants in a given string?
    // How do you count the occurrence of a given character in a string?
    // How do you find all permutations of a string?
    // How do you reverse words in a given sentence without using any library method?
    // How do you check if two strings are a rotation of each other?
    // How do you check if a given string is a palindrome?
    
    public static void Case1(){
        // count a number of vowels and consonants in a given string
        
        String words = " ";
        int vowels = 0, consonants = 0;
        
        System.out.print("Enter some words: ");
        words = in.nextLine();
        
        char[] StringArray = new char[words.length()];
        
        // convert all the letters into lower case
        // convert string into char and store into an array
        for(int i = 0; i < words.length(); i++) {
            StringArray[i] = words.toLowerCase().charAt(i);
        }
        
        // count vowels (a, e, i, o, u)
        for(int i = 0; i < StringArray.length; i++){
            if(StringArray[i] == 'a' || StringArray[i] == 'e' || StringArray[i] == 'i' || StringArray[i] == 'o' || StringArray[i] == 'u'){
                vowels++;
            }
            else if(StringArray[i] == ' '){
                
            }
            else{
                consonants++;
            }
        }
        
        System.out.println("\nVowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
    
    public static void Case2(){
        // check if a string contains only digits
        
        boolean digits = false;
        
        System.out.print("Enter only digits: ");
        String words = in.nextLine();
        
        digits = Pattern.compile("-?\\d+(\\.\\d+)?").matcher(words).matches();
        
        if (words == null) {
			digits = false;
        }
        
        System.out.println(digits);
    }
    
    public static void Case3(){
        // check string palindrome
        // "bob", "dannad"
        
        String str;
        
        System.out.print("Enter something: ");
        String words = in.nextLine().toLowerCase();
        
        char[] chars = new char[words.length()];
        char[] chars2 = new char[words.length()];
        
        for(int i = 0; i < words.length(); i++){
            chars[i] = words.charAt(i);
        }
        
        for(int i = chars.length - 1, j = 0; i >= 0; i--, j++){
            chars2[j] = chars[i];
        }
        
        str = String.valueOf(chars2);
        
        // for(int i = 0; i < chars2.length; i++){
        //     System.out.println(chars2[i]);
        // }
        
        // System.out.println(str);
        
        if(str.equals(words)){
            System.out.println("Done!");
        }
        else{
            System.out.println("Failed!");
        }
    }
    
}
