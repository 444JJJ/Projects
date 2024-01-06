#include<iostream>
using namespace std;

class Student{
private:
    int rollno;
    char name[30];
public:
    void dataInput(){
        cout<<"Enter you name"<<endl;
        cin>>name;
        cout<<"Enter you rollno"<<endl;
        cin>>rollno;
    }

    void dataOutput(){
        cout<<"Your entered name is "<<name<<endl;
        cout<<"Your entered rollnumber is "<<rollno<<endl;
    }





};

int main(){
    Student s1;
    s1.dataInput();
    s1.dataOutput();



    return 0;
}