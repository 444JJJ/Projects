#include<iostream>
using namespace std;


int main(){
    int i=5;
    int *ip=&i;
    cout<<i<<" "<<&i<<" "<<ip<<" "<<*ip<<endl;

    double d=50.0;
    double *dp=&d;
    cout<<d<<" "<<&d<<" "<<dp<<" "<<*dp<<endl;

    bool b=true;
    bool *bp=&b;
    cout<<b<<" "<<&b<< " "<<bp<< " "<<*bp<<endl;

    cout<<sizeof(i)<<" "<<sizeof(d)<<" "<<sizeof(b)<<endl;



    return 0;
}