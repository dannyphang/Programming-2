import java.util.*;

public class Main {
    
    static Scanner in = new Scanner(System.in);
    static Scanner in2 = new Scanner(System.in);
    
    final static String TopLeft = "\u256D";
    final static String TopRight = "\u256E";
    final static String BottomRight = "\u256F";
    final static String BottomLeft= "\u2570";
    final static String Horizontal = "\u2500";
    final static String Vertical = "\u2502";
    final static String Blanks = "\u2591";
    final static String Full = "\u0058";
    final static String screen = "\u2588";
    final static String BlankSpace = Vertical + Blanks + Blanks + Blanks + Vertical;
    final static String FullSpace = Vertical + Full + Full + Full + Vertical;
    final static String BottomLine = BottomLeft + Horizontal + Horizontal + Horizontal + BottomRight;
    final static String invalidInputMessage = "Invalid Input! Please try again!\n";
    
    public static void main(String[] args){
        int error = 0, error2 = 0;
        boolean keepLooping = true;
        char movieSelect, timeSelect, classSelect, categorySelect, seatYSelect = '0';
        int Movie = 0, Time = 0, Seat = 0;
        
        int[][][] seat = new int[3][5][30];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 30; k++){
                    seat[i][j][k] = 0;
                }
            }
        }
        
        int[][] seatAvailable = new int[3][5];
        for(int i = 0; i < seatAvailable.length; i++){
            for(int j = 0; j < seatAvailable[i].length; j++){
                seatAvailable[i][j] = SeatAvailable(seat, Movie, Time);
            }
        }
        
        // start!!
        do{
            int av = 0, cv = 0, sv = 0;
            int ab = 0, cb = 0, sb = 0;
            int af = 0, cf = 0, sf = 0;
            // Select Movie
            do{
                Logo();
                if(error != 0){
                    System.out.println(StringFormat.Space() + invalidInputMessage);
                }
                error = 0;
                
                MovieMenu();
                movieSelect = in.next().charAt(0);
                
                switch(movieSelect){
                    case '1':
                        Movie = 0;
                        break;
                    case '2':
                        Movie = 1;
                        break;
                    case '3':
                        Movie = 2;
                        break;
                    case '4':
                        Movie = 3;
                        break;
                    default:
                        error++;
                }
                
            } while(error != 0);
            
            // Select time
            do{
                
                Logo();
                if(error != 0){
                    System.out.println(StringFormat.Space() + invalidInputMessage);
                    error = 0;
                }
                if(error2 != 0){
                    System.out.println(StringFormat.Space() + "The movie (" + MovieName(Movie) + ", " + TimeName(Time) + ") is full now.");
                    error2 = 0;
                }
                
                TimeMenu();
                timeSelect = in.next().charAt(0);
                if(seatAvailable[Movie][Time] == 30){
                    error2++;
                }
                switch(timeSelect){
                    case '1':
                        Time = 0;
                        break;
                    case '2':
                        Time = 1;
                        break;
                    case '3':
                        Time = 2;
                        break;
                    case '4':
                        Time = 3;
                        break;
                    case '5':
                        Time = 4;
                        break;
                    default:
                        error++;
                }
                
                
            }while(error != 0 || error2 != 0);
                
            do
            {
                // Select Seat
                do{
                    Logo();
                    SeatTable();
                    
                    // display seat
                    SeatMenu(seat, Movie, Time);
                    
                    String SeatAvailable = "Seat Available: ";
                    System.out.print(StringFormat.Space() + TopLeft);
                    for(int i = 0; i < 20; i++){
                        System.out.print(Horizontal);
                    }
                    System.out.println(TopRight);
                    
                    System.out.format(StringFormat.Space() + "%s%s%3d%2s\n", Vertical, SeatAvailable, (30 - SeatAvailable(seat, Movie, Time)), Vertical);
                    
                    System.out.print(StringFormat.Space() + BottomLeft);
                    
                    for(int i = 0; i < 20; i++){
                        System.out.print(Horizontal);
                    }
                    System.out.println(BottomRight);
                    // select class
                    do{
                        if(error != 0){
                            System.out.println(StringFormat.Space() + invalidInputMessage);
                            error = 0;
                        }
                        error = 0;
                        ClassMenu();
                        classSelect = in.next().charAt(0);
                        
                        if(classSelect != '1' && classSelect != '2' && classSelect != '3'){
                            error++;
                        }
                        
                    }while(error != 0);
                    
                    error = 0;
                    error2 = 0;
                    
                    // Enter seat
                    do{
                        if(error != 0){
                            System.out.println(StringFormat.Space() + invalidInputMessage);
                        }
                        error = 0;
                        
                        System.out.println(StringFormat.Space() + "[N] Procceed to next page!");
                        System.out.println(StringFormat.Space() + "[E] Exit!");
                        System.out.print(StringFormat.Space() + "Please enter your seat: ");
                        seatYSelect = in.next().charAt(0);
                        
                        if(seatYSelect == 'n' || seatYSelect == 'N'){
                            keepLooping = false;
                        }
                        else if(seatYSelect == 'e' || seatYSelect == 'E'){
                            System.exit(0);
                        }
                        else{
                            // validate input
                            if(seatYSelect < '0' || seatYSelect > '9'){
                                error++;
                            }
                            else{
                                Seat = returnNumber(classSelect, seatYSelect);
                                
                                if(seat[Movie][Time][Seat] != 1){
                                    seat[Movie][Time][Seat] = 1;
                                    
                                    // select seat for different categories
                                    do{
                                        if(error != 0){
                                            System.out.println(StringFormat.Space() + invalidInputMessage);
                                            error = 0;
                                        }
                                        Logo();
                                        CategoryMenu();
                                        categorySelect = in.next().charAt(0);
                                        if(categorySelect == '1'){
                                            switch(classSelect){
                                                case '3':
                                                    av++;
                                                    break;
                                                case '2':
                                                    ab++;
                                                    break;
                                                case '1':
                                                    af++;
                                                    break;
                                            }
                                        }
                                        else if(categorySelect == '2'){
                                            switch(classSelect){
                                                case '3':
                                                    cv++;
                                                    break;
                                                case '2':
                                                    cb++;
                                                    break;
                                                case '1':
                                                    cf++;
                                                    break;
                                            }
                                        }
                                        else if(categorySelect == '3'){
                                            switch(classSelect){
                                                case '3':
                                                    sv++;
                                                    break;
                                                case '2':
                                                    sb++;
                                                    break;
                                                case '1':
                                                    sf++;
                                                    break;
                                            }
                                        }
                                        else{
                                            error++;
                                        }
                                    }while(error != 0);
                                }
                                else{
                                    // seat is selected
                                    error2++;
                                } 
                            }
                        }
                    }while(error != 0);
                    
                    // continue?
                    do{
                        // Logo();
                        if(error2 != 0){
                            System.out.println(StringFormat.Space() + "\nSeat is selected! Please try again!\n");
                        }
                        error2 = 0;
                        if(error != 0){
                            System.out.println(StringFormat.Space() + invalidInputMessage);
                            error = 0;
                        }
                        
                        System.out.println(StringFormat.Space() + "Do you want to continue to buy the ticket?");
                        System.out.println(StringFormat.Space() + "[Y] Yes");
                        System.out.println(StringFormat.Space() + "[N] No");
                        System.out.print(StringFormat.Space() + "Answer: ");
                        char yesno = in.next().charAt(0);
                        if(yesno == 'y' || yesno == 'Y'){
                            keepLooping = true;
                        }
                        else if(yesno == 'n' || yesno == 'N'){
                            keepLooping = false;
                        }
                        else{
                            error++;
                        }
                    }while(error != 0);
                        
                }while(error != 0 || error2 != 0 || keepLooping == true);
                
                // payment
                Logo();
                Payment(av, ab, af, cv, cb, cf, sv, sb, sf);
                idle();
                
                // print ticket
                Logo();
                TicketPrint(av, ab, af, cv, cb, cf, sv, sb, sf, Time, Movie);
                SeatMenu(seat, Movie, Time);
                
                do{
                    if(error != 0){
                        System.out.println(StringFormat.Space() + invalidInputMessage);
                    }
                    error = 0;
                    System.out.println(StringFormat.Space() + "Do you want to continue buying?");
                    System.out.println(StringFormat.Space() + "[Y] Yes!");
                    System.out.println(StringFormat.Space() + "[N] No...");
                    System.out.println(StringFormat.Space() + "[E] Exit");
                    System.out.print(StringFormat.Space() + "Answer: ");
                    char yesno = in.next().charAt(0);
                    
                    if(yesno == 'y' || yesno == 'Y'){
                        keepLooping = true;
                    }
                    else if(yesno == 'n' || yesno == 'N'){
                        keepLooping = false;
                    }
                    else if(yesno == 'e' || yesno == 'E'){
                        System.exit(0);
                    }
                    else{
                        error++;
                    }
                }while(error != 0);
            }while(keepLooping == true);
            
            // print report
            Logo();
            ReportPrint(av, ab, af, cv, cb, cf, sv, sb, sf, Time, Movie);
            idle();
            
            do{
                Logo();
                if(error != 0){
                    System.out.println(StringFormat.Space() + invalidInputMessage);
                }
                error = 0;
                System.out.println(StringFormat.Space() + "Do you want to continue as a new Customer?");
                System.out.println(StringFormat.Space() + "[Y] Yes");
                System.out.println(StringFormat.Space() + "[N] No");
                System.out.print(StringFormat.Space() + "Answer: ");
                
                char yesno = in.next().charAt(0);
                
                if(yesno == 'y' || yesno == 'Y'){
                    keepLooping = true;
                }
                else if(yesno == 'n' || yesno == 'N'){
                    keepLooping = false;
                }
                else{
                    error++;
                }
            }while(error != 0);
        }while(keepLooping == true);
        in.close();
    }
    
    public static void MovieMenu(){
        String[] MovieMenu = {"[1] Avenger 4: EndGame", "[2] Frozen II", "[3] Ip Man", "[4] Justic League"};
        StringFormat.FormatString(MovieMenu);
        System.out.print(StringFormat.Space() + "Please enter your selection: ");
    }
    
    public static String MovieName(int Movie){
        String name = "";
        if(Movie == 0){
            name = "Avenger 4: EndGame";
        }
        else if(Movie == 1){
            name = "Frozen II";
        }
        else if(Movie == 2){
            name = "Ip Man";
        }
        else if(Movie == 3){
            name = "Justic League";
        }
        return name;
    } 
    
    public static void TimeMenu() {
        String[] TimeMenu = {"[1] 10.00 AM", "[2] 3.00 PM", "[3] 5.00 PM", "[4] 8.00 PM", "[5] 10.00 PM"};
        StringFormat.FormatString(TimeMenu);
        System.out.print(StringFormat.Space() + "Please enter your selection: ");
    }
    
    public static String TimeName(int Time){
        String time = "";
        if(Time == 0){
            time = "10.00 AM";
        }
        else if(Time == 1){
            time = "3.00 PM";
        }
        else if(Time == 2){
            time = "5.00 PM";
        }
        else if(Time == 3){
            time = "8.00 PM";
        }
        else if(Time == 4){
            time = "10.00 PM";
        }
        return time;
    }
    
    public static void ClassMenu(){
        String[] ClassMenu = {"[1] Front", "[2] Back", "[3] Vip"};
        StringFormat.FormatString(ClassMenu);
        System.out.print(StringFormat.Space() + "Please enter your selection: ");
    }
    
    public static void CategoryMenu(){
        String[] CategoryMenu = {"[1] Adult", "[2] Child", "[3] Student"};
        StringFormat.FormatString(CategoryMenu);
        System.out.print(StringFormat.Space() + "Please enter your selection: ");
    }
    
    public static void SeatMenu(int[][][] seat, int Movie, int Time){
        // display seat
        SeatTable();
        
        // Display Screen
        System.out.print("\n  ");
        StringFormat.Space2();
        for(int i = 0; i < 50; i++){
            System.out.print(screen);
        }
        System.out.println("\n");
        
        // display seat
        for(int i = 0; i <= 29; i++){
            switch(i){
                case 0:
                    System.out.print(StringFormat.Space2() + "1\u2503");
                    break;
                case 10:
                    System.out.print(StringFormat.Space2() + "2\u2503");
                    break;
                case 20:
                    System.out.print(StringFormat.Space2() + "3\u2503");
                    break;
            }
            // change seat icon
            if(seat[Movie][Time][i] == 0){
                System.out.print(BlankSpace);
            }
            else if(seat[Movie][Time][i] == 1){
                System.out.print(FullSpace);
            }
            
            switch(i){
                case 9:
                    System.out.print("\u2503\n ");
                    StringFormat.Space2();
                    bottomLine();
                    break;
                case 19:
                    System.out.print("\u2503\n ");
                    StringFormat.Space2();
                    bottomLine();
                    break;
                case 29:
                    System.out.print("\u2503\n ");
                    StringFormat.Space2();
                    bottomLine();
                    break;
            }
        }
        
        System.out.print(StringFormat.Space2() + " \u2517");
        for(int i = 0; i < 50; i++){
            System.out.print("\u2501");
        }
        System.out.print("\u251B\n" + StringFormat.Space2());
        for(int i = 0; i <= 9; i++){
            System.out.print("    " + i);
        }
        System.out.println();
    }
    
    public static void SeatTable(){
        
    }
    
    public static void Payment(int av, int ab, int af, int cv, int cb, int cf, int sv, int sb, int sf){
        int adult = 1, child = 2, student = 3, vip = 4, back = 5, front = 6, totalpay = 0, error = 0, cashPayment = 0;
        
        do{
            if(error != 0){
                System.out.println(StringFormat.Space() + "Your payment amount is not enought!!");
                error = 0;
            }
            System.out.print(StringFormat.Space() + TopLeft);
            for(int i = 0; i < 67; i++){
                System.out.print(Horizontal);
            }
            System.out.println(TopRight);
            System.out.println(StringFormat.Space() + Vertical + "                                                                   " + Vertical);
            
            if(av != 0){
                System.out.format(StringFormat.Space() + "%-6sNumber of Adult (VIP)     = %2d @ RM %4d.00 = RM %5d.00 %5s\n", Vertical, av, TicketPrice(adult, vip), (av * TicketPrice(adult, vip)), Vertical);
                System.out.println(StringFormat.Space() + Vertical + "                                                                   " + Vertical);
            }
            if(cv != 0){
                System.out.format(StringFormat.Space() + "%-6sNumber of Child (VIP)     = %2d @ RM %4d.00 = RM %5d.00 %5s\n", Vertical, cv, TicketPrice(child, vip), (cv * TicketPrice(child, vip)), Vertical);
                System.out.println(StringFormat.Space() + Vertical + "                                                                   " + Vertical);
            }
            if(sv != 0){
                System.out.format(StringFormat.Space() + "%-6sNumber of Student (VIP)   = %2d @ RM %4d.00 = RM %5d.00 %5s\n", Vertical, sv, TicketPrice(student, vip), (sv * TicketPrice(student, vip)), Vertical);
                System.out.println(StringFormat.Space() + Vertical + "                                                                   " + Vertical);
            }
            if(ab != 0){
                System.out.format(StringFormat.Space() + "%-6sNumber of Adult (Back)    = %2d @ RM %4d.00 = RM %5d.00 %5s\n", Vertical, ab, TicketPrice(adult, back), (ab * TicketPrice(adult, back)), Vertical);
                System.out.println(StringFormat.Space() + Vertical + "                                                                   " + Vertical);
            }
            if(cb != 0){
                System.out.format(StringFormat.Space() + "%-6sNumber of Child (Back)    = %2d @ RM %4d.00 = RM %5d.00 %5s\n", Vertical, cb, TicketPrice(child, back), (cb * TicketPrice(child, back)), Vertical);
                System.out.println(StringFormat.Space() + Vertical + "                                                                   " + Vertical);
            }
            if(sb != 0){
                System.out.format(StringFormat.Space() + "%-6sNumber of Student (Back)  = %2d @ RM %4d.00 = RM %5d.00 %5s\n", Vertical, sb, TicketPrice(student, back), (sb * TicketPrice(student, back)), Vertical);
                System.out.println(StringFormat.Space() + Vertical + "                                                                   " + Vertical);
            }
            if(af != 0){
                System.out.format(StringFormat.Space() + "%-6sNumber of Adult (Front)   = %2d @ RM %4d.00 = RM %5d.00 %5s\n", Vertical, af, TicketPrice(adult, front), (af * TicketPrice(adult, front)), Vertical);
                System.out.println(StringFormat.Space() + Vertical + "                                                                   " + Vertical);
            }
            if(cf != 0){
                System.out.format(StringFormat.Space() + "%-6sNumber of Child (Front)   = %2d @ RM %4d.00 = RM %5d.00 %5s\n", Vertical, cf, TicketPrice(child, front), (cf * TicketPrice(child, front)), Vertical);
                System.out.println(StringFormat.Space() + Vertical + "                                                                   " + Vertical);
            }
            if(sf != 0){
                System.out.format(StringFormat.Space() + "%-6sNumber of Student (Front) = %2d @ RM %4d.00 = RM %5d.00 %5s\n", Vertical, sf, TicketPrice(student, front), (sf * TicketPrice(student, front)), Vertical);
                System.out.println(StringFormat.Space() + Vertical + "                                                                   " + Vertical);
            }
            
            totalpay = (av * TicketPrice(adult, vip)) + (cv * TicketPrice(child, vip)) + (sv * TicketPrice(student, vip)) + 
                        (ab * TicketPrice(adult, back)) + (cb * TicketPrice(child, back)) + (sb * TicketPrice(student, back)) + 
                        (af * TicketPrice(adult, front)) + (cf * TicketPrice(child, front)) + (sf * TicketPrice(student, front));
            
            System.out.format(StringFormat.Space() + "%-12s Total to pay =                         RM %5d.00 %5s\n", Vertical, totalpay, Vertical);
            System.out.println(StringFormat.Space() + Vertical + "                                                                   " + Vertical);
            
            System.out.print(StringFormat.Space() + BottomLeft);
            for(int i = 0; i < 67; i++){
                System.out.print(Horizontal);
            }
            System.out.println(BottomRight);
            
            error = 0;
            System.out.print(StringFormat.Space() + "Cash Payment: ");
            cashPayment = in.nextInt();
            if(cashPayment < totalpay){
                error++;
            }
        }while(error != 0);
        
        System.out.print(StringFormat.Space() + TopLeft);
        for(int i = 0; i < 60; i++){
            System.out.print(Horizontal);
        }
        System.out.println(TopRight);
        
        System.out.println(StringFormat.Space() + Vertical + "                                                            " + Vertical);
        System.out.format(StringFormat.Space() + "%-5s Cash Payment =                         RM %5d.00 %5s\n", Vertical, cashPayment, Vertical);
        System.out.format(StringFormat.Space() + "%-5s Change Due   =                         RM %5d.00 %5s\n", Vertical, (cashPayment - totalpay), Vertical);
        System.out.println(StringFormat.Space() + Vertical + "                                                            " + Vertical);
        
        System.out.print(StringFormat.Space() + BottomLeft);
        for(int i = 0; i < 60; i++){
            System.out.print(Horizontal);
        }
        System.out.println(BottomRight);
    }
    
    public static int TicketPrice(int categories, int class1){
        int price = 0;
        
        if(categories == 1 && class1 == 4){
            price = 20;
        }
        else if(categories == 2 && class1 == 4){
            price = 10;
        }
        else if(categories == 3 && class1 == 4){
            price = 12;
        }
        else if(categories == 1 && class1 == 5){
            price = 18;
        }
        else if(categories == 2 && class1 == 5){
            price = 8;
        }
        else if(categories == 3 && class1 == 5){
            price = 10;
        }
        else if(categories == 1 && class1 == 6){
            price = 16;
        }
        else if(categories == 2 && class1 == 6){
            price = 6;
        }
        else if(categories == 3 && class1 == 6){
            price = 8;
        }
        return price;
    }
    
    public static void TicketPrint(int av, int ab, int af, int cv, int cb, int cf, int sv, int sb, int sf, int Time, int Movie) {
        for(int i = 0; i < av; i++){
            System.out.print(StringFormat.Space2() + TopLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(TopRight);
            
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Danny Cinemax Ticket           %-20s %4s\n", Vertical, TicketPrint2("av"), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Movie       =              %11s %10s\n", Vertical, MovieName(Movie), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Date / Time =    Friday 22-11-2020 (%8s) %10s\n", Vertical, TimeName(Time), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            
            System.out.print(StringFormat.Space2() + BottomLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(BottomRight);
        }
        for(int i = 0; i < ab; i++){
            System.out.print(StringFormat.Space2() + TopLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(TopRight);
            
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Danny Cinemax Ticket           %-20s %4s\n", Vertical, TicketPrint2("ab"), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Movie       =              %11s %10s\n", Vertical, MovieName(Movie), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Date / Time =    Friday 22-11-2020 (%8s) %10s\n", Vertical, TimeName(Time), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            
            System.out.print(StringFormat.Space2() + BottomLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(BottomRight);
        }
        for(int i = 0; i < af; i++){
            System.out.print(StringFormat.Space2() + TopLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(TopRight);
            
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Danny Cinemax Ticket           %-20s %4s\n", Vertical, TicketPrint2("af"), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Movie       =              %11s %10s\n", Vertical, MovieName(Movie), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Date / Time =    Friday 22-11-2020 (%8s) %10s\n", Vertical, TimeName(Time), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            
            System.out.print(StringFormat.Space2() + BottomLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(BottomRight);
        }
        for(int i = 0; i < cv; i++){
            System.out.print(StringFormat.Space2() + TopLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(TopRight);
            
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Danny Cinemax Ticket           %-20s %4s\n", Vertical, TicketPrint2("cv"), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Movie       =              %11s %10s\n", Vertical, MovieName(Movie), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Date / Time =    Friday 22-11-2020 (%8s) %10s\n", Vertical, TimeName(Time), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            
            System.out.print(StringFormat.Space2() + BottomLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(BottomRight);
        }
        for(int i = 0; i < cb; i++){
            System.out.print(StringFormat.Space2() + TopLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(TopRight);
            
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Danny Cinemax Ticket           %-20s %4s\n", Vertical, TicketPrint2("cb"), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Movie       =              %11s %10s\n", Vertical, MovieName(Movie), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Date / Time =    Friday 22-11-2020 (%8s) %10s\n", Vertical, TimeName(Time), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            
            System.out.print(StringFormat.Space2() + BottomLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(BottomRight);
        }
        for(int i = 0; i < cf; i++){
            System.out.print(StringFormat.Space2() + TopLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(TopRight);
            
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Danny Cinemax Ticket           %-20s %4s\n", Vertical, TicketPrint2("cf"), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Movie       =              %11s %10s\n", Vertical, MovieName(Movie), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Date / Time =    Friday 22-11-2020 (%8s) %10s\n", Vertical, TimeName(Time), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            
            System.out.print(StringFormat.Space2() + BottomLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(BottomRight);
        }
        for(int i = 0; i < sv; i++){
            System.out.print(StringFormat.Space2() + TopLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(TopRight);
            
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Danny Cinemax Ticket           %-20s %4s\n", Vertical, TicketPrint2("sv"), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Movie       =              %11s %10s\n", Vertical, MovieName(Movie), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Date / Time =    Friday 22-11-2020 (%8s) %10s\n", Vertical, TimeName(Time), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            
            System.out.print(StringFormat.Space2() + BottomLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(BottomRight);
        }
        for(int i = 0; i < sb; i++){
            System.out.print(StringFormat.Space2() + TopLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(TopRight);
            
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Danny Cinemax Ticket           %-20s %4s\n", Vertical, TicketPrint2("sb"), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Movie       =              %11s %10s\n", Vertical, MovieName(Movie), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Date / Time =    Friday 22-11-2020 (%8s) %10s\n", Vertical, TimeName(Time), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            
            System.out.print(StringFormat.Space2() + BottomLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(BottomRight);
        }
        for(int i = 0; i < sf; i++){
            System.out.print(StringFormat.Space2() + TopLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(TopRight);
            
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Danny Cinemax Ticket           %-20s %4s\n", Vertical, TicketPrint2("sf"), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + "%-5s Movie       =              %11s %10s\n", Vertical, MovieName(Movie), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            System.out.format(StringFormat.Space2() + StringFormat.Space2() + "%-5s Date / Time =    Friday 22-11-2020 (%8s) %10s\n", Vertical, TimeName(Time), Vertical);
            System.out.println(StringFormat.Space2() + Vertical + "                                                            " + Vertical);
            
            System.out.print(StringFormat.Space2() + BottomLeft);
            for(int j = 0; j < 60; j++){
                System.out.print(Horizontal);
            }
            System.out.println(BottomRight);
        }
    }
    
    public static String TicketPrint2(String category){
        String name = "";
        if(category == "av"){
            name = "Adult - Class 1";
        }
        else if(category == "ab"){
            name = "Adult - Class 2";
        }
        else if(category == "af"){
            name = "Adult - Class 3";
        }
        else if(category == "cv"){
            name = "Child - Class 1";
        }
        else if(category == "cb"){
            name = "Child - Class 2";
        }
        else if(category == "cf"){
            name = "Child - Class 3";
        }
        else if(category == "sv"){
            name = "Student - Class 1";
        }
        else if(category == "sb"){
            name = "Student - Class 2";
        }
        else if(category == "sf"){
            name = "Student - Class 3";
        }
        return name;
    }
    
    public static void ReportPrint(int av, int ab, int af, int cv, int cb, int cf, int sv, int sb, int sf, int Time, int Movie){
        int vip = av + cv + sv;
        int back = ab + cb + sb;
        int front = af + cf + sf;
        
        int adult = av + ab + af;
        int child = cv + cb + cf;
        int student = sv + sf + sb;
        
        int adult2 = 1, child2 = 2, student2 = 3, vip2 = 4, back2 = 5, front2 = 6;
        
        double vp = (vip * 100) / 10;
        double bp = (back * 100) / 10;
        double fp = (front * 100) / 10;
        double tp = (vip + back + front) * 100 / 30;
        
        int tavp = TicketPrice(adult2, vip2) * av;
        int tabp = TicketPrice(adult2, back2) * ab;
        int tafp = TicketPrice(adult2, front2) * af;
        int tcvp = TicketPrice(child2, vip2) * cv;
        int tcbp = TicketPrice(child2, back2) * cb;
        int tcfp = TicketPrice(child2, front2) * cf;
        int tsvp = TicketPrice(student2, vip2) * sv;
        int tsbp = TicketPrice(student2, back2) * sb;
        int tsfp = TicketPrice(student2, front2) * sf;
        int ttp = tavp + tafp + tabp + tcvp + tcbp + tcfp + tsvp + tsbp + tsfp;
        String[] ticketTitle = {"   Ticket Sales Report"};
        StringFormat.FormatString(ticketTitle);
        
        System.out.println();
        System.out.format(StringFormat.Space2() + "Movie Title:      %s\n\n", MovieName(Movie));
        System.out.format(StringFormat.Space2() + "Date / Time:      Friday 22-11-2019 (%s)\n\n", TimeName(Movie));
        System.out.println(StringFormat.Space2() + "Seat Occupancy For Each Class:\n");
        System.out.println(StringFormat.Space2() + "         Total Seats   Quantity Sold    Sold %");
        System.out.format(StringFormat.Space2() + "Class 1     %3d %15d%13.0f\n", 10, vip, vp);
        System.out.format(StringFormat.Space2() + "Class 2     %3d %15d%13.0f\n", 10, back, bp);
        System.out.format(StringFormat.Space2() + "Class 3     %3d %15d%13.0f\n", 10, front, fp);
        System.out.format(StringFormat.Space2() + "           ------          ------      --------\n");
        System.out.format(StringFormat.Space2() + "Overall     %3d %15d%13.0f\n\n", 30, (vip + back + front), tp);
        System.out.println(StringFormat.Space2() + "Sales For Each Category Type\n");
        System.out.println(StringFormat.Space2() + "         Category     Seats    Sales (RM)");
        System.out.format(StringFormat.Space2() + "            Adult     %3d %10d.00\n", adult, (tavp + tabp + tafp));
        System.out.format(StringFormat.Space2() + "            Child     %3d %10d.00\n", child, (tcvp + tcbp + tcfp));
        System.out.format(StringFormat.Space2() + "          Student     %3d %10d.00\n", student, (tsvp + tsbp + tsfp));
        System.out.format(StringFormat.Space2() + "                     ------    ----------\n");
        System.out.format(StringFormat.Space2() + "            Total     %3d %10d.00\n", (adult + child + student), ttp);
    }
    
    public static int SeatAvailable(int[][][] seat, int Movie, int Time){
        int seatCount = 0;
        
        for(int k = 0; k < 30; k++){
            if(seat[Movie][Time][k] == 1){
                seatCount++;
            }
        }
        
        return seatCount;
    }
    
    public static int returnNumber(char classSelect, char seatYSelect){
        int x = 0, y = 0;
        int number2 = (int)seatYSelect - 48;
        int number3 = (int)classSelect - 48;
        
        for(int i = 1; i <= 3; i++){
            if(i == number3){
                x = (i - 1) * 10;
            }
        }
        for(int i = 0; i <= 9; i++){
            if(i == number2){
                y = i;
            }
        }
        return x + y;
    }
    
    public static void bottomLine(){
        System.out.print("\u2503");
        for(int i = 0; i < 10; i++){
            System.out.print(BottomLine);
        }
        System.out.println("\u2503");
    }
    
    public static void Logo(){
        ClearScreen();
        
        String[] logo = {"   ____                            ", 
                         "  |  _ \\  __ _ _ __  _ __  _   _   ", 
                         "  | | | |/ _` | '_ \\| '_ \\| | | |  ", 
                         "  | |_| | (_| | | | | | | | |_| |  ", 
                         "  |____/ \\__,_|_| |_|_| |_|\\__, |  ", 
                         "                           |___/   "};
                         
        StringFormat.formatMenu(logo);
    }
    
    public static void ClearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void idle(){
        System.out.print(StringFormat.Space() + "Press [Enter] to continue...");
        in2.nextLine();
    }
}