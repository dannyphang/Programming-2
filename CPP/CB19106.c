#include<stdio.h>

struct Books{

char title[30];
int qty;
float price;
float totalprice;

};

int main(){

  struct Books getInput();
  void display(struct Books book);
  struct Books book1,book2;
  float totalprice, qty, price;

  book1=getInput();
  book2=getInput();
  totalprice=book1.qty*book1.price;
  totalprice=book2.qty*book2.price;
  display(book1);
  display(book2);

  return 0;

}

struct Books getInput(){

  struct Books book;

  printf("ENTER TITLE:");
  scanf("%s",&book.title);
  printf("ENTER QUANTITY:");
  scanf("%d",&book.qty);
  printf("ENTER PRICE:");
  scanf("%f",&book.price);

  return book;

}

void display(struct Books book){

   printf("BOOK INFORMATION\n");
   printf("===========================\n");
   printf("TITLE:%s\n",book.title);
   printf("ENTER QUANTITY:%d\n",book.qty);
   printf("TOTAL PRICE:%RM.2f\n",book.totalprice);

}