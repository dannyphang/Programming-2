package TestFile;

import java.util.*;

public class NumberTest {
    static Scanner in = new Scanner(System.in);
    static int errorMessage;
    
    // 1. How do you find the missing number in a given integer array of 1 to 100?
    // 2. How do you find the duplicate number on a given integer array?
    // 3. How do you find the largest and smallest number in an unsorted integer array?
    // 4. How do you find all pairs of an integer array whose sum is equal to a given number?
    // 5. How do you find duplicate numbers in an array if it contains multiple duplicates?
    // 6. How are duplicates removed from a given array in Java?
    // 7. How is an integer array sorted in place using the quicksort algorithm?
    // 8. How do you remove duplicates from an array in place?
    // 9. How do you reverse an array in place in Java?
    // 10. How are duplicates removed from an array without using any library?
    
    public static void Case1(){
        
        // find the missing integer
        // -3 -> 10
        // -1, 0, 1, 2, 4, 5, 6, 10
        
        int max, min, integer = 0, diff, int2, count = 0;
        ArrayList<Integer> integerArray = new ArrayList<Integer>();
        ArrayList<Integer> integerArray2 = new ArrayList<Integer>();
        ArrayList<Integer> integerArray3 = new ArrayList<Integer>();
        
        System.out.print("Enter minimum ingeter: ");    // min = 1
        min = in.nextInt();
        
        System.out.print("Enter maximum ingeter: ");    // max = 10
        max = in.nextInt();
        
        diff = max - min;
        
        System.out.println("---------------------------------------");
        
        // Input the integer and store it in the arraylist(integerArray1)
        // when key in the max number or wrong data the loop will break
        for(int i = 0; i < diff; i++){
            System.out.print("Enter an integer: ");
            integer = in.nextInt();
            
            if(integer < max){
                integerArray.add(integer);
            }
            else if(integer == max){
                integerArray.add(integer);
                break;
            }
            else{
                break;
            }
        }
        
        // for(int j = 0; j < integerArray.size(); j++){
        //     System.out.println("Arr1: " + integerArray.get(j));
        // }
        
        // 10- -3 = 13
        // 10 - 13 = -3
        // 10 - 12 = -2
        // ...
        // 10 - 5 = 5
        // 10 - 4 = 6
        // 10 - 3 = 7
        // 10 - 2 = 8
        // 10 - 1 = 9
        // 10 - 0 - 10
        
        // diff = 13 +-, max = 10
        
        // Store all the integer between the max and min into an arraylist(integerArray2)
        for(int loop = 0; loop <= diff; loop++){
            int2 = max - loop;
            integerArray2.add(int2);
        }
        
        // for(int loop2 = 0; loop2 < integerArray2.size(); loop2++){
        //     System.out.println("Arr2: " + integerArray2.get(loop2));
        // }
        
        // check the missing integer
        // if the integer is in the list, the count != 0(count++)
        // so we just store the integer into an new arraylist(integerArray3) if its count == 0
        for(int i = 0; i < integerArray2.size(); i++){
            count = 0;
            for(int j = 0; j < integerArray.size(); j++){
                if(integerArray2.get(i) == integerArray.get(j)){
                    count++;
                }
            }
            if(count == 0){
                integerArray3.add(integerArray2.get(i));
            }
        }
        
        // sort the arraylist
        Collections.sort(integerArray3);
        
        System.out.println("---------------------------------------");
        
        // display the result
        for(int i = 0; i < integerArray3.size(); i++){
            System.out.println("Missiong number: " + integerArray3.get(i));
        }
        
        System.out.println("---------------------------------------");
    }
    
    public static void Case2(){
        
        // find the duplicated integer
        // {1, 2, 3, 3, 3, 4, 5, 5, 7, 8, 9, 10}
        
        int loop, integer, count = 0;
        int[] integerArray;
        
        System.out.print("Enter number of integer: ");
        loop = in.nextInt();
        // integerArray = new int []{1, 2, 3, 3, 5, 5, 7, 8, 9, 10};
        integerArray = new int[loop];
        
        for(int i = 0; i < integerArray.length; i++){
            System.out.print("Enter the integer(" + (i + 1) + "): ");
            integer = in.nextInt();
            integerArray[i] = integer;
        }
        
        for(int j = 0; j < integerArray.length; j++){
            count = 0;
            for(int k = j + 1; k < integerArray.length; k++){
                
                if(integerArray[j] == integerArray[k]){
                    count++;
                }
            }
            if(j != 0){
                if(integerArray[j - 1] != integerArray[j] && count != 0){
                    System.out.println(integerArray[j]);
                }
            }
            else{
                if(count != 0){
                    System.out.println(integerArray[j]);
                }
            }
        }
    }
    
