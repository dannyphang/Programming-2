package TestFile;

import java.util.*;
import java.util.regex.*;
import java.io.*;

public class PasswordValidate {
    
    static Scanner in = new Scanner(System.in);
    static int errorMessage;
    
    public static void Case1() {    // show asterisk when entering password

        Console console = System.console();
        Character mask = '*';
        String line = null;
        do {
            line = console.readLine("Enter Password(blank pwd to exit)> ", mask);
            System.out.println("Got password: " + line);
        } while (line != null && line.length() > 0);
    }
    
    public static void Case2() {   // Didn't show anything when entering password
        
        Console console = System.console();
        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

        console.printf("Testing password%n");
        char passwordArray[] = console.readPassword("Enter your secret password: ");
        console.printf("Password entered was: %s%n", new String(passwordArray));
        
    }
    
    public static void Case3(){     // Check the format
        
        // Must have 8 - 12 character
        // Must include alphanumeric, symbol(@#$%) 
        // Must include uppercase and lowercase
        
        // ^ asserts position at start of a line
        
        // Group (?=.*\\d)
        // Assert that the Regex below matches
        // .* matches any character (except for line terminators)
        // \\ matches the character \ literally (case sensitive)
        // d matches the digit literally (case sensitive)
        
        // Group (?=.*[a-z])
        // Assert that the Regex below matches
        // .* matches any character (except for line terminators)
        // Match a single character present in the list below [a-z]
        // a-z a single character in the range between a (index 97) and z (index 122) (case sensitive)
        
        // Group (?=.*[A-Z])
        // Assert that the Regex below matches
        // .* matches any character (except for line terminators)
        // Match a single character present in the list below [A-Z]
        // A-Z a single character in the range between A (index 65) and Z (index 90) (case sensitive)
        
        // Group (?=.*[@#$%])
        // Assert that the Regex below matches
        // .* matches any character (except for line terminators)
        // Match a single character present in the list below [@#$%]
        // @#$% matches a single character in the list @#$% (case sensitive)
        
        // .{8,20} matches any character (except for line terminators)
        // {8,20} Quantifier — Matches between 8 and 20 times, as many times as possible, giving back as needed (greedy)
        
        // $ asserts position at the end of a line
        
        String password;
        String validateFormat = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,12}$";
        
        System.out.print("Enter password: ");
        password = in.nextLine();
        
        boolean validPassword = isValidPassword(password, validateFormat);
        
        System.out.print("The password is " );
        if(validPassword == true){
            System.out.println("valid!");
        }
        else{
            System.out.println("not valid!");
        }
    }

    public static boolean isValidPassword(String password, String validateFormat) {
        
        Pattern pattern = Pattern.compile(validateFormat);
        Matcher matcher = pattern.matcher(password);
        
        return matcher.matches();
    }
}
