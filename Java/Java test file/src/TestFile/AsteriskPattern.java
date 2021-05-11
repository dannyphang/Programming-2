package TestFile;

import java.util.*;

public class AsteriskPattern {
    static Scanner in = new Scanner(System.in);
    static int errorMessage;
    
    public static void Case1() {

        // *******
        //  *****
        //   ***
        //    *

        int spacing, line, line2, starNumber;

        do {
            errorMessage = 0;
            System.out.print("Enter a number: ");
            line = in.nextInt();
            if (line % 2 != 1) {
                errorMessage++;
                System.out.println("This number is unable to print out the pattern! Please try again with a new number.");
            }
        } while (errorMessage != 0);

        line2 = line;
        for (int j = 1; j <= ((line2 + 1) / 2); j++) {

            //System.out.print(j);

            if (j == 1) {
                starNumber = line;
                for (int k = 0; k < starNumber; k++) {
                    System.out.print("*");
                }
                System.out.println();
            } else {
                line -= 2;
                starNumber = line;

                spacing = (line2 - starNumber) / 2;
                
                for (int l = 0; l < spacing; l++) {
                    System.out.print(" ");
                }

                for (int k = 0; k < starNumber; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        
    }

    public static void Case2() {

        //   *
        //  ***
        // *****

        int spacing, line, starNumber, spacing2;

        do {
            errorMessage = 0;
            System.out.print("Enter a number: ");
            line = in.nextInt();
            if (line % 2 != 1) {
                errorMessage++;
                System.out.println("This number is unable to print out the pattern! Please try again with a new number.");
            }
        } while (errorMessage != 0);

        spacing = line / 2;
        spacing2 = line / 2;

        for (int j = 0; j < spacing2; j++) {
            if (j == 0) {
                for (int k = 0; k < spacing; k++) {
                    System.out.print(" ");

                }
                System.out.println("*");
            } else {
                for (starNumber = 3; starNumber <= line; starNumber += 2) {
                    spacing--;
                    for (int k = 1; k <= spacing; k++) {
                        System.out.print(" ");

                    }
                    for (int l = 1; l <= starNumber; l++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            }
        }
    }

    public static void Case3() {

        // *
        // **
        // ***
        // ****
        // *****
        int line, starNumber;

        System.out.print("Enter a number:");
        line = in.nextInt();

        for (int i = 1; i <= line; i++) {
            starNumber = i;
            for (int j = 0; j < starNumber; j++) {

                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void Case4() {

        //     *
        //    **
        //   ***
        //  ****
        // *****

        int line, starNumber, spacing;

        System.out.print("Enter a number:");
        line = in.nextInt();

        spacing = line - 1;

        for (starNumber = 1; starNumber <= line; starNumber++) {
            for (int j = 0; j < spacing; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < starNumber; k++) {
                System.out.print("*");
            }
            System.out.println();
            spacing--;
        }
    }

    public static void Case5() {
        
        // ****
        // ***
        // **
        // *
        
        int line, starNumber;

        System.out.print("Enter a number:");
        line = in.nextInt();
        
        for (starNumber = line; starNumber >= 1; starNumber--) {
            
            for (int k = 0; k < starNumber; k++) {
                System.out.print("*");
            }
            
            System.out.println();
        }
    }
    
    public static void Case6() {
        
        // ****
        //  ***
        //   **
        //    *
        
        int line, line2, starNumber, spacing;

        System.out.print("Enter a number:");
        line = in.nextInt();

        line2 = line;

        for (starNumber = line; starNumber >= 1; starNumber--) {    // line = 5
            
            spacing = line2 - starNumber;   // spacing = 5(line2) - 4
            
            for (int k = 0; k < spacing; k++) {
                System.out.print(" ");
            }
            
            
            for (int k = 0; k < starNumber; k++) {
                System.out.print("*");
            }
            System.out.println();
            
        }
    }
    
    public static void drawPattern(int number){
        int n = 10;
        
        if(number < n){
            for(int i = 0; i < number; i++){
                System.out.print("*");
            }
            
            System.out.println();
            drawPattern(number+1);
        }
        
    }
    
    public static void Case7(){
        drawPattern(1);
    }
}
