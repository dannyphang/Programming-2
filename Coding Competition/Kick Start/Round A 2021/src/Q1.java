import java.util.*;

public class Q1 {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        
        System.out.print("Test Case: ");
        int loop = in.nextInt();
        
        for(int i = 0; i < loop; i++) {
            System.out.print("N: ");
            int N = in.nextInt();
            
            System.out.print("K: ");
            int K = in.nextInt();
            
            //String[][] letterArray = new String[loop][N];
            int result2 = 0;
            
            
                
            System.out.print("Letters: ");
            String letter = in2.nextLine();
            int result = stringToChar(letter);
            
            if(result >= K){
                result2 = 0;
            }
            else{
                result2 = K - result;
            }
                
                
                
            
            System.out.println("Case #" + (i + 1) + ": " + result2);
        }
        
        
        
        
        
        in.close();
    }
    
    public static int stringToChar(String letter){
        char[] letterArr = new char[letter.length()];
        //int count = 0;
        int result = 0;
        
        for(int i = 0; i < letter.length(); i++){
            letterArr[i] = letter.charAt(i);
        }
        
        //if(letter.length() % 2 == 0){
            for(int i = 0; i < letterArr.length / 2; i++){
                if(letterArr[i] != letterArr[((letterArr.length - 1) - i)]){
                    result++;
                }
            }
        //}
        
        
        return result;
    }
}

