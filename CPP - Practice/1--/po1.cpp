#include<iostream>
using namespace std;

//Pass by value

void swap(int a,int b){

    cout<<a<<" "<<b<<endl;
    int temp=a;
    a=b;
    b=temp;

    cout<<a<<" "<<b<<endl;

}



int main(){

    int x=5,y=10;
    cout<<x<<" "<<y<<endl;

    swap(x,y);
    cout<<x<<" "<<y<<endl;



    return 0;
}