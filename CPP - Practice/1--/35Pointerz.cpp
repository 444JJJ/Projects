#include<iostream>
using namespace std;

int main(){

    int age=24;
    bool human=true;

    int *agePtr=&age;
    bool humanPtr=&human;

    cout<<age<<" "<<agePtr<<endl;
    cout<<human<<" "<<humanPtr<<endl;



    return 0;
}