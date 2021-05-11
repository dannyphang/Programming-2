#include<iostream>
#include<iomanip>
#include<conio.h>

using namespace std;

char board[9];
int x, y;
int num;
char state;

void board_UI();
void xmove();
void omove();
char result();

int main() {



	do
	{
		board_UI();
		xmove();
		if (result() == 'w')
		{
			system("cls");
			board_UI();
			cout << "\nX player win!!\n";
			break;
		}
		system("cls");
		board_UI();
		omove();
		if (result() == 'l')
		{
			system("cls");
			board_UI();
			cout << "\nO player win!!\n";
			break;
		}
		system("cls");
	} while (1);

}

void board_UI() {
	
	/*cout << "1|2|3\n";
	cout << "-|-|-\n";
	cout << "4|5|6\n";
	cout << "-|-|-\n";
	cout << "7|8|9\n";*/
	cout << endl;
	cout << (char)218 << (char)196 << (char)196 << (char)196 << (char)194 << (char)196 << (char)196 << (char)196 << (char)194 << (char)196 << (char)196 << (char)196 << (char)191 << endl
		 << (char)179 << ' ' << board[6] << ' ' << (char)179 << ' ' << board[7] << ' ' << (char)179 << ' ' << board[8] << ' ' << (char)179 << endl
		 << (char)195 << (char)196 << (char)196 << (char)196 << (char)197 << (char)196 << (char)196 << (char)196 << (char)197 << (char)196 << (char)196 << (char)196 << (char)180 << endl
		 << (char)179 << ' ' << board[3] << ' ' << (char)179 << ' ' << board[4] << ' ' << (char)179 << ' ' << board[5] << ' ' << (char)179 << endl
		 << (char)195 << (char)196 << (char)196 << (char)196 << (char)197 << (char)196 << (char)196 << (char)196 << (char)197 << (char)196 << (char)196 << (char)196 << (char)180 << endl
		 << (char)179 << ' ' << board[0] << ' ' << (char)179 << ' ' << board[1] << ' ' << (char)179 << ' ' << board[2] << ' ' << (char)179 << endl
		 << (char)192 << (char)196 << (char)196 << (char)196 << (char)193 << (char)196 << (char)196 << (char)196 << (char)193 << (char)196 << (char)196 << (char)196 << (char)217 << endl;
}

void xmove() {
	do
	{
		cout << "X player turn\n";
		cin >> num;
		//num = _getche(); // input without enter and will show the input, "_getch()" is input without showing it and the enter
		while (!(cin >> num))
		{
			cin.clear();
			cin.ignore(132, '\n');
			system("cls");
			break;
			cin >> num;
		}
		if (num >= 1 && num <= 9)
		{
			if (board[num - 1] != 'x' && board[num - 1] != 'o')
			{
				board[num - 1] = 'x';
			}
			else if (board[num - 1] == 'x' || board[num - 1] == 'o')
			{
				//cout << "Place taken\n";
				system("cls");
				board_UI();
				xmove();
			}
		}
		else
		{
			system("cls");
			break;
		}
	} while (num != 1 && num != 2 && num != 3 && num != 4 && num != 5 && num != 6 && num != 7 && num != 8 && num != 9);

}

void omove() {
	do
	{
		cout << "O player turn\n";
		cin >> num;
		//num = _getche(); // input without enter and will show the input, "_getch()" is input without showing it and the enter
		while (!(cin >> num))
		{
			cin.clear();
			cin.ignore(132, '\n');
			system("cls");
			break;
			cin >> num;
		}
		if (num >= 1 && num <= 9)
		{
			if (board[num - 1] != 'x' && board[num - 1] != 'o')
			{
				board[num - 1] = 'o';
			}
			else if (board[num - 1] == 'x' || board[num - 1] == 'o')
			{
				//cout << "Place taken\n";
				system("cls");
				board_UI();
				omove();
			}
		}
		else
		{
			system("cls");
			break;
		}
	} while (num != 1 && num != 2 && num != 3 && num != 4 && num != 5 && num != 6 && num != 7 && num != 8 && num != 9);

}

char result() {

	// for X player win
	if (board[0] == 'x' && board[1] == 'x' && board[2] == 'x')
	{
		return 'w';
	}
	if (board[0] == 'x' && board[3] == 'x' && board[6] == 'x')
	{
		return 'w';
	}
	if (board[0] == 'x' && board[4] == 'x' && board[8] == 'x')
	{
		return 'w';
	}
	if (board[3] == 'x' && board[4] == 'x' && board[5] == 'x')
	{
		return 'w';
	}
	if (board[6] == 'x' && board[7] == 'x' && board[8] == 'x')
	{
		return 'w';
	}
	if (board[1] == 'x' && board[4] == 'x' && board[7] == 'x')
	{
		return 'w';
	}
	if (board[2] == 'x' && board[5] == 'x' && board[8] == 'x')
	{
		return 'w';
	}
	if (board[2] == 'x' && board[4] == 'x' && board[6] == 'x')
	{
		return 'w';
	}
	
	// for O player win
	if (board[0] == 'o' && board[1] == 'o' && board[2] == 'o')
	{
		return 'l';
	}
	if (board[0] == 'o' && board[3] == 'o' && board[6] == 'o')
	{
		return 'l';
	}
	if (board[0] == 'o' && board[4] == 'o' && board[8] == 'o')
	{
		return 'l';
	}
	if (board[3] == 'o' && board[4] == 'o' && board[5] == 'o')
	{
		return 'l';
	}
	if (board[6] == 'o' && board[7] == 'o' && board[8] == 'o')
	{
		return 'l';
	}
	if (board[1] == 'o' && board[4] == 'o' && board[7] == 'o')
	{
		return 'l';
	}
	if (board[2] == 'o' && board[5] == 'o' && board[8] == 'o')
	{
		return 'l';
	}
	if (board[2] == 'o' && board[4] == 'o' && board[6] == 'o')
	{
		return 'l';
	}

}