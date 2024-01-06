#include<iostream>
using namespace std;

struct student{
    int id;
    char sex;
    int age;



};

void display(student s);
void show(student *s);


int main(){
    
    student anil={1234,'m',24};
    display(anil);
    show(&anil);


    return 0;
}

void display(student s){
    cout<<s.id<<endl;
    cout<<s.sex<<endl;
    cout<<s.age<<endl;

}


void show(student *s){
    cout<<s->id<<endl;
    cout<<s->sex<<endl;
    cout<<s->age<<endl;

}