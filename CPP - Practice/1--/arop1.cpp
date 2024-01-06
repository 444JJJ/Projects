#include<iostream>
using namespace std;

struct person{
    int age;
    string name;
};

int main(){
    person p1,p2;

    p1.name="Jacob";
    p1.age=99;

    cout<<p1.name<<" is "<<p1.age<<" year old. "<<endl;



    return 0;
}