#include<iostream>
using namespace std;

int main(){

    int age;

    int *ptr_age=new int;

    *ptr_age=5;

    cout<<*ptr_age<<endl;

    delete ptr_age;


    return 0;
}