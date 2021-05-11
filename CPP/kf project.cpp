#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<math.h>
#define ambulance_speed 80.0
#define policeCar_speed 50.0
#define minute 60.0

void today(int DAY, int MONTH, int YEAR, int hrs, int min);
const char * month_display(int MONTH);
void Road_condition();
const char * road_con_sel(int road_con);
void road_acc(int road_con, int vic_num, int truck_num, int bus_num, int car_num, int motor_num, int i);
void road_maint(int road_con);
int vic_cal(int truck_num, int bus_num, int car_num, int motor_num);
void accident_scene(int vic_num);
float hospical_cal(float hospital_dis);
int time_est_arr(float value);
float police_cal(float police_dis);
const char * Vehicle_Condition (int vic_con[], int vic_num, int i);

int main(){
    int DAY, MONTH, YEAR, hrs, min, truck_num, bus_num, car_num, motor_num, vic_num, i;

    today(DAY, MONTH, YEAR, hrs, min);
    Road_condition();
    printf("--END--");
    system("pause");
    return 0;
}

void today(int DAY, int MONTH, int YEAR, int hrs, int min)
{
    char day_night;
    int not_valid;
    //char weather;
    do
    {
        not_valid = 0;
        printf("%-6s", "YEAR");
        printf(": ");
        scanf("%d",&YEAR);
        if(YEAR >= 1800 && YEAR <= 2021)
        {
            printf("%-6s", "MONTH");
            printf(": ");
            scanf("%d",&MONTH);
            if(MONTH >= 1 && MONTH <= 12)
            {
                printf("%-6s", "DAY");
                printf(": ");
                scanf("%d",&DAY);
                if(MONTH == 1 || MONTH == 3 || MONTH == 5 || MONTH == 7 || MONTH == 8 || MONTH == 10 || MONTH == 12)
                {
                    if(DAY >= 1 && DAY <= 31)
                    {
                        break;
                    }
                    else
                    {
                        system("cls");
                        printf("Your input is invalid! Please input it again!!\n");
                        not_valid++;
                    }
                }
                else if(MONTH == 2)
                {
                    if(DAY >= 1 && DAY <= 29)
                    {
                        break;
                    }
                    else
                    {
                        system("cls");
                        printf("Your input is invalid! Please input it again!!\n");
                        not_valid++;
                    }
                }
                else
                {
                    if(DAY >= 1 && DAY <= 29)
                    {
                        break;
                    }
                    else
                    {
                        system("cls");
                        printf("Your input is invalid! Please input it again!!\n");
                        not_valid++;
                    }
                }
            }
            else
            {
                system("cls");
                printf("Your input is invalid! Please input it again!!\n");
                not_valid++;
            }
        }
        else
        {
            system("cls");
            printf("Your input is invalid! Please input it again!!\n");
            not_valid++;
        }
    }while(not_valid != 0);

    system("cls");    //use to clear screen

    month_display(MONTH);
    const char * months = month_display(MONTH);

    printf("Date: %02d %s %d\n\n", DAY, months, YEAR);

    do
    {
        not_valid = 0;
        printf("Day or Noon(Night)? \nD -> Day\nN -> Noon(Night)\n");
        scanf("%s", &day_night);
        if(day_night != 'd' && day_night != 'D' && day_night != 'n' && day_night != 'N')    // check the validation of the user input
        {
            system("cls");
            printf("Your input is invalid! Please input it again!!\n");
            not_valid++;
        }
    }while(not_valid != 0);   // will keep on looping until user input correct char

    system("cls");

    do
    {
        not_valid = 0;
        printf("Time:-\n");
        printf("Hour   : ");
        scanf("%d", &hrs);
        if(hrs >= 0 && hrs <= 12)
        {
            printf("Minute : ");
            scanf("%d", &min);
            if(min < 0 || min > 59)
            {
                system("cls");
                printf("Your input is invalid! Please input it again!!\n");
                not_valid++;
            }
            else
            {
                break;
            }
        }
        else
        {
            system("cls");
            printf("Your input is invalid! Please input it again!!\n");
            not_valid++;
        }
    }while(not_valid != 0);

    system("cls");

    printf("Time -> %02d : %02d", hrs, min);

    if(day_night == 'd' || day_night == 'D')    // it will show a.m. or p.m. when user input the day or night and time
    {
        printf(" A.M.\n\n");
    }
    else
    {
        printf(" P.M.\n\n");
    }
}

