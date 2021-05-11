import java.util.*;

public class KickStart{
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        
        Round_A_2020_Problem_One();
        //Round_A_2020_roblem_Two();
        //Round_A_2020_Problem_Three();
        //Round_A_2020_Problem_Four();
        //Round_B_2020_Problem_One();
        // Round_B_2020_Problem_Two();
    
    }

    public static void Round_A_2020_Problem_One(){
        int T, N, budget, price, count;
        int[] priceArray;
        int[] houseCount;

        System.out.print("Number of test cases: ");
        T = in.nextInt();
        houseCount = new int[T];

        for(int i = 0; i < T; i++){
            count = 0;
            
            System.out.print("Number of house: ");
            N = in.nextInt();

            priceArray = new int[N];

            System.out.print("Budget: ");
            budget = in.nextInt();
            for(int j = 0; j < N; j++){
                price = in.nextInt();
                priceArray[j] = price;
                
            }
            Arrays.sort(priceArray);
            // for(int j = 0; j < N; j++){
            //     System.out.println(priceArray[j]);
            // }
            for(int j = 0; j < N; j++){
                if(priceArray[j] <= budget){
                    budget = budget - priceArray[j];
                    count++; // count = count + 1;
                }
                else{
                    break;
                }
            }
            houseCount[i] = count;
        }

        for(int i = 0; i < T; i++){
            System.out.println("Case #" + (i+1) + ": " + houseCount[i]);
        }
    }
    
    public static void Round_A_2020_Problem_Two(){
        int T, N, K, P;

        T = in.nextInt();

        for(int i = 0; i < T; i++){
            N = 0;
            K = 0;
            P = 0;

            N = in.nextInt();
            K = in.nextInt();
            P = in.nextInt();

            for(int j = 0; j < N; j++){
                for(int k = 0; k < K; k++){
                    
                }
            }
        }
    }

    public static void Round_A_2020_Problem_Three(){
        int T, N, K;
        int[] M;

        T = in.nextInt();

        for(int i = 0; i < T; i++){
            N = in.nextInt();
            K = in.nextInt();

            M = new int[N];
            
            for(int j = 0; j < N; j++){
                M[j] = in.nextInt();
            }

            for(int j = 0; j < N; j++){
                for(int l = 0; l+1 < N; l++){

                }
            }

        }
    }

    public static void Round_A_2020_Problem_Four(){
        int T, NN, K;
        char[][] wordArray;
        String words;
        char[] ch = new char[10000];
        

        System.out.print("T: ");
        T = in.nextInt();
        for(int i = 0; i < T; i++){
            System.out.print("N: ");
            NN = in.nextInt();
            wordArray = new char[NN][ch.length];
            // System.out.print("Number of string to compare: ");
            //K = in.nextInt();
            //wordArray = new char[N];
            for(int jj = 0; jj <= NN; jj++){

                words = in.nextLine();
                System.out.print(jj+1 + ": ");
                ch = words.toCharArray();
                //wordArray[jj][ch.length] = ch;
                
                
                
                
            }
            
            System.out.println();
            for(int iii = 0; iii < NN; iii++){
                for(int ii = 0; ii < ch.length; ii++) {
                    System.out.print(ch[ii] + " ");
                }
                System.out.println();
            }
            
        }
    }
    
    public static void Round_B_2020_Problem_One(){
        int T, N;
        int[] peaks;
        int[] checkpoints;
        T = in.nextInt();
        peaks = new int[T];
            
        for(int j = 0; j < T; j++){
            int peak = 0;
            
            N = in.nextInt();
            checkpoints = new int[N];
            
            for(int k = 1; k <= N; k++){
                checkpoints[k-1] = in.nextInt();
            }
            
            for(int i = 1; i < checkpoints.length - 1; i++) {
                if(checkpoints[i-1] < checkpoints[i] && checkpoints[i+1] < checkpoints[i]) {
                    peak++;
                }
            }
            peaks[j] = peak;
        }
        
        for(int i = 0; i < T; i++){
            System.out.println("Case #" + (i+1) + ": " + peaks[i]);
        }
    }
    
    public static void Round_B_2020_Problem_Two() {
        
    }
}