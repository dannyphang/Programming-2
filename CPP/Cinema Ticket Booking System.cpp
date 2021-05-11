#include<iostream>
#include<cmath>
#include<string>
#include<iomanip>
#include<stdlib.h>		//use to clear screen
#include<cctype>
#include<limits>		//defines elements with the characteristics of arithmetic types
#include<fstream>
using namespace std;

void logo();
void welc();
void movie_select(int& movie_num, int& vip2, int& front2, int& back2);
void timetable();
void seat_display(int& y, int& x, char seat[4][15]);
void seat_select(int& y, int& x, char seat[4][15]);
void seat_select_agn(int& y, int& x, char seat[4][15]);
void check_class(int& y, int& x, int& vip, int& front, int& back, char seat[4][15]);
void customer_num(int& vip, int& front, int& back, int& vipadult_num, int& vipchild_num, int& vipstudent_num, int& frontadult_num, int& frontchild_num, int& frontstudent_num, int& backadult_num, int& backchild_num, int& backstudent_num, int& adultsold, int& childsold, int& studentsold);
void ticket_calculation(int& vip, int& front, int& back, int& vipadult_num, int& vipchild_num, int& vipstudent_num, int& frontadult_num, int& frontchild_num, int& frontstudent_num, int& backadult_num, int& backchild_num, int& backstudent_num, int& total_vip, int& total_front, int& total_back, int& adultprice, int& childprice, int& studentprice, int& vipadult_ticket2, int& vipchild_ticket2, int& vipstudent_ticket2, int& frontadult_ticket2, int& frontchild_ticket2, int& frontstudent_ticket2, int& backadult_ticket2, int& backchild_ticket2, int& backstudent_ticket2);
void ticket_print(int& movie_num, int& vip, int& front, int& back, int& total_vip, int& total_front, int& total_back, char seat[4][15]);
void finish_seat(int& y, int& x, int& vip, int& front, int& back, int& vip2, int& front2, int& back2, char seat[4][15]);
void sale_report(int& movie_num, int& vip, int& front, int& back, int& vip2, int& front2, int& back2, int& vipadult_num, int& vipchild_num, int& vipstudent_num, int& frontadult_num, int& frontchild_num, int& frontstudent_num, int& backadult_num, int& backchild_num, int& backstudent_num, int& adultsold, int& childsold, int& studentsold, int& adultprice, int& childprice, int& studentprice);



int main() {
	//---declaration
	int movie_num, y, x, seat_icon3 = 254, vip, front, back,
		vipadult_num, vipchild_num, vipstudent_num,
		frontadult_num, frontchild_num, frontstudent_num,
		backadult_num, backchild_num, backstudent_num,
		adultsold, childsold, studentsold,
		total_vip, total_front, total_back,
		adultprice, childprice, studentprice,
		vipadult_ticket2, vipchild_ticket2, vipstudent_ticket2,
		frontadult_ticket2, frontchild_ticket2, frontstudent_ticket2,
		backadult_ticket2, backchild_ticket2, backstudent_ticket2,
		vip2, front2, back2;

	char seat[4][15],yes_no;

	string movie_name[2];

	//---functions
	for (y = 0; y < 4; y++)
		for (x = 0; x < 15; x++)
			seat[y][x] = seat_icon3;
	vip = 0;
	front = 0;
	back = 0;
	vip2 = 0;
	front2 = 0;
	back2 = 0;
	adultsold = 0;
	childsold = 0;
	studentsold = 0;
	adultprice = 0;
	childprice = 0;
	studentprice = 0;
	vipadult_ticket2 = 0;
	vipchild_ticket2 = 0;
	vipstudent_ticket2 = 0;
	frontadult_ticket2 = 0;
	frontchild_ticket2 = 0;
	frontstudent_ticket2 = 0;
	backadult_ticket2 = 0;
	backchild_ticket2 = 0;
	backstudent_ticket2 = 0;
newcustomer:
	do
	{
		welc();		
		movie_select(movie_num, vip2, front2, back2);
		timetable();
		seat_select_agn(y, x, seat);
		check_class(y, x, vip, front, back, seat);
		customer_num(vip, front, back, vipadult_num, vipchild_num, vipstudent_num, frontadult_num, frontchild_num, frontstudent_num, backadult_num, backchild_num, backstudent_num, adultsold, childsold, studentsold);
		ticket_calculation(vip, front, back, vipadult_num, vipchild_num, vipstudent_num, frontadult_num, frontchild_num, frontstudent_num, backadult_num, backchild_num, backstudent_num, total_vip, total_front, total_back, adultprice, childprice, studentprice, vipadult_ticket2, vipchild_ticket2, vipstudent_ticket2, frontadult_ticket2, frontchild_ticket2, frontstudent_ticket2, backadult_ticket2, backchild_ticket2, backstudent_ticket2);
		ticket_print(movie_num, vip, front, back, total_vip, total_front, total_back, seat);
		finish_seat(y, x, vip, front, back, vip2, front2, back2, seat);
		do
		{
			cout << "Next customer?\n[Y] YES\n[N] NO\n";
			cin >> yes_no;
			yes_no = toupper(yes_no);
			if (yes_no == 'Y')
			{
				system("cls");
				
				goto newcustomer;
			}
			else if (yes_no == 'N')
			{
				sale_report(movie_num, vip, front, back, vip, front, back, vipadult_num, vipchild_num, vipstudent_num, frontadult_num, frontchild_num, frontstudent_num, backadult_num, backchild_num, backstudent_num, adultsold, childsold, studentsold, adultprice, childprice, studentprice);
			}
			else
			{
				cout << "Invalid input!\n";
			}
		} while (yes_no != 'Y' && yes_no != 'N');
	} while (yes_no != 'Y' && yes_no != 'N');
	return 0;
}