const char* month_display(int MONTH){
    switch(MONTH)
    {
        case (1):
            return "January";
            break;
        case (2):
            return "February";
            break;
        case (3):
            return "March";
            break;
        case (4):
            return "April";
            break;
        case (5):
            return "May";
            break;
        case (6):
            return "June";
            break;
        case (7):
            return "July";
            break;
        case (8):
            return "August";
            break;
        case (9):
            return "September";
            break;
        case (10):
            return "October";
            break;
        case (11):
            return "November";
            break;
        case (12):
            return "December";
            break;
    }
}

void Road_condition(){

    int road_con;
    int vic_num, truck_num, bus_num, car_num, motor_num, i;

    do
    {
        printf("What is the road condition? ");
        printf("\n1 -> Accident");
        printf("\n2 -> Maintenance\n");

        scanf("%d", &road_con);
        road_con_sel(road_con);
        if(road_con == 1 || road_con == 2)
        {
            if(road_con == 1)
            {
                road_acc(road_con, vic_num, truck_num, bus_num, car_num, motor_num, i);
            }
            else
            {
                road_maint(road_con);
            }
        }
        else
        {
            //system("cls");
            printf("Your input is invalid! Please input it again!!\n");
        }
    }while(road_con != 1 && road_con != 2);
}

const char * road_con_sel(int road_con){
    if(road_con == 1)
    {
        return "Road Accident";
    }
    else
    {
        return "Road Maintenance";
    }
}

void road_acc(int road_con, int vic_num, int truck_num, int bus_num, int car_num, int motor_num, int i){
    int vic_cal_ans;
    char vic_con_ans;
    do{
        system("cls");

        printf("--%s--\n", road_con_sel(road_con));

        do{
            printf("Number of vehicle involve in accident: ");
            scanf("%d",&vic_num);
            if(vic_num >= 1 && vic_num <= 999999999)
            {
                printf("%-12s", "Truck");
                printf(": ");
                scanf("%d", &truck_num);

                printf("%-12s", "Bus");
                printf(": ");
                scanf("%d", &bus_num);

                printf("%-12s", "Car");
                printf(": ");
                scanf("%d", &car_num);

                printf("%-12s", "Motorcycle");
                printf(": ");
                scanf("%d", &motor_num);
            }
            else
            {
                system("cls");
                printf("Your input is invalid! Please input it again!!\n");
            }
        }while(vic_num < 1 || vic_num > 999999999);

        vic_cal_ans = vic_cal(truck_num, bus_num, car_num, motor_num);
    }while(vic_num != vic_cal_ans);

    printf("[1] Serious\n[2] Moderate\n[3] Normal\n");
    printf("Vehicle Type\t\tVehicle Condition\n");

    int vic_con[vic_num];

    for(i = 0; i < truck_num; i++){
        if(truck_num != 0){
            printf("Truck %d", (i+1));
            printf("%-20s", "");
            scanf("%10d",&vic_con[i]);

            Vehicle_Condition (vic_con, vic_num, i);

            //printf("%25s", "");
            printf("Condition: %s\n", Vehicle_Condition (vic_con, vic_num, i));
        }
    }
    for(i = (truck_num); i < (truck_num + bus_num); i++){
        if(bus_num != 0){
            printf("Bus %d", (i - truck_num + 1));
            printf("%-22s", "");
            scanf("%d",&vic_con[i]);

            Vehicle_Condition (vic_con, vic_num, i);

            //printf("%25s", "");
            printf("Condition: %s\n", Vehicle_Condition (vic_con, vic_num, i));
        }
    }
    for(i = (truck_num + bus_num); i < (truck_num + bus_num + car_num); i++){
        if(car_num != 0){
            printf("Car %d", (i - truck_num - bus_num + 1));
            printf("%-22s", "");
            scanf("%d",&vic_con[i]);

            Vehicle_Condition (vic_con, vic_num, i);

           // printf("%25s", "");
            printf("Condition: %s\n", Vehicle_Condition (vic_con, vic_num, i));
        }
    }
    for(i = (truck_num + bus_num + car_num); i < (truck_num + bus_num + car_num + motor_num); i++){
        if(motor_num != 0){
            printf("Motorcycle %d", (i - truck_num - bus_num - car_num + 1));
            printf("%-15s", "");
            scanf("%d",&vic_con[i]);

            Vehicle_Condition (vic_con, vic_num, i);

            //printf("%25s", "");
            printf("Condition: %s\n", Vehicle_Condition (vic_con, vic_num, i));
        }
    }
    accident_scene(vic_num);
}

