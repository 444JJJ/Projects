#include<iostream>
using namespace std;

class student{
private:
    int rollno=10;
    int inputData;

public:
    void display(){
        cout<<"The rollno is: "<<rollno<<endl;;
    }

    //outside the class

    void show();

    void inputShow(int);






};

void student::show(){
    cout<<"The roll num is: "<<rollno<<endl;
}

void student::inputShow(int a){
    
    cout<<"You entered: "<<a<<endl;

}




int main(){
    student s1;
    s1.display();
    s1.show();
    cout<<"Enter an integer: "<<endl;
    int a;
    cin>>a;
    s1.inputShow(a);





    return 0;
}


/*

Acess specifier label private and public:

Function are public and data is private

Data is hidden so that it can be safe from accidental manipulation

Functions operates on data are public so they can be accessed outside
from the class

Member functions are the functions that operate on the data
encapsulated in the class

Public member functions are the interface to the class

Define member function inside the class definition
Or
Define member function outside the class definition
- But they must be declared inside class definition



*/


//12345
//12345
//12345
//12345123451234512345
//
