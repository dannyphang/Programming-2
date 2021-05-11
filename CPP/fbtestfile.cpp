#include <iostream>
#include <conio.h>
using namespace std;
void ShowElements(long dt[3][5])
{
    cout<<"Source Data:\n\nStates\t\tBiden Votes\tTrump Votes\tJorgensen Votes\tTotal Votes\n\n ";
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<5;j++)
            {
                cout<<dt[i][j]<<"\t\t";
            }
            cout<<endl;
        }
}
float PercentageBiden(long dt[3][5], int option)
{
    float Percentage_b[3]={0.0};
    for (int i=0;i<3;i++)
    {
        Percentage_b[i] = (float) 100*dt[i][1]/dt[i][4];
    }
    return Percentage_b[option];
}
float PercentageTrump(long dt[3][5], int option)
{
    float Percentage_t[3]={0.0};
    for (int i=0;i<3;i++)
    {
        Percentage_t[i] = (float) 100*dt[i][2]/dt[i][4];
    }
    return Percentage_t[option];
}
float PercentageJorgensen(long dt[3][5] , int option)
{
    float Percentage_j[3]={0.0};
    for (int i=0;i<3;i++)
    {
        Percentage_j[i] = (float) 100*dt[i][3] / dt[i][4];
    }
    return Percentage_j[option];
}
main()
{
 int op=0;
    long data[3][5]=
    {
        1, 52854453,5658847,70046,11013346,
        2, 2465781, 2455428,61894,4983103, 
        3, 2790648, 2644525,60287,5495460
    };
        ShowElements(data);
    do
    {
        cout<<"\n\nPress the state code to calculate the percentage of trump, Biden and Jorgensen Votes";
        cout<<"\n\nPress 1 for Florida\nPress 2 for Gorgia\nPress 3 for Michigan\nPress 4 to exit";
        cout<<"\n\nPlease select an option, Use number from 1 to 4 : ";
        cin>>op;
        switch(op)
        {
            case 1 : 
                cout<<"----------------------------------------------";
                cout<<"\nPercentage of Jo Biden vote is : "<<PercentageBiden(data, op-1);
                cout<<"\nPercentage of Donald Trump vote is : "<<PercentageTrump(data , op-1);
                cout<<"\nPercentage of Jo Jorgensen vote is : "<<PercentageJorgensen(data , op-1);
                break;
            case 2 :
                cout<<"----------------------------------------------";
                cout<<"\nPercentage of Jo Biden vote is : "<<PercentageBiden(data, op-1);
                cout<<"\nPercentage of Donald Trump vote is : "<<PercentageTrump(data , op-1);
                cout<<"\nPercentage of Jo Jorgensen vote is : "<<PercentageJorgensen(data , op-1);
                break;
            case 3 :
                cout<<"----------------------------------------------";
                cout<<"\nPercentage of Jo Biden vote is : "<<PercentageBiden(data, op-1);
                cout<<"\nPercentage of Donald Trump vote is : "<<PercentageTrump(data , op-1);
                cout<<"\nPercentage of Jo Jorgensen vote is : "<<PercentageJorgensen(data , op-1);
                break;
            default : 
                cout<<"\nChoice should be between 1 and 4\nInvalid choice , Please Select Agian";
                continue;
        }
    }while(true); 
}