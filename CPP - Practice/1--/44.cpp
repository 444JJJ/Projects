#include<iostream>
#include<string>
using namespace std;

struct address{
    int h_no;
    string s_name;


};

struct student{
    string name;
    int id;

    address addr;

};


int main(){
    student anil;
    anil.name="Anil";
    anil.id=1234;
    anil.addr.h_no=4000;
    anil.addr.s_name="Long Lane";

    cout<<anil.name<<endl;
    cout<<anil.id<<endl;
    cout<<anil.addr.h_no<<endl;
    cout<<anil.addr.s_name<<endl;


    return 0;
}