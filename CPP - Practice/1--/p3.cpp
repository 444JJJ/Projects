#include<iostream>
using namespace std;

int main(){
    
    int theVariable=555;

    cout<<theVariable<<endl;
    cout<<&theVariable<<endl;

    int *ptr=&theVariable;
    cout<<ptr<<endl;

    cout<<&ptr<<endl;

    cout<<*ptr<<endl;

    return 0;
}