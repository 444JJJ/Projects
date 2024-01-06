#include<iostream>
using namespace std;

struct student{
    int id;
    char sex;



}anil, rashmit;

int main(){

    student rahul,ajay;

    anil.id=454;
    anil.sex='m';

    rashmit.id=234;
    rashmit.sex='m';

    rahul.id=4543;
    rahul.sex='m';

    ajay.id=342;
    ajay.sex='m';

    cout<<anil.id<<" "<<anil.sex<<endl;
    cout<<rashmit.id<<" "<<rashmit.sex<<endl;
    cout<<rahul.id<<" "<<rahul.sex<<endl;
    cout<<ajay.id<<" "<<ajay.sex<<endl;
    


    return 0;
}