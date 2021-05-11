#include<iostream>
#include<ctime>
#include<cstdlib>
#include<iomanip>
#include<conio.h>
#include<windows.h>
using namespace std;

HANDLE console = GetStdHandle(STD_OUTPUT_HANDLE);

int board[4][4];
int dir_line[] = { 1, 0, -1, 0};
int dir_column[] = {0, 1, 0, -1};

void logo() {
	cout << endl;
	cout << "                                                ###     ###    #  #    ####	\n";
	cout << "                                               #   #   #   #   #  #   #    #  \n";
	cout << "                                                 ##   #     #  #####  ######	\n";
	cout << "                                                #      #   #      #   #    #  \n";
	cout << "                                               #####    ###       #    ####   \n";
	cout << "                                              ";
	for (int a = 0; a <= 30; a++)
	{
		cout << "=";
	}
	cout << endl;
	cout << "                                              ";
	for (int a = 0; a <= 30; a++)
	{
		cout << "=";
	}
	cout << endl << endl;

}

void setcursor(bool visible, DWORD size) // set bool visible = 0 - invisible, bool visible = 1 - visible
{
	if (size == 0)
	{
		size = 20;	// default cursor size Changing to numbers from 1 to 20, decreases cursor width
	}
	CONSOLE_CURSOR_INFO lpCursor;
	lpCursor.bVisible = visible;
	lpCursor.dwSize = size;
	SetConsoleCursorInfo(console, &lpCursor);
}

pair<int, int> generate_unoccupied_position() {

	int occupied = 1;
	int line;
	int column;

	while (occupied) {
		line = rand() % 4;
		column = rand() % 4;
		if (board[line][column] == 0)
		{
			occupied = 0;
		}
	}
	return make_pair(line, column);
}

void add_piece() {

	pair<int, int> pos = generate_unoccupied_position();
	board[pos.first][pos.second] = 2;
}

void new_game() {

	for (int i = 0; i < 4; ++i)
		for (int j = 0; j < 4; ++j)
			board[i][j] = 0;

	add_piece();
}

void print_UI() {
	system("cls");
	logo();
	
	cout << setw(50) << (char)218 << (char)196 << (char)196 << (char)196 << (char)196 << (char)196 << (char)194
		 << (char)196 << (char)196 << (char)196 << (char)196 << (char)196 << (char)194 
		 << (char)196 << (char)196 << (char)196 << (char)196 << (char)196 << (char)194 
		 << (char)196 << (char)196 << (char)196 << (char)196 << (char)196 << (char)191;
	

	cout << endl;
	for (int i = 0; i < 3; ++i)
	{
		cout << setw(50) << (char)179;

		for (int j = 0; j < 4; ++j)
		{
			if (board[i][j] == 0)
			{
				cout << setw(5) << " " << (char)179;
			}
			else
			{
				cout << setw(4) << board[i][j] << " " << (char)179;
			}
		}

		cout << endl;
		cout << setw(50) << (char)195 << (char)196 << (char)196 << (char)196 << (char)196 << (char)196 << (char)197
			 << (char)196 << (char)196 << (char)196 << (char)196 << (char)196 << (char)197
			 << (char)196 << (char)196 << (char)196 << (char)196 << (char)196 << (char)197
			 << (char)196 << (char)196 << (char)196 << (char)196 << (char)196 << (char)180;;
		cout << endl;
		
	}
	for (int i = 3; i < 4; ++i)
	{
		cout << setw(50) << (char)179;

		for (int j = 0; j < 4; ++j)
		{
			if (board[i][j] == 0)
			{
				cout << setw(5) << " " << (char)179;
			}
			else
			{
				cout << setw(4) << board[i][j] << " " << (char)179;
			}
		}

		cout << endl;
		cout << setw(50) << (char)192 << (char)196 << (char)196 << (char)196 << (char)196 << (char)196 << (char)193
			<< (char)196 << (char)196 << (char)196 << (char)196 << (char)196 << (char)193
			<< (char)196 << (char)196 << (char)196 << (char)196 << (char)196 << (char)193
			<< (char)196 << (char)196 << (char)196 << (char)196 << (char)196 << (char)217;;
		cout << endl;

	}
	
	cout << setw(65) << "N: New Game\n";
	cout << setw(65) << "W: Up      \n";
	cout << setw(65) << "S: Down    \n";
	cout << setw(65) << "D: Right   \n";
	cout << setw(65) << "A: Left    \n";
	cout << setw(65) << "Q: Quit    \n";
	cout << endl;
}

bool can_move(int line, int column, int next_line, int next_column) {

	if (next_line < 0 || next_column < 0 || next_line >= 4 || next_column >= 4
		|| (board[line][column] != board[next_line][next_column] && board[next_line][next_column] != 0))
	{
		return false;
	}
	return true;
}

void apply_move(int direction) {

	int start_line = 0;
	int start_column = 0;
	int line_step = 1;
	int column_step = 1;

	if (direction == 0)
	{
		start_line = 3;
		line_step = -1;
	}

	if (direction == 1)
	{
		start_column = 3;
		column_step = -1;
	}

	int move_poss, can_add_piece = 0;
	do
	{
		move_poss = 0;
		for (int i = start_line; i >= 0 && i < 4; i += line_step)
			for (int j = start_column; j >= 0 && j < 4; j += column_step)
			{
				int next_i = i + dir_line[direction], next_j = j + dir_column[direction];
				if (board[i][j] && can_move(i, j, next_i, next_j))
				{
					board[next_i][next_j] += board[i][j];
					board[i][j] = 0;
					move_poss = can_add_piece = 1;
				}
			}
		print_UI();
	} while (move_poss);
	if (can_add_piece)
		add_piece();
}

int main() {
	// hide cursor
	setcursor(0, 0);

	char command;
	char command_to_dir[128];
	 
	command_to_dir['s'] = 0;
	command_to_dir['d'] = 1;
	command_to_dir['w'] = 2;
	command_to_dir['a'] = 3;

	new_game();
	srand(time(0));
	while (true) {
		
		print_UI();
		command = _getch();
		if (command == 'n')
		{
			new_game();
		}
		else if (command == 'q')
		{
			break;
		}
		else
		{
			int current_dir = command_to_dir[command];
			apply_move(current_dir);
		}
	}
	return 0;
}