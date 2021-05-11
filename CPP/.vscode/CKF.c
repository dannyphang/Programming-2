#include<stdio.h>


void main()
float calcCallCharge(int);
float calcSMScharge(int);
float calcTotalSub(float,float);
float calcTotal(float);


{
    char name[20];
    int iden_no;
    int mob_no;
    int call_mins;
    int no_sms;
    float call_charge;
    float sms_charge;
    float total_sub;
    float total_bill;
    int_data=30;
    vid_str=5;
    mainline=80;


    printf("Mainline Information\n");

    printf("Name:");
    scanf("%s",&name);

    printf("Identification No:");
    scanf("%d",&iden_no);

    printf("Mobile Phone No:");
    scanf("%d",&mob_no);

    printf("--------------------------------\n");

    printf("Subline Information\n");

    printf("Name:");
    scanf("%s",&name);

    printf("Identification No:");
    scanf("%d",&iden_no);

    printf("Mobile Phone No:");
    scanf("%d",&mob_no);

    printf("Minutes of call:");
    scanf("%d",&call_mins);

    printf("Number of sms sent:");
    scanf("%d",&no_sms);

}

float calcCallCharge(int call_mins)
{
     float call_charge;
     call_charge=call_mins * 0.30;
     return call_charge;
}

float calcSMScharge(int no_sms)
{
    float sms_charge;
    sms_charge=no_sms * 0.50;
    return sms_charge;
}

float calcTotalSub(float call_charge, float sms_charge)
{
    float total_sub;
    total_sub= 30 + 5 + call_charge + sms_charge;
    float total_sub;
}

float calcTotal(float total_sub);
{
    float total_bill;
    total_bill= total_sub + 80;
    return total_sub;
}