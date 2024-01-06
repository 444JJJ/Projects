#include<iostream>
using namespace std;

class Student{
private:

public:

    void display(int rollno, char name[30]);

};

void Student::display(int rollno, char name[30]){
    cout<<"The rollnumber for student "<<name<<" is "<<rollno<<endl;
}



int main(){

    Student s1;
    int rollno;
    char name[30];

    cout<<"Enter your name "<<endl;
    cin>>name;
    cout<<"Enter you roll number "<<endl;
    cin>>rollno;

    s1.display(rollno, name);

    


    return 0;
}