int vic_cal(int truck_num, int bus_num, int car_num, int motor_num){
    int check = 0;

    check = truck_num + bus_num + car_num + motor_num;

    return check;
}

const char * Vehicle_Condition (int vic_con[], int vic_num, int i){

    if(vic_con[i] == 1){
        return "Serious";
    }
    if(vic_con[i] == 2){
        return "Moderate";
    }
    if(vic_con[i] == 3){
        return "Normal";
    }

}

void accident_scene(int vic_num){
    int HOURS, MINUTE, SECOND;
    int XXX_need = vic_num;
    float time_est_hosp, time_est_police, hospital_dis;

    //system("cls");

    printf("Distance from hospital to accident scene (Meter): ");
    scanf("%f", &hospital_dis);

    float value = hospical_cal(hospital_dis);

    int return_time_value = time_est_arr(value);

    HOURS = (return_time_value / 10000);
    MINUTE = (return_time_value / 100) % 100; //313 % 100
    SECOND = (return_time_value % 10000) % 100;

    printf("\nTime estimate of Ambulance arrive is about %02dhrs%02dmin%02dsec \n", HOURS, MINUTE, SECOND);

    printf("Number of Recovery Vehicle needed: %d\n", XXX_need);

}

float hospical_cal(float hospital_dis){
    float time_est_hosp_cal;
    time_est_hosp_cal = (hospital_dis / ambulance_speed) * minute;  //time = distance / speed then convert hr into min

    return time_est_hosp_cal;
}

float police_cal(float police_dis){
    float time_est_police_cal;
    time_est_police_cal = (police_dis / policeCar_speed) * minute;

    return time_est_police_cal;
}

int time_est_arr(float value){
    int integer_time, time_est_sec, time_est_hrs, time_est_min, return_time;

    float time_est;

    integer_time = (int)(floor(value));

    time_est = value - (float)integer_time;
    time_est_hrs = integer_time / 60;
    time_est_min = integer_time % 60;
    time_est_sec = time_est * 60;

    return_time = (time_est_hrs * 10000) + (time_est_min * 100) + (time_est_sec);

    return return_time;
    //printf("%dhrs%dmin%dsec", time_est_hrs, time_est_min, time_est_sec);

}

void road_maint(int road_con){
    float police_dis;
    int HOURS, MINUTE, SECOND;

    system("cls");

    printf("--%s--\n", road_con_sel(road_con));

    printf("Distance from police station to scene (Meter): ");
    scanf("%f", &police_dis);

    float value2 = police_cal(police_dis);
    int return_time_value = time_est_arr(value2);

    HOURS = (return_time_value / 10000);
    MINUTE = (return_time_value / 100) % 100;
    SECOND = (return_time_value % 10000) % 100;

    printf("\nTime estimate of Traffic Police arrive is about %dhrs%dmin%02dsec \n", HOURS, MINUTE, SECOND);

}