#include<iostream>
using namespace std;

bool check(int);


int main(){

    if(check(18))
        cout<<"You are an adult";
    else    
        cout<<"You are a kid";

    return 0;
}

bool check(int age){
    if(age>=18)
    return true;
    else
    return false;

}