#include<iostream>
using namespace std;

int main(){

    int ans=5;
    int *ptr=&ans;

    int& ref=ans;

    cout<<ans<<" "<<ref<<endl;
    cout<<&ans<<" "<<&ref<<endl;




    return 0;
}