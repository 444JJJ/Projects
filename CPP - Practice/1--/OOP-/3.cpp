#include<iostream>
using namespace std;

class Student{
private:

public:
    void displat(int rollno, char name[30]);
};

void Student::displat(int rollno, char name[30]){
    cout<<"The rollnumber for student "<<name<<" is "<<rollno<<endl;
}


int main(){

    Student s1;

    int rno;
    cout<<"Enter your rollnumber "<<endl;
    cin>>rno;
    char name[30];
    cout<<"Enter you name "<<endl;
    cin>>name;

    s1.displat(rno,name);




    return 0;
}

//12345