#include<iostream>
using namespace std;

struct student{
    int id;
    char sex;

};



int main(){

    int age;

    cout<<"int -->"<<sizeof(age)<<endl;
    cout<<"short int -->"<<sizeof(short int)<<endl;
    cout<<"char -->"<<sizeof(char)<<endl;
    cout<<"float -->"<<sizeof(float)<<endl;
    cout<<"struct student -->"<<sizeof(student)<<endl;



    return 0;
}