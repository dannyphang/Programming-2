import java.util.*;
import java.io.*;


public class App {
    static Scanner in = new Scanner(System.in);
    static Board bd = new Board();
    public static void main(String[] args) throws Exception {
        boolean continueLoop = true;
        
        for(int i = 0; i < 9; i++) {
            bd.num[i] = ' ';
        }
        
        while(continueLoop){
            bd.displayBoard();
            System.out.print("Player 1: ");
            P1();
            bd.displayBoard();
            System.out.print("Player 2: ");
            P2();
        }
        
        
        
        
        
        
        
        
        
        
        
    }
    
    public static void P1(){
        int num = 0;
        num = in.nextInt();
        bd.setBoardNum(num);
    }
    
    public static void P2(){
        int num = 0;
        num = in.nextInt();
        bd.setBoardNum(num);
    }
}
