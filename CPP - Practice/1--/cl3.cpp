#include<iostream>
using namespace std;

class Employee{
    public:
    string Name;
    string Company;
    int Age;

    void IUS(){
        cout<<"Hello, my name is "<<Name<<", I work in "<<Company<<", and I am "<<Age<<" Years old."<<endl;
        cout<<" "<<endl;
    }

    Employee(string name,string company,int age){
        Name=name;
        Company=company;
        Age=age;
    }


};

int main(){
    Employee emp1=Employee("Anna","YouTube",35);
    emp1.IUS();

    Employee emp2=Employee("John","Amazon",44);
    emp2.IUS();
    




    return 0;
}