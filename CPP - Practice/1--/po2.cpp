#include<iostream>
using namespace std;


void swap2(int *a,int *b){
    cout<<*a<<" "<<*b<<endl;
    int temp=*a;
    *a=*b;
    *b=temp;
    cout<<*a<<" "<<*b<<endl;
}


int main(){
    int x=5,y=10;
    cout<<x<<" "<<y<<endl;

    swap2(&x,&y);
    cout<<x<<" "<<y<<endl;



    return 0;
}