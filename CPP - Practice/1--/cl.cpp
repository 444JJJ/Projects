#include<iostream>
using namespace std;

class Employee{
public:
    string Name;
    string Company;
    int Age;

    void IUS(){
        cout<<"Name - "<<Name<<endl;
        cout<<"Company - "<<Company<<endl;
        cout<<"Age - "<<Age<<endl;
    }

    Employee(string name,string company,int age){
        Name=name;
        Company=company;
        Age=age;
    }

};

int main(){
    Employee emp1=Employee("Anna ", "YouTube ",25);
    emp1.IUS();
    Employee emp2=Employee("John ", "Amazon ",35);
    emp2.IUS();




    return 0;
}