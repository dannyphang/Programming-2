#include<iostream>
#include<conio.h>	//for _getch()
#include<windows.h>
#include<direct.h>
#include<time.h>
#include<iomanip>
#include<stdlib.h>

#define max_snake_size 100
#define max_framex 50
#define max_framey 20
#define ENTER_KEY 10


using namespace std;

HANDLE console = GetStdHandle(STD_OUTPUT_HANDLE);
COORD CursorPosition;
char op = '1';

void gotoxy(int x, int y) {

	CursorPosition.X = x;
	CursorPosition.Y = y;
	SetConsoleCursorPosition(console, CursorPosition);

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

class point {

private:
	int x;
	int y;
public:
	point() {
		x = y = 10;

	}
	point(int x, int y)
	{
		this->x = x;
		this->y = y;
	}
	void setpoint(int x, int y) {
		this->x = x;
		this->y = y;
	}
	int getX() {
		return x;
	}
	int getY() {
		return y;
	}
	void move_up() {
		y--;
		if (y < 1)				// will appear on the other side if hit the wall
		{
			y = max_framey;
		}
	}
	void move_down() {
		y++;
		if (y > max_framey)
		{
			y = 1;
		}
	}
	void move_left() {
		x--;
		if (x < 1)
		{
			x = max_framex;
		}
	}
	void move_right() {
		x++;
		if (x > max_framex)
		{
			x = 1;
		}
	}

	void draw(char ch = 'o')	// the icon of snake
	{
		gotoxy(x, y);
		cout << ch;
	}
	void erase()				// background 
	{
		gotoxy(x, y);
		cout << " ";
	}
	void copy_poss(point* p) {
		p->x = x;
		p->y = y;
	}
	int is_equal(point* p) {
		if (p->x == x && p->y == y)
		{
			return 1;
		}
		return 0;
	}
	void debug() {
		cout << "(" << x << "," << y << ")";
	}


};

class Snake {
private:
	point* cell[max_snake_size]; // array of points to represent snake
	int size;				// current size of snake
	char dir;				// current direction of snake
	point fruit;
	int state;				// show state of the snake : living or dead
	int started;
	int score = 0;
	string name;

public:
	Snake() {
		size = 1;	//default size
		cell[0] = new point(rand() % max_framex + 1, rand() % max_framey + 1);	// 20,20 is default position

		for (int i = 1; i < max_snake_size; i++)
		{
			cell[i] = NULL;
		}
		fruit.setpoint(rand() % max_framex + 1, rand() % max_framey + 1);
		state = 0;
		started = 0;
	}
	void addcell(int x, int y) {
		cell[size++] = new point(x, y);
	}
	void turn_up() {
		if (dir != 's')
			dir = 'W';		// w is control key for turning upward
	}
	void turn_down() {
		if (dir != 'w')
			dir = 's';		// s is control key for turning downward
	}
	void turn_left() {
		if (dir != 'd')
			dir = 'a';		// a is control key for turning left
	}
	void turn_right() {
		if (dir != 'a')
			dir = 'd';		// d is control key for turning right
	}
	void welcome_screen() {
		system("color 02");
		cout << "66666666666666666666666666666666666666666\n";
	}

	void move() {
		char key;
		system("cls");

		if (state == 0)
		{
			if (!started)
			{
				welcome_screen();
				cout << "Enter Your Name : ";
				cin >> name;
				started = 1;
				state = 1;

			}
			else
			{
				do
				{
					
					system("color 02");
					cout << "Game Over!!\n";
					cout << "NOOB ";
					cout << name << endl;
					cout << "Your score is ";
					cout << score << endl;
					cout << "[Q] QUIT\n[SPACE]Start Game\n";
					key = _getch();
					if (key == ' ')
					{
						state = 1;
						size = 1;
						score = 0;
						move();
						break;
					}
					else if (key == 'q')
					{
						system("cls");
						op = 'e';
					}
				} while (key != ' ' && key != 'q');
			}
		}

		// making wall

		// top
		cout << (char)218;
		for (int i = 0; i < max_framex; i++)
		{
			cout << (char)196;
		}
		cout << (char)191;
		cout << endl;

		// middle
		for (int i = 1; i < max_framey + 1; i++)
		{
			for (int j = 0; j < max_framex; j++)
			{
				if (j == 0)
				{
					cout << (char)179;	// left wall
				}
			}

			cout << setw(max_framex + 1) << (char)179;	// right wall
			if (i == 3)
			{
				cout << right << "W: UP";
			}
			if (i == 4)
			{
				cout << right << "A: LEFT";
			}
			if (i == 5)
			{
				cout << right << "S: DOWN";
			}
			if (i == 6)
			{
				cout << right << "D: RIGHT";
			}
			if (i == 7)
			{
				cout << right << "SPACE: PAUSE";
			}
			if (i == 8)
			{
				cout << right << "Press ANY 'A', 'W', 'S', 'D' To RESUME";
			}
			if (i == 9)
			{
				cout << right << "E: EXIT";
			}
			cout << endl;
		}

		// btm
		cout << (char)192;
		for (int i = 0; i < max_framex; i++)
		{
			cout << (char)196;
		}
		cout << (char)217 << endl;

		/*-------------------------------score board-------------------------------------*/
		cout << (char)218;
		for (int i = 0; i < 30; i++)
		{
			cout << (char)196;
		}
		cout << (char)191;
		cout << endl;
		for (int i = 0; i < 1; i++)
		{
			for (int j = 0; j < 30; j++)
			{
				if (j == 0)
				{
					cout << (char)179;	// left wall
				}
			}
			if (i == 0)
			{
				cout << "SCORE: " << setw(10) << score;
				cout << setw(14) << (char)179;	// right wall
			}

			cout << endl;
		}
		cout << (char)192;
		for (int i = 0; i < 30; i++)
		{
			cout << (char)196;
		}
		cout << (char)217 << endl;
		/*------------------------------------------------------------------------------------*/

		//instruction


		// making the snake body to follow its head
		for (int i = size - 1; i > 0; i--)
		{
			cell[i - 1]->copy_poss(cell[i]);
		}

		// turning snake's head
		switch (dir) {
		case 'W':
			cell[0]->move_up();
			break;
		case 's':
			cell[0]->move_down();
			break;
		case 'a':
			cell[0]->move_left();
			break;
		case 'd':
			cell[0]->move_right();
			break;
		}

		if (self_collision())
		{
			state = 0;
		}

		// collision with fruit
		if (fruit.getX() == cell[0]->getX() && fruit.getY() == cell[0]->getY())
		{
			addcell(130, 0);
			score += 10;		// score adding
			fruit.setpoint(rand() % max_framex + 1, rand() % max_framey + 1);
		}
		// drawing snake
		for (int i = 0; i < size; i++)
		{
			cell[i]->draw();
		}
		SetConsoleTextAttribute(console, 242);
		fruit.draw('0');
		SetConsoleTextAttribute(console, 252);
		//debug();

	int sleep_time = 100;
	sleep_time = sleep_time - 10;
	Sleep(sleep_time);
	}
	int self_collision() {
		for (int i = 1; i < size; i++)
		{
			if (cell[0]->is_equal(cell[i]))
			{
				return 1;
			}
		}
		return 0;
	}
	void debug() {
		for (int i = 0; i < size; i++)
		{
			cell[i]->debug();
		}
	}

};

int main() {

	// hide cursor
	setcursor(0, 0);

	// random no. generate
	srand((unsigned)time(NULL));

	// testing snake
	Snake snake;
	do
	{
		if (_kbhit())
		{
			op = _getch();
		}
		switch (op) {
		case 'w':
		case 'W':
			snake.turn_up();
			break;
		case 's':
		case 'S':
			snake.turn_down();
			break;
		case 'a':
		case 'A':
			snake.turn_left();
			break;
		case 'd':
		case 'D':
			snake.turn_right();
			break;
		case ' ':
			continue;
		}
		snake.move();
	} while (op != 'e');

}