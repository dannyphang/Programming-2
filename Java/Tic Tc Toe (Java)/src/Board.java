public class Board {
    private int boardNum = 1;
    char[] num = new char[9];
    
    public int getBoardNum() {
        return (boardNum - 1);
    }

    public void setBoardNum(int boardNum) {
        this.boardNum = boardNum;
    }
    
    public void displayBoard(){
        
        System.out.format("%s|%s|%s\n", num[6], num[7], num[8]);
        System.out.println("-----");
        System.out.format("%s|%s|%s\n", num[3], num[4], num[5]);
        System.out.println("-----");
        System.out.format("%s|%s|%s\n", num[0], num[1], num[2]);
        System.out.println(getBoardNum());
        
        
        if(num[getBoardNum()] == ' '){
            num[getBoardNum()] = '-';
        }
        else{
            num[getBoardNum()] = ' ';
        }
    }

    
    
}