void welc() {

		logo();
		cout << endl << endl;
		for (int line = 0; line <= 30; line++)
		{
			cout << " ";
		}
		for (int line = 40; line <= 65; line++)
		{
			cout << (char)205;
		}
		cout << endl << endl;
		cout << setfill(' ') << setw(59) << " WELCOME TO DANNY CINEMAX \n\n";
		
		for (int line = 0; line <= 30; line++)
		{
			cout << " ";
		}
		for (int line = 40; line <= 65; line++)
		{
			cout << (char)205;
		}
		cout << endl << endl << endl << endl << endl << endl;
		system("pause");
		
}

void logo() {
	system("cls");
	for (int w = 1; w <= 96; w++)
	{
		cout << (char)205;
	}
	cout << endl;
	cout << "  ,------.                                    ,-----,--.                                       \n";
	cout << "  |  .-.  \\ ,--,--,--,--,,--,--,,--. ,--.    '  .--.`--,--,--, ,---.,--,--,--.,--,--,--.  ,--. \n";
	cout << "  |  |  \\  ' ,-.  |      |      \\\\  '  /     |  |   ,--|      | .-. |        ' ,-.  |\\  `'  /  \n";
	cout << "  |  '--'  \\ '-'  |  ||  |  ||  | \\   '      '  '--'|  |  ||  \\   --|  |  |  \\ '-'  |/  /.  \\  \n";
	cout << "  `-------' `--`--`--''--`--''--.-'  /        `-----`--`--''--'`----`--`--`--'`--`--'--'  '--' \n";
	cout << "                                `---'                                                          \n";
	for (int w = 1; w <= 96; w++)
	{
		cout << (char)205;
	}
	cout << endl;

}

void movie_select(int& movie_num, int& vip2, int& front2, int& back2) {

	string movie_name[2] = { "FROZEN II", " Avenger 4: EndGame" };

	logo();
	cout << "~~~~~~~~Movie~~~~~~~~~\n";							//display the movie that can let user to select
	cout << "  1. Frozen II        \n";
	cout << "  2. Avenger 4 EndGame\n";
	cout << "~~~~~~~~~~~~~~~~~~~~~~\n\n";

	cout << "Seats available \n";
	for (int i = 0; i <= 15; i++)
	{
		cout << (char)205 ;
	}
	cout << endl;
	cout << "VIP   - " << (15 - vip2) << endl;
	cout << "FRONT - " << (15 - front2) << endl;
	cout << "BACK  - " << (30 - back2) << endl;
	if ((vip2 + front2 + back2) == 60)
	{
		cout << "Seeat is sold out, please come back next time...\n\n\n\n";
		exit(0);
	}

	cout << endl;
	do															//do the looping of input the selection of movie when user inputed wrong 
	{
		cout << "Please Pick a Movie : ";
		cin >> movie_num;
		if (cin.fail())
		{
			cin.clear();
			cin.ignore(132, '\n');

		}
		switch (movie_num)
		{
		case (1):
			cout << "Your picked movie is " << movie_name[movie_num - 1] << endl;
			break;
		case (2):
			cout << "Your picked movie is " << movie_name[movie_num - 1] << endl;
			break;

		default:
			cout << "Invalid Number! Please keyin again!\n";
			break;
		}

	} while (movie_num != 1 && movie_num != 2);
	system("pause");
	system("cls");		//clear screen


}

void timetable() {
	system("cls");
	logo();
	for (int line = 0; line <= 50; line++)
	{
		cout << (char)196;
	}
	cout << endl;
	cout << (char)179 << "  Catogory  " << (char)179 << "   ADULT   " << (char)179 << "   CHILD   " << (char)179 << "   STUDENT  " << (char)179 ;
	cout << "   ";										//screen
	for (int screen = 0; screen <= 25; screen++)
	{
		cout << (char)254;
	}
	cout << " SCREEN ";
	for (int screen = 0; screen <= 24; screen++)
	{
		cout << (char)254;
	}
	cout << endl;
	for (int line = 0; line <= 50; line++)
	{
		cout << (char)196;
	}
	cout << endl;
	cout << (char)179 << "    VIP     " << (char)179 << "   RM 20   " << (char)179 << "   RM 10   " << (char)179 << "    RM 12   " << (char)179 ;
	
	cout << "    ";										//vip seat
	for (int screen = 0; screen <= 24; screen++)
	{
		cout << (char)196;
	}
	cout << "  VIP   ";
	for (int screen = 0; screen <= 23; screen++)
	{
		cout << (char)196;
	}
	cout << endl;
	
	for (int line = 0; line <= 50; line++)
	{
		cout << (char)196;
	}
	cout << endl;
	cout << (char)179 << "    FRONT   " << (char)179 << "   RM 16   " << (char)179 << "   RM  6   " << (char)179 << "    RM  8   " << (char)179 ;

	cout << "    ";										//front seat
	for (int screen = 0; screen <= 24; screen++)
	{
		cout << (char)196;
	}
	cout << " FRONT  ";
	for (int screen = 0; screen <= 23; screen++)
	{
		cout << (char)196;
	}
	cout << endl;

	for (int line = 0; line <= 50; line++)
	{
		cout << (char)196;
	}
	cout << endl;
	cout << (char)179 << "    BACK    " << (char)179 << "   RM 18   " << (char)179 << "   RM  8   " << (char)179 << "    RM 10   " << (char)179 ;

	cout << "    ";										//back seat
	for (int screen = 0; screen <= 24; screen++)
	{
		cout << (char)196;
	}
	cout << "  BACK  ";
	for (int screen = 0; screen <= 23; screen++)
	{
		cout << (char)196;
	}
	cout << endl;

	for (int line = 0; line <= 50; line++)
	{
		cout << (char)196;
	}
	cout << endl;
	cout << "Above is the price of diffence class ticket\n";

	cout << endl;

}