    public static void Case3(){
        
        // find the largest and smallest number in an unsorted integer array
        
        ArrayList<Integer> integerArray = new ArrayList<Integer>();
        int max, min, diff, integer;
        
        System.out.print("Enter minimum ingeter: ");
        min = in.nextInt();
        
        System.out.print("Enter maximum ingeter: ");
        max = in.nextInt();
        
        diff = max - min;
        
        System.out.println("---------------------------------------");
        
        // Input the integer and store it in the arraylist(integerArray1)
        // when key in the max number or wrong data the loop will break
        for(int i = 0; i < diff; i++){
            System.out.print("Enter an integer: ");
            integer = in.nextInt();
            
            if(integer <= max && integer >= min){
                integerArray.add(integer);
            }
            else{
                break;
            }
        }
        
        // sort the arraylist
        Collections.sort(integerArray);
        
        System.out.println("Smallest integer: " + integerArray.get(0) + "\nLargest Integer: " + integerArray.get(integerArray.size() - 1));
    }
    
    public static void Case4(){
        
        // find all pairs of an integer array whose sum is equal to a given number
        
        int integer, min, max, diff;
        ArrayList<Integer> integerArray = new ArrayList<Integer>();
        ArrayList<Integer> integerArray2 = new ArrayList<Integer>();
        
        System.out.print("Enter an integer: ");
        integer = in.nextInt();
        
        System.out.println("---------------------------------------");
        
        System.out.print("Enter minimum ingeter: ");    // min = 1
        min = in.nextInt();
        
        System.out.print("Enter maximum ingeter: ");    // max = 100
        max = in.nextInt();
        
        diff = max - min;   // diff = 99
        
        System.out.println("---------------------------------------");
        
        // store all the integer in between the min and max in an arraylist
        for(int i = 1; i <= diff; i++){
            integerArray.add(i);
        }
        
        // situation(1): if the pairs' integer can be repeated
        // for(int i = 0; i < diff; i++){
        //     for(int j = 0; j < diff; j++){
        //         if(integerArray.get(i) != integerArray.get(j) && (integerArray.get(i) + integerArray.get(j) == integer)){
        //             System.out.println("The pairs: " + integerArray.get(i) + " & " + integerArray.get(j));
        //         }
        //     }
        // }
        
        // situation(2): if the pairs' integer can't be repeated
        // store all the pairs in an new arraylist(integerArray2)
        for(int i = 0; i < diff; i++){
            for(int j = 0; j < diff; j++){
                if(integerArray.get(i) != integerArray.get(j) && (integerArray.get(i) + integerArray.get(j) == integer)){
                    integerArray2.add(integerArray.get(i));
                    integerArray2.add(integerArray.get(j));
                }
            }
        }
        
        // Only display half of the arraylist
        // so the pairs won't be repeated
        for(int i = 0; i < integerArray2.size() / 2; i+=2){
            System.out.println("The pairs: " + integerArray2.get(i) + " & " + integerArray2.get(i + 1));
        }
        
    }
    
    public static void Case5(){
        
        // find duplicate numbers in an array if it contains multiple duplicates
        // {1, 2, 3, 3, 3, 4, 5, 5, 7, 8, 9, 10}
        
        int integer, min, max, count = 0, error = 0;
        ArrayList<Integer> integerArray = new ArrayList<Integer>();
        ArrayList<Integer> integerArray2 = new ArrayList<Integer>();
        ArrayList<Integer> integerArray3 = new ArrayList<Integer>();
        
        System.out.print("Enter minimum ingeter: ");    // min = 1
        min = in.nextInt();
        
        System.out.print("Enter maximum ingeter: ");    // max = 100
        max = in.nextInt();
        
        System.out.println("---------------------------------------");
        
        do{
            error = 0;
            System.out.print("Enter an integer: ");
            integer = in.nextInt();
            
            if(integer <= max && integer >= min){
                integerArray.add(integer);
            }
            else{
                error++;
            }
        }while(error == 0);
        
        // Collections.sort(integerArray);
        
        // store all the duplicated integer in a new arraylist(ArrayList2)
        for(int i = 0; i < integerArray.size(); i++){
            count = 0;
            for(int j = i + 1; j < integerArray.size(); j++){
                if(integerArray.get(i) == integerArray.get(j)){
                    count++;
                }
            }
            if(i != 0){
                if(count != 0 && integerArray.get(i - 1) != integerArray.get(i)){
                    integerArray2.add(integerArray.get(i));
                }
            }
            else if(i == 0){
                if(count != 0){
                    integerArray2.add(integerArray.get(i));
                }
            }
        }
        
        // find the duplicated integer from ArrayList2 
        // then store all the integer in a new arraylist(ArrayList3)
        for(int i = 0; i < integerArray2.size(); i++){
            count = 0;
            for(int j = i + 1; j < integerArray2.size(); j++){
                if(integerArray2.get(i) == integerArray2.get(j)){
                    count++;
                }
            }
            if(i != 0){
                if(count != 0 && integerArray2.get(i - 1) != integerArray2.get(i)){
                    integerArray3.add(integerArray2.get(i));
                }
            }
            else if(i == 0){
                if(count != 0){
                    integerArray3.add(integerArray2.get(i));
                }
            }
        }
        
        for(int i = 0; i < integerArray3.size(); i++){
            System.out.println("Multiple duplicates integer: " + integerArray3.get(i));
        }
    }
       
