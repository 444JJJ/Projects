#include<iostream>
using namespace std;


int main(){
    cout<<"how many items do you wish to enter?"<<endl;
    int input;
    cin>>input;
    int *pointer=new int[input];

    int temp;

    for(int counter=0;counter<input;counter++){
        cout<<" Enter the item "<<counter+1<<endl;
        cin>>temp;
        *(pointer+counter)=temp;
    }

    cout<<"The items you entered are: "<<endl;
    for(int counter=0;counter<input;counter++){
        cout<<counter+1<<" item is "<<*(pointer+counter)<<endl;
    }

    delete []pointer;

    return 0;
}