void seat_display(int& y, int& x, char seat[4][15]) {

	//-----display seat
	cout << "   ";
	for (int screen = 0; screen <= 25; screen++)
	{
		cout << (char)254;
	}
	cout << " SCREEN ";
	for (int screen = 0; screen <= 24; screen++)
	{
		cout << (char)254;
	}
	cout << endl;
	for (int y = 0; y < 4; y++)
	{
		cout << y << " " << (char)179 << " " << seat[y][0] << " " << (char)179 << " " << seat[y][1] << " " << (char)179 << " " << seat[y][2] << " " <<
			(char)179 << " " << seat[y][3] << " " << (char)179 << " " << seat[y][4] << " " << (char)179 << " " << seat[y][5] << " " <<
			(char)179 << " " << seat[y][6] << " " << (char)179 << " " << seat[y][7] << " " << (char)179 << " " << seat[y][8] << " " <<
			(char)179 << " " << seat[y][9] << " " << (char)179 << " " << seat[y][10] << " " << (char)179 << " " << seat[y][11] << " " <<
			(char)179 << " " << seat[y][12] << " " << (char)179 << " " << seat[y][13] << " " << (char)179 << " " << seat[y][14] << " " <<
			(char)179 << " " << endl;
	}
	cout << " ";
	for (int z = 0; z < 10; z++)
	{
		cout << fixed << setw(4) << z;
	}
	cout << " ";
	for (int z = 10; z < 15; z++)
	{
		cout << fixed << setw(4) << z;
	}
	cout << endl;
	cout << "   ";
	for (int w = 1; w <= 59; w++)
	{
		cout << (char)205;
	}
	cout << endl << endl;

}

void class_display(){

	//-----display the different of classes

	cout << "   ";										//screen
	for (int screen = 0; screen <= 25; screen++)
	{
		cout << (char)254;
	}
	cout << " SCREEN ";
	for (int screen = 0; screen <= 24; screen++)
	{
		cout << (char)254;
	}
	cout << endl;

	cout << "    ";										//vip seat
	for (int screen = 0; screen <= 24; screen++)
	{
		cout << (char)196;
	}
	cout << "  VIP   ";
	for (int screen = 0; screen <= 23; screen++)
	{
		cout << (char)196;
	}
	cout << endl;

	cout << "    ";										//front seat
	for (int screen = 0; screen <= 24; screen++)
	{
		cout << (char)196;
	}
	cout << " FRONT  ";
	for (int screen = 0; screen <= 23; screen++)
	{
		cout << (char)196;
	}
	cout << endl;

	cout << "    ";										//back seat
	for (int screen = 0; screen <= 24; screen++)
	{
		cout << (char)196;
	}
	cout << "  BACK  ";
	for (int screen = 0; screen <= 23; screen++)
	{
		cout << (char)196;
	}
	cout << endl;

	
}

void seat_select(int& y, int& x, char seat[4][15]) {

	cout << "Select seat (ROW > COLUMN)\n* Example : 0 , 9 * \n";
	cout << "ROW    : ";
	cin >> y;
	while (cin.fail())
	{
		cin.clear();
		cin.ignore(132, '\n');
		cout << "Please only enter NUMBER!\n";
		cout << "ROW    : ";
		cin >> y;
	}

	while (y < 0 || y > 3)
	{
		cout << "Invalid input! Please enter a number of your seat.\n";
		cout << "ROW    : ";
		cin >> y;
	}

	cout << "COLUMN : ";
	cin >> x;
	while (cin.fail())
	{
		cin.clear();
		cin.ignore(132, '\n');
		cout << "Please only enter NUMBER!\n";
		cout << "COLUMN : ";
		cin >> x;
	}

	while (x < 0 || x > 14)
	{
		cout << "Invalid input! Please enter a number of your seat.\n";
		cout << "COLUMN : ";
		cin >> x;
	}

	if (seat[y][x] != '1' && seat[y][x] != 'X')
	{
		seat[y][x] = '1';
	}
	else
	{
		cout << "Seat taken\n";
		cout << endl;
	}

	seat_display(y, x, seat);
}

