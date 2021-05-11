#include<iostream>
#include<iomanip>
#include<limits>		//defines elements with the characteristics of arithmetic types
using namespace std;

void seat_display(int& x, char& y, char screen_icon, char seat_icon1, char seat_icon2, char seat_icon3, char seat_icon4, char seat[4][15]);
void seat_select(int& x, char& y, char seat[4][15]);
void seat_select_loop(int& x, char& y, char screen_icon, char seat_icon1, char seat_icon2, char seat_icon3, char seat_icon4, char seat[4][15]);

int main() {
	int x;
	char screen_icon, 
		seat_icon,
		seat_icon1,
		seat_icon2, 
		seat_icon3, 
		seat_icon4,
		y,
		seat[4][15];

	screen_icon = 219;
	seat_icon1 = 192;
	seat_icon2 = 205;
	seat_icon3 = 217;
	seat_icon4 = 179;
	seat_icon = 178;
	for (y = 'A'; y <= 'D'; y++)
		for (x = 0; x <= 15; x++)
			seat[y][x] = seat_icon;
	seat_select_loop(x, y, screen_icon, seat_icon1, seat_icon2, seat_icon3, seat_icon4, seat);

	
	return 0;
}

void seat_display(int& x, char& y, char screen_icon, char seat_icon1, char seat_icon2, char seat_icon3, char seat_icon4, char seat[4][15]) {
	
	//----------display the screen-------------//
	cout << setfill(' ') << setw(8) << endl;
	for (int screen = 0; screen <= 119; screen++)
	{
		cout << screen_icon;
	}
	cout << endl << setfill(' ') << setw(8) ;
	for (int screen = 0; screen <= 119; screen++)
	{
		cout << screen_icon;
	}
	cout << endl << endl ;
	//----------------------------------------//

	//--------------display seat--------------//
	cout << setfill(' ') << setw(5) << endl;
	for(y = 'A'; y <= 'D'; y++)
	{
		cout << setfill(' ') << setw(5);
		cout << seat_icon4 << " " << seat[y][0] << seat[y][0] << " " << seat_icon4 << "  " << seat_icon4 << " " << seat[y][1] << seat[y][1] << " " << seat_icon4 << "  " 
			 << seat_icon4 << " " << seat[y][2] << seat[y][2] << " " << seat_icon4 << "  " << seat_icon4 << " " << seat[y][3] << seat[y][3] << " " << seat_icon4 << "  " 
			 << seat_icon4 << " " << seat[y][4] << seat[y][4] << " " << seat_icon4 << "  " << seat_icon4 << " " << seat[y][5] << seat[y][5] << " " << seat_icon4 << "  "
			 << seat_icon4 << " " << seat[y][6] << seat[y][6] << " " << seat_icon4 << "  " << seat_icon4 << " " << seat[y][7] << seat[y][7] << " " << seat_icon4 << "  " 
			 << seat_icon4 << " " << seat[y][8] << seat[y][8] << " " << seat_icon4 << "  " << seat_icon4 << " " << seat[y][15] << seat[y][15] << " " << seat_icon4 << "  "
			 << seat_icon4 << " " << seat[y][15] << seat[y][15] << " " << seat_icon4 << "  " << seat_icon4 << " " << seat[y][11] << seat[y][11] << " " << seat_icon4 << "  "
			 << seat_icon4 << " " << seat[y][12] << seat[y][12] << " " << seat_icon4 << "  " << seat_icon4 << " " << seat[y][13] << seat[y][13] << " " << seat_icon4 << "  "
			 << seat_icon4 << " " << seat[y][14] << seat[y][14] << " " << seat_icon4 << "  " << seat_icon4 << " " << seat[y][15] << seat[y][15] << " " << seat_icon4 << "  ";
		
		cout << endl;
		cout << setfill(' ') << setw(5) ;
		for (int seaticon2 = 0; seaticon2 <= 15; seaticon2++)
		{
			cout << seat_icon1 << seat_icon2 << seat_icon2 << seat_icon2 << seat_icon2 << seat_icon3 << "  ";
		}
		cout << endl;
		cout << setfill(' ') << setw(5) ;
		for (x = 0; x <= 15; x++)
		{
			cout << " " << y << setfill('0') << setw(3) << x << "   ";
		}
		cout << endl;
		cout << endl << endl;
	}
	//---------------------------------------//
	
}

void seat_select(int& x, char& y, char seat[4][15]) {

	//--------input y-------//
	do
	{
		cout << "ROW: ";
		cin >> y;
		y = toupper(y);
		if (y != 'A' && y != 'B' && y != 'C' && y != 'D')
		{
			cout << "Invalid input! Please keyin again!\n";
		}

	} while (y != 'A' && y != 'B' && y != 'C' && y != 'D');
	//---------------------//

	//---------input x------------//
	do
	{
		cout << "COLUMN: ";
		cin >> x;
		if (cin.fail())
		{
			cin.clear();
			cin.ignore(numeric_limits < streamsize >::max(), '\n');
			cout << "Invalid input!\n";
		}
		if (x < 0 || x > 15)
		{
			cout << "Invalid input!\n";
		}
	} while (x < 0 || x > 15);
	//---------------------------//

	if (seat[y][x] != (char)176)
	{
		seat[y][x] = (char)176;
	}
	else
	{
		cout << "Seat Taken, please select again\n";
		seat_select(x, y, seat);
	}

}

void seat_select_loop(int& x, char& y, char screen_icon, char seat_icon1, char seat_icon2, char seat_icon3, char seat_icon4, char seat[4][15]) {
	char yes_no;
	system("cls");
		seat_display(x, y, screen_icon, seat_icon1, seat_icon2, seat_icon3, seat_icon4, seat);
		seat_select(x, y, seat);
		seat_display(x, y, screen_icon, seat_icon1, seat_icon2, seat_icon3, seat_icon4, seat);
		//----------display message--------//
		
		do
		{
			cout << setfill(' ') << setw(14) << endl;
			for (int a = 0; a <= 36; a++)
			{
				cout << "*";
			}
			cout << endl;
			cout << setfill(' ') << setw(50) << "Do you want to select another seat?\n";
			cout << setfill(' ') << setw(35) << "[Y] YES\n";
			cout << setfill(' ') << setw(34) << "[N] NO\n";
			cout << setfill(' ') << setw(14);
			for (int a = 0; a <= 36; a++)
			{
				cout << "*";
			}
			cout << endl;
			cin >> yes_no;
			yes_no = toupper(yes_no);
			if (yes_no != 'Y' && yes_no != 'N')
			{
				cout << "Invalid input!\n";
			}
			else if (yes_no == 'Y')
			{
				seat_select_loop(x, y, screen_icon, seat_icon1, seat_icon2, seat_icon3, seat_icon4, seat);
			}
			else if (yes_no == 'N')
			{
				cout << "ty";
			}
		} while (yes_no != 'Y' && yes_no != 'N');
		cout << setfill(' ') << setw(14) << endl;
		for (int a = 0; a <= 36; a++)
		{
			cout << "*";
		}
		cout << endl;
		//---------------------------------//

}