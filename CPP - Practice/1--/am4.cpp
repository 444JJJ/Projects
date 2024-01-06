#include<iostream>
using namespace std;

class AbstractEmployee{
    virtual void AFP()=0;
};

class Employee:AbstractEmployee{
private:
    string Name;
    string Company;
    int Age;
public:
    void setName(string name){
        Name=name;
    }
    string getName(){
        return Name;
    }
    void setCompany(string company){
        Company=company;
    }
    string getCompan(){
        return Company;
    }
    void setAge(int age){
        Age=age;
    }
    int getAge(){
        return Age;
    }
    

    void IUS(){
        cout<<"Hello, my name is "<<Name<<", I am "<<Age<<" years old, and I work at "<<Company<<"."<<endl;
        
    }

    Employee(string name, string company, int age){
        Name=name;
        Company=company;
        Age=age;
    }
    void AFP(){
        if(Age>30)
        cout<<Name<<" Promoted"<<endl;
        else
        cout<<Name<<" Not applicable"<<endl;
            
    }


};


int main(){

    Employee emp1=Employee("Anna", "YouTube", 25);
    emp1.IUS();

    Employee emp2=Employee("Joe Bttery", "Portable Electronic Devices", 100);
    emp2.IUS();

    emp1.AFP();
    emp2.AFP();





    return 0;
}