void seat_select_agn(int& y, int& x, char seat[4][15]) {
	char seat_agn;
	do
	{
		seat_display(y, x, seat);
		cout << "           \"1\" = Selected Seat\n           \"X\" = Seat Sold / Seat Unavaible Currently\n         ";
	for (int screen = 0; screen <= 45; screen++)
	{
		cout << (char)196;
	}
	cout << endl;
		seat_select(y, x, seat);
		cout << "Do you want to select another seat again?\n";
		cout << "[Y] YES\n[N] NO\n";
		cin >> seat_agn;
		seat_agn = toupper(seat_agn);
		if (seat_agn == 'Y')
		{
			system("cls");
			logo();
			seat_select_agn(y, x, seat);
		}
		if (seat_agn != 'Y' && seat_agn != 'N')
		{
			cout << "Invalid! \nPlease keyin a correct Alphabet!\n";
		}
	} while (seat_agn != 'Y' && seat_agn != 'N');
}

void check_class(int& y, int& x, int& vip, int& front, int& back, char seat[4][15]) {
	int total_seat_select;
	vip = 0;
	front = 0;
	back = 0;
	for (y = 0; y < 1; y++)
	{
		for (x = 0; x <= 14; x++)
		{
			if (seat[y][x] == '1' && seat[y][x] != 'X')
			{
				++vip;
			}
		}
	}
	for (y = 1; y < 2; y++)
	{
		for (x = 0; x <= 14; x++)
		{
			if (seat[y][x] == '1' && seat[y][x] != 'X')
			{
				++front;
			}
		}
	}
	for (y = 2; y < 4; y++)
	{
		for (x = 0; x <= 14; x++)
		{
			if (seat[y][x] == '1' && seat[y][x] != 'X')
			{
				++back;
			}
		}
	}
	total_seat_select = vip + back + front;
	system("cls");
	logo();
	if (total_seat_select == 1)
	{
		cout << "You have selected " << total_seat_select << " seat.\n";
	}
	else
	{
		cout << "You have selected " << total_seat_select << " seats.\n";
	}
}

void customer_num(int& vip, int& front, int& back, int& vipadult_num, int& vipchild_num, int& vipstudent_num, int& frontadult_num, int& frontchild_num, int& frontstudent_num, int& backadult_num, int& backchild_num, int& backstudent_num, int& adultsold, int& childsold, int& studentsold) {
	 vipadult_num = 0, frontadult_num = 0, backadult_num = 0;
	 vipchild_num = 0, frontchild_num = 0, backchild_num = 0;
	 vipstudent_num = 0, frontstudent_num = 0, backstudent_num = 0;
	cout << endl;
	//-----user enter number seat of vip class
	if (vip != 0)
	{
		do
		{
			cout << "You have selected " << vip << " seats for VIP\n";
			cout << "For VIP seat :-\n";
			cout << "Adult  :";
			cin >> vipadult_num;
			while (cin.fail())
			{
				cin.clear();
				cin.ignore(132, '\n');
				cout << "Please only enter NUMBER!\n";
				cout << "Adult  :";
				cin >> vipadult_num;
			}
			if (vipadult_num == vip)
			{
				break;
			}
			
				cout << "Child  :";
				cin >> vipchild_num;
				while (cin.fail())
				{
					cin.clear();
					cin.ignore(132, '\n');
					cout << "Please only enter NUMBER!\n";
					cout << "Adult  :";
					cin >> vipchild_num;
				}
				if ((vipadult_num + vipchild_num) == vip)
				{
					break;
				}
			
				cout << "Student :";
				cin >> vipstudent_num;
				while (cin.fail())
				{
					cin.clear();
					cin.ignore(132, '\n');
					cout << "Please only enter NUMBER!\n";
					cout << "Adult  :";
					cin >> vipstudent_num;
				}
				if ((vipadult_num + vipchild_num + vipstudent_num) == vip)
				{
					break;
				}
		} while ((vipadult_num + vipchild_num + vipstudent_num) != vip);
		cout << endl << endl;
	}

	//-----user enter number seat of front class
	if (front != 0)
	{
		do
		{
			cout << "You have selected " << front << " seats for FRONT\n";
			cout << "For Front seat :-\n";
			cout << "Adult  :";
			cin >> frontadult_num;
			while (cin.fail())
			{
				cin.clear();
				cin.ignore(132, '\n');
				cout << "Please only enter NUMBER!\n";
				cout << "Adult  :";
				cin >> frontadult_num;
			}
			if (frontadult_num == front)
			{
				break;
			}
			cout << "Child  :";
			cin >> frontchild_num;
			while (cin.fail())
			{
				cin.clear();
				cin.ignore(132, '\n');
				cout << "Please only enter NUMBER!\n";
				cout << "Adult  :";
				cin >> frontchild_num;
			}
			if ((frontadult_num + frontchild_num) == front)
			{
				break;
			}
			cout << "Student :";
			cin >> frontstudent_num;
			while (cin.fail())
			{
				cin.clear();
				cin.ignore(132, '\n');
				cout << "Please only enter NUMBER!\n";
				cout << "Adult  :";
				cin >> frontstudent_num;
			}
			if ((frontadult_num + frontchild_num + frontstudent_num) == front)
				{
					break;
				}
			} while ((frontadult_num + frontchild_num + frontstudent_num) != front);
		cout << endl << endl;
	}

	//-----user enter number seat of back class
	if (back != 0)
	{
		do
		{
			cout << "You have selected " << back << " seats for BACK\n";
			cout << "For back seat :-\n";
			cout << "Adult  :";
			cin >> backadult_num;
			while (cin.fail())
			{
				cin.clear();
				cin.ignore(132, '\n');
				cout << "Please only enter NUMBER!\n";
				cout << "Adult  :";
				cin >> backadult_num;
			}
			if (backadult_num == back)
			{
				break;
			}
			cout << "Child  :";
			cin >> backchild_num;
			while (cin.fail())
			{
				cin.clear();
				cin.ignore(132, '\n');
				cout << "Please only enter NUMBER!\n";
				cout << "Adult  :";
				cin >> backchild_num;
			}
			if ((backadult_num + backchild_num) == back)
			{
				break;
			}
			cout << "Student :";
			cin >> backstudent_num;
			while (cin.fail())
			{
				cin.clear();
				cin.ignore(132, '\n');
				cout << "Please only enter NUMBER!\n";
				cout << "Adult  :";
				cin >> backstudent_num;
			}
			if ((backadult_num + backchild_num + backstudent_num) == back)
			{
				break;
			}
			}while ((backadult_num + backchild_num + backstudent_num) != back);
			cout << endl << endl;
	}
	adultsold += vipadult_num + frontadult_num + backadult_num;
	childsold += vipchild_num + frontchild_num + backchild_num;
	studentsold += vipstudent_num + frontstudent_num + backstudent_num;


	system("cls");
}

