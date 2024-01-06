#include<iostream>
using namespace std;

class Test{
private:
    int n;
public:
    Test():n(0){
        cout<<"Constructor is called..."<<endl;
    }
    void setValue(int num){
        n=num;
    }
    int getValue(){
        return n;
    }
};


void createObj(){
    Test T1,T2;
        T1.setValue(20);
    cout<<"The value of n:"<<T1.getValue()<<endl;
    T2.setValue(30);
    cout<<"The value of n:"<<T2.getValue()<<endl;
}