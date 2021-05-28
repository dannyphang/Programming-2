package TestFile;

import java.util.Scanner;

public class testfile 
{
	public static void main(String args[]) 
	{
		Scanner in = new Scanner(System.in);
		String[][] board = {{" ", " ", " "},
							{" ", " ", " "},
							{" ", " ", " "}};
		int turns = 0;
		while(true) 
		{
			Scanner input1 = new Scanner(askForInput(in, board, 1));
			board[input1.nextInt()][input1.nextInt()] = "X";
			input1.close();
			turns++;
			
			printBoard(board);
			
			if(turns == 9 && !checkForWinner(board)) 
			{
				System.out.println("It's a Draw!");
				break;
			}
			if(checkForWinner(board)) 
			{
				System.out.println("Player 1 won!");
				break;
			}
									
			Scanner input2 = new Scanner(askForInput(in, board, 2));
			board[input2.nextInt()][input2.nextInt()] = "O";
			input2.close();
			turns++;
			
			printBoard(board);
					
			
			if(checkForWinner(board)) 
			{
				System.out.println("Player 2 won!");
				break;
			}
			
		}
		in.close();
	}

	public static boolean checkForWinner(String[][] board) 
	{
		for(int i = 0; i < board.length; i++) 
		{
			if((board[i][0] == "X" && board[i][1] == "X" && board[i][2] == "X") || 
			(board[i][0] == "O" && board[i][1] == "O" && board[i][2] == "O"))
				return true;				
		}
		for(int i = 0; i < board.length; i++) 
		{
			if((board[0][i] == "X" && board[1][i] == "X" && board[2][i] == "X") || 
			(board[0][i] == "O" && board[1][i] == "O" && board[2][i] == "O"))
				return true;		
		}
		if((board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X") || 
		(board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O"))
		{
			return true;
		}	
		if((board[0][2] == "X" && board[1][1] == "X" && board[2][0] == "X") || 
		(board[0][2] == "O" && board[1][1] == "O" && board[2][0] == "O"))
		{
			return true;
		}	
		return false;
	}

	public static String askForInput(Scanner in, String[][] board, int player) 
	{
		boolean bool = true;
		int prow = 0, pcolumn = 0;
		while(bool) 
		{
			System.out.print("Player " + player + " input row: ");
			prow = in.nextInt();
			while(true) 
			{
				if(prow > 2 || prow < 0)
				{
					System.out.println("INVALID, TRY AGAIN");
					in.nextLine();
					prow = in.nextInt();
				} else 
					break;			
			}
			System.out.print("Player " + player + " input col: ");
			pcolumn = in.nextInt();
			while(true) {
				if(pcolumn > 2 || pcolumn < 0) 
				{
					System.out.println("INVALID, TRY AGAIN");
					in.nextLine();
					pcolumn = in.nextInt();
				} else 
					break;			
			}
			if(board[prow][pcolumn] == " ")
			{
				bool = false;
			}
			if(board[prow][pcolumn] == "X" || board[prow][pcolumn] == "O" )
			{
				System.out.printf("[%d,%d] is already filled!\n",prow,pcolumn);	
			}	
		}	
        System.out.println(prow);	
		return prow + " " + pcolumn;
		// return String.valueOf(prow) + String.valueOf(pcolumn);
	}

	public static void printBoard(String[][] board) 
	{
		System.out.println();
		System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
		System.out.println();
	}
}