void ticket_calculation(int& vip, int& front, int& back, int& vipadult_num, int& vipchild_num, int& vipstudent_num, int& frontadult_num, int& frontchild_num, int& frontstudent_num, int& backadult_num, int& backchild_num, int& backstudent_num, int& total_vip, int& total_front, int& total_back, int& adultprice, int& childprice, int& studentprice, int& vipadult_ticket2, int& vipchild_ticket2, int& vipstudent_ticket2, int& frontadult_ticket2, int& frontchild_ticket2, int& frontstudent_ticket2, int& backadult_ticket2, int& backchild_ticket2, int& backstudent_ticket2) {
	int adult_ticket, child_ticket, student_ticket, total_to_pay;
	double cash_payment, change_due;
	total_vip = 0;
	total_front = 0;
	total_back = 0;
	do
	{
		logo();
		cout << "BILL CALCULATION\n";
		//------------------------------------------------for class vip------------------------------------------------------//
		if (vip != 0)
		{
			adult_ticket = 20;
			child_ticket = 10;
			student_ticket = 12;
			vipadult_ticket2 = vipadult_num * adult_ticket;
			vipchild_ticket2 = vipchild_num * child_ticket;
			vipstudent_ticket2 = vipstudent_num * student_ticket;
			cout << "*********** VIP ***********\n";
			//-------calculation of adult ticket
			cout << "Number of Adults" << fixed << setw(5) << " = " << vipadult_num;
			cout << " @ " << "RM " << fixed << setw(5) << fixed << setprecision(2) << (double)adult_ticket;
			cout << " = " << "RM " << fixed << setprecision(2) << (double)vipadult_ticket2;
			cout << endl;

			//------calculation of child ticket
			cout << "Number of Childs" << fixed << setw(5) << " = " << vipchild_num;
			cout << " @ " << "RM " << fixed << setw(5) << fixed << setprecision(2) << (double)child_ticket;
			cout << " = " << "RM " << fixed << setprecision(2) << (double)vipchild_ticket2;
			cout << endl;

			//------calculation of student ticket
			cout << "Number of Students" << fixed << setw(1) << " = " << vipstudent_num;
			cout << " @ " << "RM " << fixed << setw(5) << fixed << setprecision(2) << (double)student_ticket;
			cout << " = " << "RM " << fixed << setprecision(2) << (double)vipstudent_ticket2;
			cout << endl;

			total_vip = vipadult_ticket2 + vipchild_ticket2 + vipstudent_ticket2;
		}
		//-------------------------------------------------for class front----------------------------------------------------//

		if (front != 0)
		{
			adult_ticket = 16;
			child_ticket = 6;
			student_ticket = 8;
			frontadult_ticket2 = frontadult_num * adult_ticket;
			frontchild_ticket2 = frontchild_num * child_ticket;
			frontstudent_ticket2 = frontstudent_num * student_ticket;
			cout << "*********** FRONT ***********\n";
			//-------calculation of adult ticket
			cout << "Number of Adults" << fixed << setw(5) << " = " << frontadult_num;
			cout << " @ " << "RM " << fixed << setw(5) << fixed << setprecision(2) << (double)adult_ticket;
			cout << " = " << "RM " << fixed << setprecision(2) << (double)frontadult_ticket2;
			cout << endl;

			//------calculation of child ticket
			cout << "Number of Childs" << fixed << setw(5) << " = " << frontchild_num;
			cout << " @ " << "RM " << fixed << setw(5) << fixed << setprecision(2) << (double)child_ticket;
			cout << " = " << "RM " << fixed << setprecision(2) << (double)frontchild_ticket2;
			cout << endl;

			//------calculation of student ticket
			cout << "Number of Students" << fixed << setw(1) << " = " << frontstudent_num;
			cout << " @ " << "RM " << fixed << setw(5) << fixed << setprecision(2) << (double)student_ticket;
			cout << " = " << "RM " << fixed << setprecision(2) << (double)frontstudent_ticket2;
			cout << endl;

			total_front = frontadult_ticket2 + frontchild_ticket2 + frontstudent_ticket2;
		}
		//-------------------------------------------------for class back-----------------------------------------------------//
		if (back != 0)
		{
			adult_ticket = 18;
			child_ticket = 8;
			student_ticket = 10;
			backadult_ticket2 = backadult_num * adult_ticket;
			backchild_ticket2 = backchild_num * child_ticket;
			backstudent_ticket2 = backstudent_num * student_ticket;
			cout << "*********** BACK ***********\n";
			//-------calculation of adult ticket
			cout << "Number of Adults" << fixed << setw(5) << " = " << backadult_num;
			cout << " @ " << "RM " << fixed << setw(5) << fixed << setprecision(2) << (double)adult_ticket;
			cout << " = " << "RM " << fixed << setprecision(2) << (double)backadult_ticket2;
			cout << endl;

			//------calculation of child ticket
			cout << "Number of Childs" << fixed << setw(5) << " = " << backchild_num;
			cout << " @ " << "RM " << fixed << setw(5) << fixed << setprecision(2) << (double)child_ticket;
			cout << " = " << "RM " << fixed << setprecision(2) << (double)backchild_ticket2;
			cout << endl;

			//------calculation of student ticket
			cout << "Number of Students" << fixed << setw(1) << " = " << backstudent_num;
			cout << " @ " << "RM " << fixed << setw(5) << fixed << setprecision(2) << (double)student_ticket;
			cout << " = " << "RM " << fixed << setprecision(2) << (double)backstudent_ticket2;
			cout << endl;

			total_back = backadult_ticket2 + backchild_ticket2 + backstudent_ticket2;
		}

		//------calculation of total payment
		total_to_pay = total_vip + total_front + total_back;
		cout << fixed << setw(20) << "Total to Pay  = " << fixed << setw(19) << "RM " << fixed << setprecision(2) << (double)total_to_pay;
		cout << endl;

		//------user input the cash amount
	
		cout << fixed << setw(20) << "Cash Payment  : " << fixed << setw(19) << "RM ";
		cin >> cash_payment;
		if (cash_payment < total_to_pay)
		{
			cout << "Your amount is not valid! Please enter a correct amount.\n";
			system("pause");
			cout << "\033[2J\033[1;1H";
		}
	} while (cash_payment < total_to_pay);

	//------calculation of change due
	change_due = (double)cash_payment - total_to_pay;
	cout << fixed << setw(20) << "Change Due    = " << fixed << setw(19) << "RM " << fixed << setprecision(2) << (double)change_due;
	cout << endl;

	adultprice = vipadult_ticket2 + frontadult_ticket2 + backadult_ticket2;
	childprice = vipchild_ticket2 + frontchild_ticket2 + backchild_ticket2;
	studentprice = vipstudent_ticket2 + frontstudent_ticket2 + backstudent_ticket2;

	system("pause");
}

