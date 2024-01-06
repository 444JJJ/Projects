#include<iostream>
using namespace std;

class Student{
private:
    int rollno;
    char name[30];
public:
    void inputdata(){
        cout<<"Enter roll no: "<<endl;
        cin>>rollno;
        cout<<"Enter name "<<endl;
        cin>>name;
    }

    void dataOutput(){
        cout<<"Your rollnumber is "<<rollno<<endl;
        cout<<"Your name is "<<name<<endl;
    }

};


int main(){
    Student s1;
    cout<<"--------------Input Data--------------"<<endl;
    s1.inputdata();
    s1.dataOutput();

    return 0;
}


//123