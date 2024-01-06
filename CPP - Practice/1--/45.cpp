#include<iostream>
#include<string>
using namespace std;

struct address{
    int house_number;
    string street_name;
};

struct student{
    int id;
    string name;
    address addr;
};

int main(){

    student anil;
    anil.id=1234;
    anil.name="Anil";
    anil.addr.house_number=2343;
    anil.addr.street_name="Lodge Land";

    cout<<anil.id<<endl;
    cout<<anil.name<<endl;
    cout<<anil.addr.house_number<<endl;
    cout<<anil.addr.street_name<<endl;



    return 0;
}