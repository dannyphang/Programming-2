import java.util.*;


public class MainClass {
    
    static Scanner in = new Scanner(System.in);
    static Scanner in2 = new Scanner(System.in);
    static int back = 0;
    static int error = 0;
    public static void main(String[] args){
        
        String[] message = {"[1] Register", "[2] Login", "[E] Exit", "Enter your selection: "};
        String messageSelect;
        do{
            error = 0;
            back = 0;
            clearScreen();
            for(int messageLoop = 0; messageLoop < message.length; messageLoop++){
                if(messageLoop != (message.length - 1)){
                    System.out.println(message[messageLoop]);
                }
                else{
                    System.out.print(message[messageLoop]);
                }
            }
            
            messageSelect = in.nextLine();
            
            switch(messageSelect){
                case "1":
                    if(register() == null){
                        back++;
                    }
                    else{
                        System.out.println("Your registration is successfully!");
                        idle();
                        
                    }
                    break;
                case "2":
                    login();
                    // System.out.println("Here is login()");
                    
                    
                    break;
                case "e":
                case "E":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Your input is invalid!"); 
                    idle();
                    break;
            }
        }while(back != 0 || error == 0);
        
        
    }
    
    public static Customer register(){
        String[] message2 = {"Username: ", "Password: ", "[E] Exit", "The username is used, please try again!"};
        String[] answer = new String [2];
        boolean validInput;
        for(int messageLoop = 0; messageLoop < 2; messageLoop++){
            //error = 0;
            validInput = true;
            do{
                
                // clearScreen();
                
                if (!validInput){
                    System.out.println("Invalid message!");
                }
					
                    
                System.out.print(message2[messageLoop]);
                
                answer[messageLoop] = in2.nextLine();
                
                if(answer[messageLoop].equals("b") || answer[messageLoop].equals("B")){
                    
                    return null;
                }
                
                if(Customer.checkUser(answer[0]) == true){
                    System.out.println(message2[3]);
                    validInput = false;
                }
                else{
                    validInput = true;
                }
                
                
                
            }while(!validInput);
        }
        
        Customer newUser = new Customer(answer[0], answer[1]);
        Customer.registerCustomer(newUser);
        
        return newUser;
    }
    
    public static Customer login(){
        
        -
        
        return "666";
    }
    
    public static void clearScreen() {
        // for any console
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			System.out.println(e);
        }
        
        // for internalConsole
        // System.out.print("\033[H\033[2J");  
        // System.out.flush();  
    }
    
    public static void idle() {
        
        System.out.println("Press 'Enter' to continue!");
        in2.nextLine();
    }
}
