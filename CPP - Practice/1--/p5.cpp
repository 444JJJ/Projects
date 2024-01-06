#include<iostream>
using namespace std;


int main(){

    int ans=5;
    cout<<ans<<" "<<&ans<<endl;

    int *ptr=&ans;
    cout<<ptr<<" "<<&ptr<<" "<<*ptr<<endl;




    return 0;
}