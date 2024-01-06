#include<iostream>
using namespace std;

class student{
private:
    int rollno=10;
    int inputData;
public:
    void display(){
        cout<<"The default rollno is "<<rollno<<" which is not assigned to a specific stduent"<<endl;
    }

    void show();
    void inputShow(int a);



};

void student::show(){
    cout<<"The roll number is "<<rollno<<endl;
    
}

void student::inputShow(int a){
    cout<<"You entered "<<a<<endl;
}



int main(){

    student s1;
    s1.display();
    s1.show();
    
    cout<<"Enter an integer "<<endl;
    int a;
    cin>>a;
    s1.inputShow(a);



    return 0;
}

//