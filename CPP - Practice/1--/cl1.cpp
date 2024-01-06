#include<iostream>
using namespace std;

class Employee{
public:
    string Name;
    string Company;
    int Age;

    void IUS(){
        std::cout<<"Name - "<<Name<<std::endl;
        std::cout<<"Company - "<<Name<<std::endl;
        std::cout<<"Age - "<<Name<<std::endl;
    }

    Employee(string name, string company, int age){
        Name=name;
        Company=company;
        Age=age;
    }


};


int main(){

    Employee employee1=Employee("Saldina ","YT ",25);
    Employee employee2=Employee("John ","Amazon ",35);
    
    employee1.IUS();
    employee2.IUS();



    return 0;
}