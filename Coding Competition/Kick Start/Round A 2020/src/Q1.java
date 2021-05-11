import java.util.*;

public class Q1{
    public static void Allocate(){
        Scanner in = new Scanner(System.in);
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
}