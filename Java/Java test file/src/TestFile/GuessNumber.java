package TestFile;

import java.util.*;

public class GuessNumber {
    
    static Scanner in = new Scanner(System.in);
    static int errorMessage;
    
    public static void Case1() {
        int number, max, min, minNumber, maxNumber, randomNumber;
        
        boolean oneMoreGame = true;
        
        do{
            do{
                errorMessage = 0;
                System.out.print("Enter the Maximun number: ");
                max = in.nextInt();
                
                System.out.print("Enter the Minimun number: ");
                min = in.nextInt();

                if (max - min == 1 || max <= min) {
                    errorMessage++;
                    System.out.println("Wrong number is entered!\n");
                }
            } while (errorMessage != 0);
            
            // max = 1000;
            // min = 1;
            
            randomNumber = (int) (Math.random() * (max - min + 1) + min); // randomNumber = 30

            //System.out.println(randomNumber);
            
            do {
                ClearScreen.Case1();
                do {
                    errorMessage = 0;
                    System.out.printf("Enter a number (%d - %d): ", min, max);
                    number = in.nextInt();
                    if (number < min || number > max) {
                        errorMessage++;
                        System.out.println("Wrong number is entered!");
                    }
                } while (errorMessage != 0);
                
                
                
                minNumber = min;
                maxNumber = max;
    
                if (number > randomNumber) { // number = 50 -> 1 - 50
                    maxNumber = number;
                    System.out.println(minNumber + " - " + maxNumber);
                } else if (number < randomNumber) { // number = 20 -> 20 - 100
                    minNumber = number;
                    System.out.println(minNumber + " - " + maxNumber);
                }
                min = minNumber;
                max = maxNumber;
            } while (number != randomNumber);
    
            System.out.println("\nBOOM!\n\nDo you want to play one more time?\n\n[E] Exit\n[Press any button] Continue the game");
            char option = in.next().charAt(0);
            
            if(option == 'e' || option == 'E'){
                oneMoreGame = false;
                System.exit(0);
            }
            System.out.println();
        }while(oneMoreGame == true || errorMessage != 0);
        
    }
    
}
