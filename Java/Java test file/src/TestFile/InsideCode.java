package TestFile;

import java.util.*;

public class InsideCode {
    // https://www.instagram.com/p/CLUKgAMAPU3/
    
    static Scanner in = new Scanner(System.in);
    static int errorMessage;
    
    public static void Case1(){
        // cumulative sum
        // input = [1, 3, 2, 0, 6, 7]
        // output = [1, 4, 6, 6, 12, 19]
        
        int[] input = {1, 3, 2, 0, 6, 7};
        int[] output = new int[input.length];
        int sum = 0;
        
        for(int i = 0; i < input.length; i++){
            sum = sum + input[i];
            output[i] = sum;
        }
        for(int i = 0; i < input.length; i++){
            System.out.print(input[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < output.length; i++){
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }
    
    public static void Case2(){
        // fibonacci sequence
        // input = 6
        // output = 8
        // 0, 1, 1, 2, 3, 5 = 8
        
        int input = 7;
        int[] output = new int[input + 1];
        
        output[0] = 0;
        output[1] = 1;
        for(int i = 2; i < input + 1; i++){
            output[i] = output[i - 1] + output[i - 2];
            // System.out.println(i + ": " + output[i]);
        }
        
        System.out.println("Output = " + output[input]);
    }
    
    public static void Case3(){
        // intersection of 2 array
        // arr1 = [1, 2, 4, 7, 6, 4, 3]
        // arr2 = [4, 2, 5, 2, 3, 5]
        
        int[] arr1 = {4, 2, 5, 2, 3, 5};
        int[] arr2 = {1, 2, 4, 7, 6, 4, 3};
        ArrayList<Integer> dup = new ArrayList<Integer>();
        
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr2.length; j++){
                if(arr1[i] == arr2[j]){
                    dup.add(arr1[i]);
                    break;
                }
            }
        }
        
        for(int i = 0; i < dup.size(); i++){
            System.out.println(dup.get(i));
        }
    }
    
    public static void Case4(){
        // Anagram strings
        
        String str1 = "listen";
        String str2 = "silent";
        char[] str1arr = new char[str1.length()];
        char[] str2arr = new char[str2.length()];
        int check1 = 0;
        boolean check = false;
        
        for(int i = 0; i < str1.length(); i++){
            str1arr[i] = str1.charAt(i);
        }
        for(int i = 0; i < str2.length(); i++){
            str2arr[i] = str2.charAt(i);
        }
        
        for(int i = 0; i < str1arr.length; i++){
            for(int j = 0; j < str2arr.length; j++){
                if(str1arr[i] == str2arr[j]){
                    str1arr[i] = '-';
                    str2arr[j] = '-';
                    break;
                }
            }
        }
        
        for(int i = 0; i < str1arr.length; i++){
            for(int j = 0; j < str2arr.length; j++){
                if(str1arr[i] != '-' || str2arr[j] != '-'){
                    check1++;
                }
            }
        }
        
        if(check1 != 0){
            check = false;
        }
        else{
            check = true;
        }
        
        System.out.println(check);
    }
    
    public static void Case5(){
        // split into chunk of n character
        String str = "Hello, world! Nice to meet you!";
        int n = 4;
        char[] strarr = new char[str.length()];
        
        for(int i = 0; i < str.length(); i++){
            strarr[i] = str.charAt(i);
        }
        
        for(int i = 0; i < strarr.length; i+=n){
            
        }
    }
}
