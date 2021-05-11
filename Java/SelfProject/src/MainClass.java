import java.util.*;

public class MainClass {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        displayUserMenu();
    }

    public static void logoDisplay(){
        clearScreen();
        System.out.println("  ,------.                                    ,-----,--.                                       ");
        System.out.println("  |  .-.  \\ ,--,--,--,--,,--,--,,--. ,--.    '  .--.`--,--,--, ,---.,--,--,--.,--,--,--.  ,--. ");
        System.out.println("  |  |  \\  ' ,-.  |      |      \\\\  '  /     |  |   ,--|      | .-. |        ' ,-.  |\\  `'  /  ");
        System.out.println("  |  '--'  \\ '-'  |  ||  |  ||  | \\   '      '  '--'|  |  ||  \\   --|  |  |  \\ '-'  |/  /.  \\  ");
        System.out.println("  `-------' `--`--`--''--`--''--.-'  /        `-----`--`--''--'`----`--`--`--'`--`--'--'  '--' ");
        System.out.println("                                `---'                                                          ");

    }

    public static void clearScreen(){
        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void displayUserMenu(){
        int menuValid;

        do{
            logoDisplay();
            menuValid = 0;
            String[] menuArray = {"[1] Login", "[2] Register", "[3] Exit"};

            for(int i = 0; i < menuArray.length; i++){
                System.out.println(menuArray[i]);
            }
            try {
                menuSelect();
            } catch (Exception e) {
                System.out.println(e);
                menuValid++;
            }
            
           
        }while(menuValid != 0);
        
    }

    public static void menuSelect() throws menuException{
        int menuOption;

        menuOption = in.nextInt();

        switch(menuOption){
            case(1):
            //go to login method
            break;
            case(2):
            //go to register method
            break;
            case(3):
                System.exit(0);
                System.out.println("why are you exits??");
            break;
            default:
                throw new menuException();
        }
    }

    
}

    