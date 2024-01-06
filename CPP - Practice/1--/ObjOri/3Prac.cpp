#include<iostream>
using namespace std;

class student{
private:
    int rollno;
    string name;



public:
    void inputData(){
        cout<<"Enter rollno: "<<endl;
        cin>>rollno;
        cout<<"Enter name"<<endl;
        cin>>name;
    }

    void outputData(){
        cout<<"Your rollno is: "<<rollno<<endl;
        cout<<"Your name is: "<<name<<endl; 
    }



};


int main(){

    student s1;
    s1.inputData();
    s1.outputData();


    return 0;
}