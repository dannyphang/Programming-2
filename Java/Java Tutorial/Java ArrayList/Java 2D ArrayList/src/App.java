import java.util.*;

public class App {
    
    static Scanner in = new Scanner(System.in);
    static int errorMessage;
    public static void main(String[] args) throws Exception {
        ArrayList<ArrayList<String>> twoDimensionArrayLists = new ArrayList<ArrayList<String>>();
        
        ArrayList<String> firstList = new ArrayList<String>();
        ArrayList<String> secondList = new ArrayList<String>();
        ArrayList<String> thirdList = new ArrayList<String>();
        
        System.out.print("Enter the first array size: ");
        int firstArraySize = in.nextInt();
        
        // 1st ArrayList
        for(int loop = 1; loop <= firstArraySize; loop++){
            System.out.print("FirstList(" + loop + "): ");
            if(loop == 1){
                in.nextLine();
            }
            String firstItems = in.nextLine();
            
            firstList.add(firstItems);    
        }
        
        for(int i = 0; i < firstList.size(); i++){
            System.out.print("FirstList(" + i + "): ");
            System.out.println(firstList.get(i));
        }
        
        System.out.println("----------------------------");
        
        // 2nd ArrayList
        System.out.print("Enter the second array size: ");
        int secondArraySize = in.nextInt();
        
        for(int loop = 1; loop <= secondArraySize; loop++){
            System.out.print("SecondList(" + loop + "): ");
            if(loop == 1){
                in.nextLine();
            }
            String secondItems = in.nextLine();
            
            secondList.add(secondItems);    
        }
        
        for(int i = 0; i < secondList.size(); i++){
            System.out.print("SecondList(" + i + "): ");
            System.out.println(secondList.get(i));
        }
        
        System.out.println("----------------------------");
        
        // 3rd ArrayList
        System.out.print("Enter the third array size: ");
        int thirdArraySize = in.nextInt();
        
        for(int loop = 1; loop <= thirdArraySize; loop++){
            System.out.print("ThirdList(" + loop + "): ");
            if(loop == 1){
                in.nextLine();
            }
            String thirdItems = in.nextLine();
            
            thirdList.add(thirdItems);    
        }
        
        for(int i = 0; i < thirdList.size(); i++){
            System.out.print("ThirdList(" + i + "): ");
            System.out.println(thirdList.get(i));
        }
        
        System.out.println("----------------------------");
        
        // add all the arrayList into an arrayList
        twoDimensionArrayLists.add(firstList);
        twoDimensionArrayLists.add(secondList);
        twoDimensionArrayLists.add(thirdList);
        
        // display the 2d ArrayList
        System.out.print("Enter the Array List Number: ");
        int arrayNum = in.nextInt() - 1;
        System.out.print("Enter the data number: ");
        int arrayNumber2 = in.nextInt() - 1;
        
        System.out.println(twoDimensionArrayLists.get(arrayNum).get(arrayNumber2));
        
    }
}
