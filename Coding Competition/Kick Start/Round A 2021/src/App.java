import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        
        System.out.print("test Case: ");
        int loop = in.nextInt();
        
        for(int i = 0; i < loop; i++) {
            System.out.print("row: ");
            int R = in.nextInt();
            System.out.print("Boxes number: ");
            int C = in.nextInt();
            for(int j = 0; j < R; j++) {
                for(int k = 0; k < C; k++) {
                    System.out.print("Box: ");
                    int box = in.nextInt();
                }
            }
            
        }
        
        
        
        
        
        in.close();
    }
}
