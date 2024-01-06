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

void output(string name, int id, int house_number, string street_name){
    cout<<name<<id<<house_number<<street_name<<endl;
}


int main(){
    student anil;
    anil.id=1234;
    anil.name="Anil";
    anil.addr.house_number=4000;
    anil.addr.street_name="Long Lane";

    output(anil.name,anil.id,anil.addr.house_number,anil.addr.street_name);
    

    return 0;
}