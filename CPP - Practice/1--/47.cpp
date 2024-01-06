#include<iostream>
using namespace std;

union emp{
    int id;
    float salary;
    
}anil, rashmit;


int main(){
    emp akshay, anjali;
    anjali.id=25;

    cout<<anjali.id<<endl;




    return 0;
}