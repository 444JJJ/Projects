#include<iostream>
#include<string>
using namespace std;

void display(string name){
    cout<<name<<" You are early, Well Done :)"<<endl;
}

int main(){

    string nameholder;
    cout<<"Enter you name: "<<endl;
    cin>>nameholder;

    display(nameholder);



    return 0;
}



