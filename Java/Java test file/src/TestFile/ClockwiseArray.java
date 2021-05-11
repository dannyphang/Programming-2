package TestFile;

import java.util.*;

public class ClockwiseArray {
    
    static Scanner in = new Scanner(System.in);
    static int errorMessage;
    
    public static void Case1() {
        
        // [ 1][ 2][ 3][ 4]
        // [12][13][14][ 5]
        // [11][16][15][ 6]
        // [10][ 9][ 8][ 7]

        int arraySize;

        System.out.print("Enter a array size:");
        arraySize = in.nextInt();

        int row = arraySize;
        int col = arraySize;
        int[][] clockArray = new int[row][col];
        
        //System.out.println("Array length is " + clockArray.length);
        
        int i = 1;
        
        for(int x = 0; x < clockArray.length; x++){
            for(int y = 0; y < clockArray.length; y++){
                clockArray[x][y] = i++;
            }
        }
        
        for(int x = 0; x < clockArray.length; x++){
            for(int y = 0; y < clockArray.length; y++){
                System.out.print("[" + clockArray[x][y] + "] ");
            }  
            System.out.println("\n");
        }
        
    }
}
