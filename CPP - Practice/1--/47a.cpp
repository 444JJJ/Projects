#include<iostream>
using namespace std;

union emp{
    int id;
    float Salary;
};


int main(){
    emp anjali;
    anjali.id=25;
   // anjali.Salary=55.5;

    cout<<anjali.id<<endl;
    //cout<<anjali.Salary<<endl;



    return 0;
}