#include<iostream>
using namespace std;

void fun(int& a){

    a+=10;

}


int main(){
    int x=1;
    cout<<x<<endl;

    fun(x);
    cout<<x<<endl;


    return 0;
}