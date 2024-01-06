#include<iostream>
using namespace std;


int main(){

    double pi=3.142;

    double *p=&pi;

    cout<<pi<<endl;
    cout<<&pi<<endl;
    cout<<p<<endl;;
    cout<<*p<<endl;
    cout<<&p<<endl;


    return 0;
}