    public static void Case6(){
        
        // remove duplicated in array
        
        int integer, min, max, count = 0, error = 0;
        ArrayList<Integer> integerArray = new ArrayList<Integer>();
        ArrayList<Integer> integerArray2 = new ArrayList<Integer>();
        ArrayList<Integer> integerArray3 = new ArrayList<Integer>();
        
        System.out.print("Enter minimum ingeter: ");    // min = 1
        min = in.nextInt();
        
        System.out.print("Enter maximum ingeter: ");    // max = 100
        max = in.nextInt();
        
        System.out.println("---------------------------------------");
        
        do{
            error = 0;
            System.out.print("Enter an integer: ");
            integer = in.nextInt();
            
            if(integer <= max && integer >= min){
                integerArray.add(integer);
            }
            else{
                error++;
            }
        }while(error == 0);
        
        System.out.println("---------------------------------------");
        
        // store all the duplicated integer in a new arraylist(ArrayList2)
        for(int i = 0; i < integerArray.size(); i++){
            count = 0;
            for(int j = i + 1; j < integerArray.size(); j++){
                if(integerArray.get(i) == integerArray.get(j)){
                    count++;
                }
            }
            if(i != 0){
                if(count != 0 && integerArray.get(i - 1) != integerArray.get(i)){
                    integerArray2.add(integerArray.get(i));
                }
            }
            else if(i == 0){
                if(count != 0){
                    integerArray2.add(integerArray.get(i));
                }
            }
        }
        
        for(int i = 0; i < integerArray.size(); i++){
            count = 0;
            for(int j = 0; j < integerArray2.size(); j++){
                if(integerArray.get(i) - integerArray2.get(j) != 0){
                    count++;
                }
            }
            if(count == integerArray2.size()){
                integerArray3.add(integerArray.get(i));
            }
        }
        
        for(int i = 0; i < integerArray3.size(); i++){
            System.out.print(integerArray3.get(i) + " ");
        }
    }
    
    public static void Case7(){
        
        // reverse an array in place in Java
        // {-1, 0, 1, 2, 4, 5, 6, 10}
        
        int[] integerArray = {-1, 0, 1, 2, 4, 5, 6, 10};
        int[] integerArray2 = new int[integerArray.length];
        
        for(int i = integerArray.length - 1, j = 0; i >= 0; i--, j++){
            integerArray2[j] = integerArray[i];
            System.out.println(integerArray2[j]);
        }
    }
    
    public static void Case8(){
        // check prime number
        // {3, 5, 7, 11, 13, 17}
        
        int integer, min, max, error = 0, num;
        ArrayList<Integer> integerArray = new ArrayList<Integer>();
        
        System.out.print("Enter minimum ingeter: ");    // min = 1
        min = in.nextInt();
        
        System.out.print("Enter maximum ingeter: ");    // max = 100
        max = in.nextInt();
        
        System.out.println("---------------------------------------");
        
        do{
            error = 0;
            System.out.print("Enter an integer: ");
            integer = in.nextInt();
            
            if(integer <= max && integer >= min){
                integerArray.add(integer);
            }
            else{
                error++;
            }
        }while(error == 0);
        
        System.out.println("---------------------------------------");
        
        for(int i = 0; i < integerArray.size(); i++){
            num =integerArray.get(i);
            if(num != 2 && num != 3){
                if(num % 2 == 0){
                    System.out.println(num + " is not a prime number! Becasue it can be divided by 2!");
                }
                else if(num <= 1){
                    System.out.println(num + " is not a prime!");
                }
                else if((num * num - 1) % 24 != 0){
                    System.out.println(num + " is not a prime number! Because it can divide by other number beside '1' and itself!");
                }
                else{
                    System.out.println(num + " is a prime number!");
                }
            }
            else{
                System.out.println(num + " is a prime number!");
            }
        }
    }
    
    
    
}