void ticket_print(int& movie_num, int& vip, int& front, int& back, int& total_vip, int& total_front, int& total_back, char seat[4][15]) {
	system("cls");
	//----------------------------------print ticket for VIP----------------------------------//
	if (vip != 0)
	{
		for (int t = 1; t <= vip; t++)
		{
			for (int m = 0; m <= 65; m++)
			{
				cout << "=";
			}
			cout << "\n  DANNNY Cinemax";
			for (int s = 0; s <= 30; s++)
			{
				cout << " ";
			}

			cout << "Class - VIP";

			cout << endl << endl;
			cout << "  Movie" << fixed << setw(10) << " = " << fixed << setw(5);
			switch (movie_num)
			{
			case (1):
				cout << "Frozen II\n";
				break;
			case (2):
				cout << "Avenger 4 EndGame\n";
				break;
			}

			cout << "  Date / Time " << fixed << setw(3) << " = " << fixed << setw(5) << "22 - 11 - 2019 ( 8.00 pm )";

			cout << "\n  Seat No: \n";

			cout << "   ";
			for (int screen = 0; screen <= 25; screen++)
			{
				cout << (char)254;
			}
			cout << " SCREEN ";
			for (int screen = 0; screen <= 24; screen++)
			{
				cout << (char)254;
			}
			cout << endl;

			for (int y = 0; y < 4; y++)
			{
				cout << y << " " << (char)179 << " " << seat[y][0] << " " << (char)179 << " " << seat[y][1] << " " << (char)179 << " " << seat[y][2] << " " <<
					(char)179 << " " << seat[y][3] << " " << (char)179 << " " << seat[y][4] << " " << (char)179 << " " << seat[y][5] << " " <<
					(char)179 << " " << seat[y][6] << " " << (char)179 << " " << seat[y][7] << " " << (char)179 << " " << seat[y][8] << " " <<
					(char)179 << " " << seat[y][9] << " " << (char)179 << " " << seat[y][10] << " " << (char)179 << " " << seat[y][11] << " " <<
					(char)179 << " " << seat[y][12] << " " << (char)179 << " " << seat[y][13] << " " << (char)179 << " " << seat[y][14] << " " <<
					(char)179 << " " << endl;
			}
			cout << " ";
			for (int z = 0; z < 10; z++)
			{
				cout << fixed << setw(4) << z;
			}
			cout << " ";
			for (int z = 10; z < 15; z++)
			{
				cout << fixed << setw(4) << z;
			}
			cout << endl;
			cout << "   ";
			for (int w = 1; w <= 59; w++)
			{
				cout << (char)205;
			}
			cout << endl;

			cout << setw(35) << fixed << setprecision(2) << "Price: RM" << total_vip;

			cout << endl;
			for (int m = 0; m <= 65; m++)
			{
				cout << "=";
			}

			cout << endl;
		}
	}

	//----------------------------------print ticket for FRONT----------------------------------//
	if (front != 0)
	{
		for (int t = 1; t <= front; t++)
		{
			for (int m = 0; m <= 65; m++)
			{
				cout << "=";
			}
			cout << "\n  DANNNY Cinemax";
			for (int s = 0; s <= 30; s++)
			{
				cout << " ";
			}

			cout << "Class - FRONT";

			cout << endl << endl;
			cout << "  Movie" << fixed << setw(10) << " = " << fixed << setw(5);
			switch (movie_num)
			{
			case (1):
				cout << "Frozen II\n";
				break;
			case (2):
				cout << "Avenger 4 EndGame\n";
				break;
			}

			cout << "  Date / Time " << fixed << setw(3) << " = " << fixed << setw(5) << "22 - 11 - 2019 ( 8.00 pm )";

			cout << "\n  Seat No: \n";

			cout << "   ";
			for (int screen = 0; screen <= 25; screen++)
			{
				cout << (char)254;
			}
			cout << " SCREEN ";
			for (int screen = 0; screen <= 24; screen++)
			{
				cout << (char)254;
			}
			cout << endl;

			for (int y = 0; y < 4; y++)
			{
				cout << y << " " << (char)179 << " " << seat[y][0] << " " << (char)179 << " " << seat[y][1] << " " << (char)179 << " " << seat[y][2] << " " <<
					(char)179 << " " << seat[y][3] << " " << (char)179 << " " << seat[y][4] << " " << (char)179 << " " << seat[y][5] << " " <<
					(char)179 << " " << seat[y][6] << " " << (char)179 << " " << seat[y][7] << " " << (char)179 << " " << seat[y][8] << " " <<
					(char)179 << " " << seat[y][9] << " " << (char)179 << " " << seat[y][10] << " " << (char)179 << " " << seat[y][11] << " " <<
					(char)179 << " " << seat[y][12] << " " << (char)179 << " " << seat[y][13] << " " << (char)179 << " " << seat[y][14] << " " <<
					(char)179 << " " << endl;
			}
			cout << " ";
			for (int z = 0; z < 10; z++)
			{
				cout << fixed << setw(4) << z;
			}
			cout << " ";
			for (int z = 10; z < 15; z++)
			{
				cout << fixed << setw(4) << z;
			}
			cout << endl;
			cout << "   ";
			for (int w = 1; w <= 59; w++)
			{
				cout << (char)205;
			}
			cout << endl;

			cout << setw(35) << fixed << setprecision(2) << "Price: RM" << total_front;

			cout << endl;
			for (int m = 0; m <= 65; m++)
			{
				cout << "=";
			}

			cout << endl;
		}
	}

	//----------------------------------print ticket for BACK----------------------------------//
	if (back != 0)
	{
		for (int t = 1; t <= back; t++)
		{
			for (int m = 0; m <= 65; m++)
			{
				cout << "=";
			}
			cout << "\n  DANNNY Cinemax";
			for (int s = 0; s <= 30; s++)
			{
				cout << " ";
			}

			cout << "Class - BACK";

			cout << endl << endl;
			cout << "  Movie" << fixed << setw(10) << " = " << fixed << setw(5);
			switch (movie_num)
			{
			case (1):
				cout << "Frozen II\n";
				break;
			case (2):
				cout << "Avenger 4 EndGame\n";
				break;
			}

			cout << "  Date / Time " << fixed << setw(3) << " = " << fixed << setw(5) << "22 - 11 - 2019 ( 8.00 pm )";

			cout << "\n  Seat No: \n";

			cout << "   ";
			for (int screen = 0; screen <= 25; screen++)
			{
				cout << (char)254;
			}
			cout << " SCREEN ";
			for (int screen = 0; screen <= 24; screen++)
			{
				cout << (char)254;
			}
			cout << endl;

			for (int y = 0; y < 4; y++)
			{
				cout << y << " " << (char)179 << " " << seat[y][0] << " " << (char)179 << " " << seat[y][1] << " " << (char)179 << " " << seat[y][2] << " " <<
					(char)179 << " " << seat[y][3] << " " << (char)179 << " " << seat[y][4] << " " << (char)179 << " " << seat[y][5] << " " <<
					(char)179 << " " << seat[y][6] << " " << (char)179 << " " << seat[y][7] << " " << (char)179 << " " << seat[y][8] << " " <<
					(char)179 << " " << seat[y][9] << " " << (char)179 << " " << seat[y][10] << " " << (char)179 << " " << seat[y][11] << " " <<
					(char)179 << " " << seat[y][12] << " " << (char)179 << " " << seat[y][13] << " " << (char)179 << " " << seat[y][14] << " " <<
					(char)179 << " " << endl;
			}
			cout << " ";
			for (int z = 0; z < 10; z++)
			{
				cout << fixed << setw(4) << z;
			}
			cout << " ";
			for (int z = 10; z < 15; z++)
			{
				cout << fixed << setw(4) << z;
			}
			cout << endl;
			cout << "   ";
			for (int w = 1; w <= 59; w++)
			{
				cout << (char)205;
			}
			cout << endl;

			cout << setw(35) << fixed << setprecision(2) << "Price: RM" << total_back;

			cout << endl;
			for (int m = 0; m <= 65; m++)
			{
				cout << "=";
			}

			cout << endl;
		}
	}
	system("pause");
}

