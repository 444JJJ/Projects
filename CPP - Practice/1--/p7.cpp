#include<iostream>
using namespace std;


int main(){

    int arr[]={5,10,15,20,25,30};
    int *ptr=&(arr[0]);
    cout<<ptr<<" "<<*ptr<<endl;


    //addition operator
    ptr=ptr+1;
    cout<<ptr<<" "<<*ptr<<endl;

    ptr=ptr+1;
    cout<<ptr<<" "<<*ptr<<endl;


    return 0;
}