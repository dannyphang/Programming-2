import java.util.*;

public class App {
    static Scanner in = new Scanner(System.in);
    static int errorMessage;
    public static void main(String[] args) throws Exception {
        ArrayList<String> itemList = new ArrayList<String>();
        String items;
        
        System.out.print("Enter an array size: ");
        int arraySize = in.nextInt();
        
        // add items into the Array List
        for(int loop = 1; loop <= arraySize; loop++){
            System.out.print("List(" + loop + "): ");
            if(loop == 1){
                in.nextLine();
            }
            items = in.nextLine();
            
            itemList.add(items);    
        }
        
        for(int i = 0; i < itemList.size(); i++){
            System.out.print("List(" + i + "): ");
            System.out.println(itemList.get(i));
        }
        
        System.out.println("----------------------------");
        
        // '.set' is to set a data to replace thee original data
        System.out.print("Enter a list number to replace the data: ");
        int listNum = in.nextInt() - 1;
        System.out.print("Enter the data: ");
        in.nextLine();
        String listData = in.nextLine();
        itemList.set(listNum, listData);    
        
        for(int i = 0; i < itemList.size(); i++){
            System.out.print("List(" + i + "): ");
            System.out.println(itemList.get(i));
        }
        
        System.out.println("----------------------------");
        
        // .remove is to remove the data from the list
        System.out.print("Enter a list number to remove the data: ");
        int listRemove = in.nextInt() - 1;
        itemList.remove(listRemove);
        
        for(int i = 0; i < itemList.size(); i++){
            System.out.print("List(" + i + "): ");
            System.out.println(itemList.get(i));
        }
        
        System.out.println("----------------------------");
        
        // .clear is to clear all the data from the list
        System.out.print("Do you want to clear the list?\n[Y] Yes\n[N] No\nAnswer: ");
        char answer = in.next().charAt(0);
        if(answer == 'y' || answer == 'Y'){
            itemList.clear();
        }
        for(int i = 0; i < itemList.size(); i++){
            System.out.print("List(" + i + "): ");
            System.out.println(itemList.get(i));
        }
        
        System.out.println("----------------------------");
    }
}