void finish_seat(int& y, int& x, int& vip, int& front, int& back, int& vip2, int& front2, int& back2, char seat[4][15]) {
	
	if (vip != 0)
	{
		for (y = 0; y < 1; y++)
		{
			for (x = 0; x <= 14; x++)
			{
				if (seat[y][x] == '1' || seat[y][x] == 'X')
				{
					seat[y][x] = 'X';
						++vip2;
					
					
				}
			}
		}
	}

	if (front != 0)
	{
		for (y = 1; y < 2; y++)
		{
			for (x = 0; x <= 14; x++)
			{
				if (seat[y][x] == '1' || seat[y][x] == 'X')
				{
					seat[y][x] = 'X';
					
						++front2;
					
				}
			}
		}
	}

	if (back != 0)
	{
		for (y = 2; y < 4; y++)
		{
			for (x = 0; x <= 14; x++)
			{
				if (seat[y][x] == '1' || seat[y][x] == 'X')
				{
					seat[y][x] = 'X';
					
						++back2;
					
				}
			}
		}
	}
}

void sale_report(int& movie_num, int& vip, int& front, int& back, int& vip2, int& front2, int& back2, int& vipadult_num, int& vipchild_num, int& vipstudent_num, int& frontadult_num, int& frontchild_num, int& frontstudent_num, int& backadult_num, int& backchild_num, int& backstudent_num, int& adultsold, int& childsold, int& studentsold, int& adultprice, int& childprice, int& studentprice) {
	int total_class_left;
	total_class_left = vip2 + front2 + back2;
	system("cls");
	logo();
	cout << (char)218;
	for (int r = 0; r <= 60; r++)
	{
		cout << (char)196;
	}
	cout << (char)191;
	cout << endl;
	cout << (char)179;
	cout << "                     TICKET SALES REPORT                     ";
	cout << (char)179 << endl << (char)179;
	cout << "Movie Title:" << fixed << setw(10) << " ";
	if (movie_num == 1)
	{
		cout << "FROZEN II";
	}
	else if (movie_num == 2)
	{
		cout << "AVENGER 4 ENDGAME";
	}
	cout << "                              " << (char)179;
	cout << endl;
	cout << (char)179;
	cout << "Date / Time:" << fixed << setw(10) << " " << "Friday 22-11-2019 (8.00pm";
	cout << ")             " << (char)179 << endl;
	cout << (char)179 << fixed << setw(62) << (char)179 << endl;
	cout << (char)179 << " SEAT OCCUPANCY FOR EACH CLASS :-" << fixed << setw(29) << (char)179 << endl;
	cout << (char)179;
	cout << fixed << setw(56) << "Total Seats    Quantity Sold     Sold %" << fixed << setw(6) << (char)179 << endl;
	cout << (char)179 << fixed << setw(15) << "Class 0\t\t15" << fixed << setw(15) << vip2 << fixed << setw(14) << (double)((vip2 / 15.00) * 100) << fixed << setw(8) << (char)179 << endl;
	cout << (char)179 << fixed << setw(15) << "Class 1\t\t15" << fixed << setw(15) << front2 << fixed << setw(14) << (double)((front2 / 15.00) * 100) << fixed << setw(8) << (char)179 << endl;
	cout << (char)179 << fixed << setw(15) << "Class 2\t\t30" << fixed << setw(15) << back2 << fixed << setw(14) << (double)((back2 / 30.00) * 100) << fixed << setw(8) << (char)179 << endl;
	cout << (char)179 << fixed << setw(27) << " ------" << fixed << setw(15) << "------" << fixed << setw(15) << "--------" << fixed << setw(5) << (char)179 << endl;
	cout << (char)179 << fixed << setw(15) << "OVERALL\t\t60" << fixed << setw(15) << total_class_left << fixed << setw(14) << (double)(100 * (total_class_left / 60.00)) << fixed << setw(8) << (char)179 << endl;
	cout << (char)179 << fixed << setw(62) << (char)179 << endl;
	cout << (char)179 << " SALES FOR EACH CATEGORY TYPE :-" << fixed << setw(30) << (char)179 << endl;
	cout << (char)179 << fixed << setw(27) << "Category" << fixed << setw(14) << "Seats" << fixed << setw(18) << "Sales (RM)" << fixed << setw(3) << (char)179 << endl;
	cout << (char)179 << fixed << setw(26) << "ADULT" << fixed << setw(14) << adultsold << fixed << setw(17) << adultprice << fixed << setw(5) << (char)179 << endl;
	cout << (char)179 << fixed << setw(26) << "CHILD" << fixed << setw(14) << childsold << fixed << setw(17) << childprice << fixed << setw(5) << (char)179 << endl;
	cout << (char)179 << fixed << setw(26) << "STUDENT" << fixed << setw(14) << studentsold << fixed << setw(17) << studentprice << fixed << setw(5) << (char)179 << endl;
	cout << (char)179 << fixed << setw(42) << "------" << fixed << setw(17) << "----------" << fixed << setw(3) << (char)179 << endl;
	cout << (char)179 << fixed << setw(26) << "TOTAL" << fixed << setw(14) << (adultsold + childsold + studentsold) << fixed << setw(17) << (adultprice + childprice + studentprice) << fixed << setw(5) << (char)179 << endl;
	cout << (char)179 << fixed << setw(62) << (char)179 << endl;
	cout << (char)192;
	for (int r = 0; r <= 60; r++)
	{
		cout << (char)196;
	}
	cout << (char)217;
	cout << endl;


	system("pause");


}

