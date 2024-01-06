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
    void setCompany(string company){
        Company=company;
    }
    void setAge(int age){
        if(age>=18)
        Age=age;
    }


    string getName(){
        return Name;
    }
    string getCompany(){
        return Company;
    }
    int getAge(){
        return Age;
    }



    void IUS(){
        cout<<"Name - "<<Name<<endl;
        cout<<"Company - "<<Company<<endl;
        cout<<"Age - "<<Age<<endl;
        void AFP(){
            if(Age>30)
            cout<<Name<<" get promoted"<<endl;
            else
            cout<<Name<<" No"<<endl;
        }
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

    emp1.setAge(15);
    cout<<emp1.getName()<<" is "<<emp1.getAge()<<" years old"<<endl;

    emp1.AFP


    return 0;
}