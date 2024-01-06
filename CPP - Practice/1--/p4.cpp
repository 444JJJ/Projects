#include<iostream>
using namespace std;


int main(){

    int ans=5;

    cout<<ans<<endl;
    cout<<&ans<<endl;

    int *ptr=&ans;
    cout<<ptr<<endl;
    cout<<*ptr<<endl;




    return 0;
}