#include<iostream>
using namespace std;

int getValueFromUser(){
    cout<<"Enter an ineger: "<<endl;
    int input;
    cin>>input;

    return input;
}



int main(){
    int num{getValueFromUser()};
    cout<<num<<" doubled is "<<num*2<<endl;



    return 0;
}